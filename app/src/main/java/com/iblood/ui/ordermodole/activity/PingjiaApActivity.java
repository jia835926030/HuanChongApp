package com.iblood.ui.ordermodole.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;

public class PingjiaApActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private Button lv_tijiao;
    private ImageView iv_myImage;
    private TextView tv_name;
    private com.iblood.ui.ordermodole.xing.RatingBar star;
    private EditText lv_ping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingjia_ap);
        initView();
        initdata();
    }

    private void initdata() {
        star.setClickable(true);
        star.setStar(3.5f);
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        lv_tijiao = (Button) findViewById(R.id.lv_tijiao);
        iv_myImage = (ImageView) findViewById(R.id.iv_myImage);
        tv_name = (TextView) findViewById(R.id.tv_name);
        star = (com.iblood.ui.ordermodole.xing.RatingBar) findViewById(R.id.star);
        lv_ping = (EditText) findViewById(R.id.lv_ping);
        iv_back.setOnClickListener(this);
        lv_tijiao.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lv_tijiao:
                submit();
   Toast.makeText(PingjiaApActivity.this,"感谢您的评价",Toast.LENGTH_SHORT).show();
   finish();
                break;
            case  R.id.iv_back:
                finish();
        }
    }

    private void submit() {
        // validate
        String ping = lv_ping.getText().toString().trim();
        if (TextUtils.isEmpty(ping)) {
            Toast.makeText(this, "写下你的建议让我们做的更好", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
    }
}
