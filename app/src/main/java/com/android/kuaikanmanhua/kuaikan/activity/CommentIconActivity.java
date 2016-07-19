package com.android.kuaikanmanhua.kuaikan.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.bean.CommentIconBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.fragment.CommentDatumFragment;
import com.android.kuaikanmanhua.kuaikan.fragment.CommentDynamicFragment;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CommentIconActivity extends AppCompatActivity {
    List<Fragment> fragments = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    @BindView(R.id.tl_comment_icon_text)
     TabLayout tabLayout;
    @BindView(R.id.vp_comment_icon_content)
    ViewPager viewPager;

    private CompanyAdapter adapter;
    private int feedBean;
    private CommentIconBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_icon);
        ButterKnife.bind(this);

        initBean();
        initview();
        initTab();
        setViewpager();
    }

    private void initview() {

        OkHttpTool.newInstance().start(SevenDayUrl.comment_icon_datum+feedBean).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();

                bean=gson.fromJson(result,CommentIconBean.class);
                CircleImageView imageview= (CircleImageView) findViewById(R.id.iv_comment_icon_picture);
                TextView textView1= (TextView) findViewById(R.id.tv_comment_attestation);
                TextView textView2= (TextView) findViewById(R.id.tv_comment_icon_name);
                textView1.setText(bean.getData().getU_intro());
                textView2.setText(bean.getData().getNickname());
                Picasso.with(CommentIconActivity.this).load(bean.getData().getAvatar_url()).into(imageview);
            }
        });

    }

    private void initBean() {
        Intent intent=getIntent();
      if(intent!=null){
          feedBean=(intent.getIntExtra("bean",0));
      }

    }

    private void setViewpager() {
        initData();
        initAdapter();
        bindAdapter();
        //把TabLayout与ViewPager 关联在一起
        tabLayout.setupWithViewPager(viewPager);
    }

    private void bindAdapter() {
       viewPager.setAdapter(adapter);
    }

    private void initAdapter() {
      adapter = new CompanyAdapter(getSupportFragmentManager());

    }
    class CompanyAdapter extends FragmentStatePagerAdapter{

        public CompanyAdapter(FragmentManager fm) {
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

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

    private void initData() {
        initFragment();

    }

    private void initFragment() {
        Bundle bundle=new Bundle();
        bundle.putInt("bean",feedBean);
        CommentDatumFragment fragment1 = CommentDatumFragment.newInstance(bundle);
        CommentDynamicFragment fragment2 = CommentDynamicFragment.newInstance(bundle);
        fragments.add(fragment1);
        fragments.add(fragment2);
    }

    private void initTab() {
        //加载标题数据
        titleList.add("资料");
        titleList.add("动态");
        for (int i = 0; i < titleList.size(); i++) {
            //创建Tab:mTabLayout.newTab()
            //设置Tab内容:tab.setText(内容);
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }
    }
    public  void onBack(View v){
        finish();
    }
}