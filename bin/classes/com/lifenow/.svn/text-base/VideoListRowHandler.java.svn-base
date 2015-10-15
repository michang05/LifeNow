package com.lifenow;

import com.lifenow.pojo.Video;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoListRowHandler {
    private View base;
    private ImageView thumb;
    private TextView title;
    //private TextView description;

    public VideoListRowHandler(View base) {
	this.base = base;
    }
    
    public void copyFrom(Video video){
	getThumb().setImageResource(R.drawable.largeimageholder);
	getThumb().setTag(video.getPreviewImage());
	getTitle().setText(video.getTitle());
	//getDescription().setText(video.getDescription());
    }

    public void setThumb(ImageView thumb) {
	this.thumb = thumb;
    }

    public ImageView getThumb() {
	if (thumb == null) {
	    thumb = (ImageView) base.findViewById(R.id.thumb);
	}
	return thumb;
    }

    public void setTitle(TextView title) {
	this.title = title;
    }

    public TextView getTitle() {
	if (title == null) {
	    title = (TextView) base.findViewById(R.id.title);
	}
	return title;
    }

//    public void setDescription(TextView description) {
//	this.description = description;
//    }
//
//    public TextView getDescription() {
//	if (description == null) {
//	    description = (TextView) base.findViewById(R.id.description);
//	}
//	return description;
//    }
}
