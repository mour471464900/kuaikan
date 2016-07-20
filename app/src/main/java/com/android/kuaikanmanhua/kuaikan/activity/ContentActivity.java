package com.android.kuaikanmanhua.kuaikan.activity;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.fragment.CommentFragment;
import com.android.kuaikanmanhua.kuaikan.fragment.MainFragment;
import com.android.kuaikanmanhua.kuaikan.fragment.ProductionFragment;
import com.android.kuaikanmanhua.kuaikan.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 *  这个是主要的 内容的activity *
 *  这是重要内容，里面有主要的四个fragment
*/
public class ContentActivity extends AppCompatActivity {
    @BindView(R.id.rg_main)
    RadioGroup rgBottom;
    private List<Fragment> fragmentList = new ArrayList<>();
    private RadioButton[] rbChilds;
    private long exitTime;
    private int preIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);
        initData();
//        初始化数据
        initView();
//        初始化控件
        initListener();
//        初始化监听
    }

    private void initData() {
        initFragment();
//         初始化Fragment
        initFragmentContent();
    }

    private void initFragmentContent() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_main_content, fragmentList.get(0));
        transaction.commit();
        //hahaha
    }

    private void initFragment() {
        MainFragment fragment1=MainFragment.newInstance(null);
        //主要的fragment
        ProductionFragment fragment2=ProductionFragment.newInstance(null);
//        作品的fragment
        CommentFragment fragment3=CommentFragment.newInstance(null);
//        评论的fragment
        UserFragment fragment4=UserFragment.newInstance(null);
//        用户的fragment
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

    }

    private void initView() {
//        初始化加载按钮
        rbChilds = new RadioButton[rgBottom.getChildCount()];
        for (int i = 0; i < rbChilds.length; i++) {
            rbChilds[i] = (RadioButton) rgBottom.getChildAt(i);
            rbChilds[i].setTag(i);
        }
        checkRadioButton(0);
    }

    private void checkRadioButton(int position) {
        for (int i = 0; i < rbChilds.length; i++) {
            if (i == position) {
                rbChilds[i].setChecked(true);
            } else {
                rbChilds[i].setChecked(false);
            }
        }
    }

    private void initListener() {
//        点击之后
        rgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbChilds.length; i++) {
                    if (rbChilds[i].getId() == checkedId) {
                        switchFragment(i);
//                        转换fragment
                    }
                }
            }
        });
    }

    private void switchFragment(int position) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragmentList.get(position);
        Fragment preFragment = fragmentList.get(preIndex);
        if (!fragment.isAdded()) {
            transaction.hide(preFragment).add(R.id.fl_main_content, fragment);
        } else {
            transaction.hide(preFragment).show(fragment);
        }
        preIndex = position;
        transaction.commit();
    }


    //    设置按两次返回键 退出的效果
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //        横竖屏切换的时候保护现场
    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        switchFragment(0);
        super.onRestoreInstanceState(savedInstanceState);
    }
}
