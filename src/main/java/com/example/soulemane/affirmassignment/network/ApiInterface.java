package com.example.soulemane.affirmassignment.network;

import com.example.soulemane.affirmassignment.model.PhotoListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("services/rest/")
    Call<PhotoListResponse> getPhotos(@Query("method")String method,
                                      @Query("api_key") String API_KEY,
                                      @Query("extras") String EXTRA_SMALL_URL,
                                      @Query("text") String SEARCH_TERM,
                                      @Query("format") String format,
                                      @Query("nojsoncallback") String set);
}
