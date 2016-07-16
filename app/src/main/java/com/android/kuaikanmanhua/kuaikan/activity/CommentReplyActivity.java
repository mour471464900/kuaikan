package com.android.kuaikanmanhua.kuaikan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.kuaikanmanhua.kuaikan.R;

import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.fragment.CommentHotReplyFragment;

import com.android.kuaikanmanhua.kuaikan.fragment.CommentZuiXinReplyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
//  从评论热门Fragment跳转到回复，界面
public class CommentReplyActivity extends AppCompatActivity {

   @BindView(R.id.rb_comment_hot_1)
    RadioButton rb1;
    @BindView(R.id.rb_comment_hot_2)
    RadioButton rb2;
    private List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.rg_hot_reply)
    RadioGroup radioGroup;
    @BindView(R.id.vp_hot_reply)
    ViewPager viewPager;

    private ReplyAdapter replyAdapter;
    private long feedId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_reply);
        ButterKnife.bind(this);
        initBean();
     setupViewPager();


    }

    private void initBean() {
        Intent intent=getIntent();
        if(intent!=null){
            feedId=  intent.getLongExtra("id",0);
        }
    }

    private void setupViewPager() {
        initData();
//      初始化数据

        initAdapter();
//       初始化适配器
        bindAdapter();
//        判定适配器
        initListen();

    }

    private void initListen() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 switch (checkedId){
                     case R.id.rb_comment_hot_1:
                      viewPager.setCurrentItem(0);
                     break;
                     case R.id.rb_comment_hot_2:
                         viewPager.setCurrentItem(1);
                         break;
                 }
            }
        });
      viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

          }

          @Override
          public void onPageSelected(int position) {
              switch (position){
                  case 0:
                      rb1.setChecked(true);
                      break;
                  case 1:
                      rb2.setChecked(true);
                      break;
              }
          }

          @Override
          public void onPageScrollStateChanged(int state) {

          }
      });
    }


    private void bindAdapter() {
        viewPager.setAdapter(replyAdapter);

    }

    private void initAdapter() {
        replyAdapter = new ReplyAdapter(getSupportFragmentManager());
    }


    class ReplyAdapter extends FragmentPagerAdapter {
        public ReplyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments==null?0:fragments.size();
        }

    }

        private void initData() {
           initFragment();
        }

        private void initFragment() {
            Bundle bundle=new Bundle();
            bundle.putLong("feedId",feedId);
            CommentHotReplyFragment fragment1 = CommentHotReplyFragment.newInstance(bundle);
            CommentZuiXinReplyFragment fragment2 = CommentZuiXinReplyFragment.newInstance(bundle);
            fragments.add(fragment1);
            fragments.add(fragment2);
        }


    }