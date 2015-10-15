/**
 * 
 */
package com.lifenow.preferences;


/**
 * @author Michael Angelo
 *
 */
public class SourcePreferences extends BasePreferences{

	public static final String CHECKED ="checked";
	public static final boolean DEFAULT_CHECKED=false;
	
	
	
	 public static void setChecked(boolean checked) {
	    	editor.putBoolean(CHECKED,checked);
	    }
	    
	    public static boolean getChecked() {
	    	return settings.getBoolean(CHECKED,DEFAULT_CHECKED);
	    }
	    
	    
}
