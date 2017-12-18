package com.iblood.ui.ordermodole.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.iblood.R;
import com.iblood.ui.ordermodole.bean.NexBean;

import java.util.List;

/**
 * Created by dell on 2017/12/13.
 */

public class NexDapter extends BaseAdapter {
private Context context;
private List<NexBean> mlist;

    public NexDapter(Context context, List<NexBean> mlist) {
        this.context = context;
        this.mlist = mlist;
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
   Horder  horder = null;
     if (view==null){
            horder = new Horder();
       view=  LayoutInflater.from(context).inflate(R.layout.item_mychals,null);
        horder.top_Image =  (ImageView)view.findViewById(R.id.my_topimage);
         horder.net_Image=  (ImageView)  view.findViewById(R.id.titleimage);
         view.setTag(horder);
     }else {
       horder= (Horder) view.getTag();
     }
        Glide.with(context).load(mlist.get(i).getImage()).transform(new GlideCircleTransform(context)).into(horder.net_Image);
       Glide.with(context).load(mlist.get(i).getImage()).transform(new GlideCircleTransform(context)).into(horder.top_Image);
        return view;
    }
    class  Horder{
        ImageView top_Image;
         ImageView net_Image;
    }
}
