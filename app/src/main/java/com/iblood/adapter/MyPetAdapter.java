package com.iblood.adapter;

import android.content.Context;
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

import java.util.List;

/**
 * Created by 刘贵河 on 2017/12/11.
 */

public class MyPetAdapter extends BaseAdapter {
    private Context context;
    private List<PetAddBean> petList;

    private RelativeLayout mItem;


    public MyPetAdapter(Context context, List<PetAddBean> petList) {
        super();
        this.context = context;
        this.petList = petList;
    }

    @Override
    public int getCount() {
        return petList.size();
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
        Glide.with(context).load(petList.get(i).getPetimgurl()).into(vh.imgface);
        vh.petName.setText(petList.get(i).getPetname());
        vh.petIntroduce.setText(petList.get(i).getPetsterilization());



//        vh.petsexy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return view;
    }

//    private void showTipPop(View v) {
//        View inflate = View.inflate(context, R.layout.pet_sexy_pop, null);
//        PopupWindow window = new PopupWindow(inflate, ActionBar.LayoutParams.MATCH_PARENT,
//                android.support.v4.view.ViewPager.LayoutParams.WRAP_CONTENT,
//                true);
//        window.setAnimationStyle(R.style.style_dialog);
//        window.setBackgroundDrawable(new BitmapDrawable());
//        window.showAtLocation(v, Gravity.BOTTOM, 0, 0);
//
//
//
//
//
//    }

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
