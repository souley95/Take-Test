package com.example.soulemane.affirmassignment.photoList;

import com.example.soulemane.affirmassignment.model.Photo;

import java.util.List;

interface PhotoListContract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(List<Photo> photoList);

            void onFailure(Throwable t);
        }

        void getPhotoList(OnFinishedListener onFinishedListener, int pageNo,String search);

    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Photo> photoList);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();

        void getMoreData(int pageNo,String search);

        void requestDataFromServer(String search);

    }
}
