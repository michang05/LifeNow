package com.lifenow;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lifenow.pojo.Topic;

public class TopicsListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Topic> items;

	public TopicsListAdapter(Context context, ArrayList<Topic> items) {
		this.context = context;
		this.items = items;
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
		TopicsListRowHandler row;

		if (view == null) {
			view = LayoutInflater.from(context).inflate(
					R.layout.topicslistitem, null);
			row = new TopicsListRowHandler(view);
			view.setTag(row);
		} else {
			row = (TopicsListRowHandler) view.getTag();
		}

		row.populateFrom((Topic) getItem(position));
		return view;
	}
}
