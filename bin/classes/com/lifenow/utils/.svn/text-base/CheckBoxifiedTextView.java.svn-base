package com.lifenow.utils;

import com.lifenow.Log;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckBoxifiedTextView extends LinearLayout {

	private TextView mText;
	private CheckBox mCheckBox;
	private CheckBoxifiedText mCheckBoxText;

	public CheckBoxifiedTextView(Context context,
			CheckBoxifiedText aCheckBoxifiedText) {
		super(context);
		
		setPadding(5, 5, 5, 5);

		/*
		 * First CheckBox and the Text to the right (horizontal), not above and
		 * below (vertical)
		 */
		this.setOrientation(HORIZONTAL);
		mCheckBoxText = aCheckBoxifiedText;
		mCheckBox = new CheckBox(context);
		//mCheckBox.setPadding(0, 0, 20, 0); // 5px to the right

		/* Set the initial state of the checkbox. */
		mCheckBox.setChecked(aCheckBoxifiedText.ismChecked());
		mCheckBox.setOnClickListener(new OnClickListener() {
			/**
			 * Check or uncked the current checkbox!
			 */
			@Override
			public void onClick(View v) {
				// Force both the checkbox and our own type to be cehcked or
				if(getCheckBoxState()==true) {
					Log.v(mText.getText().toString()+" was clicked");
				}else {
					Log.v(mText.getText().toString()+" was unclicked");
				}
				// unchecked!
				// It's not needed to check the box again but reusing our
				// functions is not too bad
				setCheckBoxState(getCheckBoxState());
			}
		});
		/*
		 * At first, add the CheckBox to ourself (! we are extending
		 * LinearLayout)
		 */
		addView(mCheckBox, new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		mText = new TextView(context);
		mText.setTextColor(Color.WHITE);
		mText.setText(aCheckBoxifiedText.getmText());
		 mText.setPadding(10, 0, 15, 0);
		addView(mText, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
	}

	public void setText(String words) {
		mText.setText(words);
	}

	public void toggleCheckBoxState() {
		setCheckBoxState(!getCheckBoxState());
	}

	public void setCheckBoxState(boolean bool) {
		mCheckBox.setChecked(bool);
		mCheckBoxText.setmChecked(bool);
	}

	public boolean getCheckBoxState() {
		return mCheckBox.isChecked();
	}
}
