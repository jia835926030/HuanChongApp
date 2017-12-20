package com.iblood.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;

public class WalletActivity extends AppCompatActivity {

    private ImageView wall_back_back;
    private TextView wallsend;
    private TextView tv_Balance;
    private TextView zhifubao;
    private TextView youhuijquan;
    private TextView jifen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        initView();
        wall_back_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void initView() {
        wall_back_back = (ImageView) findViewById(R.id.wall_back_back);
        wallsend = (TextView) findViewById(R.id.wallsend);
        tv_Balance = (TextView) findViewById(R.id.tv_Balance);
        zhifubao = (TextView) findViewById(R.id.zhifubao);
        youhuijquan = (TextView) findViewById(R.id.youhuijquan);
        jifen = (TextView) findViewById(R.id.jifen);
    }
}
