/**
 * 
 */
package com.example.gpsdemo.user;

import android.support.v4.app.Fragment;

/**
 * @author vishal
 *
 */
public class UserTabsFactory {
	
	public static  Fragment getTab(int position){
		Fragment userFragment = null ;
		switch (position) {
			case UserFragmentAdapter.TAB_1:
				userFragment =  OrderTracking.getInstance(position);
				break ; 
			case UserFragmentAdapter.TAB_2:
				userFragment =  OrderTracking.getInstance(position);
				break ; 
			case UserFragmentAdapter.TAB_3:
				userFragment =  OrderTracking.getInstance(position);
				break ; 
			}
		return userFragment ;
		
	}
	
	public static String getTabTitle(int position){
		String tabTitle = null ;
		switch (position) {
			case UserFragmentAdapter.TAB_1:
				tabTitle =  "Track Order";
				break ; 
			case UserFragmentAdapter.TAB_2:
				tabTitle =  "Details";
				break ; 
			case UserFragmentAdapter.TAB_3:
				tabTitle =  "Promotions";
				break ; 
			default:
				tabTitle =  "No Title";

				break; 
			}
			
		return tabTitle ;
		
	}

}
