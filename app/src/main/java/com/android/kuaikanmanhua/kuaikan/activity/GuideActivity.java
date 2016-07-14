package com.android.kuaikanmanhua.kuaikan.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;


import com.android.kuaikanmanhua.kuaikan.MainActivity;
import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.GuidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    //图片资源的数组
    private int[]mImageIdArray;
    //图片的集合
    private List<View>mViewList;
    //放置圆点
    private ViewGroup mViewGroup;
    //实例化圆点View
    private ImageView mImageView;
    private ImageView []mImageViewArray;
    //最后一页的按钮
    private RadioButton mRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mRadioButton= (RadioButton) findViewById(R.id.rb_vp_into);
        mRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuideActivity.this, ContentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //加载ViewPager
        initViewPager();
        //加在底部圆点
        initViewPagerTag();
    }

    /**
     * 加载底部圆点
     */
    private void initViewPagerTag() {
        //这里实例化LinearLayout
        mViewGroup= (ViewGroup) findViewById(R.id.ll_vp_tag);
        //根据ViewPager的Item数量实例化数组
        mImageViewArray=new ImageView[mViewList.size()];
        //循环新建底部圆点，将生成的imageview保存到数组中
        for (int i = 0; i <mViewList.size() ; i++) {
            mImageView=new ImageView(this);
            mImageView.setLayoutParams(new ViewGroup.LayoutParams(0,0));
            mImageView.setPadding(10,0,10,0);
            mImageViewArray[i]=mImageView;
            //第一个页面需要设置为选中状态，这里要使用两张不同的图片（选中与未选中）
            if(i==0){
                mImageView.setBackgroundResource(R.drawable.tag_on);
            }else{
                mImageView.setBackgroundResource(R.drawable.tag_off);
            }
            //将数组中的Imageview加入到viewgroup
            mViewGroup.addView(mImageViewArray[i]);
        }
    }

    /**
     * 加载ViewPager
     */
    private void initViewPager() {
        mViewPager= (ViewPager) findViewById(R.id.vp_first);
        //实例化图片资源
        mImageIdArray=new int[]{R.drawable.bg_guide1_background,R.drawable.bg_guide2_background,
        R.drawable.bg_guide3_background};
        mViewList=new ArrayList<View>();
        //获取一个layout参数，设置为match_parent
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        //循环创建view并进入集合
        for (int i = 0; i <mImageIdArray.length ; i++) {
            //new Imageview 并设置全屏个图片资源
            ImageView imageView=new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(mImageIdArray[i]);
            //将imageView加入到View集合中
            mViewList.add(imageView);
        }
        //View集合输出初始化好，就可以setAdapter了
        mViewPager.setAdapter(new GuidePagerAdapter(mViewList));
        //添加CiewPager的滑动监听
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    //滑动后的监听
    @Override
    public void onPageSelected(int position) {
        //循环设置当前页的标记图
        for (int i = 0; i <mImageViewArray.length ; i++) {
            mImageViewArray[position].setBackgroundResource(R.drawable.tag_on);
            if (position!=i){
                mImageViewArray[i].setBackgroundResource(R.drawable.tag_off);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
