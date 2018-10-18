package com.example.soulemane.affirmassignment.photoList;

import com.example.soulemane.affirmassignment.model.Photo;

import java.util.List;

public class PhotoListPresenter implements PhotoListContract.Presenter,PhotoListContract.Model.OnFinishedListener {

    private PhotoListContract.View photoListView;
    private PhotoListContract.Model photoListModel;


    public PhotoListPresenter(PhotoListContract.View photoListView){
        this.photoListView = photoListView;

        photoListModel = new PhotoListModel();
    }

    @Override
    public void onFinished(List<Photo> photoList) {
        photoListView.setDataToRecyclerView(photoList);
        if(photoListView != null){
            photoListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        photoListView.onResponseFailure(t);

        if(photoListView != null){
            photoListView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {

        this.photoListView = null;
    }

    @Override
    public void getMoreData(int pageNo,String search) {

        if(photoListView != null){
            photoListView.showProgress();
        }

        photoListModel.getPhotoList(this,pageNo,search);
    }

    @Override
    public void requestDataFromServer(String search) {
        if(photoListView != null){
            photoListView.showProgress();
        }

        photoListModel.getPhotoList(this,1,search);
    }
}
