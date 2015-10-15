/**
 * 
 */
package com.lifenow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.lifenow.utils.SeparatedListAdapter;

/**
 * @author Michael Angelo
 *
 */
public class Settings extends Activity {

	
	public final static String ITEM_TITLE = "title";
	public final static String ITEM_CAPTION = "caption";

	public Map<String, ?> createItem(String title, String caption) {
		Map<String, String> item = new HashMap<String, String>();
		item.put(ITEM_TITLE, title);
		item.put(ITEM_CAPTION, caption);
		return item;
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		List<Map<String, ?>> sourceNames = new LinkedList<Map<String, ?>>();
		sourceNames.add(createItem("Source Names",
				"Sets predefined sources around the globe"));
		List<Map<String, ?>> twitterInfo = new LinkedList<Map<String, ?>>();
		twitterInfo.add(createItem("Twitter Credentials",
				"Sets username and password for your Twitter account"));
		
		// create our list and custom adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this);
		adapter.addSection("Choose Source Names", new SimpleAdapter(this, sourceNames,
				R.layout.list_complex,
				new String[] { ITEM_TITLE, ITEM_CAPTION }, new int[] {
						R.id.list_complex_title, R.id.list_complex_caption }));
		adapter.addSection("Twitter Information", new SimpleAdapter(this, twitterInfo,
				R.layout.list_complex,
				new String[] { ITEM_TITLE, ITEM_CAPTION }, new int[] {
						R.id.list_complex_title, R.id.list_complex_caption }));

		ListView list = new ListView(this);
		list.setAdapter(adapter);
		
		this.setContentView(list);
		list.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapter, View view, int pos,
					long id) {
				Log.d("SETTINGS","selected is: "+adapter.getItemIdAtPosition(pos));
				if(adapter.getItemIdAtPosition(pos)==1) {
					Intent sourceNames = new Intent(Settings.this,SourcePrefList.class);
					startActivity(sourceNames);
				}else if(adapter.getItemIdAtPosition(pos)==3) {
					Intent twitter = new Intent(Settings.this,TwitterLogin.class);
					startActivity(twitter);
				}
			}
		});
		super.onCreate(savedInstanceState);
	}
}
