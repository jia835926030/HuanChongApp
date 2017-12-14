package com.iblood.fellow;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FellowActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.pinglun_fellow)
    LinearLayout pinglunFellow;
    @BindView(R.id.lianxi_fellow)
    TextView lianxiFellow;
    @BindView(R.id.queding_fellow)
    TextView quedingFellow;
    @BindView(R.id.ll_fellow)
    LinearLayout llFellow;
    private View v1;
    private PopupWindow popu1;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_fellow;
    }

    @Override
    protected void initView() {
        pinglunFellow.setOnClickListener(this);
        lianxiFellow.setOnClickListener(this);
        quedingFellow.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pinglun_fellow:
                Intent intent = new Intent(FellowActivity.this, PingLunActivity.class);
                startActivity(intent);
                break;
            case R.id.lianxi_fellow:

                popu();
                break;
            case R.id.queding_fellow:
                Intent intent1 = new Intent(FellowActivity.this, YuYueActivity.class);
                startActivity(intent1);
                break;
            case R.id.dianhua_call:
                Toast.makeText(this, "打电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xiaoxi_call:
                Toast.makeText(this, "发消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quxiao_call:
                popu1.dismiss();
                break;
        }
    }

    private void popu() {
        //显示popuwindow
        v1 = LayoutInflater.from(FellowActivity.this).inflate(R.layout.call_popu, null);
        //创建一个popuwindow对象
        popu1 = new PopupWindow(v1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAtLocation(llFellow, Gravity.BOTTOM,0,0);

        View dianhua_call = v1.findViewById(R.id.dianhua_call);
        View xiaoxi_call = v1.findViewById(R.id.xiaoxi_call);
        View quxiao_call = v1.findViewById(R.id.quxiao_call);
        dianhua_call.setOnClickListener(this);
        xiaoxi_call.setOnClickListener(this);
        quxiao_call.setOnClickListener(this);
    }
}
