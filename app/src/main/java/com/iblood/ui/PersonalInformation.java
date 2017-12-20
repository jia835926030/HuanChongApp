package com.iblood.ui;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.config.Urls;
import com.iblood.tools.CircleImageView;
import com.iblood.ui.personal.PersonalAddress;
import com.iblood.ui.postpersondata.BindQQActivity;
import com.iblood.ui.postpersondata.BindWeChatActivity;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.CharacterParser;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.PostBitmapUtils;
import com.iblood.utils.SDPathUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TableUtils;
import com.iblood.utils.TokenUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.Manifest.permission.WRITE_APN_SETTINGS;

/**
 * Created by 刘贵河 on 2017/12/6.
 * 个人信息
 */

public class PersonalInformation extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;
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
    @BindView(R.id.iv_head)//头像
    CircleImageView ivHeadLogo;


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
    private String localImg;

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
        button_forward.setVisibility(View.GONE);
        button_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String q = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "userName", "");
        String w = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "userPhone", "");
        String ws = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "userId", "");
        String wechat = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "wechat", "");
        String qq = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "qq", "");
        int sex = (int) SharedPreferencesUtils.getParam(PersonalInformation.this, "userSex", 0);
        String address = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "address", "");
        if(sex==1){
            user_sexy.setText("男");
        }else {
            user_sexy.setText("女");
        }
        Log.e("da",q);
        Log.e("da",sex+"");
        Log.e("da",w);
        Log.e("da",ws);
        Log.e("da",qq);
        Log.e("da",wechat);
        user_name.setText(q);
        user_phone.setText(w);
        user_wachat.setText(wechat);
        user_address.setText(address+"");
        user_qq.setText(qq);
    }

    private void postData(int o) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(PersonalInformation.this);
        TokenUtil.init(PersonalInformation.this);
        String token = TokenUtil.createToken();
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(PersonalInformation.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(PersonalInformation.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID, ws);
        map.put(TableUtils.UserInfo.USERSEX, o);
        String s1 = CJSON.toJSONMap(map);
        builder.add("data", s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        Request build1 = request.url(Urls.BASE + Urls.PERSONDATAUP1).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("data", string);
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
            R.id.modification_phone, R.id.modification_QQ, R.id.modification_wachat, R.id.modification_address,
            R.id.button_backward})
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
                Date_selection(user_time,1970);


                break;
            case R.id.modification_wachat:
                Intent intent = new Intent(PersonalInformation.this, BindWeChatActivity.class);
                startActivity(intent);
                break;

            case R.id.modification_QQ:
                Intent intent1=new Intent(PersonalInformation.this,BindQQActivity.class);
                startActivity(intent1);
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
            case R.id.button_backward:
                finish();
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
                //int chsAscii = instance.getChsAscii(men.getText().toString());
                postData(1);
                SharedPreferencesUtils.setParam(PersonalInformation.this,"sex",1);
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
                postData(2);
                SharedPreferencesUtils.setParam(PersonalInformation.this,"sex",2);
                window.dismiss();
            }
        });

    }


    //当点击头像时
    @SuppressLint("NewApi")
    private void showTipPop() {
        View view = getLayoutInflater().inflate(R.layout.choosepicturedialog, null);
        final Dialog dialog = new Dialog(this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.onWindowAttributesChanged(wl);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        TextView btnCamera = (TextView) view.findViewById(R.id.btn_to_camera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                dialog.dismiss();
//
                Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                        openCameraIntent.putExtra(Settings.ACTION_APN_SETTINGS,"");
                            openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(SDPathUtils.getCachePath(), "temp.jpg")));
                            startActivityForResult(openCameraIntent, 2);


                    }
            }
        });
        TextView btnPhoto = (TextView) view.findViewById(R.id.btn_to_photo);
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 1);
                dialog.dismiss();
            }
        });
        TextView btnCancel = (TextView) view.findViewById(R.id.btn_to_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 3 && resultCode == 200) {
            user_name.setText(data.getStringExtra("rcode"));
            textToast("修改成功");
        }
        //微信
        if (requestCode == 4 && resultCode == 200) {
//            user_wachat.setText(data.getStringExtra("rcode"));
            textToast("修改成功");
        }
        //QQ
        if (requestCode == 5 && resultCode == 200) {
//            user_qq.setText(data.getStringExtra("rcode"));
            textToast("修改成功");
        }
        //电话
        if (requestCode == 6 && resultCode == 200) {
//            user_phone.setText(data.getStringExtra("rcode"));
            textToast("修改成功");
        }
        //住址
        if (requestCode == 7 && resultCode == 200) {
//            user_address.setText(data.getStringExtra("rcode"));
            textToast("修改成功");
        }
        if (requestCode == 1 && data != null) {
            startPhotoZoom(data.getData());
        } else if (requestCode == 2) {
            File temp = new File(SDPathUtils.getCachePath(), "temp.jpg");
            startPhotoZoom(Uri.fromFile(temp));
        } else if (requestCode == 3) {
            if (data != null) {
                setPicToView(data);


            }
        }
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent(PersonalInformation.this, PreviewActivity.class);
        intent.setDataAndType(uri, "image/*");
        startActivityForResult(intent, 3);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param picdata
     */
    private void setPicToView(Intent picdata) {
        Bitmap bitmap = null;
        byte[] bis = picdata.getByteArrayExtra("bitmap");
        bitmap = BitmapFactory.decodeByteArray(bis, 0, bis.length);
        localImg = System.currentTimeMillis() + ".JPEG";

        if (bitmap != null) {

            SDPathUtils.saveBitmap(bitmap, localImg);

            Log.e("bitmap",localImg+"");
            Log.e("本地图片绑定", SDPathUtils.getCachePath() + localImg);
            textToast("修改成功");
            setImageUrl(ivHeadLogo, "file:/" + SDPathUtils.getCachePath() + localImg, R.mipmap.user_defaults);
            Log.e("path","file:/" + SDPathUtils.getCachePath() + localImg);

//            try {
//                File myCaptureFile = new File("file:/" + SDPathUtils.getCachePath() + localImg);
//                Log.e("file",myCaptureFile+"");
//                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
//                bos.flush();
//                bos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }

    }



    private DisplayImageOptions options;

    public void setImageUrl(ImageView ivId, String imageUrl, int emptyImgId) {
        if (options == null) {
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(emptyImgId)
                    .showImageForEmptyUri(emptyImgId)
                    .showImageOnFail(emptyImgId).cacheInMemory(true)
                    .cacheOnDisk(true).considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565).build();
        }
        ImageLoader.getInstance().displayImage(imageUrl, ivId, options);
    }
}
