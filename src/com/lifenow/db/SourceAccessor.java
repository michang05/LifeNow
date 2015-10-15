package com.lifenow.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lifenow.pojo.Source;

public class SourceAccessor {
    
    private final static String[] columns = { "_id, source_id, name, favicon" };
    
    public static Source insert(final Source image, SQLiteDatabase db) throws Exception {
	ContentValues values = new ContentValues();
	values.put("source_id", image.getSourceId());
	values.put("name", image.getName());
	values.put("favicon", image.getFavicon());
	
	long id = db.insertOrThrow("source", "", values);
	image.setId(id);

	return image;
    }
    
    public static Source getSourceBySourceId(final String sourceId, SQLiteDatabase db) throws Exception {
	Source source = null;
	
	final String[] params = {sourceId};
	final Cursor c = db.query("source", columns, "source_id=?", params, null, null, null);
	int index = 0;
	
	if(c.moveToFirst()){
	    source = new Source();
	    source.setId(c.getLong(index++));
	    source.setSourceId(c.getString(index++));
	    source.setName(c.getString(index++));
	    source.setFavicon(c.getString(index++));
	}

	c.close();
	
	return source;
    }
}
