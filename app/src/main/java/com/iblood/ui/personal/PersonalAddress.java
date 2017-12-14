package com.iblood.ui.personal;

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
 *
 * 修改联系地址
 */

public class PersonalAddress extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    Button button_forward;
    @BindView(R.id.myaddress)
    EditText myAddress;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_address;
    }


    @Override
    protected void onResume() {
        super.onResume();

        header_title.setText(getIntent().getStringExtra("title"));
    }

    @Override
    protected void initView() {
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = myAddress.getText().toString().trim();
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
