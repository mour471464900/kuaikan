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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.kuaikanmanhua.kuaikan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是评论的fragment
 * 由
 * 严岩完成负责
 */
public class CommentFragment extends Fragment {
    private RadioButton[] rbArray;
    private List<Fragment> fragments = new ArrayList<>();
    private int curIndes;
    @BindView(R.id.rg_comment)
    RadioGroup radioGroup;

    public static CommentFragment newInstance(Bundle args) {
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        ButterKnife.bind(this, view);
        initData();
        initTabs();
        //初始化RadioGroup监听
        initListenter();
        return view;
    }

    private void initData() {
        initFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_comment, fragments.get(0));
        transaction.commit();
        curIndes = 0;
    }

    private void initFragment() {
        CommentHotFragmet fragment1 = CommentHotFragmet.newInstance(null);
        CommentZuiXinFragment fragment2 = CommentZuiXinFragment.newInstance(null);
        fragments.add(fragment1);
        fragments.add(fragment2);

    }

    private void initListenter() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbArray.length; i++) {
                    if (checkedId == rbArray[i].getId()) {
                        switchFragment(i);
                    }
                }
            }
        });

    }

    private void switchFragment(int i) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(i);
        if (!fragment.isAdded()) {
            transaction.hide(fragments.get(curIndes)).add(R.id.fl_comment, fragment);
        } else {
            transaction.hide(fragments.get(curIndes)).show(fragment);
        }
        transaction.commit();
        curIndes = i;
    }

    private void initTabs() {
        rbArray = new RadioButton[radioGroup.getChildCount()];
        for (int i = 0; i < rbArray.length; i++) {
            rbArray[i] = (RadioButton) radioGroup.getChildAt(i);
        }
    }


}
