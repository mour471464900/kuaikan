package com.android.kuaikanmanhua.kuaikan.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.UpdatePagerAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是主页里面 更新的fragment
 */
public class MainUpdateFragment extends Fragment {

    private int  [] urlNum = {
            1467993600, 1467907200, 1467820800, 1467734400, 1467648000,   1,    0
//           ，动态1      ,动态2,         动态3,       动态4,      动态5    ，昨天   今天
    };

    private  String nowData(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String now=sdf.format(new Date());
         return  now;
    }


//    周一到  周日  让 title 显示不同天数的数组
    private String[] day1={"周二","周三","周四","周五","周六","昨天","今天"};
    private String[] day2={"周三","周四","周五","周六","周日","昨天","今天"};
    private String[] day3={"周四","周五","周六","周日","周一","昨天","今天"};
    private String[] day4={"周五","周六","周日","周一","周二","昨天","今天"};
    private String[] day5={"周六","周日","周一","周二","周三","昨天","今天"};
    private String[] day6={"周日","周一","周二","周三","周四","昨天","今天"};
    private String[] day7={"周一","周二","周三","周四","周五","昨天","今天"};
//-------------------------------------
    @BindView(R.id.tab_update)
    TabLayout mTab;
    @BindView(R.id.vp_update)
    ViewPager mViewPager;

    private List<Fragment> fragmentList = new ArrayList<>();
//    fragment 的集合
    private List<String> titleList = new ArrayList<>();
    private UpdatePagerAdapter updatePagerAdapter;

    //    标题的集合
    public static MainUpdateFragment newInstance(Bundle args) {
        MainUpdateFragment fragment = new MainUpdateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_updata, container, false);
        ButterKnife.bind(this,view);
        setupViewPager();
//        设置viewPager
        return view;
    }

    private void setupViewPager() {
        initData();
//      初始化数据
        initTableList();
//       初始化tableLayout的上方的文字
        initAdapter();
//       初始化适配器
        bindAdapter();
//        判定适配器

    }

    private void initTableList() {
        for (int i = 0; i < titleList.size(); i++) {
            //创建Tab:mTabLayout.newTab()
            //设置Tab内容:tab.setText(内容);
            mTab.addTab(mTab.newTab().setText(titleList.get(i)));
        }
    }

    private void bindAdapter() {
        mViewPager.setAdapter(updatePagerAdapter);
//        设置tablayout 到最后一个位置
        mTab.setupWithViewPager(mViewPager);
//        将viewpager关联起来
        mViewPager.setCurrentItem(urlNum.length);
//        设置viewpager的设置选中项
//        刚进入的设置到 tab 到:今天，
    }

    private void initAdapter() {
        updatePagerAdapter = new UpdatePagerAdapter
                (getChildFragmentManager(),fragmentList,titleList);
    }

    private void initData() {
        fragmentList=initFragment();
//        设置fragment
        titleList=initTitle();
//        设置标题的集合
    }

//       返回标题的集合
    private List<String> initTitle() {
        SimpleDateFormat myFmt=new SimpleDateFormat("E", Locale.CHINESE);
        Date date=new Date();
        String now = myFmt.format(date);
//        匹配今天是星期几，然后动态加入星期几
//        有的机型是周几 ，三星的机型是星期几
        List<String> mList=new ArrayList<>();
        switch (now){
            case "星期一":
                mList.addAll(getDay(day1));
            break;
            case "星期二":
                mList.addAll(getDay(day2));
                break;
            case "星期三":
                mList.addAll(getDay(day3));
                break;
            case "星期四":
                mList.addAll(getDay(day4));
                break;
            case "星期五":
                mList.addAll(getDay(day5));
                break;
            case "星期六":
                mList.addAll(getDay(day6));
                break;
            case "星期日":
                mList.addAll(getDay(day7));
                break;
//            此处应该动态用英文来判断
            case "周一":
                mList.addAll(getDay(day1));
                break;
            case "周二":
                mList.addAll(getDay(day2));
                break;
            case "周三":
                mList.addAll(getDay(day3));
                break;
            case "周四":
                mList.addAll(getDay(day4));
                break;
            case "周五":
                mList.addAll(getDay(day5));
                break;
            case "周六":
                mList.addAll(getDay(day6));
                break;
            case "周日":
                mList.addAll(getDay(day7));
                break;
//
        }
        return mList;
    }

//     动态将数组加入title里面去
    private ArrayList< String> getDay(String [] days) {
        ArrayList< String> dlist=new ArrayList<>();
        for (int i = 0; i <days.length ; i++) {
            dlist.add(days[i]);
        }
        return dlist;
    }

    //    将id 动态的传到每个fragment里面去然后动态的取id
    private List<Fragment> initFragment() {
        List<Fragment> mList=new ArrayList<>();
        for (int i = 0; i <urlNum.length ; i++) {
            Bundle bundle=new Bundle();
            bundle.putInt("id",urlNum[i]);
            Fragment fragment=NewSevenFragment.newInstance(bundle);
            mList.add(fragment);
        }
        return mList;
    }
}
