package com.android.kuaikanmanhua.kuaikan.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kuaikanmanhua.kuaikan.R;

/**
 *
 *
 *
 */
public class MainFollowFragment extends Fragment {


    // 这是主页面里面的关注页面
    public static MainFollowFragment newInstance(Bundle args) {
        MainFollowFragment fragment = new MainFollowFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_follow_fragment, container, false);
    }


}
