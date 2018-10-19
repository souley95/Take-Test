package com.example.soulemane.affirmassignment.photoList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.soulemane.affirmassignment.R;
import com.example.soulemane.affirmassignment.adapter.PhotosAdapter;
import com.example.soulemane.affirmassignment.model.Photo;
import com.example.soulemane.affirmassignment.utils.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class PhotoListActivity extends AppCompatActivity implements PhotoItemClickListener,PhotoListContract.View {

    private PhotoListPresenter photoListPresenter;
    private RecyclerView rvPhotoList;
    private List<Photo> photoArrayList;
    private PhotosAdapter photosAdapter;
    private ProgressBar rvLoading;
    private GridLayoutManager mLayoutManager;
    private String search ;

    private int pageNo = 1 ;


    //Constants for load more
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
        initUI();
        setListeners();
        search = getIntent().getExtras().getString("query");

        photoListPresenter = new PhotoListPresenter(this);
        photoListPresenter.requestDataFromServer(search);
    }

    private void initUI(){

        rvPhotoList = findViewById(R.id.rv_photo_list);
        rvPhotoList.setHasFixedSize(true);
        photoArrayList = new ArrayList<>();
        photosAdapter = new PhotosAdapter(this,photoArrayList);

        mLayoutManager = new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false);
        rvPhotoList.setLayoutManager(mLayoutManager);
        rvPhotoList.addItemDecoration(new SpaceItemDecoration(5));
        rvPhotoList.setAdapter(photosAdapter);

        rvLoading = findViewById(R.id.rv_loading);

    }

    private void setListeners() {

        rvPhotoList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = rvPhotoList.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

                // Handling the infinite scroll
                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    photoListPresenter.getMoreData(pageNo,search);
                    loading = true;
                }
            }
        });
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
