package com.example.gpsdemo;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Restaurant extends ActionBarActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant);
		Button timeTen = (Button) findViewById(R.id.time_ten);
		timeTen.setOnClickListener(this);
		Button timeTwenty = (Button) findViewById(R.id.time_twenty);
		timeTwenty.setOnClickListener(this);
		Button timeThirty = (Button) findViewById(R.id.time_thirty);
		timeThirty.setOnClickListener(this);
		Button timeForty = (Button) findViewById(R.id.time_forty);
		timeForty.setOnClickListener(this);
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
		Intent mIntent = new Intent(this, RestaurantOrder.class);
		switch (v.getId()){
		
		case R.id.time_ten :
			mIntent.putExtra(RestaurantOrder.TIME_TO_DELIVERY_PICKUP, 10);
			break;
		case R.id.time_twenty :
			mIntent.putExtra(RestaurantOrder.TIME_TO_DELIVERY_PICKUP, 20);
			break;
		case R.id.time_thirty :
			mIntent.putExtra(RestaurantOrder.TIME_TO_DELIVERY_PICKUP, 30);
			break;
		case R.id.time_forty :
			mIntent.putExtra(RestaurantOrder.TIME_TO_DELIVERY_PICKUP, 40);
			break;
			
		}
		
		startActivity(mIntent);
	}
}
