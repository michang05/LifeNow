package com.lifenow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		new Handler().postDelayed(new Runnable() {
			public void run() {
				final Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		}, 5000);

	}
}
