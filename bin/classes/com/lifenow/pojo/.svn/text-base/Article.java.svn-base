package com.lifenow.pojo;

public class Article extends BaseVO {
    private String timestamp;
    private String headline;
    private String excerpt;
    private String url;
    private String articleId;
    private String sourceId;
    private String category;
    private int favorite;
    private Source source;

    public Source getSource() {
	return source;
    }

    public void setSource(Source source) {
	this.source = source;
    }

    public String getHeadline() {
	return headline;
    }

    public void setHeadline(String headline) {
	this.headline = headline;
    }

    public String getExcerpt() {
	return excerpt;
    }

    public void setExcerpt(String excerpt) {
	this.excerpt = excerpt;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public void setArticleId(String articleId) {
	this.articleId = articleId;
    }

    public String getArticleId() {
	return articleId;
    }

    public void setSourceId(String sourceId) {
	this.sourceId = sourceId;
    }

    public String getSourceId() {
	return sourceId;
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

    public Article copy() {
	Article copy = new Article();
	copy.articleId = articleId;
	copy.category = category;
	copy.excerpt = excerpt;
	copy.favorite = favorite;
	copy.headline = headline;
	copy.sourceId = sourceId;
	copy.timestamp = timestamp;
	copy.url = url;
	copy.source = source;

	return copy;
    }

    public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
    }

    public String getTimestamp() {
	return timestamp;
    }

    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((headline == null) ? 0 : headline.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Article other = (Article) obj;
	if (headline == null) {
	    if (other.headline != null)
		return false;
	} else if (!headline.equals(other.headline))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return String
		.format(
			"Article [articleId=%s, category=%s, excerpt=%s, favorite=%s, headline=%s, sourceId=%s, timestamp=%s, url=%s]",
			articleId, category, excerpt, favorite, headline, sourceId, getTimestamp(), url);
    }

}
