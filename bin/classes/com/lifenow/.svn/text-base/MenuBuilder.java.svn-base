package com.lifenow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public class MenuBuilder {

    private final static int REFRESH_MENU_ID = 0;
    private final static int ABOUT_MENU_ID = 1;
    private final static int SETTINGS_MENU_ID = 2;
    
    public static void buildRefreshMenuItem(final Context context, Menu menu, int order) {
	final MenuItem refreshMenuItem = menu.add(Menu.CATEGORY_SECONDARY, REFRESH_MENU_ID, order, "Refresh");
	refreshMenuItem.setIcon(R.drawable.refresh);
	refreshMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
	    public boolean onMenuItemClick(MenuItem item) {
		((MainActivity)context).refreshList();
		return false;
	    }
	});
    }

    public static void buildSettingsMenuItem(final Context context, Menu menu, int order) {
	final MenuItem settingsMenuItem = menu.add(Menu.CATEGORY_SECONDARY, SETTINGS_MENU_ID, order, "Settings");
	settingsMenuItem.setIcon(R.drawable.settings);
	settingsMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
	    public boolean onMenuItemClick(MenuItem item) {
		Intent settings = new Intent(context, Settings.class);
		context.startActivity(settings);
		return false;
	    }
	});
    }

    public static void buildAboutMenuItem(final Context context, Menu menu, int order) {
	final MenuItem aboutMenuItem = menu.add(Menu.CATEGORY_SECONDARY, ABOUT_MENU_ID, order, "About");
	aboutMenuItem.setIcon(R.drawable.about);
	aboutMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
	    public boolean onMenuItemClick(MenuItem item) {
		new AlertDialog.Builder(context)
			.setTitle("About")
			.setIcon(R.drawable.about)
			.setMessage(
				"Created by Michael Angelo Rivera and Marc Lester Tan for Smart Developer Conference & Competition")
			.setPositiveButton("Ok", null).create().show();

		return false;
	    }
	});
    }

}
