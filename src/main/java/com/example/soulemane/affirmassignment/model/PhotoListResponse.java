package com.example.soulemane.affirmassignment.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PhotoListResponse {

    @SerializedName("photos")
    private Photos photos;

    public Photos getPhotos(){
        return photos;
    }

    public class Photos {
        @SerializedName("page")
        private int page;
        @SerializedName("pages")
        private int pages;
        @SerializedName("perpage")
        private int perpage;
        @SerializedName("total")
        private int total;
        @SerializedName("photo")
        private ArrayList<Photo> results;

        public int getPage() {
            return page;
        }

        public int getPages() {
            return pages;
        }

        public int getPerpage() {
            return perpage;
        }

        public ArrayList<Photo> getResults() {
            return results;
        }
    }
}
