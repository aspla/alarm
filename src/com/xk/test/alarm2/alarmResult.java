package com.xk.test.alarm2;

import android.app.Activity;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.os.Bundle;

public class alarmResult extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.main);
		//alarmMusic=MediaPlayer.create(this, R.raw.alerm);
		//alarmMusic.setLooping(true);
		//alarmMusic.start();
		new AlertDialog.Builder(alarmResult.this)
		   .setTitle("ƒ÷÷”")
		   .setMessage("ƒ÷÷”œÏ¡À")
		   .setPositiveButton("»∑∂®", new DialogInterface.OnClickListener() {
			
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
				   // TODO Auto-generated method stub
				   //alarmMusic.stop();
				   alarmResult.this.finish();
			    }
		     }
		   ).show();
	}


}
