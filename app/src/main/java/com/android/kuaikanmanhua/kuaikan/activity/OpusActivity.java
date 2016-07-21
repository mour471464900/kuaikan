package com.android.kuaikanmanhua.kuaikan.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.OpusBeanAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.OpusBean;
import com.android.kuaikanmanhua.kuaikan.custom.CustomListView;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.google.gson.Gson;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//   这是作品详情页面
//    上面是一个背景图和上下伸缩的内容
public class OpusActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomListView listView;
    private View headView;
    private int id;
    private ProgressDialog dialog;
    private List<OpusBean.DataBean.ComicsBean> mList;
    private OpusBeanAdapter opusBeanAdapter;

    @BindView(R.id.tv_opus_title)
    TextView tv_opus_title;  // 标题
    @BindView(R.id.tv_opus_fav)
    TextView tv_opus_fav;     //关注
    @BindView(R.id.tv_opus_comment)
    TextView tv_opus_comment;   //  评论
    @BindView(R.id.tv_opus_like)
    TextView tv_opus_like;   //  点赞
    @BindView(R.id.lv_cover)
    ImageView iv_cover;   //  点赞
    private OpusBean opusBean;
    private TextView tv_array;

    //   条目的集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opus);
//         绑定黄油刀
        ButterKnife.bind(this);

//       获取id
        initBean();
//       设置listview
        initListView();

    }

    private void initListView() {
        listView = (CustomListView) findViewById(R.id.lv_main);
        headView = LayoutInflater.from(this).inflate(R.layout.item_opus_lv_head, null);
        listView.addHeaderView(headView);
//        倒序按钮
        tv_array =(TextView) headView.findViewById(R.id.tv_array_to);
        tv_array.setOnClickListener(this);
//    设置信信息
        initDialog();
        //        初始化数据
        initData();
        //        初始化适配器
        initAdapter();
//        绑定适配器
        bindAdapter();
//        初始化监听
        initListener();
    }

    private void setupUI() {
        tv_opus_comment.setText("" + (opusBean.getData().getComments_count() / 10000) + "万");
        tv_opus_fav.setText((opusBean.getData().getFav_count() / 10000) + "万人关注");
        tv_opus_title.setText(opusBean.getData().getTitle());
        tv_opus_like.setText((opusBean.getData().getLikes_count() / 10000) + "万");
        Picasso.with(this)
                .load(opusBean.getData().getCover_image_url())
                .config(Bitmap.Config.RGB_565)//
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//放弃内存缓存，直接存到磁盘中去
                .placeholder(R.drawable.ic_common_placeholder_l)  //设置占位图 这样可以让
                // ，有很多图片的请求
                .into(iv_cover)
        ;
    }

    private void initListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OpusActivity.this, FullscreenActivity.class);
                intent.putExtra("id", mList.get(position-1).getId());
//                 将comic_id传入到 看漫画的页面中去
                startActivity(intent);
                finish();
            }
        });
    }

    private void bindAdapter() {
        listView.setAdapter(opusBeanAdapter);
    }

    private void initAdapter() {
        opusBeanAdapter = new OpusBeanAdapter(this, R.layout.item_lv_opus, mList);
    }

    private void initData() {
        dialog.show();
        mList = new ArrayList<>();
        if (id != 0) {
            OkHttpTool.newInstance().start(URLConstants.URL_OPUS_START + id + URLConstants.URL_OPUS_END).callback(new IOKCallBack() {
                @Override
                public void success(String result) {
                    Gson gson = new Gson();
                    opusBean = gson.fromJson(result, OpusBean.class);
                    mList.addAll(opusBean.getData().getComics());
//                    适配器刷新
                    opusBeanAdapter.notifyDataSetChanged();
                    dialog.dismiss();
//                       更新UI
                    setupUI();
                }
            });
        }
    }

    private void initDialog() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("客官请骚等");
    }

    private void initBean() {
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", 0);
//            得到的i
        }
    }

    //     返回键的设置
    public void Click(View view) {
        finish();
    }

//     点击之后  条目的顺序改变
    @Override
    public void onClick(View v) {
//        倒序集合
        Collections.reverse(mList);
//         适配器刷新
        opusBeanAdapter.notifyDataSetChanged();
    }
}
