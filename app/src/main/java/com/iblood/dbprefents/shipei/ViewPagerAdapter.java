package com.iblood.dbprefents.shipei;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter{

	   List<Fragment> fragmentList;

	public ViewPagerAdapter(FragmentManager fm , List<Fragment> fragmentss) {
		super(fm);
		this.fragmentList=fragmentss;

	}


	@Override
	public Fragment getItem(int arg0) {
		return fragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

}
