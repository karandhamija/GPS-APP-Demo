/**
 * 
 */
package com.example.gpsdemo.user;

import com.example.gpsdemo.R;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * @author vishal
 *
 */
public class EndUserActivity extends AppCompatActivity {
	
	private ViewPager mPagerEndUser ; 
	private TabLayout mTabLayoutuser ;
	private UserFragmentAdapter mAdapterPager ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enduser);
		initViews();
	}
	
	private void initViews() {
		
		mPagerEndUser = (ViewPager) findViewById(R.id.pager_enduser);
		mTabLayoutuser = (TabLayout) findViewById(R.id.tab_layout_enduser);
		mAdapterPager = new UserFragmentAdapter(getSupportFragmentManager());
		mPagerEndUser.setAdapter(mAdapterPager);
		mTabLayoutuser.setupWithViewPager(mPagerEndUser);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
