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
 * 这是评论的fragment
 * 由
 *  严岩完成负责
 *
 */
public class CommentFragment extends Fragment {

    public static CommentFragment newInstance(Bundle args) {
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //初始化视图
        initView();
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    private void initView() {

    }

}
