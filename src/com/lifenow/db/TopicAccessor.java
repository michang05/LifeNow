package com.lifenow.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lifenow.pojo.Topic;

public class TopicAccessor {
    private final static String[] columns = { "_id, topicId, type, name, imageId, favorite" };

    public static Topic insert(final Topic topic, SQLiteDatabase db) throws Exception {

	ContentValues values = new ContentValues();
	values.put("topic_id", topic.getTopicId());
	values.put("type", topic.getType());
	values.put("name", topic.getName());
	values.put("image_id", topic.getImageId());
	values.put("favorite", topic.getFavorite());

	long id = db.insertOrThrow("topic", "", values);
	topic.setId(id);

	return topic;
    }

    public static Topic getTopicByTopicId(final String topicId, SQLiteDatabase db) throws Exception {
	Topic topic = null;

	final String[] params = { topicId };
	final Cursor c = db.query("topic", columns, "topic_id=?", params, null, null, null);

	if (c.moveToFirst()) {
	    topic = buildEntity(c);
	}

	c.close();

	return topic;
    }

    public static ArrayList<Topic> getTopicsForCategory(final String category, SQLiteDatabase db) throws Exception {
	final ArrayList<Topic> list = new ArrayList<Topic>();
	final String[] params = { category };

	final Cursor c = db.query("topic", columns, "category=?", params, null, null, "name");
	c.moveToFirst();

	while (!c.isAfterLast()) {
	    list.add(buildEntity(c));
	    c.moveToNext();
	}

	c.close();

	return list;
    }

    private static Topic buildEntity(final Cursor c) {
	int index = 0;
	final Topic topic = new Topic();
	topic.setId(c.getLong(index++));
	topic.setTopicId(c.getString(index++));
	topic.setType(c.getString(index++));
	topic.setName(c.getString(index++));
	topic.setImageId(c.getString(index++));
	topic.setFavorite(c.getInt(index++));
	return topic;
    }
}
