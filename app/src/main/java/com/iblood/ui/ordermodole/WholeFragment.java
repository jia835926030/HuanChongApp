package com.iblood.ui.ordermodole;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.iblood.R;
import com.iblood.base.BaseFragment;
import com.iblood.ui.ordermodole.bean.NexBean;
import com.iblood.ui.ordermodole.dapter.NexDapter;

import java.util.ArrayList;
import java.util.List;

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
