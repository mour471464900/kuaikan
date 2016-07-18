package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import android.widget.ListView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.activity.CommentContextActivity;

import com.android.kuaikanmanhua.kuaikan.activity.CommentIconActivity;
import com.android.kuaikanmanhua.kuaikan.activity.CommentReplyActivity;
import com.android.kuaikanmanhua.kuaikan.adapter.HotGridViewAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.custom.CustomGridView;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MBENBEN on 2016/7/13.
 */
public class CommentHotFragmet extends Fragment {

    @BindView(R.id.lv_comment_hot_listview)
    PullToRefreshListView pullToRefreshListView;
    List<CommentHotBean.DataBean.FeedsBean> mlist = new ArrayList<>();
    private HotAdapter hotAdapter;
    private HotGridViewAdapter gridViewAdapter;
    boolean res = true;
    private ListView refreshableView;

    public static CommentHotFragmet newInstance(Bundle args) {
        CommentHotFragmet fragment = new CommentHotFragmet();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment_hot_fragment, container, false);
        ButterKnife.bind(this, view);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        refreshableView = pullToRefreshListView.getRefreshableView();
        initRefreshListen();
        //初始化数据
        initData();
        setAdapter();
        bindAdapter();
        initListen();
        return view;
    }

    private void initListen() {

//监听item跳转到评论热门内容界面
        refreshableView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), CommentContextActivity.class);
                intent.putExtra("bean", mlist.get(position - 1));
                startActivity(intent);
            }
        });

    }

    private void initRefreshListen() {

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //这是上拉更新数据
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                OkHttpTool.newInstance().start(SevenDayUrl.getUrl_comment_hot_refresh).callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        CommentHotBean mbean = gson.fromJson(result, CommentHotBean.class);
                        if (result != null && mbean != null) {
                            mlist.addAll(mbean.getData().getFeeds());
                            hotAdapter.notifyDataSetChanged();
                            pullToRefreshListView.onRefreshComplete();
                        }
                    }
                });


            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });

//这是下拉刷新加载
        pullToRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {

                if (res) {
                    OkHttpTool.newInstance().start(SevenDayUrl.getUrl_comment_hot_refresh).callback(new IOKCallBack() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            CommentHotBean mbean = gson.fromJson(result, CommentHotBean.class);
                            if (result != null && mbean != null) {
                                mlist.addAll(mbean.getData().getFeeds());
                                hotAdapter.notifyDataSetChanged();
                                pullToRefreshListView.onRefreshComplete();
                            }

                        }
                    });


                }
                res = false;
            }


        });

    }

    private void bindAdapter() {
        pullToRefreshListView.setAdapter(hotAdapter);
    }

    private void setAdapter() {
        hotAdapter = new HotAdapter();
    }


    private void initData() {


        OkHttpTool.newInstance().start(SevenDayUrl.URL_COMMENT_HOT).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                CommentHotBean bean = gson.fromJson(result, CommentHotBean.class);
                if (result != null && bean != null) {
                    mlist.addAll(bean.getData().getFeeds());


                    hotAdapter.notifyDataSetChanged();
                }

            }
        });
    }

    //   这是将毫秒转换成日期的方法
    private String returnDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String now = sdf.format(new Date(time));
        return now;
    }

    class HotAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mlist == null ? 0 : mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).
                        inflate(R.layout.comment_hot_fragment_listview, null);
                viewHolder = new ViewHolder();
                viewHolder.iv_show = (CircleImageView) convertView.findViewById(R.id.iv_comment_hot_icon);
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.iv_comment_hot_name);
                viewHolder.tv_context = (TextView) convertView.findViewById(R.id.tv_hot_text);
                viewHolder.gv_picture = (CustomGridView) convertView.findViewById(R.id.gv_hot_picture);

                viewHolder.tv_data = (TextView) convertView.findViewById(R.id.tv_hot_data);
                 viewHolder.likes_count = (CheckBox) convertView.findViewById(R.id.tv_hot_likes_count);
                viewHolder.comments_count = (CheckBox) convertView.findViewById(R.id.tv_hot_comments_count);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();

            }
           //头像监听跳转到CommentIconActivity
            viewHolder.iv_show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int postion= (int) v.getTag();
                    Intent intent=new Intent(getActivity(), CommentIconActivity.class);
                    intent.putExtra("bean",mlist.get(position));
                    startActivity(intent);
                }
            });

            Picasso.with(getActivity()).load(mlist.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
            viewHolder.tv_name.setText(mlist.get(position).getUser().getNickname());
            viewHolder.tv_context.setText(mlist.get(position).getContent().getText());
            //设置position
            viewHolder.likes_count.setTag(position);
            viewHolder.comments_count.setTag(position);
            viewHolder.iv_show.setTag(position);
//            点击回复跳转到回复界面
        viewHolder.comments_count.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int postion= (int) buttonView.getTag();
                Intent intent=new Intent(getActivity(),CommentReplyActivity.class);
//        调到回复ACtivity
                intent.putExtra("id",mlist.get(position).getFeed_id());
                startActivity(intent);
            }
        });
            String Date = returnDate((mlist.get(position).getUpdated_at()));
            viewHolder.tv_data.setText(Date);

            //            ------点赞按钮的点击--------
            viewHolder.likes_count.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked=true){
                      int postion= (int) buttonView.getTag();
                        buttonView.setText("" + (mlist.get(position).getLikes_count()+1));
                    }else {
                        buttonView.setText("" + (mlist.get(position).getLikes_count()-1));
                    }
                }
            });

            viewHolder.likes_count.setText("" + mlist.get(position).getLikes_count());

            viewHolder.comments_count.setText("" + mlist.get(position).getComments_count());
            List<String> list = new ArrayList<>();
            list.addAll(mlist.get(position).getContent().getImages());
            int layoutId = 0;
            if(list.size()==1){
                viewHolder.gv_picture.setNumColumns(1);
                layoutId = R.layout.comment_hot_fragment_gridview2;
            }else {
                viewHolder.gv_picture.setNumColumns(3);
                layoutId = R.layout.comment_hot_fragment_gridview;
            }

//            if (list.size() != 1) {
              //  layoutId = R.layout.comment_hot_fragment_gridview;
//            } else {
//                layoutId = R.layout.comment_hot_fragment_gridview2;
//                int   colnum  =  (int) (((getResources().getDisplayMetrics().widthPixels  ))/600  );
//                viewHolder.gv_picture.setNumColumns(colnum);
         //   }
            gridViewAdapter = new HotGridViewAdapter(getActivity(),layoutId, list);
            viewHolder.gv_picture.setAdapter(gridViewAdapter);
            gridViewAdapter.notifyDataSetChanged();

            return convertView;
        }
    }

    class ViewHolder {
        CircleImageView iv_show;
        TextView tv_context;
        TextView tv_name;
        CustomGridView gv_picture;
        TextView tv_data;
          CheckBox likes_count;
        CheckBox comments_count;

    }

}
