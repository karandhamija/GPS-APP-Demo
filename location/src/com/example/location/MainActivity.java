package com.example.location;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends MapActivity 
{    
		MapView mapView;
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        mapView = (MapView) findViewById(R.id.mapView);
	        LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);  
	        View zoomView = mapView.getZoomControls(); 
	 
	        zoomLayout.addView(zoomView, 
	            new LinearLayout.LayoutParams(
	                LayoutParams.WRAP_CONTENT, 
	                LayoutParams.WRAP_CONTENT)); 
	        mapView.displayZoomControls(true);
	    }
	 
	    public boolean onKeyDown(int keyCode, KeyEvent event) 
	    {
	        MapController mc = mapView.getController(); 
	        switch (keyCode) 
	        {
	            case KeyEvent.KEYCODE_3:
	                mc.zoomIn();
	                break;
	            case KeyEvent.KEYCODE_1:
	                mc.zoomOut();
	                break;
	        }
	        return super.onKeyDown(keyCode, event);
	    } 
	    
	    @Override
	    protected boolean isRouteDisplayed() {
	        return false;
	    }
}
