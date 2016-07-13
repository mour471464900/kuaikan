package com.android.kuaikanmanhua.kuaikan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MBENBEN on 2016/7/13.
 */
public class CommentZuiXinFragment extends Fragment {
     public static CommentZuiXinFragment newInstance(Bundle args){
         CommentZuiXinFragment fragment=new CommentZuiXinFragment();
         fragment.setArguments(args);
         return fragment;
     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
