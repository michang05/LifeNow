package com.lifenow;

import android.app.AlertDialog;

import com.commonsware.cwac.cache.SimpleWebImageCache;
import com.lifenow.utils.ThumbnailBus;
import com.lifenow.utils.ThumbnailMessage;

public class Application extends android.app.Application {
    private ThumbnailBus bus = new ThumbnailBus();
    private SimpleWebImageCache<ThumbnailBus, ThumbnailMessage> cache = new SimpleWebImageCache<ThumbnailBus, ThumbnailMessage>(
	    null, null, 101, bus);

    public Application() {
	super();

	Thread.setDefaultUncaughtExceptionHandler(onBlooey);
    }

    void goBlooey(Throwable t) {
	AlertDialog.Builder builder = new AlertDialog.Builder(this);

	builder.setTitle("Error").setMessage(t.toString()).setPositiveButton("Ok", null).show();
    }

    ThumbnailBus getBus() {
	return (bus);
    }

    SimpleWebImageCache<ThumbnailBus, ThumbnailMessage> getCache() {
	return (cache);
    }

    private Thread.UncaughtExceptionHandler onBlooey = new Thread.UncaughtExceptionHandler() {
	public void uncaughtException(Thread thread, Throwable ex) {
	    Log.v("Uncaught exception: " + ex.getMessage());
	    ex.printStackTrace();
	    goBlooey(ex);
	}
    };
}
