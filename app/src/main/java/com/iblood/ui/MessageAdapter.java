package com.iblood.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iblood.R;
import com.iblood.ui.MessageBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2017/12/11.
 * 消息列表适配器
 */

public class MessageAdapter extends BaseAdapter {
    private Context context;
    private List<MessageBean> list;

    public MessageAdapter(Context context, List<MessageBean> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_messagelist, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImg()).into(holder.imgMessage);
        holder.nameMessage.setText(list.get(position).getName());
        holder.textMessage.setText(list.get(position).getText());
        holder.shijianMessage.setText(list.get(position).getShijian());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.img_message)
        ImageView imgMessage;
        @BindView(R.id.name_message)
        TextView nameMessage;
        @BindView(R.id.text_message)
        TextView textMessage;
        @BindView(R.id.shijian_message)
        TextView shijianMessage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
