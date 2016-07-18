package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import android.widget.ListView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;

import com.android.kuaikanmanhua.kuaikan.adapter.HotGridViewAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.CommentDynamicBean;
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

public class CommentDynamicFragment extends Fragment {
   @BindView(R.id.lv_comment_datum_list)
    PullToRefreshListView RefreshListView;

    private CommentHotBean.DataBean.FeedsBean feedBean;
    private View view;
  List<CommentDynamicBean.DataBean.FeedsBean> mlist=new ArrayList<>();
    private HotGridViewAdapter gridViewAdapter;
    private HotAdapter hotAdapter;
    private View header;
    ListView listView;


    public static CommentDynamicFragment newInstance(Bundle args) {
        CommentDynamicFragment fragment = new CommentDynamicFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if(bundle!=null){
            feedBean=(CommentHotBean.DataBean.FeedsBean)bundle.getSerializable("bean");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_comment_dynamic, container, false);
  ButterKnife.bind(this,view);
        RefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        listView= RefreshListView.getRefreshableView();
        header=LayoutInflater.from(getActivity()).inflate(R.layout.comment_hot_fragment_listview,null);
        listView.addHeaderView(header);
        initData();
        initAdapter();
        initHeader();
        return view;
    }

    private void initHeader() {
        CircleImageView  iv_show = (CircleImageView) header.findViewById(R.id.iv_comment_hot_icon);
        TextView  tv_name = (TextView)header. findViewById(R.id.iv_comment_hot_name);
        TextView   tv_context = (TextView)header. findViewById(R.id.tv_hot_text);

        TextView    tv_data = (TextView)header. findViewById(R.id.tv_hot_data);
        TextView  likes_count = (TextView)header. findViewById(R.id.tv_hot_likes_count);
        TextView     comments_count = (TextView) header.findViewById(R.id.tv_hot_comments_count);
        CustomGridView   gv_picture = (CustomGridView) header.findViewById(R.id.gv_hot_picture);
        Picasso.with(getActivity()).load(feedBean.getUser().getAvatar_url()).into(iv_show);
        tv_name.setText(feedBean.getUser().getNickname());
        tv_context.setText(feedBean.getContent().getText());
        String Date = returnDate(feedBean.getUpdated_at());
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
        gridViewAdapter = new HotGridViewAdapter(getActivity(), layoutId, list);
        gv_picture.setAdapter(gridViewAdapter);
        gridViewAdapter.notifyDataSetChanged();
    }

    private void initAdapter() {
        hotAdapter = new HotAdapter();
        listView .setAdapter(hotAdapter);
    }

    private void initData() {
        OkHttpTool.newInstance().start(SevenDayUrl.comment_icon_dynamic_start+feedBean.getUser().getId()+SevenDayUrl.comment_icon_dynamic_second+feedBean.getFeed_id()+SevenDayUrl.comment_icon_dynamic_end).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                CommentDynamicBean bean=gson.fromJson(result,CommentDynamicBean.class);
                mlist.addAll(bean.getData().getFeeds());
                hotAdapter.notifyDataSetChanged();
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


            Picasso.with(getActivity()).load(mlist.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
            viewHolder.tv_name.setText(mlist.get(position).getUser().getNickname());
            viewHolder.tv_context.setText(mlist.get(position).getContent().getText());


            String Date = returnDate((mlist.get(position).getUpdated_at()));
            viewHolder.tv_data.setText(Date);



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
