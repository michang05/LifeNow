package com.lifenow.daypi;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.http.AccessToken;

public class TwitterUtil {

	
	private static TwitterUtil instance = null;
	

	private TwitterUtil() {
	}

	
	public static TwitterUtil getInstance() {
		if (instance == null) {
			instance = new TwitterUtil();
		}

		return instance;
	}

	public void storeAccessToken(long useId,
			twitter4j.http.AccessToken accessToken) {
		// store accessToken.getToken()
		// store accessToken.getTokenSecret()
	}

	public Status updateStatus(String message) throws TwitterException {

		Twitter twitter = new TwitterFactory().getInstance();
		String oauth_token ="15181205-w23sOPHM7vHvv4IBI936YCfGvXcjB8o3EryvpecxJ";
		String oauth_token_secret = "n14d1Ddd4BJKKZrP5DBhrBgkqUq3MTui78ssMfUfyls";
		AccessToken a = new AccessToken(oauth_token, oauth_token_secret);
		twitter.setOAuthConsumer("YJwsBLKGwzPDG1ptgZFsNw",
				"lpFOmyodo7iWYtRUusWvaYqMek2RE68AKfK4gIFnY");
		twitter.setOAuthAccessToken(a); 
	
		return twitter.updateStatus(message);
	}

}
