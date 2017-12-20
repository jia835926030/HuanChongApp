package com.iblood.ui;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.FileUtil;

import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.TableUtils;
import com.iblood.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.PostRequest;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


public class UpdatePersonalInfo extends BaseActivity {
    @BindView(R.id.et_update_name)
    EditText et_update_name;
    ;@BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_name;
    }

    @Override
    protected void initView() {
        header_title.setText("名称");

        String q = (String) SharedPreferencesUtils.getParam(UpdatePersonalInfo.this, "userName", "");
       et_update_name.setText(q);

    }

    @OnClick({R.id.et_update_name,R.id.button_backward,R.id.button_forward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_update_name:
                if (et_update_name.getText().toString().trim() != null) {
                    UpdateName();
                }
                break;
            case R.id.button_backward:
                finish();
                break;
            case R.id.button_forward:
                //
                UpdateName();
                break;
        }
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    private void UpdateName() {

        Map<String, Object> param = new HashMap<>();
        param.put(TableUtils.UserInfo.USERID, AppUtils.userInfo.getUserId());
        param.put(TableUtils.UserInfo.USERNAME, et_update_name.getText()
                .toString().trim());
        // 生成提交服务器的JSON字符串
        String json = CJSON.toJSONMap(param);
        // FileUtil.getToken();
        PostRequest post = OkHttpUtils.post(AppUtils.REQUESTURL
                + "user/updateUserInfo.jhtml");
        post.tag(this);
        post.params(CJSON.DATA, json);
        post.execute(new StringCallback() {
            @Override
            public void onResponse(boolean arg0, String json, Request arg2, Response arg3) {
                Log.d("TAG", json);
                Log.d("TAG", AppUtils.userInfo.getUserId());
                if (CJSON.getRET(json)) {
                    AppUtils.userInfo.setUserName(et_update_name.getText()
                            .toString());
                    FileUtil.saveUser(AppUtils.userInfo);
                    ToastUtil.show("修改成功!");
                    finish();
                } else {
                    ToastUtil.show("修改失败");
                }
            }
        });
    }
}
