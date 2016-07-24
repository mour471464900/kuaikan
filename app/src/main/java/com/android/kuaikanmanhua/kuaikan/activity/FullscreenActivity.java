package com.android.kuaikanmanhua.kuaikan.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.FullFirstAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotContextBean;
import com.android.kuaikanmanhua.kuaikan.bean.FullWatchBean;
import com.android.kuaikanmanhua.kuaikan.custom.CustomListView;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 这个是全屏的 观看漫画的  主界面
 */
public class FullscreenActivity extends Activity implements View.OnClickListener {

    private ListView mContentView;
    private View mControlsView;

    private View myView;
    private int id;
//   这是我自身的view

    //    评论的集合
    private List<CommentHotContextBean.DataBean.CommentsBean>
            sBean;

    //    图片的地址的集合
    private List<String> images;
    private FullFirstAdapter fullFirstAdapter;
    private View header;
    private TextView authur_name;
    private ImageView icon_auther;
    private View footView;
    private TextView dianzhan;
    private TextView pinglun;
    private TextView next;
    private TextView pre;
    private FullWatchBean fullWatchBean;
    private ImageView foot_icon;
    private TextView foot_name;
    private View footView2;
    private CustomListView footListView;
    private ProgressDialog dialog;
    private TextView share;
    private View footView3;
    private TextView more;
    private TextView title;
    private TextView allComic;
    private SwipeRefreshLayout refresh_layout;
//      漫画的对象

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
//         sharesdk的初始化要在oncreate方法 里面
        ShareSDK.initSDK(FullscreenActivity.this);
//        刷新的页面

        //        设置listview
        setupListView();
        //       设值刷新
        setRefresh();

    }

    private void setRefresh() {
        refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                      下拉刷新重新加载数据
                OkHttpTool.newInstance().start(URLConstants.URL_FULL_WATCH + id).callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        fullWatchBean = gson.fromJson(result, FullWatchBean.class);
                        if (fullWatchBean != null && fullWatchBean.getData() != null) {
                            images.clear();
                            images.addAll(fullWatchBean.getData().getImages());
                            fullFirstAdapter.notifyDataSetChanged();
//                            加载完成就让进度条消失
                            refresh_layout.setRefreshing(false);
                        }
                    }
                });
            }
        });
    }

    private void setupListView() {
        initBundle();
//        初始化bundle
//    设置信息
//        initDialog();
        initData();
//        初始化数据
        initView();
//        初始化控件
        initAdapter();
//        初始化适配器
        bindAdapter();
//        绑定适配器

        initListener();
//        初始化监听
        //        加载头部和底部视图
        bindHeardFootView();
//        刷新页面控件

    }



    private void bindHeardFootView() {
        mContentView.addHeaderView(header);
        mContentView.addFooterView(footView);//第一个底部
        mContentView.addFooterView(footView2);//加载第二个底部
        mContentView.addFooterView(footView3);  // 加载第三个底部
    }

    private void initListener() {
        // 当点击那个就执行隐藏或者 收起
        mContentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void bindAdapter() {
        mContentView.setAdapter(fullFirstAdapter);
    }

    private void initAdapter() {
        fullFirstAdapter = new FullFirstAdapter(this,
                R.layout.full_item_image, images);

    }

    private void initView() {
        refresh_layout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        refresh_layout.setColorSchemeColors(Color.YELLOW);

        title = (TextView) findViewById(R.id.tv_check_all_title); //标题

        mControlsView = findViewById(R.id.fullscreen_content_controls);
//        这个是被隐藏的控件
        mContentView = (ListView) findViewById(R.id.fullscreen_content);
//        这个是被点击控件 ，view
//        自定义显示 和隐藏 布局
        myView = findViewById(R.id.info_Bar);

//         点击全集的text
        allComic = (TextView) findViewById(R.id.tv_check_all);
        //        初始化头部和尾的视图
        initHeardFootView();

    }

    //      初始化头部和底部
    private void initHeardFootView() {
//        头部布局
        header = LayoutInflater.from(this).inflate(R.layout.full_auther_heard, null);
//        头部的作者名
        authur_name = (TextView) header.findViewById(R.id.tv_name_auther);
//         头部的作者头像
        icon_auther = (ImageView) header.findViewById(R.id.iv_icon_auther);
//        第一个底部
        footView = LayoutInflater.from(this).inflate(R.layout.full_foot_item1, null);
        dianzhan = (TextView) footView.findViewById(R.id.tv_full_like);// 点赞的按钮
        pinglun = (TextView) footView.findViewById(R.id.tv_full_comment);// 评论的按钮
        pre = (TextView) footView.findViewById(R.id.tv_full_pre);// 上一篇的按钮
        next = (TextView) footView.findViewById(R.id.tv_full_next);// 下一篇的按钮
        foot_icon = (ImageView) footView.findViewById(R.id.iv_full_auther);// 底部的头像
//          更新头和底部
        foot_name = (TextView) footView.findViewById(R.id.tv_full_name);//底部的名字

        share = (TextView) footView.findViewById(R.id.tv_full_share);
//        分享的按键
//        最后一个头部
        footView2 = LayoutInflater.from(this).inflate(R.layout.full_foot_item2, null);
        footListView = (CustomListView) footView2.findViewById(R.id.lv_foot_item);
//        这是底部的评论的listview
//         z最底部的加载更多
        footView3 = LayoutInflater.from(this).inflate(R.layout.full_foot_item3, null);
        more = (TextView) footView3.findViewById(R.id.tv_more_comment);
//          下面的控件
    }

    private void setupHFUI() {
        Picasso.with(this).load(fullWatchBean.getData()
                .getTopic().getUser().getAvatar_url()).into(icon_auther);
        Picasso.with(this).load(fullWatchBean.getData()
                .getTopic().getUser().getAvatar_url()).into(foot_icon);
        authur_name.setText(fullWatchBean.getData().getTopic().getUser().getNickname());
        foot_name.setText(fullWatchBean.getData().getTopic().getUser().getNickname());
        dianzhan.setText("" + fullWatchBean.getData().getLikes_count());
        title.setText(fullWatchBean.getData().getTitle());
//          改变控件的属性
        pre.setOnClickListener(this);
        next.setOnClickListener(this);
        dianzhan.setOnClickListener(this);
        pinglun.setOnClickListener(this);
        icon_auther.setOnClickListener(this);
        foot_icon.setOnClickListener(this);
        share.setOnClickListener(this);
//        一键 分享的功能
        more.setOnClickListener(this);
        allComic.setOnClickListener(this);
    }

    //          通过网络请求得到图片的集合
    private void initData() {
        if (id != 0) {
            images = new ArrayList<>();
            OkHttpTool.newInstance().start(URLConstants.URL_FULL_WATCH + id).callback(new IOKCallBack() {
                @Override
                public void success(String result) {
                    Gson gson = new Gson();
                    fullWatchBean = gson.fromJson(result, FullWatchBean.class);
                    if (fullWatchBean != null && fullWatchBean.getData() != null) {
                        images.addAll(fullWatchBean.getData().getImages());
                        fullFirstAdapter.notifyDataSetChanged();
                        setupHFUI();
                    }
                }
            });
            setupFootListView();
        }
    }

    //    设置底部listview
    private void setupFootListView() {
//          更新评论页面
        sBean = new ArrayList<>();
        OkHttpTool.newInstance().start(URLConstants.URL_FULL_COMMENT_START + id + URLConstants.URL_FULL_COMMENT_END)
                .callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        CommentHotContextBean commentHotContextBean = gson.fromJson(result, CommentHotContextBean.class);
                        if (commentHotContextBean != null) {
                            sBean.addAll(commentHotContextBean.getData().getComments());
                            FootAdapter footAdapter = new FootAdapter();
                            footListView.setAdapter(footAdapter);
                            footAdapter.notifyDataSetChanged();

                        }
                    }
                });
    }

    //     得到
    private void initBundle() {
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", 0);//传入的是id值。14192
        }
    }

    //   这是将毫秒转换成日期的方法
    private String returnDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String now = sdf.format(new Date(time * 1000));
        return now;
    }

    //  上方  返回键
    public void backMain(View view) {
        finish();
    }

    //   点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//               上一篇
            case R.id.tv_full_pre:
                setupPreComic();
                break;
            case R.id.tv_full_next:
                setupNextComic();
                break;
            case R.id.tv_full_like:
                //需要登录
                setupLogin();
                break;
            case R.id.tv_full_comment:
                //需要登录
                setupLogin();
                break;
            case R.id.iv_icon_auther:
//                跳转作者
                setupZuozhe();
                break;
            case R.id.iv_full_auther:
//                跳转作者
                setupZuozhe();
                break;
            case R.id.tv_full_share:
//                跳转分享页面

                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle("快看漫画的分享");
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite(getString(R.string.app_name));
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");
// 启动分享GUI
                oks.show(FullscreenActivity.this);
                Toast.makeText(FullscreenActivity.this, "点击了分享按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_comment:
//                跳转跟多评论的界面
                setupMoreComment();
                break;
            case R.id.tv_check_all:
//               跳转全集的效果
                setupCheckAll();
                break;
        }
    }

    //       作品详情页面
    private void setupCheckAll() {
        Intent intent = new Intent(this, OpusActivity.class);
        intent.putExtra("id", fullWatchBean.getData().getTopic().getId());
        startActivity(intent);
        finish();
    }

    //    更多评论的对象
    private void setupMoreComment() {
        Intent intent = new Intent(this, MainReplyActivity.class);
        intent.putExtra("id", fullWatchBean.getData().getId());
        startActivity(intent);
    }

    //                跳转作者
    private void setupZuozhe() {
        int id = fullWatchBean.getData().getTopic().getUser().getId();
        Intent intent = new Intent(this, CommentIconActivity.class);
        intent.putExtra("bean", id);
        startActivity(intent);
    }

    //需要登录
    private void setupLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    //     下一篇漫画
    private void setupNextComic() {
        Intent intent = new Intent(this, FullscreenActivity.class);
        int next_comic_id = fullWatchBean.getData().getNext_comic_id();
        if (next_comic_id != 0) {
            intent.putExtra("id", (Integer) next_comic_id);
            startActivity(intent);
            finish();
//            杀死这个acitivity
        } else {
            Toast.makeText(this, "已经是最后一章", Toast.LENGTH_SHORT).show();
        }
    }

    //   上一篇漫画
    private void setupPreComic() {
        Intent intent = new Intent(this, FullscreenActivity.class);
        if (fullWatchBean.getData().getPrevious_comic_id() != 0) {
            intent.putExtra("id", (Integer) fullWatchBean.getData().getPrevious_comic_id());
            startActivity(intent);
            finish();
//            杀死这个acitivity
        } else {
            Toast.makeText(this, "只有一章", Toast.LENGTH_SHORT).show();
        }
    }

    //       ---------这是底部评论的适配器---------
    class FootAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return sBean == null ? 0 : sBean.size();
        }

        @Override
        public Object getItem(int position) {
            return sBean.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(FullscreenActivity.this).
                        inflate(R.layout.comment_context_list, null);
                viewHolder = new ViewHolder();
                viewHolder.iv_show = (CircleImageView) convertView.findViewById(R.id.iv_comment_hot_icon1);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.iv_comment_hot_name1);
                viewHolder.tv_context = (TextView) convertView.findViewById(R.id.tv_hot_text1);
                viewHolder.tv_data = (TextView) convertView.findViewById(R.id.tv_comment_hot_data1);
                viewHolder.like = (CheckedTextView) convertView.findViewById(R.id.tv_hot_likes_count1);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Picasso.with(FullscreenActivity.this).load(sBean.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
            viewHolder.tv_name.setText(sBean.get(position).getUser().getNickname());
            viewHolder.tv_context.setText(sBean.get(position).getContent());
            String Date = returnDate((sBean.get(position).getCreated_at()));
            viewHolder.tv_data.setText(Date);
            viewHolder.like.setText("" + sBean.get(position).getLikes_count());
            return convertView;
        }
    }

    class ViewHolder {
        CircleImageView iv_show;
        TextView tv_context;
        TextView tv_name;
        TextView tv_data;
        CheckedTextView like;
    }

}