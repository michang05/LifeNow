package com.lifenow;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifenow.pojo.Topic;

public class TopicsListRowHandler {
	private View base;
	private ImageView topicIcon;
	private TextView topicName;

	public TopicsListRowHandler(View base) {
		this.base = base;
	}

	public void populateFrom(Topic topic) {
		getTopicIcon().setImageResource(R.drawable.largeimageholder);
		String url = topic.getImage().getThumbURL();
		url = url.substring(0, url.lastIndexOf("/") + 1).concat("90x90.jpg");
		getTopicIcon().setTag(url);
		getTopicName().setText(topic.getName());

	}

	public void setTopicIcon(ImageView topicIcon) {
		this.topicIcon = topicIcon;
	}

	public ImageView getTopicIcon() {
		if (topicIcon == null) {
			topicIcon = (ImageView) base.findViewById(R.id.topicIcon);
			topicIcon.setAdjustViewBounds(false);
			topicIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
		}
		return topicIcon;
	}

	public void setTopicName(TextView topicName) {
		this.topicName = topicName;
	}

	public TextView getTopicName() {
		if (topicName == null) {
			topicName = (TextView) base.findViewById(R.id.topicName);
		}
		return topicName;
	}

}
