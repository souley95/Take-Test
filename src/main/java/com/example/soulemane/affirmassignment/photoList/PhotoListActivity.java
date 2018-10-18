package com.example.soulemane.affirmassignment.photoList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.soulemane.affirmassignment.R;

public class PhotoListActivity extends AppCompatActivity implements PhotoItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
    }

    @Override
    public void onPhotoItemclick(int position) {

    }
}
