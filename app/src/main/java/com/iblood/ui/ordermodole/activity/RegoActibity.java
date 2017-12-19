package com.iblood.ui.ordermodole.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegoActibity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.lv_tijiao)
    Button lvTijiao;
    @BindView(R.id.iv_myImage)
  ImageView lvimage;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.lv_ping)
    EditText lvPing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rego_actibity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.lv_tijiao, R.id.iv_myImage, R.id.tv_name, R.id.lv_ping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.lv_tijiao:
                break;
            case R.id.iv_myImage:
                break;
            case R.id.tv_name:
                break;
            case R.id.lv_ping:
                break;
        }
    }
}
