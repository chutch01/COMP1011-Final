package com.example.demo;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
/**
 * This is a heart rate calculator that takes in the age of the user and gives them the maximum range they are looking for,
 * and the range that they want to be kept in
 * 
 * @author Cody Hutchinson
 * @version April 16, 2015
 */
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //local variables
        final LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout1);
        final RadioButton MALE_RADIO_BUTTON = (RadioButton)findViewById(R.id.maleRadioButton);
        final RadioButton FEMALE_RADIO_BUTTON = (RadioButton)findViewById(R.id.femaleRadioButton);
        final EditText AGE_EDIT_TEXT = (EditText)findViewById(R.id.ageEditText);
        final Button CALCULATE_TARGET_HEART_RATE_BUTTON = (Button)findViewById(R.id.calculateButton);
        final EditText MAX_HEART_RATE_EDIT_TEXT = (EditText)findViewById(R.id.maxHeartEditText);
        final EditText TARGET_RANGE_EDIT_TEXT = (EditText)findViewById(R.id.targetRangeEditText);
        
        //set up event listener when male radio button is clicked
        MALE_RADIO_BUTTON.setOnClickListener(new View.OnClickListener() {
        	 //when male radio button is selected
			@Override
			public void onClick(View v) {
				
				layout.setBackgroundColor(Color.argb(100, 100, 100, 100));
				//set the female radio button to be unchecked
				FEMALE_RADIO_BUTTON.setChecked(false);
			}
		});
        
        //set up event listener when female radio button is clicked
        FEMALE_RADIO_BUTTON.setOnClickListener(new View.OnClickListener() {
       	 //when male radio button is selected
			@Override
			public void onClick(View v) {
				
				layout.setBackgroundColor(Color.argb(10, 10, 10, 10));
				//set the male radio button to be unchecked
				MALE_RADIO_BUTTON.setChecked(false);
			}
		});
        
        //set up the calculate button's on click event
        CALCULATE_TARGET_HEART_RATE_BUTTON.setOnClickListener(new View.OnClickListener() {
			//calculate the max, the highest rate and the lowest rate
			@Override
			public void onClick(View v) {
				double ageValue = 0;
				double maxValue = 0;
				double highRateValue = 0;
				double lowRateValue = 0;
				boolean error = false;
				//set the age value as a number
				try{
					ageValue = Double.parseDouble(AGE_EDIT_TEXT.getText().toString());
				}
				catch(Exception e){
					error = true;
				}
				
				if(!error){
					//calculate the maximum value and then display it
					maxValue = (220 - ageValue);
					MAX_HEART_RATE_EDIT_TEXT.setText(String.format("%.2f", maxValue));
					//calculate the highest rate the the lowest rate, then display both
					highRateValue = (maxValue * 0.85);
					lowRateValue = (maxValue * 0.5);
					
					TARGET_RANGE_EDIT_TEXT.setText(String.format("%.2f" + " - " + "%.2f", lowRateValue, highRateValue));
				}
				
			}
		});
       
        
    }


}
