package com.lifenow.pojo;


public class Quote extends BaseVO {
    private String quoteId;
    private String timestamp;
    private String quoteText;
    private String sourceId;
    private String articleId;
    private String category;
    private int favorite;
    private Article article;
    private Source source;
    
    
    public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
    

    public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getQuoteText() {
		return quoteText;
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public void setQuoteId(String quoteId) {
	this.quoteId = quoteId;
    }

    public String getQuoteId() {
	return quoteId;
    }

    public void setSourceId(String sourceId) {
	this.sourceId = sourceId;
    }

    public String getSourceId() {
	return sourceId;
    }

    public void setArticleId(String articleId) {
	this.articleId = articleId;
    }

    public String getArticleId() {
	return articleId;
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

    public Quote copy() {
    	Quote copy = new Quote();
    	copy.articleId = articleId;
    	copy.category= category;
    	copy.favorite = favorite;
    	copy.quoteText = quoteText;
    	copy.quoteId = quoteId;
    	copy.source = source;
    	copy.article=article;
    	copy.timestamp = timestamp;
    	return copy;
    }
    
    @Override
    public String toString() {
	return String.format(
		"Quote [articleId=%s, category=%s, favorite=%s, quoteText=%s, quoteId=%s, sourceId=%s, timestamp=%s]",
		articleId, category, favorite, quoteText, quoteId, sourceId, timestamp);
    }

}
