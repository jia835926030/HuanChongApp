package com.iblood.ui.setmodoule;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetUpActivity extends BaseActivity {

    @BindView(R.id.return_img)
    ImageView returnImg;
    @BindView(R.id.proposal_img)
    ImageView proposalImg;
    @BindView(R.id.product_proposal_text)
    TextView productProposalText;
    @BindView(R.id.proposal)
    AutoRelativeLayout proposal;
    @BindView(R.id.introduce)
    AutoRelativeLayout introduce;
    @BindView(R.id.score)
    AutoRelativeLayout score;
    @BindView(R.id.about)
    AutoRelativeLayout about;
    @BindView(R.id.wifi_display)
    AutoRelativeLayout wifiDisplay;
    @BindView(R.id.cache_img)
    ImageView cacheImg;
    @BindView(R.id.cache)
    AutoRelativeLayout cache;
    @BindView(R.id.scavenging_cache)
    AutoRelativeLayout scavengingCache;
    @BindView(R.id.sign_out)
    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_set_up;
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_set_up);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    @OnClick({R.id.proposal,R.id.introduce,R.id.score,R.id.about,R.id.wifi_display,R.id.cache,R.id.scavenging_cache,R.id.sign_out})

    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.proposal:
                Intent intent=new Intent(SetUpActivity.this,ProposalActivity.class);
                startActivity(intent);
                break;
            case R.id.introduce:
                Toast.makeText(this, "新功能介绍", Toast.LENGTH_SHORT).show();
                break;
            case R.id.score:
                Toast.makeText(this, "去评分", Toast.LENGTH_SHORT).show();
                break;

            case R.id.about:
                Toast.makeText(this, "关于欢欢", Toast.LENGTH_SHORT).show();
                break;


            case  R.id.cache:
                Toast.makeText(this, "图片缓存，文件缓存", Toast.LENGTH_SHORT).show();
                break;

            case R.id.scavenging_cache:
                Toast.makeText(this, "清除缓存", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sign_out:
                Toast.makeText(this, "退出登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wifi_display:
                Toast.makeText(this, "仅在WIFI下显示图片", Toast.LENGTH_SHORT).show();
                break;


        }

    }
}
