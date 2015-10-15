package com.lifenow.utils;

import twitter4j.Status;
import twitter4j.TwitterException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.lifenow.daypi.TwitterUtil;

public class LifeNowUtils {
	public static void sendSMS(final Context context, String message) {
		final Intent sendIntent = new Intent(Intent.ACTION_VIEW);
		sendIntent.putExtra("sms_body", message);
		sendIntent.setType("vnd.android-dir/mms-sms");
		context.startActivity(sendIntent);
	}

	public static void sendEmail(final Context context, String message) {
		final Intent sendIntent = new Intent(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, message);
		sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Viida News");
		sendIntent.setType("message/rfc822");
		context.startActivity(Intent.createChooser(sendIntent, "Title:"));
	}

	public static void sendTwit(final Context context, String message) {

		Status status = null;
		try {
			status = TwitterUtil.getInstance().updateStatus(message);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Twitter.Status status = twitter.updateStatus(message);
		if (!status.getText().equals(message)) {
			new AlertDialog.Builder(context)
					.setTitle("Twitter")
					.setMessage(
							"Unable to update status on twitter. Please check and try again.")
					.setPositiveButton("OK", null).create().show();
		} else {
			Toast.makeText(context, "Twitter status updated", 1500).show();
		}

	}

	public static void openBrowser(Activity activity, String url) {
		final Uri uri = Uri.parse(url);
		final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		activity.startActivityIfNeeded(intent, 0);
	}

}
