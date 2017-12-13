package com.iblood.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.iblood.R;
import com.iblood.adapter.MyPetAdapter;
import com.iblood.base.BaseActivity;
import com.iblood.db.DaoManager;
import com.iblood.entity.MyPetTabulationBean;
import com.iblood.entity.PetAddBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * 我的宠物 - 添加宠物
 *    刘贵河
 */
public class LateralspreadsPetActivity extends BaseActivity {
    @BindView(R.id.text_title)
    TextView header_title;//头标题
    @BindView(R.id.button_forward)
    Button add_pet;
    @BindView(R.id.mPetTabulation)
    ListView m_Pet_Tabulation;
    private List<PetAddBean> petList= new ArrayList<>();;
    private MyPetAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lateralspreads_pet;
    }





    @Override
    protected void initView() {
        header_title.setText("宠物列表");

/**
 * 判断集合里面是否有数据，如果没有就直接跳转到添加宠物页
 */
        query();
        if (petList.size()==0){
            textToast("请添加您的宠物");
            startActivity(new Intent(LateralspreadsPetActivity.this,PetAddActivity.class));
        }else{
            return;
        }
        adapter = new MyPetAdapter(LateralspreadsPetActivity.this, petList);
        m_Pet_Tabulation.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
    //用来查询数据库
    public void query(){

        List<PetAddBean> petlist = DaoManager.getInstence(this).getDao().queryBuilder().list();
        //讲查询的数据库信息添加到新集合里面
        petList.addAll(petlist);

    }

}
