package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.activity.SearchActivity;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 *
 * 这是作品界面 由孙铭博完成
 *
 */
public class ProductionFragment extends Fragment {

    @BindView(R.id.rg_production)
    RadioGroup mRadioGroup;
    @BindView(R.id.iv_search)
    ImageView mSearch;


    private RadioButton[] rbChilds;
    private List<Fragment> mFragmentList=new ArrayList<>();
    private  int curIndex;

    public static ProductionFragment newInstance(Bundle args) {
        ProductionFragment fragment = new ProductionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_production,container,false);
        ButterKnife.bind(this,view);
        initData();
        initTabs();
        //初始化RadioGroup监听
        initListenter();
        return view;
    }

    private void initData() {
        initFragment();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.fl_production,mFragmentList.get(0));
        transaction.commit();
        curIndex=0;
    }
    private void initFragment() {
        ProHotFragment fragment1 = ProHotFragment.newInstance(null);
        ProClassifyFragment fragment2 = ProClassifyFragment.newInstance(null);
        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
    }

    private void initTabs() {
        rbChilds=new RadioButton[mRadioGroup.getChildCount()];
        for(int i=0;i<rbChilds.length;i++){
            rbChilds[i]=(RadioButton) mRadioGroup.getChildAt(i);
        }
    }

    private void initListenter() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbChilds.length; i++) {
                    if (checkedId==rbChilds[i].getId()){
                        switchFragment(i);
                    }
                }
            }
        });

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }
    private void switchFragment(int i) {
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        Fragment fragment=mFragmentList.get(i);
        if(!fragment.isAdded()){
            transaction.hide(mFragmentList.get(curIndex)).add(R.id.fl_production,fragment);
        }else {
            transaction.hide(mFragmentList.get(curIndex)).show(fragment);
        }
        transaction.commit();
        curIndex=i;
    }


}



