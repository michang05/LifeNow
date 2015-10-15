package com.lifenow.pojo;

public class Source extends BaseVO {
    private String sourceId;
    private String name;
    private String favicon;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getFavicon() {
	return favicon;
    }

    public void setFavicon(String favicon) {
	this.favicon = favicon;
    }

    public void setSourceId(String sourceId) {
	this.sourceId = sourceId;
    }

    
    public String getSourceId() {
	return sourceId;
    }

    public Source copy() {
    	Source copy = new Source();
    	copy.favicon = favicon;
    	copy.name=name;
    	copy.sourceId=sourceId;
    	return copy;
    }
    
    @Override
    public String toString() {
	return String.format("Source [favicon=%s, name=%s, sourceId=%s]", favicon, name, sourceId);
    }

    
}
