package com.lifenow.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class UpdateDataService extends Service {

    @Override
    public void onStart(Intent intent, int startId) {
	new Thread() {
	    public void run() {
		final Intent updateIntent = new Intent(UpdateDataService.this, UpdateDataService.class);
		final PendingIntent pendingIntent = PendingIntent
			.getService(UpdateDataService.this, 0, updateIntent, 0);

		final long nextUpdate = System.currentTimeMillis() + 60000;
		final AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, nextUpdate, pendingIntent);

	    }
	}.start();
    }

    @Override
    public IBinder onBind(Intent arg0) {
	// TODO Auto-generated method stub
	return null;
    }

}
