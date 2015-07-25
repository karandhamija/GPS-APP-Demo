/**
 * 
 */
package com.example.gpsdemo.user;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author vishal
 *
 */
public class UserFragmentAdapter extends FragmentPagerAdapter {

	public static final int TOTAL_TABS = 3 ; 
	public static final int TAB_1 = 0 ; 
	public static final int TAB_2 = 1; 
	public static final int TAB_3 = 2 ; 


	
	public UserFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		
		return UserTabsFactory.getTab(position);
	}

	
	@Override
	public int getCount() {
		return TOTAL_TABS;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		
		return UserTabsFactory.getTabTitle(position);
	}

}
