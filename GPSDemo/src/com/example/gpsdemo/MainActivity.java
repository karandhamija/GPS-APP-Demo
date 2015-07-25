package com.example.gpsdemo;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button myBoy = (Button) findViewById(R.id.my_boy);
		myBoy.setOnClickListener(this);
		Button restaurant = (Button) findViewById(R.id.restaurant);
		restaurant.setOnClickListener(this);
		Button end_user = (Button) findViewById(R.id.end_user);
		end_user.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent mIntent = null;
		switch (v.getId()){
		
		case R.id.my_boy :
			mIntent = new Intent(this, MyBoy.class);
			break;
		case R.id.restaurant :
			mIntent = new Intent(this, Restaurant.class);
			break;
		case R.id.end_user :
			mIntent = new Intent(this, EndUser.class);
			break;
			
		}
		
		if(mIntent != null)
			startActivity(mIntent);
		
	}
}
