package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.activity.LoginActivity;

import butterknife.ButterKnife;

/**
 *
 *  这是用户登录的Fragment
 *
 *
 *  严岩，先把界面加载进去
 */
public class UserFragment extends Fragment {



    // 静态工厂模式
    public static UserFragment  newInstance(Bundle args){
        UserFragment fragment=new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this,view);
        return  view;
    }

     public void  tologin(View view){
         startActivity(new Intent(getActivity(), LoginActivity.class));
     }

}
