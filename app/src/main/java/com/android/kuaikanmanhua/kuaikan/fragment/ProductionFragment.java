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
 *
 *
 * 这是作品界面 由孙铭博完成
 *
 */
public class ProductionFragment extends Fragment {

    public static ProductionFragment newInstance(Bundle args) {
        ProductionFragment fragment = new ProductionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_production, container, false);
    }


}
