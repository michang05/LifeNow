package com.lifenow.pojo;


public class Image extends BaseVO {
    private String imageId;
    private String url;
    private String dayLifeURL;
    private String thumbURL;
    private String timestamp;
    private String credit;
    private String caption;
    private String sourceId;

    public String getImageId() {
	return imageId;
    }

    public void setImageId(String imageId) {
	this.imageId = imageId;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getDayLifeURL() {
	return dayLifeURL;
    }

    public void setDayLifeURL(String dayLifeURL) {
	this.dayLifeURL = dayLifeURL;
    }

    public String getThumbURL() {
	return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
	this.thumbURL = thumbURL;
    }

    
    public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCredit() {
	return credit;
    }

    public void setCredit(String credit) {
	this.credit = credit;
    }

    public String getCaption() {
	return caption;
    }

    public void setCaption(String caption) {
	this.caption = caption;
    }

    public void setSourceId(String sourceId) {
	this.sourceId = sourceId;
    }

    public String getSourceId() {
	return sourceId;
    }

    public Image copy() {
    	Image copy= new Image();
    	copy.caption=caption;
    	copy.credit=credit;
    	copy.dayLifeURL=dayLifeURL;
    	copy.imageId=imageId;
    	copy.sourceId=sourceId;
    	copy.thumbURL=thumbURL;
    	copy.timestamp=timestamp;
    	copy.url=url;
 
    	return copy;
    }
    
    @Override
    public String toString() {
	return String
		.format(
			"Image [caption=%s, credit=%s, dayLifeURL=%s, imageId=%s, sourceId=%s, thumbURL=%s, timestamp=%s, url=%s]",
			caption, credit, dayLifeURL, imageId, sourceId, thumbURL, timestamp, url);
    }

}
