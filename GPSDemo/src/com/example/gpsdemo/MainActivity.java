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

public class MainActivity extends ActionBarActivity implements OnClickListener{

	AlertDialog.Builder dialog = null;
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
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(!isLocationEnabled()){
			if(dialog != null)
				dialog.show();
		}
		
		
		
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
					finish();
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
		            	finish();

		            }
		        });    
		}
		Log.v("karan", "returning value as " + (!gps_enabled && !network_enabled));
		return (gps_enabled && network_enabled);
	}
}
