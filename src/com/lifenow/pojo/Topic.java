package com.lifenow.pojo;

public class Topic extends BaseVO {
    private String topicId;
    private String type;
    private String name;
    private String imageId;
    private String category;
    private int favorite;
    private Image image;
    private Source source;

    
    public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
    
    public String getTopicId() {
	return topicId;
    }

    public void setTopicId(String topicId) {
	this.topicId = topicId;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setImageId(String imageId) {
	this.imageId = imageId;
    }

    public String getImageId() {
	return imageId;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getCategory() {
	return category;
    }

    public void setFavorite(int favorite) {
	this.favorite = favorite;
    }

    public int getFavorite() {
	return favorite;
    }

    public Topic copy() {
    	Topic copy = new Topic();
    	copy.category = category;
    	copy.favorite=favorite;
    	copy.imageId=imageId;
    	copy.name=name;
    	copy.type=type;
    	copy.source=source;
    	copy.image=image;
    	copy.topicId=topicId;
    	return copy;
    }
    
    @Override
    public String toString() {
	return String.format("Topic [category=%s, favorite=%s, imageId=%s, name=%s, topicId=%s, type=%s]", category,
		favorite, imageId, name, topicId, type);
    }

}