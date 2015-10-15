package com.lifenow.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lifenow.pojo.Quote;

public class QuoteAccessor {

    private final static String[] columns = { "_id, quoteId, timestamp, quote_text, sourceId, articleId, category, favorite" };

    public static Quote insert(final Quote quote, SQLiteDatabase db) throws Exception {

	ContentValues values = new ContentValues();
	values.put("quote_id", quote.getQuoteId());
	values.put("timestamp", quote.getTimestamp());
	values.put("quote_text", quote.getQuoteText());
	values.put("source_id", quote.getSourceId());
	values.put("article_id", quote.getArticleId());
	values.put("category", quote.getCategory());
	values.put("favorite", quote.getFavorite());

	long id = db.insertOrThrow("quote", "", values);
	quote.setId(id);

	return quote;
    }

    public static Quote getQuoteByQuoteId(final String quoteId, SQLiteDatabase db) throws Exception {
	Quote quote = null;

	final String[] params = { quoteId };
	final Cursor c = db.query("quote", columns, "quote_id=?", params, null, null, null);

	if (c.moveToFirst()) {
	    quote = buildEntity(c);
	}

	c.close();

	return quote;
    }

    public static ArrayList<Quote> getQuotesForCategory(final String category, SQLiteDatabase db) throws Exception {
	final ArrayList<Quote> list = new ArrayList<Quote>();
	final String[] params = { category };

	final Cursor c = db.query("quote", columns, "category=?", params, null, null, "timestamp");
	c.moveToFirst();

	while (!c.isAfterLast()) {
	    list.add(buildEntity(c));
	    c.moveToNext();
	}

	c.close();

	return list;
    }

    private static Quote buildEntity(final Cursor c) {
	int index = 0;
	final Quote quote = new Quote();
	quote.setId(c.getLong(index++));
	quote.setQuoteId(c.getString(index++));
	quote.setTimestamp(c.getString(index++));
	quote.setQuoteText(c.getString(index++));
	quote.setSourceId(c.getString(index++));
	quote.setArticleId(c.getString(index++));
	quote.setCategory(c.getString(index++));
	quote.setFavorite(c.getInt(index++));
	
	return quote;
    }
}
