package com.example.gpsdemo;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantOrder extends ActionBarActivity implements OnClickListener{

	public static String TIME_TO_DELIVERY_PICKUP = "time to delivery pickup";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_datafill);
		Intent intent = getIntent();
		int mTimeToDeliveryPickup = intent.getIntExtra(TIME_TO_DELIVERY_PICKUP, 0);
		EditText mPhoneNumber = (EditText) findViewById(R.id.editText1);
		TextView pickupTime = (TextView) findViewById(R.id.timedelivery);
		pickupTime.setText("Picking Delivery in " + mTimeToDeliveryPickup + " Minutes");
		
		Button submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(this);
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
		switch (v.getId()){
		
		case R.id.submit :
			Toast.makeText(this, "Data Sent to Server", Toast.LENGTH_LONG).show();
			break;
		}
		
	}
}
