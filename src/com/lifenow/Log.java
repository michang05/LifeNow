package com.lifenow;

import android.util.Config;

public class Log {
    public final static String LOGTAG = "Viida";

    private static final boolean DEBUG = true;
    // private static final boolean DEBUG = false;
    static final boolean LOGV = DEBUG ? Config.LOGD : Config.LOGV;

    public static void v(String msg) {
	if (LOGV) {
	    //android.util.Log.v(LOGTAG, msg);
	}
    }

    public static void e(String msg) {
	// android.util.Log.e(LOGTAG, msg);
    }
}
