package com.iblood.ui;


import android.app.DatePickerDialog;
import android.app.Dialog;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;

import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import android.widget.PopupWindow;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.base.BaseActivity;

import com.iblood.ui.personal.PersonalAddress;

import java.io.File;
import java.util.Calendar;


import java.io.File;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 刘贵河 on 2017/12/6.
 */

public class PersonalInformation extends BaseActivity {
    @BindView(R.id.modification_face)//修改头像

            RelativeLayout modification_face;
    @BindView(R.id.modification_name)//名称
            RelativeLayout modification_name;
    @BindView(R.id.modification_sexy)//性别
            RelativeLayout modification_sexy;
    @BindView(R.id.modification_ddyymm)//年/月/日
            RelativeLayout modification_ddyymm;
    @BindView(R.id.modification_phone)//手机号
            RelativeLayout modification_phone;
    @BindView(R.id.modification_wachat)//微信
            RelativeLayout modification_wachat;
    @BindView(R.id.modification_QQ)//QQ
            RelativeLayout modification_QQ;
    @BindView(R.id.modification_address)//联系地址
            RelativeLayout modification_address;
    @BindView(R.id.user_sexy)
    TextView user_sexy;
    @BindView(R.id.user_time)
    TextView user_time;

    RelativeLayout modification_face;

    private PopupWindow window;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;

    private TextView men;
    private TextView women;
    final int DATE_DIALOG = 1;
    private int mYear;
    private int mMonth;
    private int mDay;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_information;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    @OnClick({R.id.modification_face, R.id.modification_name, R.id.modification_sexy, R.id.modification_ddyymm,
            R.id.modification_phone, R.id.modification_QQ, R.id.modification_wachat, R.id.modification_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {

    @OnClick({R.id.modification_face})
    public void onViewClicked(View view){
        switch (view.getId()){

            case R.id.modification_face:
                //弹窗
                showTipPop();
                break;

            case R.id.modification_name:
                //跳转修改名称
                startActivity(new Intent(PersonalInformation.this, ModificationActivity.class)
                        .putExtra("title", "名称")
                        .putExtra("hint", "请输入16字以内的名称（中文，数字，字母）"));
                break;
            case R.id.modification_sexy:
                //性别弹窗
                showSexyPop();
                break;
            case R.id.modification_ddyymm:
                //年月日弹窗
                showDialog(DATE_DIALOG);
                Calendar ca = Calendar.getInstance();
                mYear = ca.get(Calendar.YEAR);
                mMonth = ca.get(Calendar.MONTH);
                mDay = ca.get(Calendar.DAY_OF_MONTH);
                break;
            case R.id.modification_wachat:
                startActivity(new Intent(PersonalInformation.this, ModificationActivity.class)
                        .putExtra("title", "微信")
                        .putExtra("hint", "请输入您的微信账户（中文，数字，字母）"));
                break;
            case R.id.modification_QQ:
                startActivity(new Intent(PersonalInformation.this, ModificationActivity.class)
                        .putExtra("title", "QQ")
                        .putExtra("hint", "请输入您的QQ账户（数字）"));
                break;
            case R.id.modification_phone:
                startActivity(new Intent(PersonalInformation.this, ModificationActivity.class)
                        .putExtra("title", "手机号码")
                        .putExtra("hint", "请输入您的手机号码"));
                break;
            case R.id.modification_address:
                //联系地址
                startActivity(new Intent(PersonalInformation.this, PersonalAddress.class)
                        .putExtra("title", "联系地址"));
                break;
        }
    }
//展示年月日  这里不用了，因为用了系统自带的
//    private void showTimePop( ) {
//        View view = View.inflate(this, R.layout.timedialog, null);
//        window = new PopupWindow(view, ActionBar.LayoutParams.MATCH_PARENT,
//                android.support.v4.view.ViewPager.LayoutParams.WRAP_CONTENT,
//                true);
//        window.setAnimationStyle(R.style.style_dialog);
//        window.setBackgroundDrawable(new BitmapDrawable());
//        window.showAtLocation(modification_ddyymm, Gravity.BOTTOM, 0, 0);
//
//
//    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    public void display() {
        //控件设置时间
        textToast("修改成功");
        user_time.setText(new StringBuffer().append(mMonth + 1).append("-").append(mDay).append("-").append(mYear).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };

    //展示性别窗口
    private void showSexyPop() {
        View view = View.inflate(this, R.layout.sexydialog, null);
        window = new PopupWindow(view, ActionBar.LayoutParams.MATCH_PARENT,
                android.support.v4.view.ViewPager.LayoutParams.WRAP_CONTENT,
                true);
        window.setAnimationStyle(R.style.style_dialog);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.showAtLocation(modification_sexy, Gravity.BOTTOM, 0, 0);
        men = view.findViewById(R.id.but_men);
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToast("修改成功");
                user_sexy.setText(men.getText().toString().trim());
                window.dismiss();
            }
        });
        women = view.findViewById(R.id.but_women);
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToast("修改成功");
                user_sexy.setText(women.getText().toString().trim());
                window.dismiss();
            }
        });

    }


        }
    }

    //当点击头像时
    private void showTipPop() {

        View view = View.inflate(this, R.layout.choosepicturedialog, null);

        window = new PopupWindow(view, ActionBar.LayoutParams.MATCH_PARENT,
                android.support.v4.view.ViewPager.LayoutParams.WRAP_CONTENT,
                true);
        window.setAnimationStyle(R.style.style_dialog);
        window.setBackgroundDrawable(new BitmapDrawable());
        //出现位置
        window.showAtLocation(modification_face, Gravity.BOTTOM, 0, 0);
        //拍照
        TextView mTake_pictures = view.findViewById(R.id.but_Take_pictures);
        mTake_pictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTakePictures();
            }
        });
        //相册
        TextView mAlbum = view.findViewById(R.id.but_album);
        mAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAlbum();
            }
        });
        //取消
        TextView mCancel = view.findViewById(R.id.but_cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
    }



    //拍照
    private void myTakePictures() {
        Intent openCameraIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);
        Uri tempUri = Uri.fromFile(new File(Environment
                .getExternalStorageDirectory(), "image.jpg"));
        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        startActivityForResult(openCameraIntent, TAKE_PICTURE);
    }

    //相册
    private void myAlbum() {

        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        openAlbumIntent.setType("image/*");
        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case CHOOSE_PICTURE:
//                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case TAKE_PICTURE:
//                    startPhotoZoom(tempUri);
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
//                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }
}