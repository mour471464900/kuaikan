package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kuaikanmanhua.kuaikan.R;

/**
 *这是显示页面开场，
 * 七天页面的fragment
 * ，今天，昨天，动态
 */
public class SevenDayFragment extends Fragment {
    public static SevenDayFragment newInstance(Bundle args) {
        SevenDayFragment fragment = new SevenDayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_seven_day, container, false);
        return view;
    }

}
