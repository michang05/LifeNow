/**
 * 
 */
package com.lifenow.parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

import com.lifenow.parserbase.BaseXmlParser;
import com.lifenow.pojo.Article;
import com.lifenow.pojo.Source;

/**
 * @author Michael Angelo
 * 
 */
public class ArticleParser extends BaseXmlParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lifenow.parserbase.XmlParser#parse(java.io.InputStream)
	 */
	@Override
	public List<?> parse() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lifenow.parserbase.XmlParser#parse()
	 */
	@Override
	public ArrayList<Article> parse(InputStream inputStream) {
		
		final Article articleObj = new Article();
		final Source sourceObj = new Source();
		final ArrayList<Article> listArticles = new ArrayList<Article>();
		
		RootElement response = new RootElement(RESPONSE);
		Element payload = response.getChild(PAYLOAD);
		Element article = payload.getChild(ARTICLE);
		Element source = article.getChild(SOURCE);
		//start source
		Element name = source.getChild(NAME);
		name.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				sourceObj.setName(body);
			}
		});
		Element sourceId = source.getChild(SOURCE_ID);
		sourceId.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				sourceObj.setSourceId(body);
			}
		});
		Element faviconUrl = source.getChild(FAVICON_URL);
		faviconUrl.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				sourceObj.setFavicon(body);			
			}
		});
		source.setEndElementListener(new EndElementListener() {

			@Override
			public void end() {
				
				articleObj.setSource(sourceObj.copy());				
			}
		});
		// end of source
		
		Element timestamp = article.getChild(TIMESTAMP_ARTICLE);
		timestamp.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {				
				articleObj.setTimestamp(body);
			}
		});
		Element headline = article.getChild(HEADLINE);
		headline.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setHeadline(body);
			}
		});
		Element excerpt = article.getChild(EXCERPT);
		excerpt.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setExcerpt(body);
			}
		});
		Element url = article.getChild(URL_ARTICLE);
		url.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setUrl(body);
			}
		});
		Element articleId = article.getChild(ARTICLE_ID);
		articleId.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setArticleId(body);
			}
		});

		article.setEndElementListener(new EndElementListener() {

			@Override
			public void end() {				
				listArticles.add(articleObj.copy());
			}
		});
		try {
			Xml.parse(inputStream, Xml.Encoding.UTF_8, response.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return listArticles;
	}

}
