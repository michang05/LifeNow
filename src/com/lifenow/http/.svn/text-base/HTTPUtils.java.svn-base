package com.lifenow.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HTTPUtils {

    public static synchronized String getUrlContent(String url) throws ApiException, UnknownHostException {

	HttpParams params = new BasicHttpParams();
	HttpConnectionParams.setConnectionTimeout(params, 10000);
	HttpConnectionParams.setSoTimeout(params, 10000);
	HttpConnectionParams.setSocketBufferSize(params, 4028);
	
	final HttpClient client = new DefaultHttpClient(params);
	final HttpGet request = new HttpGet(url);

	try {
	    final HttpResponse response = client.execute(request);

	    // Check if server response is valid
	    final StatusLine status = response.getStatusLine();
	    if (status.getStatusCode() != HttpStatus.SC_OK) {
		throw new ApiException("Invalid response from server: " + status.toString());
	    }

	    // Pull content stream from response
	    final HttpEntity entity = response.getEntity();
	    final InputStream inputStream = entity.getContent();

	    final ByteArrayOutputStream content = new ByteArrayOutputStream();

	    // Read response into a buffered stream
	    int readBytes = 0;
	    while ((readBytes = inputStream.read(sBuffer)) != -1) {
		content.write(sBuffer, 0, readBytes);
	    }

	    // Return result from buffered stream
	    return new String(content.toByteArray());
	} catch (UnknownHostException ukhe) {
	    throw ukhe;
	} catch (IOException e) {
	    throw new ApiException("Problem communicating with API", e);
	}
    }

    private static byte[] sBuffer = new byte[512];

    @SuppressWarnings("serial")
    public static class ApiException extends Exception {
	public ApiException(String detailMessage, Throwable throwable) {
	    super(detailMessage, throwable);
	}

	public ApiException(String detailMessage) {
	    super(detailMessage);
	}
    }

    /**
     * Thrown when there were problems parsing the response to an API call,
     * either because the response was empty, or it was malformed.
     */
    @SuppressWarnings("serial")
    public static class ParseException extends Exception {
	public ParseException(String detailMessage, Throwable throwable) {
	    super(detailMessage, throwable);
	}
    }
}
