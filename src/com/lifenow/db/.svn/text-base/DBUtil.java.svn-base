package com.lifenow.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.lifenow.Log;

public class DBUtil extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "viida.db";
    private final static int DATABASE_VERSION = 4;

    public DBUtil(Context context) {
	this(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBUtil(Context context, String name, CursorFactory factory, int version) {
	super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

	// source
	db.execSQL(getCreateSourceSQL());
	db.execSQL(getCreateSourceIndexSQL());
	
	// image
	db.execSQL(getCreateImageSQL());
	db.execSQL(getCreateImageIndexSQL());
	
	// topic
	db.execSQL(getCreateTopicSQL());
	db.execSQL(getCreateTopicIndexSQL());
	
	// article
	db.execSQL(getCreateArticleSQL());
	db.execSQL(getCreateArticleIndexSQL());
	
	// quote
	db.execSQL(getCreateQuoteSQL());
	db.execSQL(getCreateQuoteIndexSQL());
	
    }

    private String getCreateSourceSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create table source (");
	builder.append("_id integer primary key autoincrement,");
	builder.append(" source_id TEXT, ");
	builder.append(" favicon TEXT);");

	return builder.toString();
    }

    private String getCreateSourceIndexSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create index source_idx on source(source_id);");
	return builder.toString();
    }
    
    
    private String getCreateImageSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create table image (");
	builder.append("_id integer primary key autoincrement,");
	builder.append(" image_id TEXT, ");
	builder.append(" url TEXT, ");
	builder.append(" daylife_url TEXT, ");
	builder.append(" thumb_url TEXT, ");
	builder.append(" cache_uri TEXT, ");
	builder.append(" timestamp REAL, ");
	builder.append(" credit TEXT, ");
	builder.append(" caption TEXT, ");
	builder.append(" source_id REAL);");
	

	return builder.toString();
    }
    
    private String getCreateImageIndexSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create index image_idx on image(image_id);");
	return builder.toString();
    }
    
    
    private String getCreateTopicSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create table topic (");
	builder.append("_id integer primary key autoincrement,");
	builder.append(" topic_id TEXT, ");
	builder.append(" type TEXT, ");
	builder.append(" name TEXT, ");
	builder.append(" category TEXT, ");
	builder.append(" favorite REAL, ");
	builder.append(" image_id REAL);");

	return builder.toString();
    }

    private String getCreateTopicIndexSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create index topic_idx on topic(topic_id, category);");
	return builder.toString();
    }
    
    private String getCreateArticleSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create table article (");
	builder.append("_id integer primary key autoincrement,");
	builder.append(" article_id TEXT, ");
	builder.append(" source_id REAL, ");
	builder.append(" timestamp REAL, ");
	builder.append(" headline TEXT, ");
	builder.append(" excerpt TEXT, ");
	builder.append(" category TEXT, ");
	builder.append(" favorite REAL, ");
	builder.append(" url TEXT);");

	return builder.toString();
    }

    private String getCreateArticleIndexSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create index article_idx on article(article_id, category);");
	return builder.toString();
    }
    
    private String getCreateQuoteSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create table quote (");
	builder.append("_id integer primary key autoincrement,");
	builder.append(" quote_id TEXT, ");
	builder.append(" source_id REAL, ");
	builder.append(" article_id REAL, ");
	builder.append(" timestamp REAL, ");
	builder.append(" category TEXT, ");
	builder.append(" favorite REAL, ");
	builder.append(" quote_text TEXT);");

	return builder.toString();
    }

    private String getCreateQuoteIndexSQL() {
	final StringBuilder builder = new StringBuilder();
	builder.append("create index quote_idx on quote(quote_id, category);");
	return builder.toString();
    }
    


    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
	Log.v("Upgrading DB from version " + arg1 + " to " + arg2);
	db.execSQL("drop table if exists source");
	db.execSQL("drop index if exists source_idx");
	
	db.execSQL("drop table if exists image");
	db.execSQL("drop index if exists image_idx");
	
	db.execSQL("drop table if exists topic");
	db.execSQL("drop index if exists topic_idx");
	
	db.execSQL("drop table if exists article");
	db.execSQL("drop index if exists article_idx");
	
	db.execSQL("drop table if exists quote");
	db.execSQL("drop index if exists quote_idx");
	onCreate(db);

    }

}
