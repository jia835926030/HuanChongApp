package com.iblood.fellow;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YuYueActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.dom_fanhui)
    ImageView domFanhui;
    @BindView(R.id.jiyangshijian_jiyang)
    TextView jiyangshijianJiyang;
    @BindView(R.id.kaishi_yuyue)
    LinearLayout kaishiYuyue;
    @BindView(R.id.zongshu_yuyue)
    TextView zongshuYuyue;
    @BindView(R.id.jiehuishijian_jiyang)
    TextView jiehuishijianJiyang;
    @BindView(R.id.jieshu_yuyue)
    LinearLayout jieshuYuyue;
    @BindView(R.id.img_yuyue)
    ImageView imgYuyue;
    @BindView(R.id.name_yuyue)
    TextView nameYuyue;
    @BindView(R.id.pingjia_yuyue)
    TextView pingjiaYuyue;
    @BindView(R.id.shanchu_yuyue)
    ImageView shanchuYuyue;
    @BindView(R.id.tianshu_yuyue)
    TextView tianshuYuyue;
    @BindView(R.id.qian_yuyue)
    TextView qianYuyue;
    @BindView(R.id.jian1_yuyue)
    TextView jian1Yuyue;
    @BindView(R.id.jia1_yuyue)
    TextView jia1Yuyue;
    @BindView(R.id.qian1_yuyue)
    TextView qian1Yuyue;
    @BindView(R.id.jian2_yuyue)
    TextView jian2Yuyue;
    @BindView(R.id.jia2_yuyue)
    TextView jia2Yuyue;
    @BindView(R.id.qian2_yuyue)
    TextView qian2Yuyue;
    @BindView(R.id.tianjia_yuyue)
    LinearLayout tianjiaYuyue;
    @BindView(R.id.liuyan_yuyue)
    EditText liuyanYuyue;
    @BindView(R.id.zongqian_yuyue)
    TextView zongqianYuyue;
    @BindView(R.id.queding_yuyue)
    TextView quedingYuyue;
    @BindView(R.id.tian1_yuyue)
    EditText tian1Yuyue;
    @BindView(R.id.tian2_yuyue)
    EditText tian2Yuyue;
    @BindView(R.id.heji_yuyue)
    TextView hejiYuyue;


    private int mYear;
    private int mMonth;
    private int mDay;
    //开始时间
    String days1;
    //结束时间
    String days2;
    //寄养天数
    private long days;
    //洗澡次数
    private int tian1;
    //接送次数
    private int tian2;
    //天数费用
    private double tianshuqian;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yu_yue;
    }

    @Override
    protected void initView() {
        kaishiYuyue.setOnClickListener(this);
        jieshuYuyue.setOnClickListener(this);
        jian1Yuyue.setOnClickListener(this);
        jia1Yuyue.setOnClickListener(this);
        jian2Yuyue.setOnClickListener(this);
        jia2Yuyue.setOnClickListener(this);
        tianjiaYuyue.setOnClickListener(this);
        shanchuYuyue.setOnClickListener(this);
        quedingYuyue.setOnClickListener(this);
        domFanhui.setOnClickListener(this);

        //Activity的onCreate方法中获取当时的年 ，月，日
        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        String trim1 = tian1Yuyue.getText().toString().trim();
        String trim2 = tian2Yuyue.getText().toString().trim();

        if (TextUtils.isEmpty(tian1Yuyue.getText())){
            tian1 = 1;
            tian2 = 1;
        }else {
            //获取洗澡次数
            tian1 = Integer.parseInt(trim1);
            //获取接送次数
            tian2 = Integer.parseInt(trim2);
        }

    }

    @Override
    protected void initData() {

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



    /**
     * 日期选择器对话框监听
     */
    private DatePickerDialog.OnDateSetListener onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

            if (mMonth + 1 < 10) {
                if (mDay < 10) {
                    days1 = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days1 = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }
            } else {
                if (mDay < 10) {
                    days1 = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days1 = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }
            }
            jiyangshijianJiyang.setText(days1);

        }
    };
    private DatePickerDialog.OnDateSetListener onDateSetListener2 = new DatePickerDialog.OnDateSetListener() {



        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

            if (mMonth + 1 < 10) {
                if (mDay < 10) {
                    days2 = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days2 = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }
            } else {
                if (mDay < 10) {
                    days2 = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days2 = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }
            }
            jiehuishijianJiyang.setText(days2);

            DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
            try {
                Date d1 = df.parse(days1);
                Date d2 = df.parse(days2);
                //Date   d2 = new   Date(System.currentTimeMillis());//你也可以获取当前时间
                long diff = d2.getTime() - d1.getTime();//这样得到的差值是微秒级别
                days = diff / (1000 * 60 * 60 * 24);
                long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
                long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);

                zongshuYuyue.setText(days + "晚");
                tianshuYuyue.setText(days + "天");
                if (days>0){
                    tianshuqian = days * 30.00;
                    qianYuyue.setText(days * 30 + "元");
                    hejiYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                    zongqianYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                }else {
                    zongshuYuyue.setText(0 + "晚");
                    tianshuYuyue.setText(0 + "天");
                    tianshuqian = 0;
                    Toast.makeText(YuYueActivity.this, "日期不能为负数哟", Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {

            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kaishi_yuyue:
                new DatePickerDialog(YuYueActivity.this, onDateSetListener1, mYear, mMonth, mDay).show();
                break;
            case R.id.jieshu_yuyue:
                new DatePickerDialog(YuYueActivity.this, onDateSetListener2, mYear, mMonth, mDay).show();
                break;
            case R.id.jian1_yuyue:
                if (tian1>1){
                    tian1-=1;
                }
                tian1Yuyue.setText(tian1+"");
                qian1Yuyue.setText(tian1*60.00+"元");
                hejiYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                zongqianYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                break;
            case R.id.jia1_yuyue:
                tian1+=1;
                tian1Yuyue.setText(tian1+"");
                qian1Yuyue.setText(tian1*60.00+"元");
                hejiYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                zongqianYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                break;
            case R.id.jian2_yuyue:
                if (tian2>1){
                    tian2-=1;
                }
                tian2Yuyue.setText(tian2+"");
                qian2Yuyue.setText(tian2*50.00+"元");
                hejiYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                zongqianYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                break;
            case R.id.jia2_yuyue:
                tian2+=1;
                tian2Yuyue.setText(tian2+"");
                qian2Yuyue.setText(tian2*50.00+"元");
                hejiYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                zongqianYuyue.setText(tianshuqian+tian1*60.00+tian2*50.00+"元");
                break;
            case R.id.tianjia_yuyue:
                Toast.makeText(this, "请您先充值会员！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shanchu_yuyue:
                Toast.makeText(this, "您确定要残忍删除？！", Toast.LENGTH_SHORT).show();
                break;

            case R.id.queding_yuyue:
                if (days>0){
                    Intent intent = new Intent(YuYueActivity.this,SuccessActivity.class);
                    intent.putExtra("qian",tianshuqian+tian1*60.00+tian2*50.00+"元");
                    startActivity(intent);
                }else {
                    Toast.makeText(YuYueActivity.this, "日期不能少哟", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.dom_fanhui:
                finish();
                break;
        }
    }
}
