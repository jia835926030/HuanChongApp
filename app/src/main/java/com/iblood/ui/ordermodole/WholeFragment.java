package com.iblood.ui.ordermodole;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.iblood.R;
import com.iblood.base.BaseFragment;
import com.iblood.ui.ordermodole.bean.NexBean;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.FileUtil;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TokenUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 全部
 * A simple {@link Fragment} subclass.
 */
public class WholeFragment extends BaseFragment {
    private String url = "http://123.56.150.230:8885/dog_family/orderInfo/getOrderInfoByUserId.jhtml";
  private List<NexBean> mlist = new ArrayList<>();
    private ListView listView;
    private String ip;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_whole;
    }
    @Override
    protected void initView(View view) {
       listView =  (ListView) view .findViewById(R.id.listView);

    }

    @Override
    protected void initData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(getActivity());
        FileUtil.saveToken();
        TokenUtil.init(getActivity());
        String token = TokenUtil.createToken();
        Request.Builder request = new Request.Builder();
        ip = ConnectionUtils.getIp(getActivity());
        Map<String, Object> map = new HashMap<>();
        String userID = (String) SharedPreferencesUtils.getParam(getActivity(), "userId", "");
        Log.e("id=====",userID+"");
        map.put("userId  ", userID);
        map.put("orderState  ", null);
        String s1 = CJSON.toJSONMap(map);
        Log.e("TAG", s1 + "++++++++++++++++++++++++");
        builder.add("data", s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("channel", "android")
                .addHeader("ip", ip)
                .addHeader("sign", linkString)
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
                Log.e("Tag", s2);
                // text1.setText(s2);
            }
        });


    }



    @Override
    public void setBundle(Bundle bundle) {

    }

}
