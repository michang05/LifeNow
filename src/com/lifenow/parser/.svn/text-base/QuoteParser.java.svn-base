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
import com.lifenow.pojo.Quote;
import com.lifenow.pojo.Source;

/**
 * @author Michael Angelo
 *
 */
public class QuoteParser extends BaseXmlParser {

	
	
	/* (non-Javadoc)
	 * @see com.lifenow.parserbase.XmlParser#parse(java.io.InputStream)
	 */
	@Override
	public List<?> parse() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lifenow.parserbase.XmlParser#parse()
	 */
	@Override
	public List<Quote> parse(InputStream inputStream) {
		final Quote quoteObj = new Quote();
		final Source sourceObj = new Source();
		final Article articleObj = new Article();
		final List<Quote> listArticles = new ArrayList<Quote>();

		RootElement response = new RootElement(RESPONSE);
		Element payload = response.getChild(PAYLOAD);
		Element quote = payload.getChild(QUOTE);
		Element quoteId = quote.getChild(QUOTE_ID);
		quoteId.setEndTextElementListener(new EndTextElementListener() {
			
			@Override
			public void end(String body) {
			quoteObj.setQuoteId(body);	
			}
		});
		
		Element timestamp = quote.getChild(TIMESTAMP_QUOTE);
		timestamp.setEndTextElementListener(new EndTextElementListener() {
			
			@Override
			public void end(String body) {
			quoteObj.setTimestamp(body);	
			}
		});
		Element quoteText = quote.getChild(QUOTE_TEXT);
		quoteText.setEndTextElementListener(new EndTextElementListener() {
			
			@Override
			public void end(String body) {
			quoteObj.setQuoteText(body);	
			}
		});
		//start source
		Element source = quote.getChild(SOURCE);
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
				quoteObj.setSource(sourceObj.copy());
			}
		});
		// end of source
		
		//start article
		Element articleElement = quote.getChild(ARTICLE);
		Element timestampArt = articleElement.getChild(TIMESTAMP_ARTICLE);
		timestampArt.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setTimestamp(body);
			}
		});
		Element headline = articleElement.getChild(HEADLINE);
		headline.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setHeadline(body);
			}
		});
		Element url = articleElement.getChild(URL_ARTICLE);
		url.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setUrl(body);
			}
		});
		Element articleId = articleElement.getChild(ARTICLE_ID);
		articleId.setEndTextElementListener(new EndTextElementListener() {

			@Override
			public void end(String body) {
				articleObj.setArticleId(body);
			}
		});
		articleElement.setEndElementListener(new EndElementListener() {
			
			@Override
			public void end() {
			quoteObj.setArticle(articleObj.copy());	
			}
		});
		//end article
		quote.setEndElementListener(new EndElementListener() {

			@Override
			public void end() {
				listArticles.add(quoteObj.copy());
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
