package com.example.gpsdemo;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
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
	AlertDialog.Builder dialog = null;
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
			if(!isLocationEnabled()){
				if(dialog != null)
					dialog.show();
			}else{
				Toast.makeText(this, "Data Sent to Server", Toast.LENGTH_LONG).show();
			}
			
			break;
		}
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("karan", "OnPause");
	}
	
	public boolean isLocationEnabled(){
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		boolean gps_enabled = false;
		boolean network_enabled = false;

		try {
		    gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
		    Log.v("karan", "gps_enabled value as " + gps_enabled);
		} catch(Exception ex) {}

		try {
		    network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		    Log.v("karan", "network_enabled value as " + network_enabled);
		} catch(Exception ex) {}

		if(!gps_enabled && !network_enabled) {
		    // notify user
		    dialog = new AlertDialog.Builder(this);
		    dialog.setMessage(getResources().getString(R.string.gps_network_not_enabled));
		    dialog.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
		    dialog.setPositiveButton(getResources().getString(R.string.open_location_settings), new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
		                // TODO Auto-generated method stub
		                Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		                startActivity(myIntent);
		                //get gps
		            }
		        });
		    dialog.setNegativeButton(getString(R.string.cancel_dialog), new DialogInterface.OnClickListener() {

		            @Override
		            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
		                // TODO Auto-generated method stub
		            	
		            }
		        });    
		}
		Log.v("karan", "returning value as " + (!gps_enabled && !network_enabled));
		return (gps_enabled && network_enabled);
	}
}
