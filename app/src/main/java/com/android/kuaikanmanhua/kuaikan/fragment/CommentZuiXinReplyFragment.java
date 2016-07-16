package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kuaikanmanhua.kuaikan.R;

//评论最新的回复界面
public class CommentZuiXinReplyFragment extends Fragment {

    public static CommentZuiXinReplyFragment newInstance(Bundle args) {
        CommentZuiXinReplyFragment fragment = new CommentZuiXinReplyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.fragment_comment_zui_xin_reply, container, false);

        return view;

    }
}
