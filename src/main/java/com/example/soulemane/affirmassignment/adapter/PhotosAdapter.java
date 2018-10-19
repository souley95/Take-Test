package com.example.soulemane.affirmassignment.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.soulemane.affirmassignment.R;
import com.example.soulemane.affirmassignment.model.Photo;
import com.example.soulemane.affirmassignment.photoList.PhotoListActivity;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {

    private PhotoListActivity listActivity;
    private List<Photo> photoList;


    public PhotosAdapter(PhotoListActivity listActivity, List<Photo> photoList){

        this.listActivity = listActivity;
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {

        Photo photo = photoList.get(position);
        RequestOptions options = new RequestOptions();
        options.centerCrop();

        Glide.with(listActivity)
                .load(photo.getUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        myViewHolder.pg.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        myViewHolder.pg.setVisibility(View.GONE);
                        return false;
                    }
                })
                .apply(options)
                .into(myViewHolder.image);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listActivity.onPhotoItemclick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public ProgressBar pg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            pg = itemView.findViewById(R.id.loading);
        }
    }

}
