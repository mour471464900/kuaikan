package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.activity.EnterActivity;

/**
 *
 *
 // 这是主页面里面的关注页面
   暂时没有业务逻辑
 */
public class MainFollowFragment extends Fragment {


    private View view;
    private ImageView imageView;

    // 这是主页面里面的关注页面
    public static MainFollowFragment newInstance(Bundle args) {
        MainFollowFragment fragment = new MainFollowFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_main_follow_fragment, container, false);
        initView();
        initListen();
        return  view;
    }

    private void initListen() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), EnterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
         imageView= (ImageView) view.findViewById(R.id.iv_follow_login);
    }




}
