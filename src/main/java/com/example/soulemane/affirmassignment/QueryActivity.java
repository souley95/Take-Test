package com.example.soulemane.affirmassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.soulemane.affirmassignment.photoList.PhotoListActivity;

public class QueryActivity extends AppCompatActivity {

    EditText query;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);


        query = findViewById(R.id.query);
        search = findViewById(R.id.searchQuery);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPhotoList();
            }
        });
    }

    public void goToPhotoList(){

        String s = query.getText().toString();

        Intent photoList = new Intent(this,PhotoListActivity.class);
        photoList.putExtra("query",s);
        startActivity(photoList);
    }
}
