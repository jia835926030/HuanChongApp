package com.iblood.fellow;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.ui.ordermodole.dapter.GlideCircleTransform;
import com.iblood.ui.ordermodole.xing.RatingBar;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FellowActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.pinglun_fellow)
    LinearLayout pinglunFellow;
    @BindView(R.id.lianxi_fellow)
    TextView lianxiFellow;
    @BindView(R.id.queding_fellow)
    TextView quedingFellow;
    @BindView(R.id.ll_fellow)
    LinearLayout llFellow;
    @BindView(R.id.pingluntv_fellow)
    TextView pingluntvFellow;
    @BindView(R.id.jiage1_fellow)
    TextView jiage1Fellow;
    @BindView(R.id.jiage2_fellow)
    TextView jiage2Fellow;
    @BindView(R.id.jiage3_fellow)
    TextView jiage3Fellow;
    @BindView(R.id.jiage4_fellow)
    TextView jiage4Fellow;
    @BindView(R.id.jiage5_fellow)
    TextView jiage5Fellow;
    @BindView(R.id.jiage6_fellow)
    TextView jiage6Fellow;
    @BindView(R.id.jiage7_fellow)
    TextView jiage7Fellow;
    @BindView(R.id.jiage8_fellow)
    TextView jiage8Fellow;
    @BindView(R.id.dizhi_fellow)
    TextView dizhiFellow;
    @BindView(R.id.jianjie_fellow)
    TextView jianjieFellow;
    @BindView(R.id.star)
    RatingBar star;
    private View v1;
    private PopupWindow popu1;
    private FellowBean.DescBean desc;
    private String name;
    private String userId;
    private RatingBar mRB;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_fellow;
    }

    @Override
    protected void initView() {
        pinglunFellow.setOnClickListener(this);
        lianxiFellow.setOnClickListener(this);
        quedingFellow.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        mRB = (RatingBar)findViewById(R.id.star);
        mRB.setClickable(true);

    }

    @Override
    protected void initData() {
        //接受传值UserId
        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        //网络请求
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(FellowActivity.this);
        TokenUtil.init(FellowActivity.this);
        String token = TokenUtil.createToken();
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(FellowActivity.this);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", name);
        String s1 = CJSON.toJSONMap(map);
        //Log.e("DA", s1);
        builder.add("data", s1);

        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        Request build1 = request.url(Urls.BASE + Urls.JIYANGSI).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                Log.e("onResponse=====: ", data);
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        FellowBean fellowBean = gson.fromJson(data, FellowBean.class);

                        if (fellowBean.isRet()) {
                            desc = fellowBean.getDesc();
                            userId = desc.getFosterInfo().getUserId();
                            if (userId.equals(name)) {
                                textView12.setText(desc.getFosterInfo().getUserName());
                                pingluntvFellow.setText("寄养评价-" + desc.getFosterCommentCount());
                                jianjieFellow.setText(desc.getFosterInfo().getIntro());
                                dizhiFellow.setText(desc.getFosterInfo().getAddress());

                                float v = Float.parseFloat(desc.getFosterGrade()+"");
                                mRB.setStar(v);
                                Glide.with(FellowActivity.this).load(desc.getFosterInfo().getUserImage()).transform(new GlideCircleTransform(FellowActivity.this)).error(R.mipmap.ic_launcher).into(imageView2);
                            }
                        } else {
                            Toast.makeText(FellowActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    @Override
    protected void initListener() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pinglun_fellow:
                Intent intent = new Intent(FellowActivity.this, PingLunActivity.class);
                intent.putExtra("usersId ",userId);
                startActivity(intent);
                break;
            case R.id.lianxi_fellow:

                popu();
                break;
            case R.id.imageView3:
                finish();
                popu();
                break;
            case R.id.queding_fellow:
                Intent intent1 = new Intent(FellowActivity.this, YuYueActivity.class);
                startActivity(intent1);
                break;
            case R.id.dianhua_call:
                call("1008611");
                Toast.makeText(this, "打电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xiaoxi_call:
                Toast.makeText(this, "发消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quxiao_call:
                popu1.dismiss();
                break;
        }
    }

    //拨号页面
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void popu() {
        //显示popuwindow
        v1 = LayoutInflater.from(FellowActivity.this).inflate(R.layout.call_popu, null);
        //创建一个popuwindow对象
        popu1 = new PopupWindow(v1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAtLocation(llFellow, Gravity.CENTER, 0, 0);

        View dianhua_call = v1.findViewById(R.id.dianhua_call);
        View xiaoxi_call = v1.findViewById(R.id.xiaoxi_call);
        View quxiao_call = v1.findViewById(R.id.quxiao_call);
        dianhua_call.setOnClickListener(this);
        xiaoxi_call.setOnClickListener(this);
        quxiao_call.setOnClickListener(this);
    }
}
