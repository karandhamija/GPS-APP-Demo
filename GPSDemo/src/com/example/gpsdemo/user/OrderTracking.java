/**
 * 
 */
package com.example.gpsdemo.user;

import com.example.gpsdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author vishal
 *
 */
public class OrderTracking extends Fragment {
	
	public static final String TAG_FIXED = "order";
	public static final String TAG_POSITION = "position";

	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}




	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}




	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}




	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_main, container, false);
		return v;
	}




	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}




	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}




	/**
	 * returns new instance of OrderTracking 
	 */
	public static OrderTracking getInstance(int position){
		OrderTracking orderFragment = new OrderTracking();
		Bundle args = new Bundle();
        args.putInt(TAG_POSITION, position);
        args.putString(TAG_FIXED, TAG_FIXED);
        orderFragment.setArguments(args);
        return orderFragment;
	}
	
}
