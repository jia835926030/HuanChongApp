package com.iblood.ui.setmodoule;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.iblood.R;

public class ReagardActivity extends AppCompatActivity {

    private ImageView iv_back;
    private RelativeLayout rl_geng;
    private RelativeLayout rl_tiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reagard);
        iv_back = (ImageView) findViewById(R.id.iv_backg);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**
         * 检查更新
         */
        rl_geng = (RelativeLayout) findViewById(R.id.rl_geng);
        rl_geng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ReagardActivity.this).setTitle("友情提示")
                        .setMessage("已经是最新版本了!").setPositiveButton("Ok", null)
                        .show();
            }
        });
        /**
         * 协议条款
         */
        rl_tiao = (RelativeLayout) findViewById(R.id.rl_tiao);
        rl_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReagardActivity.this,
                        TiaokuanActivity.class);
                startActivity(intent);
            }
        });
    }
}
