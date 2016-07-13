package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.android.kuaikanmanhua.kuaikan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
   这是引导页面进入之后的情况
   吴浩，先完成这个
 */
public class MainFragment extends Fragment {

    @BindView(R.id.rg_top)
    RadioGroup rg_top;
    @BindView(R.id.iv_mainfragment_search)
    ImageView iv_search;
//    查找控件
    public static MainFragment newInstance(Bundle args) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,view);
        setupFramLayout();

//        设置fragment
        return view;
    }

    private void setupFramLayout() {
        initData();
//        初始化数据
        initView();
//        初始化控件
        initListener();
//        初始化监听
    }

    private void initListener() {

    }

    private void initView() {

    }

    private void initData() {

    }

}
