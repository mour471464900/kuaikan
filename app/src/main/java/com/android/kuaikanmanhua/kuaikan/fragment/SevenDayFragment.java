package com.android.kuaikanmanhua.kuaikan.fragment;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.activity.CommentIconActivity;
import com.android.kuaikanmanhua.kuaikan.activity.FullscreenActivity;
import com.android.kuaikanmanhua.kuaikan.activity.MainReplyActivity;
import com.android.kuaikanmanhua.kuaikan.adapter.CommonAdapter;
import com.android.kuaikanmanhua.kuaikan.adapter.ViewHolderM;
import com.android.kuaikanmanhua.kuaikan.bean.SevenDayBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 这是显示页面开场，
 * 七天页面的fragment
 * ，今天，昨天，动态
 */
public class SevenDayFragment extends Fragment {
    private int id;
    //    通过id 来动态的获取 url
    private SevenDayBean sevenDayBean;
    //    sevenday的实体类
    private ProgressDialog dialog;

    private List<SevenDayBean.DataBean.ComicsBean> mList = new ArrayList<>();
    //    实现的实体类
    @BindView(R.id.pull_to_refresh_listview)
    PullToRefreshListView mListView;
    private SevenAdapter sevenAdapter;
    private View footView;
    private ListView refreshableView;
    private CheckBox dianzhan;
    private CheckBox pinlun;


    public static SevenDayFragment newInstance(Bundle args) {
        SevenDayFragment fragment = new SevenDayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getInt("id", 0);
        }
//        将外部导入的bundle 传入到此fragment中去
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seven_day, container, false);
        ButterKnife.bind(this, view);
        setupListView();
//        设置listview
        return view;
    }

    //
    private void setupListView() {
        refreshableView = mListView.getRefreshableView();
        initDialog();
//    出书啊弹窗
        initData();
//      初始化数据
        initAdapter();
//       初始化适配器
        bindAdapter();
//        绑定适配器
        initFootView();
//        给listview 加载底部
        initRefreshListener();
//        刷新的监听
        initClickListener();
//        点击监听
    }

    //     item 的点击监听
    private void initClickListener() {
        refreshableView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FullscreenActivity.class);
                intent.putExtra("id", mList.get(position - 1).getId());
                startActivity(intent);
//               这个要跳转到观看漫画的activity，是一个全屏的activity
            }
        });
    }

    private void initRefreshListener() {
//
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//                  下拉刷新
                OkHttpTool.newInstance().start(SevenDayUrl.DAY_START + id + SevenDayUrl.DAY_END).callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
//                加载界面的实体类
                        SevenDayBean sevenDayBean = gson.fromJson(result, SevenDayBean.class);
                        if (sevenDayBean != null && sevenDayBean.getData() != null) {
                            mList.clear();
                            //下拉的时候将数据清除掉
                            mList.addAll(sevenDayBean.getData().getComics());
//                            重新new 对象 让其获得新的加载数据
                            sevenAdapter.notifyDataSetChanged();
//                    异步加载数据，
                            dialog.dismiss();
//                   dialog消失
                        }
                        mListView.onRefreshComplete();
//                          刷新完成之后,listview就消失
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
            }
        });

    }

    private void initFootView() {
        footView = LayoutInflater.from(getActivity())
                .inflate(R.layout.item_foot_seven_listview, null);
        refreshableView.addFooterView(footView);
    }

    private void initDialog() {
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("客官请骚等");
    }

    private void bindAdapter() {
        refreshableView.setAdapter(sevenAdapter);
//        切记使用pulltoReFreshable的时候
//        绑定适配器的时候使用装换过来 listview

    }

    private void initAdapter() {
        sevenAdapter = new SevenAdapter(getActivity(),
                R.layout.item_seven_fragment_listview, mList);
    }

    private void initData() {
        dialog.show();
        OkHttpTool.newInstance().start(SevenDayUrl.DAY_START + id + SevenDayUrl.DAY_END).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
//                加载界面的实体类
                sevenDayBean = gson.fromJson(result, SevenDayBean.class);
                if (sevenDayBean != null && sevenDayBean.getData() != null) {
                    mList.addAll(sevenDayBean.getData().getComics());
                    sevenAdapter.notifyDataSetChanged();
//                    适配器刷新
//                    异步加载数据，
                    dialog.dismiss();
//                   dialog消失
                }
            }
        });
    }


    class SevenAdapter extends CommonAdapter<SevenDayBean.DataBean.ComicsBean> {
        private Context context;
        private int layoutId;
        private List<SevenDayBean.DataBean.ComicsBean> list;

        public SevenAdapter(Context context, int layoutId, List<SevenDayBean.DataBean.ComicsBean> list) {
            super(context, layoutId, list);
            this.layoutId = layoutId;
            this.context = context;
            this.list = list;
        }

        /**
         * 这个适配器里面改变了控件
         **/
        @TargetApi(Build.VERSION_CODES.M)
        @Override
        public void convert(ViewHolderM holderM, final SevenDayBean.DataBean.ComicsBean bean) {
            TextView lable = (TextView) holderM.getView(R.id.tv_seven_lable);
            TextView top_title = (TextView) holderM.getView(R.id.tv_seven_top_title);
            TextView top_avatar = (TextView) holderM.getView(R.id.tv_seven_top_avatar);
            TextView bottom_title = (TextView) holderM.getView(R.id.tv_seven_bottom_title);
            dianzhan = (CheckBox) holderM.getView(R.id.tv_seven_dianzhan);
            pinlun = (CheckBox) holderM.getView(R.id.tv_seven_pinlun);
            ImageView cover = (ImageView) holderM.getView(R.id.iv_seven_cover);
//            改变Ui控件
//            --------------------
            lable.setText(bean.getLabel_text()); // 改变文字
//            lable.setBackgroundColor(Color.parseColor(bean.getLabel_color()));
//             改变颜色
            Drawable background = lable.getBackground();
//bean.getLabel_color()这是一个十六进制的颜色配置    "label_color":"#fa6499",
            background.setColorFilter(Color.parseColor(bean.getLabel_color()), PorterDuff.Mode.SRC);
            //这个是颜色过滤器，来改变drawable 的颜色
            top_title.setText(bean.getTopic().getTitle());
            top_avatar.setText(bean.getTopic().getUser().getNickname());
            bottom_title.setText(bean.getTitle());
            dianzhan.setText("" + bean.getLikes_count());
            pinlun.setText("" + bean.getComments_count());
            Picasso.with(getActivity()).load(bean.getCover_image_url())
                    .placeholder(R.drawable.ic_common_placeholder_l).into(cover);
//              设置设
//            改变控件
//            ----------作者的点击---------
            top_avatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getActivity(),CommentIconActivity.class);
                    intent.putExtra("bean",bean.getTopic().getUser().getId());
                    startActivity(intent);
                }
            });
//            ------点赞按钮的点击--------
            dianzhan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    AnimationSet animationSet=new AnimationSet(true);
                     if(isChecked){
                         dianzhan.setText("" + (bean.getLikes_count() + 1));// 当选中时点赞+1
                         dianzhan.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.cb_anim));
                     }else {
                         dianzhan.setText("" + bean.getLikes_count());// 点赞取消就 回复原样
                     }
                }
            });


//              点击评论 跳转更多的评论
            pinlun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Intent intent =new Intent(getActivity(),MainReplyActivity.class);
                    intent.putExtra("id",bean.getId());
                    startActivity(intent);
                }
            });
        }
    }

}
