package com.iblood.ui.setmodoule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.iblood.R;

public class TiaokuanActivity extends AppCompatActivity {

    private ImageView iv_backt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiaokuan);
        initView();
    }

    private void initView() {
        iv_backt = (ImageView) findViewById(R.id.iv_backt);
        iv_backt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
