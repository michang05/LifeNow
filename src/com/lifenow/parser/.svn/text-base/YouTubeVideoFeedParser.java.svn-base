package com.lifenow.parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

import com.lifenow.parserbase.BaseXmlParser;
import com.lifenow.pojo.Video;

public class YouTubeVideoFeedParser extends BaseXmlParser {
    @Override
    public ArrayList<Video> parse(InputStream inputStream) {
	final ArrayList<Video> list = new ArrayList<Video>();
	final Video video = new Video();

	final RootElement response = new RootElement(VIDEO_URI, FEED);
	final Element entry = response.getChild(VIDEO_URI, ENTRY);

	final Element title = entry.getChild(VIDEO_URI, TITLE);
	title.setEndTextElementListener(new EndTextElementListener() {
	    @Override
	    public void end(String body) {
		video.setTitle(body != null ? body.trim() : "");
	    }
	});

	final Element url = entry.getChild(VIDEO_URI, LINK);
	url.setStartElementListener(new StartElementListener() {
	    public void start(Attributes attributes) {
		final String rel = attributes.getValue(0);
		//Log.v("LOCAL NAME::::::::::::::: "+rel);
		if (rel.equals(ALTERNATE)) {
		    video.setUrl(attributes.getValue(2));
		}
	    }
	});

	final Element mediaGroup = entry.getChild(MEDIA_URI, MEDIAGROUP);

//	final Element description = mediaGroup.getChild(MEDIA_URI, MEDIADESCRIPTION);
//	description.setEndTextElementListener(new EndTextElementListener() {
//	    @Override
//	    public void end(String body) {
//		video.setDescription(body != null ? body.trim() : "");
//	    }
//	});

	final Element previewImage = mediaGroup.getChild(MEDIA_URI, MEDIATHUMBNAIL);
	previewImage.setStartElementListener(new StartElementListener() {
	    public void start(Attributes attributes) {
		String image = attributes.getValue(0);
		if (image.indexOf("1.jpg") != -1) {
		    video.setPreviewImage(image);
		}
	    }
	});

	final Element uploaded = mediaGroup.getChild(YOUTUBE_URI, UPLOADED);
	uploaded.setEndTextElementListener(new EndTextElementListener() {
	    @Override
	    public void end(String body) {
		video.setTimestamp(body != null ? body.trim() : "");
	    }
	});

	entry.setEndElementListener(new EndElementListener() {
	    public void end() {
		list.add(video.copy());
	    }
	});

	try {
	    Xml.parse(inputStream, Xml.Encoding.UTF_8, response.getContentHandler());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}

	return list;
    }

    @Override
    public List<?> parse() {
	return null;
    }

}
