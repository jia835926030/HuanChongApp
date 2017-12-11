package com.iblood.ui.ordermodole;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderActivity extends BaseActivity {

    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.button_backward)
    Button buttonBackward;
    @BindView(R.id.button_forward)
    Button buttonForward;
    @BindView(R.id.layout_titlebar)
    AutoRelativeLayout layoutTitlebar;
    @BindView(R.id.myorder_tab)
    TabLayout myorderTab;
    @BindView(R.id.myorder_viewpager)
    ViewPager myorderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        ArrayList<String> tablist=new ArrayList<>();
        tablist.add("全部");
        tablist.add("待确认");
        tablist.add("寄养中");
        tablist.add("待评价");
        ArrayList<Fragment> fragmentlist=new ArrayList<>();
        WholeFragment wholeFragment=new WholeFragment();
        ConfirmFragment confirmFragment=new ConfirmFragment();
        EvaluateFragment evaluateFragment=new EvaluateFragment();
        FosterFragment fosterFragment=new FosterFragment();
        fragmentlist.add(wholeFragment);
        fragmentlist.add(confirmFragment);
        fragmentlist.add(evaluateFragment);
        fragmentlist.add(fosterFragment);
        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(getSupportFragmentManager(),tablist,fragmentlist);
        Log.e("initData========: ", fragmentlist.size()+"");
        Log.e("initData========: ", tablist.size()+"");
        myorderViewpager.setAdapter(myOrderAdapter);
        myorderViewpager.setCurrentItem(0);
        myorderTab.setupWithViewPager(myorderViewpager);
    }

    @Override
    protected void initListener() {

    }
}
