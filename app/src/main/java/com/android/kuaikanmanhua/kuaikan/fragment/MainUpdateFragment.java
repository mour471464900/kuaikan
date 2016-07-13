package com.android.kuaikanmanhua.kuaikan.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kuaikanmanhua.kuaikan.R;

/**
 * 这是主页里面 更新的fragment
 */
public class MainUpdateFragment extends Fragment {

    private int[] urlNums = {
            0,    1, 1467993600, 1467907200, 1467820800, 1467734400, 1467648000
//          今天，昨天 ，动态1     ,动态2,         动态3,       动态4,      动态5
    };

    public static MainUpdateFragment newInstance(Bundle args) {
        MainUpdateFragment fragment = new MainUpdateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_updata, container, false);
        return view;
    }
}
