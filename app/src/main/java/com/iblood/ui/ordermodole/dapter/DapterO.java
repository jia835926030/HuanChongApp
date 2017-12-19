package com.iblood.ui.ordermodole.dapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.ui.ordermodole.bean.Bean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 2017/12/18.
 */

public class DapterO extends BaseAdapter {
   private List<Bean.DescBean> mlist;
   private Context context;
    private TextView textone;
    private RadioButton rdo;
    private RadioButton rdo_but;
    public HashMap<Integer, Boolean> states = new HashMap<Integer, Boolean>();
    public DapterO(List<Bean.DescBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
    view =    LayoutInflater.from(context).inflate(R.layout.layout,null);
      textone =  (TextView) view.findViewById(R.id.textone);
//      texttian =  (TextView) view.findViewById(R.id.texttian);
       rdo_but = (RadioButton) view.findViewById(R.id.radioButton);
      //texttian.setText(mlist.get(i).getPetPrice());
        textone.setText(mlist.get(i).getTypeName());
        rdo_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < getCount(); i++) {
                    states.put(i, false);
                }
                //然后设置点击的那个按钮设置状态为选中
                if (states.put(i, true) ){
                    textone.setTextColor(R.color.colorBlack);
                }else {
                    textone.setTextColor(R.color.colorGreyLight);
                }
              //  states.put(i, true);    //这样所有的条目中只有一个被选中！
                notifyDataSetChanged();//刷新适配器
            }
        });
        //上面是点击后设置状态，但是也是需要设置显示样式,通过判断状态设置显示的样式
        if (states.get((Integer) i) == null || states.get((Integer) i) == false) {  //true说明没有被选中
            rdo_but.setChecked(false);
//            textone.setTextColor(R.color.colorBlack);
        } else {
            rdo_but.setChecked(true);
//            textone.setTextColor(R.color.colorGreyLight);
        }
         return view;
    }


}
