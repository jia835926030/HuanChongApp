package com.iblood.ui;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.app.App;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.ui.personal.PersonalAddress;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.CharacterParser;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TableUtils;
import com.iblood.utils.TokenUtil;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 刘贵河 on 2017/12/6.
 * 个人信息
 */

public class PersonalInformation extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    Button button_forward;
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
    @BindView(R.id.user_name)
    TextView user_name;
    @BindView(R.id.user_sexy)
    TextView user_sexy;
    @BindView(R.id.user_time)
    TextView user_time;
    @BindView(R.id.user_wachat)
    TextView user_wachat;
    @BindView(R.id.user_QQ)
    TextView user_qq;
    @BindView(R.id.user_phone)
    TextView user_phone;
    @BindView(R.id.user_address)
    TextView user_address;


    private PopupWindow window;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static final int NAME_CODE = 3;
    protected static final int WACHAT_CODE = 4;
    protected static final int QQ_CODE = 5;
    protected static final int PHONE_CODE = 6;
    protected static final int ADDRESS_CODE = 7;


    private TextView men;
    private TextView women;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_information;
    }

    @Override
    protected void onResume() {
        super.onResume();
        header_title.setText("个人信息");
    }

    @Override
    protected void initView() {
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //postData();
            }


        });
    }

    private void postData(String o) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(PersonalInformation.this);
        TokenUtil.init(PersonalInformation.this);
        String token = TokenUtil.createToken();
        Log.e("token",token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(PersonalInformation.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.USERSEX, o);
        String s1 = CJSON.toJSONMap(map);
        Log.e("DA", s1);
        builder.add("data", s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        Request build1 = request.url(Urls.BASE+Urls.PERSONDATAUP1).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("data",string);
            }
        });
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

            case R.id.modification_face:
                //弹窗
                showTipPop();
                break;

            case R.id.modification_name:
                //跳转修改名称
                startActivityForResult(new Intent(PersonalInformation.this, ModificationActivity.class)
                        .putExtra("title", "名称")
                        .putExtra("hint", "请输入16字以内的名称（中文，数字，字母）"), NAME_CODE);

                break;
            case R.id.modification_sexy:
                //性别弹窗
                showSexyPop();

                break;
            case R.id.modification_ddyymm:
                //年月日弹窗
                Date_selection(user_time);


                break;
            case R.id.modification_wachat:
               Intent intent=new Intent(PersonalInformation.this,BindWeChatActivity.class);
               startActivity(intent);
                break;
            case R.id.modification_QQ:
                startActivityForResult(new Intent(PersonalInformation.this, ModificationActivity.class)
                        .putExtra("title", "QQ")
                        .putExtra("hint", "请输入您的QQ账户（数字）"), QQ_CODE);
                break;
            case R.id.modification_phone:
                startActivityForResult(new Intent(PersonalInformation.this, ModificationActivity.class)
                        .putExtra("title", "手机号码")
                        .putExtra("hint", "请输入您的手机号码"), PHONE_CODE);
                break;
            case R.id.modification_address:
                //联系地址
                startActivityForResult(new Intent(PersonalInformation.this, PersonalAddress.class)
                        .putExtra("title", "联系地址"), ADDRESS_CODE);
                break;
        }
    }




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
                CharacterParser instance = CharacterParser.getInstance();
                int chsAscii = instance.getChsAscii(men.getText().toString());
                postData(chsAscii+"");
                window.dismiss();
            }
        });
        women = view.findViewById(R.id.but_women);
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToast("修改成功");
                user_sexy.setText(women.getText().toString().trim());
                CharacterParser instance = CharacterParser.getInstance();
                int chsAscii = instance.getChsAscii(women.getText().toString());
                postData(chsAscii+"");
                window.dismiss();
            }
        });

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
//        Intent openCameraIntent = new Intent(
//                MediaStore.ACTION_IMAGE_CAPTURE);
//        Uri tempUri = Uri.fromFile(new File(Environment
//                .getExternalStorageDirectory(), "image.jpg"));
//        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
//        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
//        startActivityForResult(openCameraIntent, TAKE_PICTURE);
//只用来拍照 android7.0
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = FileProvider.getUriForFile(App.mBaseActivity, "com.jph.takephoto.fileprovider", file);//通过FileProvider创建一个content类型的Uri
        Log.e("uuu", imageUri + "");
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//将拍取的照片保存到指定URI
        startActivityForResult(intent, TAKE_PICTURE);

//        //拍照并裁剪 Android7.0
//        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
//        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
//        Uri outputUri = FileProvider.getUriForFile(App.mBaseActivity, "com.jph.takephoto.fileprovider",file);
//        //通过FileProvider创建一个content类型的Uri
//        Uri imageUri=FileProvider.getUriForFile(App.mBaseActivity, "com.jph.takephoto.fileprovider", new File("/storage/emulated/0/temp/1474960080319.jpg"));
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        intent.setDataAndType(imageUri, "image/*");
//        intent.putExtra("crop", "true");
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        intent.putExtra("scale", true);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//        intent.putExtra("noFaceDetection", true); // no face detection
//        startActivityForResult(intent,TAKE_PICTURE);
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

        if (requestCode == 3 && resultCode == 200) {
            user_name.setText(data.getStringExtra("rcode"));
        }
        //微信
        if (requestCode == 4 && resultCode == 200) {
            user_wachat.setText(data.getStringExtra("rcode"));
        }
        //QQ
        if (requestCode == 5 && resultCode == 200) {
            user_qq.setText(data.getStringExtra("rcode"));
        }
        //电话
        if (requestCode == 6 && resultCode == 200) {
            user_phone.setText(data.getStringExtra("rcode"));
        }
        //住址
        if (requestCode == 7 && resultCode == 200) {
            user_address.setText(data.getStringExtra("rcode"));
        }

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
