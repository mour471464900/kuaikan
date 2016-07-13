package com.android.kuaikanmanhua.kuaikan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kuaikanmanhua.kuaikan.R;

/**
 * Created by MBENBEN on 2016/7/13.
 */
public class CommentHotFragmet extends Fragment {
    public static CommentHotFragmet newInstance(Bundle args) {
        CommentHotFragmet fragment = new CommentHotFragmet();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.comment_hot_fragment,container,false);
       initData();
        return view;
    }

    private void initData() {

    }
}
