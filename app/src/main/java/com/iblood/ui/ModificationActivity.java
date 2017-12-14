package com.iblood.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by 刘贵河 on 2017/12/7.
 */

public class ModificationActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView text_title;
    @BindView(R.id.mEditText)
    EditText mEditText;
    @BindView(R.id.button_forward)
    Button button_forward;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modification;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        //获取传过来的值
        String titletext = intent.getStringExtra("title");
        String hint = intent.getStringExtra("hint");
        text_title.setText(titletext);
        mEditText.setHint(hint);
    }

    @Override
    protected void initView() {

        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = mEditText.getText().toString().trim();
                Log.e("TAG", trim);

                Intent intent = new Intent();
                Intent rcode = intent.putExtra("rcode", trim);
                Log.e("TAG", rcode.getStringExtra("rcode"));
                setResult(200, rcode);
                finish();
            }
        });

    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
