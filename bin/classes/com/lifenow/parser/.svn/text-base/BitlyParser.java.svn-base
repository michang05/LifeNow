package com.lifenow.parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.sax.Element;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

import com.lifenow.parserbase.BaseXmlParser;

public class BitlyParser extends BaseXmlParser {

    @Override
    public ArrayList<String> parse(InputStream inputStream) {

	final ArrayList<String> list = new ArrayList<String>();
	final RootElement response = new RootElement("bitly");
	final Element results = response.getChild("results");
	final Element nodeKeyVal = results.getChild("nodeKeyVal");
	final Element shortUrl = nodeKeyVal.getChild("shortUrl");

	shortUrl.setEndTextElementListener(new EndTextElementListener() {
	    public void end(String body) {
		list.add(body.trim());
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
	// TODO Auto-generated method stub
	return null;
    }

}
