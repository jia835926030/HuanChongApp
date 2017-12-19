package com.iblood.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iblood.R;
import com.iblood.entity.PetAddBean;
import com.iblood.entity.PetInfo;

import java.util.List;

/**
 * Created by 刘贵河 on 2017/12/11.
 */

public class MyPetAdapter extends BaseAdapter {
    private Context context;
    private List<PetInfo> petInfos;

    private RelativeLayout mItem;


    public MyPetAdapter(Context context, List<PetInfo> petInfos) {
        super();
        this.context = context;
        this.petInfos = petInfos;
    }

    @Override
    public int getCount() {
        return petInfos.size();
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
        ViewHolder vh = null;
        if (view == null) {
            view = View.inflate(context, R.layout.pet_layout_item, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        //To Do
        Glide.with(context).load(petInfos.get(i).getPetImage()).into(vh.imgface);
        vh.petName.setText(petInfos.get(i).getPetName());
        vh.petIntroduce.setText(petInfos.get(i).getIsSterilization());
        return view;
    }



    public static class ViewHolder {
        public View rootView;
        private ImageView imgface;
        private TextView petName;
        private TextView petIntroduce;
        private ImageView petsexy;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            imgface = rootView.findViewById(R.id.imageView2);
            petName = rootView.findViewById(R.id.pet_name);
            petIntroduce = rootView.findViewById(R.id.petintroduce);
            petsexy = rootView.findViewById(R.id.pet_sexy);
        }

    }

}
