package com.iblood.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
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
        List<MessageBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MessageBean("帅比"+i,R.mipmap.ic_launcher,"我要寄养一条大老服","今天 "+"1"+i+":00"));
        }
        MessageAdapter adapter = new MessageAdapter(this,list);
        messageListview.setAdapter(adapter);
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
