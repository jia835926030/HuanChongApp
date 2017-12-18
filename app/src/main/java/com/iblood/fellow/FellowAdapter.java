package com.iblood.fellow;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iblood.R;
import com.iblood.entity.Screen;
import com.iblood.utils.LoadImgUtils;
import com.iblood.utils.SharedPreferencesUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by asus on 2017/12/12.
 */

public class FellowAdapter extends BaseAdapter {
    private Context context;
    List<Screen.DescBean> desc;

    public FellowAdapter(Context context, List<Screen.DescBean> desc) {
        this.context = context;
        this.desc = desc;
    }

    @Override
    public int getCount() {
        return desc.size();
    }

    @Override
    public Object getItem(int position) {
        return desc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_houmelv, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {

            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameHome.setText(desc.get(position).getFamily());
        holder.dizhiHome.setText(desc.get(position).getAddress());
        holder.jiageHome.setText(desc.get(position).getPrice()+"");
        holder.juliHome.setText(desc.get(position).getCoordX()+"");
        //String flag = (String) SharedPreferencesUtils.getParam(context, "flag", "");
        String is = (String) SharedPreferencesUtils.getParam(context, "flag3", "");
       // Log.e(TAG, "getView:"+is);

        if(is.equals("ischeckd")){
            LoadImgUtils loadImgUtils=new LoadImgUtils();
            loadImgUtils.loadImg(context,desc.get(position).getUserImage(),holder.imgHomelv);
            //Glide.with(context).load(R.drawable.a).into(holder.imgHomelv);

        }else if(is.equals("nocheckd")){
            Glide.with(context).load(desc.get(position).getUserImage()).into(holder.imgHomelv);
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.img_homelv)
        ImageView imgHomelv;
        @BindView(R.id.name_home)
        TextView nameHome;
        @BindView(R.id.dizhi_home)
        TextView dizhiHome;
        @BindView(R.id.jiage_home)
        TextView jiageHome;
        @BindView(R.id.juli_home)
        TextView juliHome;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
