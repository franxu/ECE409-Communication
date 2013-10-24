package com.example.communication;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class MainActivity extends Activity {
	TextView httpStuff;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//StrictMode is required to add if Android version is higher than 3.0
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
		StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//set the data string to the textview
		httpStuff = (TextView) findViewById(R.id.tvHttp);
		//GetMethod is a httpClient which handle the HTTPGet
		GetMethod result = new GetMethod();
		String returned = result.getInternetData();
		httpStuff.setText(returned);
		
	}
}
