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
import com.iblood.ui.ordermodole.dapter.GlideCircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2017/12/13.
 */

public class PingLunAdapter extends BaseAdapter {
    private Context context;
    private List<PingLunBean.DescBean> list;

    public PingLunAdapter(Context context, List<PingLunBean.DescBean> list) {
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
        holder.namePinglun.setText(list.get(position).getUserName());
        holder.pingjiaPinglun.setText(list.get(position).getDescription());
        holder.leixingPinglun.setText(list.get(position).getPetDuration());
        holder.shijianPinglun.setText(list.get(position).getCreateTime());
        Glide.with(context).load(list.get(position).getUserImage()).transform(new GlideCircleTransform(context)).error(R.mipmap.ic_launcher).into(holder.imgPinglun);
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
