/**
 * 
 */
package com.lifenow;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lifenow.utils.CheckBoxifiedText;
import com.lifenow.utils.CheckBoxifiedTextListAdapter;

/**
 * @author Michael Angelo
 * 
 */
public class SourceNames extends ListActivity {

	private static final int SAVE =Menu.FIRST;
	private static final int SELECT_ALL =Menu.FIRST+1;
	private static final int DESELECT_ALL=Menu.FIRST+2;
	
	// Create CheckBox List Adapter, cbla
	private CheckBoxifiedTextListAdapter cbla;
	

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.source_names_list);
		
		// Array of string we want to display in our list
		String[] items = getResources().getStringArray(R.array.Source_Name);
		Log.v(items.length + " |" + items[0]);
		cbla = new CheckBoxifiedTextListAdapter(this);
		for (int k = 0; k < items.length; k++) {
			cbla.addItem(new CheckBoxifiedText(items[k], false));
		}
		// Display it
		setListAdapter(cbla);
		
		getListView().setBackgroundColor(Color.BLACK);
		getListView().setCacheColorHint(0);
	}

	/*
	 * Remember the other methods of the CheckBoxifiedTextListAdapter class!!!!
	 * cbla.selectAll() :: Check all items in list cbla.deselectAll() :: Uncheck
	 * all items
	 */
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, SAVE, 0, "Save").setIcon(R.drawable.save_sources);
		menu.add(0, SELECT_ALL, 0, "Select All").setIcon(R.drawable.selectall);
		menu.add(0, DESELECT_ALL, 0, "Deselect All").setIcon(R.drawable.deselect);
		return super.onCreateOptionsMenu(menu);
	}
	
	/*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case SELECT_ALL:
	   cbla.selectAll();
	    break;
	case DESELECT_ALL:
		cbla.deselectAll();
		break;
	case SAVE:
		   cbla.save();
		    break;
	}
	return super.onOptionsItemSelected(item);
    }
}
