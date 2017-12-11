package com.iblood.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.ui.loginactivity.GiadingActivity;
import com.iblood.ui.ordermodole.MyOrderActivity;
import com.iblood.ui.setmodoule.SetUpActivity;
import com.zaaach.citypicker.CityPickerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private FragmentManager fragmentManager;
    private long mExitTime;
    private View v1;
    private View v2;
    private View v3;
    private TextView personal_dizhi;
    private static final int REQUEST_CODE_PICK_CITY = 233;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        //侧滑头布局
        View headerView = navView.getHeaderView(0);
        View cehua_tou = headerView.findViewById(R.id.cehua_tou);
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
                }
                return false;
            }
        });
        myHome.setOnClickListener(this);
        dingweiHoem.setOnClickListener(this);
        cehuaShenqing.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.mOLBtn, R.id.mMangerBtn, R.id.mPersonalBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mOLBtn:
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_home:
               startActivity(new Intent(this, GiadingActivity.class));
                break;
            case R.id.dingwei_hoem:
                Toast.makeText(this, "ddddddddddd", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cehua_tou:
                Intent intent1 = new Intent(HomeActivity.this, PersonalInformation.class);
                startActivity(intent1);
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
