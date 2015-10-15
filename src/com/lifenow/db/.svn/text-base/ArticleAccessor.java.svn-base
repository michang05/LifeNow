package com.lifenow.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lifenow.pojo.Article;

public class ArticleAccessor {

    private final static String[] columns = { "_id, articleId, timestamp, headline, excerpt, url, sourceId, category, favorite" };

    public static Article insert(final Article article, SQLiteDatabase db) throws Exception {
	ContentValues values = new ContentValues();
	values.put("article_id", article.getArticleId());
	values.put("timestamp", article.getTimestamp());
	values.put("headline", article.getHeadline());
	values.put("excerpt", article.getExcerpt());
	values.put("url", article.getUrl());
	values.put("source_id", article.getSourceId());
	values.put("category", article.getCategory());
	values.put("favorite", article.getFavorite());

	long id = db.insertOrThrow("article", "", values);
	article.setId(id);

	return article;
    }

    public static Article getArticleByArticleId(final String articleId, SQLiteDatabase db) throws Exception {
	Article quote = null;

	final String[] params = { articleId };
	final Cursor c = db.query("article", columns, "article_id=?", params, null, null, null);

	if (c.moveToFirst()) {
	    quote = buildEntity(c);
	}

	c.close();

	return quote;
    }

    public static ArrayList<Article> getArticlesForCategory(final String category, SQLiteDatabase db) throws Exception {
	final ArrayList<Article> list = new ArrayList<Article>();
	final String[] params = { category };

	final Cursor c = db.query("article", columns, "category=?", params, null, null, "timestamp");
	c.moveToFirst();

	while (!c.isAfterLast()) {
	    list.add(buildEntity(c));
	    c.moveToNext();
	}

	c.close();

	return list;
    }

    private static Article buildEntity(final Cursor c) {
	int index = 0;
	final Article quote = new Article();
	quote.setId(c.getLong(index++));
	quote.setArticleId(c.getString(index++));
	quote.setTimestamp(c.getString(index++));
	quote.setHeadline(c.getString(index++));
	quote.setExcerpt(c.getString(index++));
	quote.setUrl(c.getString(index++));
	quote.setSourceId(c.getString(index++));
	quote.setCategory(c.getString(index++));
	quote.setFavorite(c.getInt(index++));
	return quote;
    }
}
