package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.Advert;
import com.android.kuaikanmanhua.kuaikan.util.HttpUtil;
import com.android.kuaikanmanhua.kuaikan.util.IRequestCallBack;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/7/13.
 */
public class ProHotFragment extends Fragment{

    @BindView(R.id.scrollview_prohot)
    PullToRefreshScrollView mScrollView;


    private List<Advert.DataBean.BannerGroupBean> banner;
    private ArrayList<String> adUrls;
    private View bannerView;
    private ConvenientBanner convenientBanner;


    private ScrollView refreshableView;

    public static ProHotFragment newInstance(Bundle args){
        ProHotFragment fragment=new ProHotFragment();
        fragment.setArguments(args);
        return  fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_pro_hot,container,false);
        ButterKnife.bind(this,view);

        refreshableView=mScrollView.getRefreshableView();
        //广告视图
        bannerView=inflater.inflate(R.layout.listview_prohot_banner,null);
        convenientBanner= (ConvenientBanner) bannerView.findViewById(R.id.cb_prohot_banner);



        initScrollView();

        refreshableView.addView(bannerView);



        return view;
    }

    private void initScrollView() {
        //加载广告
        initAdvert();


    }



    //----------加载广告------------
    private void initAdvert() {
        adUrls = new ArrayList<>();
        banner = new ArrayList<>();
        HttpUtil.requestGet(URLConstants.URL_BANNER, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Advert advert=gson.fromJson(result,Advert.class);
                Advert.DataBean dataBean=advert.getData();
                banner.addAll(dataBean.getBanner_group());
                for (int i = 0; i <banner.size() ; i++) {
                    adUrls.add(banner.get(i).getPic());
                }
                setUpConvenientBanner();
            }
        });
    }

    private void setUpConvenientBanner() {
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        },adUrls)
                .setPointViewVisible(true)  //设置指示器可见
                .setPageIndicator(new int[]{R.drawable.tag_off,
                        R.drawable.tag_on}) //设置指示器圆点
                .startTurning(5000) //设置自动切换的时间间隔
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);//设置指示器的位置
    }

    public class NetworkImageHolderView implements Holder<String>{
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView=new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Picasso.with(getActivity()).load(data).into(imageView);
        }
    }

}
