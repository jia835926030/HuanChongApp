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
 * Created by asus on 2017/12/13.
 */

public class PingLunAdapter extends BaseAdapter {
    private Context context;
    private List<PingLunBean> list;

    public PingLunAdapter(Context context, List<PingLunBean> list) {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.pinglun_fellow, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.namePinglun.setText(list.get(position).getName());
        holder.pingjiaPinglun.setText(list.get(position).getText());
        holder.leixingPinglun.setText(list.get(position).getZhonglei());
        holder.shijianPinglun.setText(list.get(position).getShiian());
        Glide.with(context).load(list.get(position).getImg()).into(holder.imgPinglun);
        return convertView;
    }



    static class ViewHolder {
        @BindView(R.id.img_pinglun)
        ImageView imgPinglun;
        @BindView(R.id.name_pinglun)
        TextView namePinglun;
        @BindView(R.id.pingjia_pinglun)
        TextView pingjiaPinglun;
        @BindView(R.id.leixing_pinglun)
        TextView leixingPinglun;
        @BindView(R.id.shijian_pinglun)
        TextView shijianPinglun;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
