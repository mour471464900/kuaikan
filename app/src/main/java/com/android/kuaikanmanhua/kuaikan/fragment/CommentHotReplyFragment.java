package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotContextBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
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
 * Created by MBENBEN on 2016/7/15.
 * 这是评论热门回复界面
 */

public class CommentHotReplyFragment extends Fragment{

    List<CommentHotContextBean.DataBean.CommentsBean> sBean=new ArrayList<>();
    private MyAdapter myAdapter;
    @BindView(R.id.lv_comment_hot_reply)
    ListView mlistview;
    private long feedId;

    public static CommentHotReplyFragment newInstance(Bundle args) {
        CommentHotReplyFragment fragment = new CommentHotReplyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if ( bundle!=null) {
            feedId =  bundle.getLong("feedId");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

             View view=   inflater.inflate(R.layout.fragment_comment_hot_reply, container, false);
        ButterKnife.bind(this,view);
          initData();
        setAdapter();
        bindAdapter();
        return  view;
    }
    private void bindAdapter() {
        mlistview.setAdapter(myAdapter);
    }

    private void setAdapter() {
        myAdapter=new MyAdapter();
    }

    private void initData() {

        OkHttpTool.newInstance().start(SevenDayUrl.COMMENT_START_HOT_CONTEXT+feedId+SevenDayUrl.COMMENT_END_HOT_CONTEXT).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                CommentHotContextBean ContextBean=gson.fromJson(result,CommentHotContextBean.class);

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
                convertView = LayoutInflater.from(getActivity()).
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
            Picasso.with(getActivity()).load(sBean.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
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
}
