package com.android.kuaikanmanhua.kuaikan.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kuaikanmanhua.kuaikan.R;

/**
 *
 *这是主页里面 更新的fragment
 */
public class MainUpdateFragment extends Fragment {

    // TODO: Rename and change types and number of parameters
    public static MainUpdateFragment newInstance(Bundle args) {
        MainUpdateFragment fragment = new MainUpdateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_updata, container, false);
    }
}
