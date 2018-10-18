package com.example.soulemane.affirmassignment.photoList;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.soulemane.affirmassignment.model.Photo;
import com.example.soulemane.affirmassignment.model.PhotoListResponse;
import com.example.soulemane.affirmassignment.network.ApiClient;
import com.example.soulemane.affirmassignment.network.ApiInterface;
import com.example.soulemane.affirmassignment.utils.Constants;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoListModel  implements PhotoListContract.Model{
        @Override
        public void getPhotoList(final OnFinishedListener onFinishedListener, int pageNo,String search) {
            ApiInterface apiService = ApiClient.getCLient().create(ApiInterface.class);
            Call<PhotoListResponse> call = apiService.getPhotos(Constants.METHOD_GET_SEARCH,Constants.VAL_API_KEY,Constants.URL_S,search,Constants.JSON,"1");
            call.enqueue(new Callback<PhotoListResponse>() {
                @Override
                public void onResponse(@NonNull Call<PhotoListResponse> call, @NonNull Response<PhotoListResponse> response) {
                    List<Photo> photos = null;
                    if (response.body() != null) {
                        photos = response.body().getPhotos().getResults();
                        onFinishedListener.onFinished(photos);
                    }
                    else{
                        Log.d("test result", "failed fetching " );
                    }

                }
                @Override
                public void onFailure(Call<PhotoListResponse> call, Throwable t) {
                    onFinishedListener.onFailure(t);

                }
            });
        }
    }

