package com.lifenow;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifenow.pojo.Article;

public class ArticleListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Article> items;

    public ArticleListAdapter(Context context, ArrayList<Article> items) {
	this.context = context;
	this.items = items;
    }
    
    public void appendData(ArrayList<Article> data){
	items.addAll(data);
    }

    @Override
    public int getCount() {
	return items.size();
    }

    @Override
    public Object getItem(int position) {
	return items.get(position);
    }

    @Override
    public long getItemId(int position) {
	return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	View view = convertView;

	ArticleListRowHandler row = null;
	if (view == null) {
	    view = LayoutInflater.from(context).inflate(R.layout.articlelistitem, null);
	    row = new ArticleListRowHandler(view);
	    view.setTag(row);
	} else {
	    row = (ArticleListRowHandler) view.getTag();
	}

	row.populateFrom((Article) getItem(position));
	return view;
    }

}
