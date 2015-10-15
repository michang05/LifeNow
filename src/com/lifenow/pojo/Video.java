package com.lifenow.pojo;

public class Video extends BaseVO {
    private String title;
    private String description;
    private String url;
    private String previewImage;
    private String timestamp;

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getPreviewImage() {
	return previewImage;
    }

    public void setPreviewImage(String previewImage) {
	this.previewImage = previewImage;
    }

    public Video copy() {
	Video copy = new Video();
	copy.description = description;
	copy.previewImage = previewImage;
	copy.title = title;
	copy.url = url;
	return copy;
    }

    public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
    }

    public String getTimestamp() {
	return timestamp;
    }

}
