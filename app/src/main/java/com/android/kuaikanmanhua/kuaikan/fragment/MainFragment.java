package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.List;

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
    private List<Fragment> fragmentList = new ArrayList<>();
    private RadioButton[] rbChilds;
    private int preIndex=1;

    public static MainFragment newInstance(Bundle args) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
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

    private void initData() {
        initFragment();
//         初始化Fragment
        initFragmentContent();
    }

    private void initFragmentContent() {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_main_fragment, fragmentList.get(1));
//        因为是在更新的fragment所以就是第二个
        transaction.commit();
    }

    private void initFragment() {
        MainFollowFragment fragment1 = MainFollowFragment.newInstance(null);
        //关注的fragment
        MainUpdateFragment fragment2 = MainUpdateFragment.newInstance(null);
//        更新的fragment
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
    }

    private void initView() {
//        初始化加载按钮
        rbChilds = new RadioButton[rg_top.getChildCount()];
        for (int i = 0; i < rbChilds.length; i++) {
            rbChilds[i] = (RadioButton) rg_top.getChildAt(i);
            rbChilds[i].setTag(i);
        }
        checkRadioButton(1);
    }

    private void checkRadioButton(int position) {
        for (int i = 0; i < rbChilds.length; i++) {
            if (i == position) {
                rbChilds[i].setChecked(true);
            } else {
                rbChilds[i].setChecked(false);
            }
        }
    }

    private void initListener() {
//        rb的点击事件
        rg_top.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbChilds.length; i++) {
                    if (rbChilds[i].getId() == checkedId) {
                        switchFragment(i);
//                        转换fragment
                    }
                }
            }
        });
    }

    //  装换fragment 的代码
    private void switchFragment(int position) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragmentList.get(position);
        Fragment preFragment = fragmentList.get(preIndex);
        if (!fragment.isAdded()) {
            transaction.hide(preFragment).add(R.id.fl_main_fragment, fragment);
        } else {
            transaction.hide(preFragment).show(fragment);
        }
        preIndex = position;
        transaction.commit();
    }

}
