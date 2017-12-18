package com.iblood.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.entity.Screen;
import com.iblood.entity.UserInfo;
import com.iblood.fellow.FellowActivity;
import com.iblood.fellow.FellowAdapter;
import com.iblood.fellow.FellowBean;
import com.iblood.ui.loginactivity.GiadingActivity;
import com.iblood.ui.menu.MainActivity;
import com.iblood.ui.ordermodole.MyOrderActivity;
import com.iblood.ui.setmodoule.OrderActivity;
import com.iblood.ui.setmodoule.SetUpActivity;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.FileUtil;
import com.iblood.utils.OkHttpUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TokenUtil;
import com.zaaach.citypicker.CityPickerActivity;

import java.io.IOException;
import java.util.ArrayList;
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

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.mOLBtn)
    RadioButton mOLBtn;
    @BindView(R.id.mMangerBtn)
    RadioButton mMangerBtn;
    @BindView(R.id.mPersonalBtn)
    RadioButton mPersonalBtn;
    @BindView(R.id.my_home)
    ImageView myHome;
    @BindView(R.id.ed_home)
    EditText edHome;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.dingwei_hoem)
    ImageView dingweiHoem;
    @BindView(R.id.rel_home)
    RelativeLayout relHome;
    @BindView(R.id.mBottomGroup)
    RadioGroup mBottomGroup;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.activity_home)
    DrawerLayout activityHome;
    @BindView(R.id.cehua_shenqing)
    Button cehuaShenqing;
    @BindView(R.id.list_home)
    ListView listHome;
    private View v1;
    private View v2;
    private View v3;
    private TextView personal_dizhi;
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private TextView cehua_name;
    private TextView cehua_dianhua;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        String q = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userName", "");
        String w = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userPhone", "");
        String ws = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userId", "");
        Log.e("name=====",q);
        Log.e("phone=====",w+"");
        Log.e("1231231====",ws+"");
        if(q!=null){
            cehua_name.setText(q);
            cehua_dianhua.setText(w);

        }else if (w.equals("")){
            cehua_name.setText("还未登录");
        }
    }

    //侧滑
    @Override
    protected void initView() {
        //侧滑头布局
        View headerView = navView.getHeaderView(0);
        View cehua_tou = headerView.findViewById(R.id.cehua_tou);
        cehua_dianhua = headerView.findViewById(R.id.cehua_dianhua);
        cehua_name = headerView.findViewById(R.id.cehua_name);

        cehua_tou.setOnClickListener(this);
        //侧滑item点击事件
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //允许条目点击
                item.setCheckable(true);
                switch (item.getItemId()) {
                    case R.id.cehua_xiaoxi:
                      Intent intent11=new Intent(HomeActivity.this,MessageActivity.class);
                      startActivity(intent11);
                      break;
                    case R.id.cehua_chongwu:
                        Toast.makeText(HomeActivity.this, "22222222222222", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cehua_shezhi:
                        Intent intent = new Intent(HomeActivity.this, SetUpActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.cehua_qianbao:
                        Intent intent1 = new Intent(HomeActivity.this, WalletActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.cehua_dingdan:

                        Intent intent2=new Intent(HomeActivity.this,MyOrderActivity.class);
                        startActivity(intent2);
                        break;
                    case  R.id.cehua_xuzhi:
                        startActivity(new Intent(HomeActivity.this, OrderActivity.class));
                        break;
                }
                return false;
            }
        });
        myHome.setOnClickListener(this);
        dingweiHoem.setOnClickListener(this);
        cehuaShenqing.setOnClickListener(this);
    }
    public void getdata() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(HomeActivity.this);
        TokenUtil.init(HomeActivity.this);
        String token = TokenUtil.createToken();
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(HomeActivity.this);
        Map<String, Object> map = new HashMap<>();
        map.put("beginIndex", 0);
        map.put("coordX",40.116384);
        map.put("coordY", 116.250374);
        map.put("endIndex", 15);
        map.put("orderBy", "distance asc");
        String s1 = CJSON.toJSONMap(map);
        Log.e("DA", s1);
        builder.add("data", s1);

        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        Request build1 = request.url(Urls.BASE+Urls.CHONGWU).post(builder.build()).build();
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
                        Screen dAta = gson.fromJson(data, Screen.class);
                        List<Screen.DescBean> desc = dAta.getDesc();
                        FellowAdapter adapter = new FellowAdapter(HomeActivity.this,desc);
                        listHome.setAdapter(adapter);
                    }
                });
            }
        });

    }
    //主体ListView
    @Override
    protected void initData() {
            getdata();
        final List<FellowBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new FellowBean(R.mipmap.ic_launcher,"米妮捷豹的家"+i,"双井桥东北角东波街东南角天之蓝...","$50起","距 0.1km"));
        }



        listHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, FellowActivity.class);
                intent.putExtra("name",list.get(position).getName());
                Toast.makeText(HomeActivity.this, list.get(position).getName(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    //弹出popu
    @OnClick({R.id.mOLBtn, R.id.mMangerBtn, R.id.mPersonalBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mOLBtn:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                popu1();
                break;
            case R.id.mMangerBtn:
                popu2();
                break;
            case R.id.mPersonalBtn:
                popu3();
                break;
        }
    }

    //附近优先
    private void popu1() {
        //显示popuwindow
        v1 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_online, null);
        //创建一个popuwindow对象
        PopupWindow popu1 = new PopupWindow(v1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAsDropDown(mBottomGroup, 0, 0);
    }

    //宠物类型
    private void popu2() {
        //显示popuwindow
        v2 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_manage, null);
        //创建一个popuwindow对象
        PopupWindow popu1 = new PopupWindow(v2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAsDropDown(mBottomGroup, 0, 0);
    }

    //筛选城市
    private void popu3() {
        //显示popuwindow
        v3 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.fragment_personal, null);
        //创建一个popuwindow对象
        PopupWindow popu1 = new PopupWindow(v3, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu1.setFocusable(true);
        //点击窗口以外区域，窗口消失
        popu1.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
        //显示popuwindow
        popu1.showAsDropDown(mBottomGroup, 0, 0);

        //ImageView personal_saixuan = v3.findViewById(R.id.personal_saixuan);

        Button personal_chongzhi = v3.findViewById(R.id.personal_chongzhi);
        Button personal_queding = v3.findViewById(R.id.personal_queding);
        ImageView personal_tiaozhuan = v3.findViewById(R.id.personal_tiaozhuan);
        personal_dizhi = v3.findViewById(R.id.personal_dizhi);
        personal_tiaozhuan.setOnClickListener(this);
        personal_chongzhi.setOnClickListener(this);
        personal_queding.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    //侧滑栏点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_home:
              /*  String userName = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userName", "");
                String userPhone = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userPhone", "");
                Log.e("name=====",userName);
                Log.e("name=====",userPhone);*/
                if(activityHome.isDrawerOpen(Gravity.LEFT)){
                    activityHome.closeDrawer(Gravity.LEFT);

                }else {
                    activityHome.openDrawer(Gravity.LEFT);
                }



                break;
            case R.id.dingwei_hoem:
                Toast.makeText(this, "ddddddddddd", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cehua_tou:
                String q = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userName", "");
                String w = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userPhone", "");
                String ws = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "userId", "");
                Log.e("name=====",q);
                Log.e("phone=====",w+"");
                Log.e("1231231====",ws+"");
                if(q.equals("")){

                    Log.e("登录",q);
                    Intent intent=new Intent(HomeActivity.this,GiadingActivity.class);
                    startActivity(intent);
                }else {
                    Log.e("个人",q);
                    Intent intent1 = new Intent(HomeActivity.this, PersonalInformation.class);
                    startActivity(intent1);
                }

                break;
            case R.id.cehua_shenqing:
                Toast.makeText(this, "不好使", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_chongzhi:
                Toast.makeText(HomeActivity.this, "1111111111111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_queding:
                Toast.makeText(HomeActivity.this, "1111111111111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_tiaozhuan:
                startActivityForResult(new Intent(HomeActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
        }
    }

    //城市筛选
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                personal_dizhi.setText(city);
            }
        }
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                setResult(1);
                finish();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
