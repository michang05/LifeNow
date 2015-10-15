package com.lifenow;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifenow.pojo.Video;

public class VideoListAdapter extends BaseAdapter{
    
    private Context context;
    private ArrayList<Video> items;
    
    public VideoListAdapter(Context context, ArrayList<Video> items) {
	this.context = context;
	this.items = items;
    }

    @Override
    public int getCount() {
	return items.size();
    }

    @Override
    public Object getItem(int arg0) {
	return items.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
	View view = arg1;
	VideoListRowHandler row;
	
	if(view == null){
	    view = LayoutInflater.from(context).inflate(R.layout.videolistitem, null);
	    row = new VideoListRowHandler(view);
	    view.setTag(row);
	}else{
	    row = (VideoListRowHandler) view.getTag();
	}
	
	Video vid = (Video) getItem(arg0);
	Log.v("================================ "+vid.getPreviewImage());
	row.copyFrom(vid);
	
	return view;
    }
    
}
