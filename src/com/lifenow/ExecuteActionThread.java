package com.lifenow;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.lifenow.daypi.APIHelper;
import com.lifenow.pojo.Article;
import com.lifenow.utils.LifeNowUtils;

public class ExecuteActionThread extends Thread {

    Context context;
    Article article;
    int selectedIndex;

    public ExecuteActionThread(Context context, Article article, int selectedIndex) {
	this.context = context;
	this.article = article;
	this.selectedIndex = selectedIndex;
    }

    @Override
    public void run() {
	String shortUrl = "";
	try {
	    shortUrl = new LoadShortURLTask().execute(article.getUrl()).get();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	    return;

	} catch (ExecutionException e) {
	    e.printStackTrace();
	    return;
	}

	if (shortUrl == null) {
	    new AlertDialog.Builder(context).setTitle("Network Error").setMessage("Unable to communicate with server")
		    .setPositiveButton("OK", null).create().show();

	    return;
	}

	final String message = article.getHeadline() + " " + shortUrl;

	switch (selectedIndex) {
	case 0:
	    LifeNowUtils.openBrowser((Activity) context, article.getUrl());
	    break;
	case 1:
	    LifeNowUtils.sendSMS(context, message);
	    break;
	case 2:
	    LifeNowUtils.sendEmail(context, message);
	    break;
	case 3:
	    LifeNowUtils.sendTwit(context, message);
	    break;
	}
    }

    class LoadShortURLTask extends AsyncTask<String, String, String> {

	ProgressDialog dialog;

	@Override
	protected void onPreExecute() {
	    dialog = new ProgressDialog(context);
	    dialog.setIndeterminate(true);
	    dialog.setMessage("Converting link to short url");
	    dialog.show();
	}

	@Override
	protected String doInBackground(String... params) {
	    try {
		return APIHelper.getShortURL(params[0]);
	    } catch (Exception e) {

	    }

	    return null;
	}

	@Override
	protected void onPostExecute(String result) {
	    if (dialog != null && dialog.isShowing()) {
		dialog.dismiss();
	    }

	    if (result == null) {
		new AlertDialog.Builder(context).setTitle("Network Error").setMessage(
			"Unable to contact server. Please check internet connection").setPositiveButton("OK", null)
			.create().show();
	    }

	    super.onPostExecute(result);
	}
    }

}
