package com.xk.test.alarm2;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmMainActivity extends Activity {
	Button btnSetTime;
	AlarmManager aManager;
	static final String LOG_TAG="log";
	Calendar currentTime=Calendar.getInstance();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnSetTime=(Button)findViewById(R.id.btnSetTime);
        
        aManager=(AlarmManager)getSystemService(ALARM_SERVICE);
	
        
        btnSetTime.setOnClickListener(new OnClickListener()
        {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar currentTime=Calendar.getInstance();
				new TimePickerDialog(AlarmMainActivity.this, 0,new TimePickerDialog.OnTimeSetListener() 
				   {					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(AlarmMainActivity.this,alarmResult.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						Log.i(LOG_TAG,"a");
						PendingIntent pi=PendingIntent.getActivity(AlarmMainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
						Log.i(LOG_TAG,"b");
						Calendar c=Calendar.getInstance();
						c.setTimeInMillis(System.currentTimeMillis());
						c.set(Calendar.HOUR,hourOfDay);
						c.set(Calendar.MINUTE, minute);
						aManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
						Toast.makeText(AlarmMainActivity.this, "…Ë÷√≥…π¶"+hourOfDay+" "+minute, 5000).show();
					}
				},
				currentTime.get(Calendar.HOUR_OF_DAY),//HOUR_OF_DAY
				currentTime.get(Calendar.MINUTE),true).show();
			}//end onClick

		});
    }

}