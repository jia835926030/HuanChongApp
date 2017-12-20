package com.iblood.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.entity.MessageBean;
import com.iblood.ui.xiaoxi.LiaoTianActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
//消息列表
public class MessageActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.button_backward)
    Button buttonBackward;
    @BindView(R.id.button_forward)
    Button buttonForward;
    @BindView(R.id.layout_titlebar)
    AutoRelativeLayout layoutTitlebar;
    @BindView(R.id.message_listview)
    ListView messageListview;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonForward.setVisibility(View.GONE);
        textTitle.setText("消息");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void initView() {
        buttonBackward.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        final List<MessageBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MessageBean("帅比"+i,R.mipmap.ic_launcher,"我要寄养一条大老服","今天 "+"1"+i+":00"));
        }
        MessageAdapter adapter = new MessageAdapter(this,list);
        messageListview.setAdapter(adapter);

        messageListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MessageActivity.this, LiaoTianActivity.class);
                intent.putExtra("friend",list.get(position).getName());
                Log.e("TAG", "onItemClick: "+ list.get(position).getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_backward:
                finish();
                break;
        }
    }
}
