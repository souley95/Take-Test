package com.example.soulemane.affirmassignment.photoList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.soulemane.affirmassignment.R;
import com.example.soulemane.affirmassignment.adapter.PhotosAdapter;
import com.example.soulemane.affirmassignment.model.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoListActivity extends AppCompatActivity implements PhotoItemClickListener,PhotoListContract.View {

    private PhotoListPresenter photoListPresenter;
    private RecyclerView rvPhotoList;
    private List<Photo> photoArrayList;
    private PhotosAdapter photosAdapter;
    private ProgressBar rvLoading;
    private StaggeredGridLayoutManager mLayoutManager;
    private String search ;

    private int pageNo = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
        initUI();
        search = getIntent().getExtras().getString("query");

        photoListPresenter = new PhotoListPresenter(this);
        photoListPresenter.requestDataFromServer(search);
    }

    private void initUI(){

        rvPhotoList = findViewById(R.id.rv_photo_list);
        rvPhotoList.setHasFixedSize(true);
        photoArrayList = new ArrayList<>();
        photosAdapter = new PhotosAdapter(this,photoArrayList);

        mLayoutManager = new StaggeredGridLayoutManager(3,1);
        rvPhotoList.setLayoutManager(mLayoutManager);
        rvPhotoList.setAdapter(photosAdapter);

        rvLoading = findViewById(R.id.rv_loading);

    }

    @Override
    public void onPhotoItemclick(int position) {

    }

    @Override
    public void showProgress() {
        rvLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        rvLoading.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<Photo> photoList) {

        photoArrayList.addAll(photoList);
        photosAdapter.notifyDataSetChanged();

        pageNo++;

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e("Error :", throwable.getMessage());
        Toast.makeText(this, "Error Fetching Data", Toast.LENGTH_LONG).show();
    }
}
