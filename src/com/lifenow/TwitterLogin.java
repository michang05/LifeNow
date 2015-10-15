package com.lifenow;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lifenow.daypi.TwitterUtil;
import com.lifenow.preferences.RememberMePreferences;

public class TwitterLogin extends Activity implements Button.OnClickListener {

    private static final String TAG = "TWITTER";

    private EditText mUsername;
    private EditText mPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.twitter_login);

	mUsername = (EditText) findViewById(R.id.txtUserId);
	mPassword = (EditText) findViewById(R.id.txtPassword);

	Button saveButton = (Button) findViewById(R.id.save);
	saveButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		RememberMePreferences.setUsername(mUsername.getText().toString());
		RememberMePreferences.setPassword(mPassword.getText().toString());
		RememberMePreferences.save();
//		try {
//			TwitterUtil.getInstance().init(getApplicationContext());
//		} catch (TwitterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		setResult(Activity.RESULT_OK, getIntent());
		finish();
	    }
	});

	Button cancelButton = (Button) findViewById(R.id.cancel);
	cancelButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		setResult(Activity.RESULT_CANCELED);
		finish();
	    }
	});

	// load the preferences
	RememberMePreferences.load(this);

	mUsername.setText(RememberMePreferences.getUserName());
	mPassword.setText(RememberMePreferences.getPassword());
    }

    private void processValues(String u, String p) {

	try {
	    if (u == null || p == null || (u.equals("") && p.equals(""))) {
		Toast.makeText(this, "Username/Password cannot be blank", Toast.LENGTH_LONG).show();
	    } else {

		String message = "You just logged in Viida Android Application";

		if (message.length() > 140) {
		    message.substring(0, 140);
		}

		// Make a Twitter object
		Twitter twitter = new Twitter(u, p);

		// Set my status
		Status status = twitter.updateStatus(message);
		boolean success;
		if (status.getText().equals(message)) {
		    success = true;
		    Toast.makeText(TwitterLogin.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
		} else {
		    success = false;
		    Toast.makeText(TwitterLogin.this, "Login Error", Toast.LENGTH_SHORT).show();
		}

	    }
	} catch (TwitterException e) {

	    Toast.makeText(TwitterLogin.this, "Login Error", Toast.LENGTH_SHORT).show();
	    e.printStackTrace();
	} catch (Exception e) {

	    Toast.makeText(this, "Error in Connection", Toast.LENGTH_LONG).show();
	    e.printStackTrace();
	}
    }

    private Handler handler = new Handler() {
	@Override
	public void handleMessage(Message msg) {

	    pd.dismiss();

	    Bundle b = msg.getData();
	    processValues(b.getString("USER"), b.getString("PASS"));
	};
    };

    private ProgressDialog pd;

    @Override
    public void onClick(View arg0) {
	Log.d(TAG, "CLICKED LOG IN");
	pd = ProgressDialog.show(this, "Authenticating", "Logging in...", true, false);

	new Thread() {
	    private Dialog pd;

	    public void run() {
		try {
		    Thread.sleep(3000);
		} catch (Exception e) {
		}

		runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
			String u = mUsername.getText().toString();
			String p = mPassword.getText().toString();

			Message message = new Message();
			Bundle data = new Bundle();
			data.putString("USER", u);
			data.putString("PASS", p);

			message.setData(data);

			handler.sendMessage(message);
		    }
		});
		// Dismiss the Dialog
		try {
		    pd.dismiss();
		} catch (NullPointerException e) {
		    e.printStackTrace();
		}
	    }
	}.start();
    }

}