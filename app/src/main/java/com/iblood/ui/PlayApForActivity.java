package com.iblood.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.ui.ordermodole.activity.SelectPicPopupWindow;
import com.iblood.ui.ordermodole.bean.Bean;
import com.iblood.ui.ordermodole.dapter.DapterO;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.PulldataHandler;
import com.iblood.utils.SignUtil;
import com.iblood.utils.ToastUtil;
import com.iblood.utils.TokenUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

public class PlayApForActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;
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
    private String url = "http://123.56.150.230:8885/dog_family/petType/getPetTypesByVO.jhtml";
    private String ip;

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
    @OnClick({R.id.button_backward})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.button_backward:
                finish();
                break;
        }
    }
    @Override
    protected void initView() {
        button_forward.setVisibility(View.GONE);
        header_title.setText("预约寄养");
        button_backward.setMaxHeight(50);
        button_backward.setMaxHeight(50);
        name = (EditText) findViewById(R.id.fosterapply_name);
        phone = (EditText) findViewById(R.id.fosterapply_phones);
        city = (EditText) findViewById(R.id.fosterapply_city);
        address = (EditText) findViewById(R.id.fosterapply_addres);
        choose_city = (LinearLayout) findViewById(R.id.fosterapply_choose_city);
        identity = (EditText) findViewById(R.id.fosterapply_identity);
        identity_icon = (ImageView) findViewById(R.id.fosterapply_shenfenzheng_icon);
        yingye_icon = (ImageView) findViewById(R.id.fosterapply_yingye_icon);
        petFosterListView = (ListView) findViewById(R.id.fosterapply_listview_foster);
        //petServiceListView = (ListView) findViewById(R.id.fosterapply_listview_service);
        gridview = (ImageView) findViewById(R.id.fosterapply_spg);
        famile = (EditText) findViewById(R.id.fosterapply_nc_name);
        desc = (EditText) findViewById(R.id.fosterapply_jieshao);
        btn_ok = (Button) findViewById(R.id.fosterapply_btn);
        fosterapply_cb = (CheckBox) findViewById(R.id.fosterapply_cb);
     item_top =   (TextView) findViewById(R.id.item_top);
     shangchuan_icon =   (ImageView) findViewById(R.id.fosterapply_shangchuan_icon);
     item_top.setText("申请成为寄养家庭");

     inithttp();
    }

    private void inithttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(PlayApForActivity.this);
        TokenUtil.init(PlayApForActivity.this);
        String token = TokenUtil.createToken();
        Request.Builder request = new Request.Builder();
        ip = ConnectionUtils.getIp(PlayApForActivity.this);
        Map<String, Object> map = new HashMap<>();
        map.put("petTypeCode", " ");
        String s1 = CJSON.toJSONMap(map);
        builder.add("data", s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("channel", "android")
                .addHeader("ip", ip).addHeader("sign", linkString)
                .addHeader("token", token);
        Request build1 = request.url(url).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {

            private String s2;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                s2 = response.body().string();
                Log.e("TAG", s2);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        Bean bean = gson.fromJson(s2, Bean.class);
                        List<Bean.DescBean> desc = bean.getDesc();
                        DapterO  dapterO  = new DapterO(desc,PlayApForActivity.this);
                        petFosterListView.setAdapter(dapterO);
                    }
                });

            }
        });
    }

    @Override
    protected void initData() {
        yingye_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(PlayApForActivity.this,
                        SelectPicPopupWindow.class), 1);
            }
        });
        identity_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(PlayApForActivity.this,
                        SelectPicPopupWindow.class), 1);
            }
        });

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

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    @NonNull
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode) {
            case 1:
                if (data != null) {
                    //取得返回的Uri,基本上选择照片的时候返回的是以Uri形式，但是在拍照中有得机子呢Uri是空的，所以要特别注意
                    Uri mImageCaptureUri = data.getData();
                    //返回的Uri不为空时，那么图片信息数据都会在Uri中获得。如果为空，那么我们就进行下面的方式获取
                    if (mImageCaptureUri != null) {
                        Bitmap image;
                        try {
                            //这个方法是根据Uri获取Bitmap图片的静态方法
                            image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), mImageCaptureUri);
                            if (image != null) {
                                identity_icon.setImageBitmap(image);
                                yingye_icon.setImageBitmap(image);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Bundle extras = data.getExtras();
                        if (extras != null) {
                            //这里是有些拍照后的图片是直接存放到Bundle中的所以我们可以从这里面获取Bitmap图片
                            Bitmap image = extras.getParcelable("data");
                            if (image != null) {
                                identity_icon.setImageBitmap(image);
                                yingye_icon.setImageBitmap(image);
                            }
                        }
                    }

                }
                break;
            default:
                break;

        }
    }
    }

