package com.iblood.fellow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuccessActivity extends BaseActivity {


    @BindView(R.id.iv_progress)
    ImageView ivProgress;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.foster_order_id)
    TextView fosterOrderId;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.foster_order_time)
    TextView fosterOrderTime;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.foster_order_money)
    TextView fosterOrderMoney;
    @BindView(R.id.foster_order_btn_ok)
    Button fosterOrderBtnOk;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_success;
    }

    @Override
    protected void initView() {

        //获取当前的年月时分：
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
        Intent intent = getIntent();
        String qian = intent.getStringExtra("qian");
        fosterOrderTime.setText(date);
        fosterOrderMoney.setText(qian);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
