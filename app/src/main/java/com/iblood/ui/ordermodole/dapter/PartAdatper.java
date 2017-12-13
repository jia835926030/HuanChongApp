package com.iblood.ui.ordermodole.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.iblood.R;

import java.util.List;

/**
 * Created by dell on 2017/12/13.
 */

public class PartAdatper extends BaseAdapter {
     private List<String> mlist;
     private Context context;

    public PartAdatper(List<String> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
     view =   LayoutInflater.from(context).inflate(R.layout.item_appraise,null);
        return view;
    }
}
