package com.android.kuaikanmanhua.kuaikan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by hao on 2016/7/4.
 * 这是标配七天的Fragment
 */
public class UpdatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
//    fragment的集合
    private List<String> titles;
//     标题的集合
    public UpdatePagerAdapter(FragmentManager fm, List<Fragment> fragmentList,
                              List<String> titles    ) {
        super(fm);
        this.fragmentList=fragmentList;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList==null ? 0 :fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  titles.get(position);
    }
}
