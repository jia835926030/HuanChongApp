package com.iblood.ui.setmodoule.dapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dell on 2017/12/14.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<View> mlList;

    public MyPagerAdapter(List<View> list) {
        this.mlList = list;
    }

    @Override
    public int getCount() {
        return mlList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mlList.get(position));
        return mlList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
