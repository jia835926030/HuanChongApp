package com.iblood.ui.ordermodole.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.ui.ordermodole.xing.RatingBar;

import butterknife.BindView;
import butterknife.OnClick;

public class AppPingActivity extends BaseActivity {

    private RatingBar mRatingBar;
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;

    @Override
    protected int getLayoutId() {
       // return R.layout.activity_app_ping;
        return R.layout.item_enenting ;
    }

    @Override
    protected void initView() {
        header_title.setText("订单详情");
        button_forward.setVisibility(View.GONE);
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
    @OnClick({R.id.button_backward})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.button_backward:
                finish();
                break;
        }
    }
}
