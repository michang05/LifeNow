package com.lifenow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifenow.pojo.Article;

public class ArticleListRowHandler {

	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static final long SECONDS = 1000;
	private static final long MINUTES = SECONDS * 60;
	private static final long HOUR = MINUTES * 60;
	private static final long DAY = HOUR * 24;

	private View base;
	private TextView headline;
	private TextView excerpt;
	private ImageView sourceIcon;
	private TextView sourceName;
	private TextView time;

	public ArticleListRowHandler(View base) {
		this.base = base;
	}

	public void populateFrom(final Article article) {
		getHeadline().setText(article.getHeadline());
		getExcerpt().setText(article.getExcerpt().concat("..."));
		getSourceIcon().setImageResource(R.drawable.imageplaceholder);
		getSourceIcon().setTag(article.getSource().getFavicon());
		getSourceName().setText(article.getSource().getName());

		String s = "";
		Date articleTime = null;
		try {
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			articleTime = sdf.parse(article.getTimestamp());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long diff = System.currentTimeMillis() - articleTime.getTime();
		if (diff < SECONDS) {
			s = "Now";
		} else if (diff > SECONDS && diff < MINUTES) {
			int val = (int) (diff / SECONDS);
			if (val > 1) {
				s = (val + " seconds ago");
			} else {
				s = (val + " second ago");
			}
		} else if (diff > MINUTES && diff < HOUR) {
			int val = (int) (diff / MINUTES);
			if (val > 1) {
				s = (val + " minutes ago");
			} else {
				s = (val + " minute ago");
			}

		} else if (diff > HOUR && diff < DAY) {
			int val = (int) (diff / HOUR);
			if (val > 1) {
				int min = (int) ((diff % HOUR) / MINUTES);
				if (min > 1) {
					s = (val + " hours " + min + " minutes ago");
				} else if (min == 1) {
					s = (val + " hours " + min + " minute ago");
				} else {
					s = (val + " hours ago");
				}
			} else {
				int min = (int) ((diff % HOUR) / MINUTES);
				if (min > 1) {
					s = (val + " hour " + min + " minutes ago");
				} else if (min == 1) {
					s = (val + " hour " + min + " minute ago");
				} else {
					s = (val + " hour ago");
				}
			}

		} else if (diff > DAY) {
			int val = (int) (diff / DAY);
			if (val > 1) {
				s = (val + " days ago");
			} else {
				s = (val + " day ago");
			}
		}

		getTime().setText(s);
	}

	public void setHeadline(TextView headline) {
		this.headline = headline;
	}

	public TextView getHeadline() {
		if (headline == null) {
			headline = (TextView) base.findViewById(R.id.headline);
		}

		return headline;
	}

	public void setExcerpt(TextView excerpt) {
		this.excerpt = excerpt;
	}

	public TextView getExcerpt() {
		if (excerpt == null) {
			excerpt = (TextView) base.findViewById(R.id.excerpt);
		}

		return excerpt;
	}

	public void setSourceIcon(ImageView sourceIcon) {
		this.sourceIcon = sourceIcon;
	}

	public ImageView getSourceIcon() {
		if (sourceIcon == null) {
			sourceIcon = (ImageView) base.findViewById(R.id.sourceIcon);
		}

		return sourceIcon;
	}

	public void setSourceName(TextView sourceName) {
		this.sourceName = sourceName;
	}

	public TextView getSourceName() {
		if (sourceName == null) {
			sourceName = (TextView) base.findViewById(R.id.sourceName);
		}
		return sourceName;
	}

	public void setTime(TextView time) {
		this.time = time;
	}

	public TextView getTime() {
		if (time == null) {
			time = (TextView) base.findViewById(R.id.timestamp);
		}
		return time;
	}
}
