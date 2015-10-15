package com.lifenow;

import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SourcePrefList extends Activity{
    
    String[] sources = null;
    String[] sourcesCodes = null;
    ListView list;
    SharedPreferences pref;
    Set<String> sourceSet = new HashSet<String>();
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.source_preflist);
        
        pref = getSharedPreferences("lifenow", Activity.MODE_PRIVATE);
        sources = getResources().getStringArray(R.array.Source_Name);
        sourcesCodes = getResources().getStringArray(R.array.Source_Name_Codes);
        
        String sourceString = pref.getString("sources", "00ztgIm6N46jg,0dmgbH7fqLbMT,04Xt71JaPXcaH,0bYNckA4Bxc6A,0aFS1Gt4xu6Ih,02geckG8IH1d4,0flCaCM3LkeiV,0blKbZP140g1Z,01DFbf7cnK4sc,0csee4fg3o5i4,0g0BarQeCPe2i,0eAceMCfZg0Zz,0gTcffMcyQ1Ax,0cZg7ph3O9eeF,0083e6H4MndJP");
        String[] temp = sourceString.split(",");
        for(String s : temp){
            sourceSet.add(s);
        }
        
        
        list = (ListView) findViewById(R.id.list);
        //list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setItemsCanFocus(false);
        //list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, sources));
        list.setAdapter(new SourceListAdapter());
        list.setCacheColorHint(0);
        list.setBackgroundColor(Color.BLACK);
        list.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
		Log.v(sources[index]);
		//list.setItemChecked(index, false);
		boolean checked = ((CheckedTextView)arg1).isChecked();
		if(!checked){
		    Log.v("adding::::::::::::: "+sourcesCodes[index]);
		    sourceSet.add(sourcesCodes[index]);
		}else{
		    Log.v("removing::::::::::::: "+sourcesCodes[index]);
		    sourceSet.remove(sourcesCodes[index]);
		}
		
		((CheckedTextView)arg1).setChecked(!checked);
	    }
            
	});
    }
    
    
    protected void onPause() {
	StringBuilder builder = new StringBuilder();
	for(String s : sourceSet){
	    Log.v(s);
	    builder.append(s+",");
	}
	
	pref.edit().putString("sources", builder.toString()).commit();
	finish();
	
	super.onPause();
    };
    
    
   
    class SourceListAdapter extends BaseAdapter{
	
	

	@Override
	public int getCount() {
	    return sources.length;
	}

	@Override
	public Object getItem(int arg0) {
	    return sources[arg0];
	}

	@Override
	public long getItemId(int arg0) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup arg2) {
	    View view = convertView;
	    SourcePrefRowHandler row;
	    if(view == null){
		view = LayoutInflater.from(getBaseContext()).inflate(android.R.layout.simple_list_item_multiple_choice, null);
		view.setPadding(10, 20, 10, 20);
		row = new SourcePrefRowHandler();
		row.checkbox = (CheckedTextView) view.findViewById(android.R.id.text1);
		view.setTag(row);
	    }else{
		row = (SourcePrefRowHandler) view.getTag();
	    }
	    
	    
	    row.checkbox.setText(sources[index]);
	    row.checkbox.setChecked(sourceSet.contains(sourcesCodes[index]));
	    //list.setItemChecked(index, true);
	    return view;
	}
	
    }
    
    class SourcePrefRowHandler{
	public CheckedTextView checkbox;	
    }
}
