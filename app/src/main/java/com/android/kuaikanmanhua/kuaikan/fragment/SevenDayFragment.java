package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.kuaikanmanhua.kuaikan.R;

/**
 *这是显示页面开场，
 * 七天页面的fragment
 * ，今天，昨天，动态
 */
public class SevenDayFragment extends Fragment {
    private int id;

    //    通过id 来动态的获取 url
    public static SevenDayFragment newInstance(Bundle args) {
        SevenDayFragment fragment = new SevenDayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle=getArguments();
        if (bundle!=null){
           id =bundle.getInt("id",0);
            Toast.makeText(context,"id="+ id, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_seven_day, container, false);
        int red= (int) (Math.random()*256);
        int blue= (int) (Math.random()*256);
        int green= (int) (Math.random()*256);
        view.setBackgroundColor(Color.rgb(red,blue,green));
        return view;
    }

}
