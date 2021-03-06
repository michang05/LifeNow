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
import com.lifenow.pojo.Image;
import com.lifenow.pojo.Source;
import com.lifenow.pojo.Topic;

/**
 * @author Michael Angelo
 * 
 */
public class TopicParser extends BaseXmlParser {

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
    public ArrayList<Topic> parse(InputStream inputStream) {
	final Topic topicObj = new Topic();
	final Image imageObj = new Image();
	final Source sourceObj = new Source();
	final ArrayList<Topic> listTopics = new ArrayList<Topic>();

	RootElement response = new RootElement(RESPONSE);
	Element payload = response.getChild(PAYLOAD);
	Element topic = payload.getChild(TOPIC);
	Element topicId = topic.getChild(TOPIC_ID);
	topicId.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		topicObj.setTopicId(body);
	    }
	});
	Element type = topic.getChild(TYPE);
	type.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		topicObj.setType(body);
	    }
	});
	Element name = topic.getChild(NAME);
	name.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		topicObj.setName(body);
	    }
	});
	// start image
	Element image = topic.getChild(IMAGE);
	Element url = image.getChild(URL_TOPIC);
	url.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		imageObj.setUrl(body);
	    }
	});
	Element thumbUrl = image.getChild(THUMB_URL);
	thumbUrl.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		imageObj.setThumbURL(body);
	    }
	});
	Element timestamp = image.getChild(TIMESTAMP_TOPIC);
	timestamp.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		imageObj.setTimestamp(body);
	    }
	});
	Element credit = image.getChild(CREDIT);
	credit.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		imageObj.setCredit(body);
	    }
	});
	Element imageId = image.getChild(IMAGE_ID);
	imageId.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		imageObj.setImageId(body);
	    }
	});
	Element caption = image.getChild(CAPTION);
	caption.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		imageObj.setCaption(body);
	    }
	});
	Element dayLifeUrl = topic.getChild(DAYLIFE_URL);
	dayLifeUrl.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		imageObj.setDayLifeURL(body);
	    }
	});

	// Start source
	Element source = image.getChild(SOURCE);

	Element sourceId = source.getChild(SOURCE_ID);
	sourceId.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		sourceObj.setSourceId(body);
	    }
	});
	Element nameTopic = source.getChild(NAME_TOPIC);
	nameTopic.setEndTextElementListener(new EndTextElementListener() {

	    @Override
	    public void end(String body) {
		sourceObj.setName(body);
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
		topicObj.setSource(sourceObj.copy());
	    }
	});
	// end of source
	image.setEndElementListener(new EndElementListener() {

	    @Override
	    public void end() {
		topicObj.setImage(imageObj.copy());
	    }
	});
	// end image

	topic.setEndElementListener(new EndElementListener() {

	    @Override
	    public void end() {
		listTopics.add(topicObj.copy());
	    }
	});
	try {
	    Xml.parse(inputStream, Xml.Encoding.UTF_8, response.getContentHandler());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return listTopics;
    }

}
