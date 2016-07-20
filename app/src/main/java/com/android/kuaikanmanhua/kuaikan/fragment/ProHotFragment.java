package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.activity.ClassifyInfoActivity;
import com.android.kuaikanmanhua.kuaikan.activity.FullscreenActivity;
import com.android.kuaikanmanhua.kuaikan.activity.OpusActivity;
import com.android.kuaikanmanhua.kuaikan.activity.ProHotArrayActivity;
import com.android.kuaikanmanhua.kuaikan.adapter.Group1Adapter;
import com.android.kuaikanmanhua.kuaikan.adapter.Group3Adapter;
import com.android.kuaikanmanhua.kuaikan.adapter.Group5Adapter;
import com.android.kuaikanmanhua.kuaikan.bean.Advert;
import com.android.kuaikanmanhua.kuaikan.bean.ExceptAdvert;
import com.android.kuaikanmanhua.kuaikan.bean.HelpBean;
import com.android.kuaikanmanhua.kuaikan.util.HttpUtil;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.IRequestCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProHotFragment extends Fragment {

    private List<Advert.DataBean.BannerGroupBean> banner;
    private ArrayList<String> adUrls;
    private Advert advert;

    private List<ExceptAdvert.DataBean.InfosBean.TopicsBean> mGroup1List;
    private List<ExceptAdvert.DataBean.InfosBean.TopicsBean> mGroup4List;
    private ConvenientBanner convenientBanner;
    private GridView gridView1;
    private ExceptAdvert group1;
    private Group1Adapter group1Adapter;
    private GridView gridView4;
    private ExceptAdvert group4;
    private Group1Adapter group4Adapter;
    private List<ExceptAdvert.DataBean.InfosBean.BannersBean> mGroup5List;
    private ExceptAdvert group5;
    private Group5Adapter group5Adapter;
    private Group3Adapter group3Adapter;
    private GridView gridView5;
    private GridView gridView3;
    private List<ExceptAdvert.DataBean.InfosBean.TopicsBean> mGroup3List;
    private ExceptAdvert group3;
    private RecyclerView recycleView;
    private List<ExceptAdvert.DataBean.InfosBean.TopicsBean> mGroup2List;
    private ExceptAdvert group2;
    private RecycleAdapter recycleAdapter;
    private ImageView array1;
    private ImageView array2;
    private ImageView array3;
    private ExceptAdvert exceptAdvert;

    public static ProHotFragment newInstance(Bundle args) {
        ProHotFragment fragment = new ProHotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pro_hot, container, false);
        //广告试图
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.cb_prohot_banner);
        //第一组图片
        gridView1 = (GridView) view.findViewById(R.id.gridview_group1);
        //第二组图片
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView_group2);
        //第三组图片
        gridView3 = (GridView) view.findViewById(R.id.gridview_group3);
        //第四组图片
        gridView4 = (GridView) view.findViewById(R.id.gridview_group4);
        //第五组图片
        gridView5 = (GridView) view.findViewById(R.id.gridview_group5);
        //几个箭头
        array1 = (ImageView) view.findViewById(R.id.array1);
        array2 = (ImageView) view.findViewById(R.id.array2);
        array3 = (ImageView) view.findViewById(R.id.array3);

        initGroups();
        initArrayListener();
        return view;
    }

    private void initArrayListener() {
        array1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpBean bean =new HelpBean(4,"人气飙升");
                Intent intent = click(bean);
                startActivity(intent);
            }
        });
        array2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpBean bean =new HelpBean(5,"新作出炉");
                Intent intent = click(bean);
                startActivity(intent);
            }
        });
        array3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpBean bean =new HelpBean(3,"主编推荐");
                Intent intent = click(bean);
                startActivity(intent);
            }
        });
    }

    public Intent  click(HelpBean bean){
        Intent intent=new Intent(getActivity(),ProHotArrayActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("bean",bean);
        intent.putExtra("bean",bundle);
        return  intent;
    }


    private void initGroups() {
        initBanner();
        initGroup1();
        initGroup2();
        initGroup3();
        initGroup4();
        initGroup5();

    }


    //--------------------------------------加载广告------------------------------------------
//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private void initBanner() {
        initAdvert();
        initBannerListener();
    }
    //广告的监听
    private void initBannerListener() {
        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int type=advert.getData().getBanner_group().get(position).getType();
                String value = advert.getData().getBanner_group().get(position).getValue();
                switch (type){
                    case 1:
                        break;
                    case 2:
                        Intent intent=new Intent(getActivity(),OpusActivity.class);

                        intent.putExtra("id",  Integer .valueOf(value));
                        startActivity(intent);
                        break;
                    case 3:
                        Intent intent2=new Intent(getActivity(),FullscreenActivity.class);
                        intent2.putExtra("id",Integer .valueOf(value));
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
    private void initAdvert() {
        adUrls = new ArrayList<>();
        banner = new ArrayList<>();
        HttpUtil.requestGet(URLConstants.URL_BANNER, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                advert = gson.fromJson(result, Advert.class);
                if (advert != null && advert.getData() != null) {
                    Advert.DataBean dataBean = advert.getData();
                    banner.addAll(dataBean.getBanner_group());
                    for (int i = 0; i < banner.size(); i++) {
                        adUrls.add(banner.get(i).getPic());
                    }
                    setUpConvenientBanner();
                }
            }
        });
    }

    private void setUpConvenientBanner() {
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, adUrls)
                .setPointViewVisible(true)  //设置指示器可见
                .setPageIndicator(new int[]{R.drawable.tag_off,
                        R.drawable.tag_on}) //设置指示器圆点
                .startTurning(3000) //设置自动切换的时间间隔
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);//设置指示器的位置
    }

    public class NetworkImageHolderView implements Holder<String> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Picasso.with(getActivity()).load(data).into(imageView);
        }
    }

//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//---------------------------------广告部分-----------------------------------------------

    //-----------------------------第一组图片Group1-------------------------------------------
    private void initGroup1() {
        initData();
        initAdapter();
        bindAdapter();
        initListener();
    }

    //第一组图片的监听
    private void initListener() {
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), OpusActivity.class);
                intent.putExtra("id", mGroup1List.get(position).getId());
                startActivity(intent);
            }
        });
    }

    private void bindAdapter() {
        gridView1.setAdapter(group1Adapter);
    }

    private void initAdapter() {
        group1Adapter = new Group1Adapter(getActivity(), R.layout.group1_item, mGroup1List);
    }

    private void initData() {
        mGroup1List = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.URL_OTHER).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                group1 = gson.fromJson(result, ExceptAdvert.class);
                if (group1 != null && group1.getData() != null) {
                    List<ExceptAdvert.DataBean.InfosBean.TopicsBean> topicsBeanList =
                            group1.getData().getInfos().get(0).getTopics();

                    for (int i = 0; i < 3; i++) {
                        mGroup1List.add(topicsBeanList.get(i));
                    }
                    group1Adapter.notifyDataSetChanged();
                }

            }
        });
    }
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//-----------------------------第一组图片Group1--------------------------------------------


    //-----------------------------第二组图片Group2---------------------------------------------
//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private void initGroup2() {
        initData2();
        initAdapter2();
        bindAdapter2();
        initListener2();
    }

    private void initListener2() {

    }

    private void bindAdapter2() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3,
                LinearLayoutManager.HORIZONTAL, false);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(recycleAdapter);
    }

    private void initAdapter2() {
        recycleAdapter = new RecycleAdapter(mGroup2List, getActivity());
    }

    private void initData2() {
        mGroup2List = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.URL_OTHER).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                group2 = gson.fromJson(result, ExceptAdvert.class);
                if (group2 != null && group2.getData() != null) {
                    List<ExceptAdvert.DataBean.InfosBean.TopicsBean> topicsBeanList2 =
                            group2.getData().getInfos().get(1).getTopics();
                    for (int i = 0; i < topicsBeanList2.size(); i++) {
                        mGroup2List.add(topicsBeanList2.get(i));
                    }
                    recycleAdapter.notifyDataSetChanged();
                }

            }
        });
    }

//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//-----------------------------第二组图片Group2--------------------------------------------


    //-----------------------------第三组图片Group3---------------------------------------------
//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private void initGroup3() {
        initData3();
        initAdapter3();
        bindAdapter3();
        initListener3();
    }

    private void initListener3() {
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), OpusActivity.class);
                intent.putExtra("id", mGroup3List.get(position).getId());
                startActivity(intent);
            }
        });
    }

    private void bindAdapter3() {
        gridView3.setAdapter(group3Adapter);
    }

    private void initAdapter3() {
        group3Adapter = new Group3Adapter(getActivity(), R.layout.group3_item, mGroup3List);
    }

    private void initData3() {
        mGroup3List = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.URL_OTHER).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                group3 = gson.fromJson(result, ExceptAdvert.class);
                if (group3 != null && group3.getData() != null) {
                    List<ExceptAdvert.DataBean.InfosBean.TopicsBean> topicsBeanList3 =
                            group3.getData().getInfos().get(2).getTopics();
                    for (int i = 0; i < 2; i++) {
                        mGroup3List.add(topicsBeanList3.get(i));
                    }
                    group3Adapter.notifyDataSetChanged();
                }

            }
        });
    }
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//-----------------------------第二组图片Group3--------------------------------------------


    //-----------------------------第四组图片Group4---------------------------------------------
//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private void initGroup4() {
        initData4();
        initAdapter4();
        bindAdapter4();
        initListener4();
    }


    private void initListener4() {
        gridView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), OpusActivity.class);
                intent.putExtra("id", mGroup4List.get(position).getId());
                startActivity(intent);
            }
        });
    }

    private void initAdapter4() {
        group4Adapter = new Group1Adapter(getActivity(), R.layout.group1_item, mGroup4List);
    }

    private void bindAdapter4() {
        gridView4.setAdapter(group4Adapter);
    }

    private void initData4() {
        mGroup4List = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.URL_OTHER).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                group4 = gson.fromJson(result, ExceptAdvert.class);
                if (group4 != null && group4.getData() != null) {
                    List<ExceptAdvert.DataBean.InfosBean.TopicsBean> topicsBeanList4 =
                            group4.getData().getInfos().get(3).getTopics();



                    for (int i = 0; i < 6; i++) {
                        mGroup4List.add(topicsBeanList4.get(i));
                    }
                    group4Adapter.notifyDataSetChanged();
                }

            }
        });
    }
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//-----------------------------第四组图片Group4--------------------------------------------


    //-----------------------------第五组图片Group5---------------------------------------------
//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private void initGroup5() {
        initData5();
        initAdapter5();
        bindAdapter5();
        initListener5();
    }

    private void initListener5() {
        gridView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FullscreenActivity.class);
                intent.putExtra("id", mGroup5List.get(position).getTarget_id());
                startActivity(intent);
            }
        });
    }

    private void bindAdapter5() {
        gridView5.setAdapter(group5Adapter);
    }

    private void initAdapter5() {
        group5Adapter = new Group5Adapter(getActivity(), R.layout.group5_item, mGroup5List);
    }

    private void initData5() {
        mGroup5List = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.URL_OTHER).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                group5 = gson.fromJson(result, ExceptAdvert.class);
                if (group5 != null && group5.getData() != null) {
                    List<ExceptAdvert.DataBean.InfosBean.BannersBean> bannersBean =
                            group5.getData().getInfos().get(4).getBanners();

                    for (int i = 0; i < 2; i++) {
                        mGroup5List.add(bannersBean.get(i));
                    }
                    group5Adapter.notifyDataSetChanged();
                }

            }
        });
    }
//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//---------------------------------------------------------------------------------------

    //------------recyler view  适配器

    class RecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<ExceptAdvert.DataBean.InfosBean.TopicsBean> list;
        private Context context;

        public RecycleAdapter(List<ExceptAdvert.DataBean.InfosBean.TopicsBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).
                    inflate(R.layout.group2_item, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Picasso.with(context).load(list.get(position).getCover_image_url()).into(holder.iv_icon);
            holder.tv_title.setText(list.get(position).getTitle());
            holder.tv_author.setText(list.get(position).getUser().getNickname());
            holder.iv_icon.setTag(position);
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        final ImageView iv_icon;
        final TextView tv_title;
        final TextView tv_author;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_group2_item);
            tv_title = (TextView) itemView.findViewById(R.id.tv_group2_title);
            tv_author = (TextView) itemView.findViewById(R.id.tv_group2_author);
            iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        int position = Integer.parseInt(iv_icon.getTag().toString());
                        Intent intent = new Intent(getActivity(), OpusActivity.class);
                        intent.putExtra("id", mGroup2List.get(position).getId());
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        //  数字 转换异常
                        e.printStackTrace();
                    }
                }
            });
        }
    }}
