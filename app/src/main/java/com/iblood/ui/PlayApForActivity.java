package com.iblood.ui;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iblood.R;
import com.iblood.base.BaseActivity;
import com.iblood.ui.ordermodole.activity.SelectPicPopupWindow;
import com.iblood.ui.ordermodole.activity.Yingye;
import com.iblood.ui.ordermodole.bean.Bean;
import com.iblood.ui.ordermodole.dapter.DapterO;
import com.iblood.ui.shenqing.MyDialog;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.PulldataHandler;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TokenUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class PlayApForActivity extends BaseActivity implements 	MyDialog.OnButtonClickListener, AdapterView.OnItemClickListener {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView button_forward;
    @BindView(R.id.button_backward)
    ImageView button_backward;

    private String pathImage;
    public static final int NONE = 0;
    public static final int PHOTOHRAPH = 1;
    public static final int PHOTOZOOM = 2;
    public static final int PHOTORESOULT = 3;
    public static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_OPEN = 4;
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
    public HashMap<Integer, Boolean> states = new HashMap<Integer, Boolean>();
    private List<Bean.DescBean> desc1;
    private RadioButton rab_1;
    private RadioButton rab_2;
    private GridView gridView;
    private MyDialog dialog;
    private Bitmap bmp;
    private ArrayList<HashMap<String, Object>> imageItem;
    private SimpleAdapter simpleAdapter;

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
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_backward:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setOnItemClickListener(this);
        dialog = new MyDialog(this);
        dialog.setOnButtonClickListener(this);
        LayoutInflater layout = this.getLayoutInflater();
        View view = layout.inflate(R.layout.layout_select_photo, null);


        button_forward.setVisibility(View.GONE);
        header_title.setText("预约寄养");
        button_backward.setMaxHeight(50);
        button_backward.setMaxHeight(50);
        name = (EditText) findViewById(R.id.fosterapply_name);
        phone = (EditText) findViewById(R.id.fosterapply_phones);
        city = (EditText) findViewById(R.id.fosterapply_city);
        rab_1 = (RadioButton) findViewById(R.id.radioButton);
        rab_2 = (RadioButton) findViewById(R.id.radioButton1);
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
//        item_top = (TextView) findViewById(R.id.item_top);
//        item_top.setText("申请成为寄养家庭");

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
                        DapterO dapterO = new DapterO(desc, PlayApForActivity.this);
                        petFosterListView.setAdapter(dapterO);
                    }
                });

            }
        });
    }

    @Override
    protected void initData() {
        bmp = BitmapFactory.decodeResource(getResources(),
                R.drawable.gridview_addpic);
        imageItem = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("itemImage", bmp);
        imageItem.add(map);
        simpleAdapter = new SimpleAdapter(this, imageItem,
                R.layout.griditem_addpic, new String[]{"itemImage"},
                new int[]{R.id.imageView1});
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                // TODO Auto-generated method stub
                if (view instanceof ImageView && data instanceof Bitmap) {
                    ImageView i = (ImageView) view;
                    i.setImageBitmap((Bitmap) data);
                    return true;
                }
                return false;
            }
        });
        gridView.setAdapter(simpleAdapter);


        yingye_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(PlayApForActivity.this,
                        Yingye.class), 1);
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
    public void camera() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), "temp.jpg")));
        startActivityForResult(intent, PHOTOHRAPH);
    }

    @Override
    public void gallery() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE_OPEN);

    }

    @Override
    public void cancel() {
        // TODO Auto-generated method stub
        dialog.cancel();
    }


    @Override
    protected void initListener() {

    }

    @SuppressLint("NewApi")
    private boolean VerificationData() {
        if (name.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!name.getText().toString().trim()
                .matches("^[\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*$")) {
            Toast.makeText(this, "真实姓名不合法", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (city.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "选择城市", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (address.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "家庭地址不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (identity.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "身份证不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!identity.getText().toString().trim()
                .matches("^[1-9][0-9]{16}[0-9|X]$")) {
            Toast.makeText(this, "身份证不合法", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (identity_icon == null) {
            Toast.makeText(this, "请上传身份照片", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (yingye_icon == null) {
            Toast.makeText(this, "请上传营业照", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (desc1.size() == 0) {
            Toast.makeText(this, "请选择宠物", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == NONE)
            return;
        if (requestCode == PHOTOHRAPH) {

            File picture = new File(Environment.getExternalStorageDirectory()
                    + "/temp.jpg");
            startPhotoZoom(Uri.fromFile(picture));
        }

        if (data == null)
            return;

        // ������
        if (requestCode == PHOTORESOULT) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)ѹ���ļ�
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("itemImage", photo);
                imageItem.add(map);
                simpleAdapter = new SimpleAdapter(this, imageItem,
                        R.layout.griditem_addpic, new String[]{"itemImage"},
                        new int[]{R.id.imageView1});
                simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                    @Override
                    public boolean setViewValue(View view, Object data,
                                                String textRepresentation) {
                        // TODO Auto-generated method stub
                        if (view instanceof ImageView && data instanceof Bitmap) {
                            ImageView i = (ImageView) view;
                            i.setImageBitmap((Bitmap) data);
                            return true;
                        }
                        return false;
                    }
                });
                gridView.setAdapter(simpleAdapter);
                simpleAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }

        }
        // ��ͼƬ
        if (resultCode == RESULT_OK && requestCode == IMAGE_OPEN) {
            startPhotoZoom(data.getData());
        }
        super.onActivityResult(requestCode, resultCode, data);


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
                            }
                        }
                    }

                }
                break;
            case 2:
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

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        if (!TextUtils.isEmpty(pathImage)) {
            Bitmap addbmp = BitmapFactory.decodeFile(pathImage);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", addbmp);
            imageItem.add(map);
            simpleAdapter = new SimpleAdapter(this, imageItem,
                    R.layout.griditem_addpic, new String[]{"itemImage"},
                    new int[]{R.id.imageView1});
            simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                @Override
                public boolean setViewValue(View view, Object data,
                                            String textRepresentation) {
                    // TODO Auto-generated method stub
                    if (view instanceof ImageView && data instanceof Bitmap) {
                        ImageView i = (ImageView) view;
                        i.setImageBitmap((Bitmap) data);
                        return true;
                    }
                    return false;
                }
            });
            gridView.setAdapter(simpleAdapter);
            simpleAdapter.notifyDataSetChanged();
            pathImage = null;
            dialog.dismiss();
        }

    }

    protected void dialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(PlayApForActivity.this);
        builder.setMessage("确认移除已经添加的照片吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                imageItem.remove(position);
                simpleAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        // TODO Auto-generated method stub
        if (imageItem.size() == 10) {
            Toast.makeText(PlayApForActivity.this, "图片九张已满",
                    Toast.LENGTH_SHORT).show();
        } else if (position == 0) {
            // ѡ��ͼƬ
            dialog.show();

            // ͨ��onResume()ˢ������
        } else {
            dialog(position);
        }

    }

    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
        intent.putExtra("crop", "true");
        // aspectX aspectY �ǿ�ߵı���
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY �ǲü�ͼƬ���
        intent.putExtra("outputX", 64);
        intent.putExtra("outputY", 64);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTORESOULT);
    }
}


