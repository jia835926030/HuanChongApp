package com.iblood.ui;


import android.content.Intent;
import android.os.Build;

import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.adapter.MyPetAdapter;
import com.iblood.base.BaseActivity;

import com.iblood.entity.PetInfo;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;

import com.iblood.utils.FileUtil;
import com.iblood.utils.OkHttpUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;

import com.iblood.utils.TableUtils;
import com.iblood.utils.TokenUtil;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 我的宠物 - 添加宠物
 * 刘贵河
 */
public class LateralspreadsPetActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    TextView add_pet;
    @BindView(R.id.button_backward)
    ImageView button_backward;
    @BindView(R.id.mPetTabulation)
    ListView m_Pet_Tabulation;
    private List<PetInfo> petList = new ArrayList<>();
    private List<PetInfo> petInfos;
    private MyPetAdapter adapter;
    public static final String URL = "http://123.56.150.230:8885/dog_family/petInfo/getPetInfoByUserId.jhtml";

    // 数据请求URL
    @Override
    protected int getLayoutId() {
        return R.layout.activity_lateralspreads_pet;
    }


    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void initView() {
        header_title.setText("宠物列表");
        add_pet.setText("添加");
        AppUtils.setAppContext(this);
        TokenUtil.init(this);
        String token = TokenUtil.createToken();
        FileUtil.saveToken();
        initListView();
/**
 * 判断集合里面是否有数据，如果没有就直接跳转到添加宠物页
 */
//        query();

        if (petList.size() == 0) {
            textToast("请添加您的宠物");
            //startActivity(new Intent(LateralspreadsPetActivity.this, PetAddActivity.class)
                    //释放模拟器运行不了要求android5.0 以上
//                    , ActivityOptions.makeSceneTransitionAnimation(LateralspreadsPetActivity.this).toBundle()
          //  );

        } else {
            return;
        }

        adapter = new MyPetAdapter(LateralspreadsPetActivity.this, petList);
        m_Pet_Tabulation.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        initListView();
    }

    @Override
    protected void initListener() {
        //集合长度如果大于等于0就可以跳转添加宠物
        //如果机和长度大于等于3，就隐藏添加按钮
        //每个用户最多添加三只宠物
        add_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (petList.size() >= 3) {
                    textToast("每个用户最多添加三只宠物!");
                } else {

                    startActivity(new Intent(LateralspreadsPetActivity.this, PetAddActivity.class));
                }
            }
        });


        button_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //用来查询数据库
    public void query() {

//        List<PetAddBean> petlist = DaoManager.getInstence(this).getDao().queryBuilder().list();
//        //讲查询的数据库信息添加到新集合里面
//        petList.addAll(petlist);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //initListView();
    }



    private void initListView() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(LateralspreadsPetActivity.this);
        TokenUtil.init(LateralspreadsPetActivity.this);
        String token = TokenUtil.createToken();
        Log.e("token",token);
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(LateralspreadsPetActivity.this);
        Map<String, Object> map = new HashMap<>();
        String ws = (String) SharedPreferencesUtils.getParam(LateralspreadsPetActivity.this, "userId", "");
        map.put(TableUtils.UserInfo.USERID,ws);

        String s1 = CJSON.toJSONMap(map);
        Log.e("DA", s1);
        builder.add(CJSON.DATA, s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign",linkString)
                .addHeader("ip",ip)
                .addHeader("token",token)
                .addHeader("channel","android");
        Request build1 = request.url(URL).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("宠物",string);
                if (CJSON.getRET(string)) {
                    petInfos = CJSON.parseArray(CJSON.getDESC(string),
                            PetInfo.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            petList.addAll(petInfos);
                            adapter.notifyDataSetChanged();
                        }
                    });
                }

            }
        });
    }
}
