package com.iblood.ui.ordermodole;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.iblood.R;
import com.iblood.base.BaseFragment;
import com.iblood.config.Urls;
import com.iblood.entity.Screen;
import com.iblood.fellow.FellowAdapter;
import com.iblood.ui.HomeActivity;
import com.iblood.ui.PersonalInformation;
import com.iblood.ui.ordermodole.bean.NexBean;
import com.iblood.ui.ordermodole.dapter.NexDapter;
import com.iblood.utils.AppUtils;
import com.iblood.utils.CJSON;
import com.iblood.utils.ConnectionUtils;
import com.iblood.utils.SharedPreferencesUtils;
import com.iblood.utils.SignUtil;
import com.iblood.utils.TokenUtil;

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

import static android.content.ContentValues.TAG;

/**
 * 全部
 * A simple {@link Fragment} subclass.
 */
public class WholeFragment extends BaseFragment {
  private List<NexBean> mlist = new ArrayList<>();
    private ListView listView;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_whole;
    }
    @Override
    protected void initView(View view) {
       listView =  (ListView) view .findViewById(R.id.listView);
        getHttpData();
//         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//             @Override
//             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               startActivity(  new Intent(getActivity(),ParticularsActivity.class));
//             }
//         });
    }

    @Override
    protected void initData() {
        mlist.clear();
        for (int i = 0; i <6 ; i++) {
            mlist.add(new NexBean(R.drawable.jia));
        }

        initdata();
    }

    private void getHttpData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        AppUtils.setAppContext(getActivity());
        TokenUtil.init(getActivity());
        String token = TokenUtil.createToken();
        Request.Builder request = new Request.Builder();
        String ip = ConnectionUtils.getIp(getActivity());
        Map<String, Object> map = new HashMap<>();
        String s1 = CJSON.toJSONMap(map);
        String ws = (String) SharedPreferencesUtils.getParam(getActivity(), "userId", "");
        //Log.e("DA", s1);
        builder.add("data", s1);
        String linkString = SignUtil.createLinkString(map);
        request.addHeader("sign", linkString);
        request.addHeader("ip", ip);
        request.addHeader("token", token);
        request.addHeader("channel", "android");
        //request.addHeader("userId", ws);
        Log.e(TAG, "getHttpData:"+ws);
        builder.add("userId",ws);
        Request build1 = request.url(Urls.BASE+Urls.PERSONORDER).post(builder.build()).build();
        okHttpClient.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                Log.e("onResponse=====: ", data);

            }
        });
    }

    private void initdata() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NexDapter nexDapter = new NexDapter(getActivity(),mlist);
                listView.setAdapter(nexDapter);
            }
        });
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

}
