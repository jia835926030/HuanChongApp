package com.iblood.dbprefents.frament;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.app.App;
import com.iblood.ui.activity.GiadingActivity;

/**
 * Created by dell on 2017/12/6.
 */

public class ThreFramentsImage extends Fragment {
    private View view;
    private RelativeLayout mRelativeLayout;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view=getView();
        initView();
    }
    private void initView() {
        mRelativeLayout= (RelativeLayout) view.findViewById(R.id.fragment_background);
        mRelativeLayout.setBackgroundResource(R.mipmap.pager03);
        mTextView = (TextView) view.findViewById(R.id.fragment_text);
        mTextView.setVisibility(View.VISIBLE);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = App.editor;
               editor.putString("domeYinDao","1");
                editor.commit();
                Intent intent=new Intent(getActivity(),GiadingActivity.class);
                    startActivityForResult(intent,1);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1)
        {
            if (resultCode==1)
            {
                getActivity().setResult(1);
                getActivity().finish();
            }
        }
    }
}
