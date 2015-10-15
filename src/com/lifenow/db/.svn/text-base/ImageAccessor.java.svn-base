package com.lifenow.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lifenow.pojo.Image;

public class ImageAccessor {

    private final static String[] columns = { "_id, imageId, url, dayLifeURL, thumbURL, timestamp, credit, caption, source_id" };

    public static Image insert(final Image image, SQLiteDatabase db) throws Exception {
	ContentValues values = new ContentValues();
	values.put("image_id", image.getImageId());
	values.put("url", image.getUrl());
	values.put("dayLifeURL", image.getDayLifeURL());
	values.put("thumbURL", image.getThumbURL());
	values.put("timestamp", image.getTimestamp());
	values.put("credit", image.getCredit());
	values.put("caption", image.getCaption());
	values.put("source_id", image.getSourceId());

	long id = db.insertOrThrow("image", "", values);
	image.setId(id);

	return image;
    }

    public static Image getImageByImageId(final String imageId, SQLiteDatabase db) throws Exception {
	Image image = null;

	final String[] params = { imageId };
	final Cursor c = db.query("image", columns, "image_id=?", params, null, null, null);
	int index = 0;

	if (c.moveToFirst()) {
	    image = new Image();
	    image.setId(c.getLong(index++));
	    image.setImageId(c.getString(index++));
	    image.setUrl(c.getString(index++));
	    image.setDayLifeURL(c.getString(index++));
	    image.setThumbURL(c.getString(index++));
	    image.setTimestamp(c.getString((index++)));
	    image.setCredit(c.getString(index++));
	    image.setCaption(c.getString(index++));
	    image.setSourceId(c.getString(index++));
	}

	c.close();

	return image;
    }
}
