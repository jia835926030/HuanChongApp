package com.iblood.ui.ordermodole;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 麦迪 on 2017/12/11.
 */

public class MyOrderAdapter extends FragmentPagerAdapter{
    ArrayList<String> tablist;
    ArrayList<Fragment> fragmentlist;

    public MyOrderAdapter(FragmentManager fm, ArrayList<String> tablist, ArrayList<Fragment> fragmentlist) {
        super(fm);
        this.tablist = tablist;
        this.fragmentlist = fragmentlist;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
}
