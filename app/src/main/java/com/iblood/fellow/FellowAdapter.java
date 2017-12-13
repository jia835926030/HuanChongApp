package com.iblood.fellow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iblood.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2017/12/12.
 */

public class FellowAdapter extends BaseAdapter {
    private Context context;
    private List<FellowBean> list;

    public FellowAdapter(Context context, List<FellowBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
        holder.nameHome.setText(list.get(position).getName());
        holder.dizhiHome.setText(list.get(position).getDizhi());
        holder.jiageHome.setText(list.get(position).getJiage());
        holder.juliHome.setText(list.get(position).getJuli());
        Glide.with(context).load(list.get(position).getImg()).into(holder.imgHomelv);
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
