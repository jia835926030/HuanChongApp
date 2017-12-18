package com.iblood.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.utils.PulldataHandler;
import com.iblood.utils.ToastUtil;

import butterknife.ButterKnife;

public class PlayApForActivity extends BaseActivity {
    private PulldataHandler handler;
    private TextView item_top;
    private EditText name;
    private EditText phone;
    private EditText city;
    private EditText address;
    private LinearLayout choose_city;
    private EditText identity;
    private ImageView identity_icon;
    private ImageView yingye_icon;
    private ListView petFosterListView;
    private ListView petServiceListView;
    private ImageView gridview;
    private EditText famile;
    private EditText desc;
    private Button btn_ok;
    private CheckBox fosterapply_cb;
    private ImageView shangchuan_icon;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play_ap_for;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.destroy();
        }
    }
    @Override
    protected void initView() {
        name = (EditText) findViewById(R.id.fosterapply_name);
        phone = (EditText) findViewById(R.id.fosterapply_phones);
        city = (EditText) findViewById(R.id.fosterapply_city);
        address = (EditText) findViewById(R.id.fosterapply_addres);
        choose_city = (LinearLayout) findViewById(R.id.fosterapply_choose_city);
        identity = (EditText) findViewById(R.id.fosterapply_identity);
        identity_icon = (ImageView) findViewById(R.id.fosterapply_shenfenzheng_icon);
        yingye_icon = (ImageView) findViewById(R.id.fosterapply_yingye_icon);
        petFosterListView = (ListView) findViewById(R.id.fosterapply_listview_foster);
        petServiceListView = (ListView) findViewById(R.id.fosterapply_listview_service);
        gridview = (ImageView) findViewById(R.id.fosterapply_spg);
        famile = (EditText) findViewById(R.id.fosterapply_nc_name);
        desc = (EditText) findViewById(R.id.fosterapply_jieshao);
        btn_ok = (Button) findViewById(R.id.fosterapply_btn);
        fosterapply_cb = (CheckBox) findViewById(R.id.fosterapply_cb);
     item_top =   (TextView) findViewById(R.id.item_top);
     shangchuan_icon =   (ImageView) findViewById(R.id.fosterapply_shangchuan_icon);
     item_top.setText("申请成为寄养家庭");
    }

    @Override
    protected void initData() {
        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                    VerificationData();
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    private Boolean VerificationData() {
        if (name.getText().toString().trim().isEmpty()) {
       ToastUtil.show("真实姓名不能为空!");
            return false;
        }
        if (!name.getText().toString().trim()
                .matches("^[\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*$")) {
           ToastUtil.show("真实姓名输入不合法！");
            return false;
        }
        if (city.getText().toString().trim().isEmpty()) {
          ToastUtil.show("请选择城市！");
            return false;
        }
        if (address.getText().toString().trim().isEmpty()) {
          ToastUtil.show("家庭地址不能为空！");
            return false;
        }
        if (identity.getText().toString().trim().isEmpty()) {
          ToastUtil.show("身份证号不能为空！");
            return false;
        }
        if (!identity.getText().toString().trim()
                .matches("^[1-9][0-9]{16}[0-9|X]$")) {
          ToastUtil.show("身份证号输入不合法！");
            return false;
        }
        if (identity_icon == null) {
          ToastUtil.show("请上传身份证照片！");
            return false;
        }
        if (yingye_icon == null) {
         ToastUtil.show("请上传营业照片！");
            return false;
        }
//        if (map_foster.size() <= 0) {
//         ToastUtil.show("请选择寄养宠物！");
//            return false;
//        }
        if (famile.getText().toString().trim().isEmpty()) {
          ToastUtil.show("昵称不能为空！");
            return false;
        }
        if (desc.getText().toString().trim().isEmpty()) {
        ToastUtil.show("我的介绍不能为空！");
            return false;
        }
//        if () {
//           ToastUtil.show("请上传照片，切照片不能少于3张！");
//            return false;
//        }
        if (!fosterapply_cb.isChecked()) {
           ToastUtil.show("您尚未同意《双方寄养服务协议》");
            return false;
        }

        return true;
    }
    }

