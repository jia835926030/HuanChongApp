package com.iblood.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.entity.HomeChongwuBeen;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TokenUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 免疫情况
 * <p>
 * 刘贵河
 */
public class ImmunizingActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;
    @BindView(R.id.pet_mian_time)
    RelativeLayout pet_mian_time;
    @BindView(R.id.tv_pet_immune_data)
    TextView tv_pet_immune_data;
    @BindView(R.id.cb_imm)
    CheckBox cb_imm;
    @BindView(R.id.pet_re_time)
    LinearLayout pet_re_time;
    @BindView(R.id.mian_gridView)
    LinearLayout mian_gridView;
    @BindView(R.id.add_pet_immune)
    LinearLayout add_pet_immune;
    @BindView(R.id.but1)
    CheckBox but1;
    @BindView(R.id.but2)
    CheckBox but2;
    @BindView(R.id.but3)
    CheckBox but3;
    @BindView(R.id.but4)
    CheckBox but4;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_immunizing;
    }

    @Override
    protected void initView() {
        header_title.setText("免疫情况");
        button_forward.setText("确定");
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        //因为默认false 所以进来是看不到这些
        add_pet_immune.setVisibility(View.GONE);
        pet_mian_time.setVisibility(View.GONE);
        pet_re_time.setVisibility(View.GONE);
        mian_gridView.setVisibility(View.GONE);

    }

    @Override
    protected void initListener() {
        cb_imm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    textToast("true");
                    add_pet_immune.setVisibility(View.VISIBLE);
                    pet_mian_time.setVisibility(View.VISIBLE);
                    pet_re_time.setVisibility(View.VISIBLE);
                    mian_gridView.setVisibility(View.VISIBLE);
                } else {
                    textToast("false");
                    add_pet_immune.setVisibility(View.GONE);
                    pet_mian_time.setVisibility(View.GONE);
                    pet_re_time.setVisibility(View.GONE);
                    mian_gridView.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.button_backward, R.id.pet_mian_time, R.id.button_forward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_backward:
                finish();
                break;
            case R.id.pet_mian_time:
                Date_selection(tv_pet_immune_data, 2015);
                break;
            case R.id.button_forward:
                textToast("不好使");
                break;
//
        }
    }

//    public void getBingDu(String str) {
//        OkHttpClient okHttpClient = new OkHttpClient();
//        FormBody.Builder builder = new FormBody.Builder();
//        AppUtils.setAppContext(ImmunizingActivity.this);
//        TokenUtil.init(ImmunizingActivity.this);
//        String token = TokenUtil.createToken();
//        Request.Builder request = new Request.Builder();
//        String ip = ConnectionUtils.getIp(ImmunizingActivity.this);
//        Map<String, Object> map = new HashMap<>();
//        map.put("isStandard", 1);
//        String s1 = CJSON.toJSONMap(map);
//        builder.add("data", s1);
//
//        String linkString = SignUtil.createLinkString(map);
//        request.addHeader("sign", linkString);
//        request.addHeader("ip", ip);
//        request.addHeader("token", token);
//        request.addHeader("channel", "android");
//        Request build1 = request.url(Urls.BASE + Urls.BINGDU).post(builder.build()).build();
//        okHttpClient.newCall(build1).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String data = response.body().string();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Gson gson = new Gson();
//                        HomeChongwuBeen homeChongwuBeen = gson.fromJson(data, HomeChongwuBeen.class);
//
//
//                        immgrid.setAdapter();
//                    }
//                });
//            }
//        });
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but1:
                break;
            case R.id.but2:
                break;
            case R.id.but3:
                break;
            case R.id.but4:
                break;

        }
    }
}
