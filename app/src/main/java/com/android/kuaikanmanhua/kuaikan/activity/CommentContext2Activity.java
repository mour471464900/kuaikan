package com.android.kuaikanmanhua.kuaikan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.HotGridViewAdapter;


import com.android.kuaikanmanhua.kuaikan.bean.CommentZUIXINContentBean;
import com.android.kuaikanmanhua.kuaikan.bean.CommentZuiXinBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.custom.CustomGridView;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MBENBEN on 2016/7/20.
 */
public class CommentContext2Activity extends AppCompatActivity {
    @BindView(R.id.lv_comment_hot_context_listview)
    ListView mlistview;
    List<CommentZUIXINContentBean.DataBean.CommentsBean> sBean=new ArrayList<>();
    private CommentZuiXinBean.DataBean.FeedsBean feedBean;
    private MyAdapter myAdapter;
    private View header;
    private CircleImageView iv_show;
    private TextView tv_name;
    private TextView tv_context;
    private CustomGridView gv_picture;
    private TextView tv_data;
    private TextView likes_count;
    private TextView comments_count;
    private HotGridViewAdapter gridViewAdapter;
    private View tail;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment_context);
        ButterKnife.bind(this);
        header= LayoutInflater.from(CommentContext2Activity.this).inflate(R.layout.comment_context_list_header,null);
        mlistview.addHeaderView(header);
        tail=LayoutInflater.from(CommentContext2Activity.this).inflate(R.layout.comment_context_list_tail,null);
        mlistview.addFooterView(tail);
        initBean();
        initData();
        setAdapter();
        bindAdapter();
        initHeader();
        initListen();
    }

        private void initListen() {

                tv= (TextView) findViewById(R.id.tv_gengduo);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(CommentContext2Activity.this,CommentReplyActivity.class);
//        调到回复ACtivity
                        intent.putExtra("id",feedBean.getFeed_id());
                        startActivity(intent);
                    }
                });

    }

    private void initHeader() {
        iv_show = (CircleImageView)header. findViewById(R.id.iv_comment_hot_icon2);
        tv_name = (TextView)header. findViewById(R.id.iv_comment_hot_name2);
        tv_context = (TextView)header. findViewById(R.id.tv_hot_text2);
        gv_picture = (CustomGridView) header.findViewById(R.id.gv_hot_picture);
        tv_data = (TextView)header. findViewById(R.id.tv_hot_data2);
        likes_count = (TextView)header. findViewById(R.id.tv_hot_likes_count2);
        comments_count = (TextView) header.findViewById(R.id.tv_hot_comments_count2);

        Picasso.with(CommentContext2Activity.this).load(feedBean.getUser().getAvatar_url()).into(iv_show);
        tv_name.setText(feedBean.getUser().getNickname());
        tv_context.setText(feedBean.getContent().getText());
        String Date = returnDate((feedBean.getUpdated_at())/1000);
        tv_data.setText(Date);
        likes_count.setText("" + feedBean.getLikes_count());
        comments_count.setText("" + feedBean.getComments_count());
        List<String> list = new ArrayList<>();
        list.addAll(feedBean.getContent().getImages());
        int layoutId = 0;
        if(list.size()==1){
            gv_picture.setNumColumns(1);
            layoutId = R.layout.comment_hot_fragment_gridview2;
        }else {
            gv_picture.setNumColumns(3);
            layoutId = R.layout.comment_hot_fragment_gridview;
        }
        gridViewAdapter = new HotGridViewAdapter(CommentContext2Activity.this, layoutId, list);
        gv_picture.setAdapter(gridViewAdapter);
        gridViewAdapter.notifyDataSetChanged();
    }

    private void bindAdapter() {
        mlistview.setAdapter(myAdapter);
    }

    private void setAdapter() {
        myAdapter=new MyAdapter();
    }

    //得到外界传入的对象
    private void initBean() {
        Intent intent=getIntent();
        if(intent!=null){
            feedBean= (CommentZuiXinBean.DataBean.FeedsBean) intent.getSerializableExtra("bean");

        }
    }

    private void initData() {
        OkHttpTool.newInstance().start(SevenDayUrl.ZUIXIN_CONTENT_START+feedBean.getFeed_id()+SevenDayUrl.ZUIXIN_CONTENT_END).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                CommentZUIXINContentBean ContextBean=gson.fromJson(result,CommentZUIXINContentBean.class);

                sBean.addAll(ContextBean.getData().getComments());
                myAdapter.notifyDataSetChanged();
            }
        });
    }
    //   这是将毫秒转换成日期的方法
    private String returnDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String now = sdf.format(new Date(time*1000));
        return now;
    }



    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return sBean==null?0:sBean.size();
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
                convertView = LayoutInflater.from(CommentContext2Activity.this).
                        inflate(R.layout.comment_context_list, null);
                viewHolder = new ViewHolder();
                viewHolder.iv_show = (CircleImageView) convertView.findViewById(R.id.iv_comment_hot_icon1);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.iv_comment_hot_name1);
                viewHolder.tv_context = (TextView) convertView.findViewById(R.id.tv_hot_text1);

                viewHolder.tv_data = (TextView) convertView.findViewById(R.id.tv_comment_hot_data1);


                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();

            }
            Picasso.with(CommentContext2Activity.this).load(sBean.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
            viewHolder.tv_name.setText(sBean.get(position).getUser().getNickname());
            viewHolder.tv_context.setText(sBean.get(position).getContent());

            String Date = returnDate((sBean.get(position).getCreated_at()));
            viewHolder.tv_data.setText(Date);


            return convertView;
        }
    }
    class ViewHolder{
        CircleImageView iv_show;
        TextView tv_context;
        TextView tv_name;
        TextView tv_data;
    }
    //  返回
    public void onBack(View view) {
        finish();
    }
}
