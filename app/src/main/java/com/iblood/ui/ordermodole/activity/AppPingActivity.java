package com.iblood.ui.ordermodole.activity;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.ui.ordermodole.xing.RatingBar;

public class AppPingActivity extends BaseActivity {

    private RatingBar mRatingBar;

    @Override
    protected int getLayoutId() {
       // return R.layout.activity_app_ping;
        return R.layout.item_enenting ;
    }

    @Override
    protected void initView() {
        mRatingBar = (com.iblood.ui.ordermodole.xing.RatingBar) findViewById(R.id.star);
    }

    @Override
    protected void initData() {
        mRatingBar.setClickable(true);
        mRatingBar.setStar(3.5f);
    }

    @Override
    protected void initListener() {

    }
}
