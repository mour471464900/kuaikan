package com.android.kuaikanmanhua.kuaikan.fragment;

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
import com.android.kuaikanmanhua.kuaikan.adapter.HotGridViewAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.bean.CommentZuiXinBean;
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
public class CommentZuiXinFragment extends Fragment {
    @BindView(R.id.lv_comment_hot_listview)
    PullToRefreshListView pullToRefreshListView;
    List<CommentZuiXinBean.DataBean.FeedsBean> mlist=new ArrayList<>();;
    private ZuiXinAdapter ZXAdapter;
    private HotGridViewAdapter gridViewAdapter;
    boolean res=true;
    int i=2;
     public static CommentZuiXinFragment newInstance(Bundle args){
         CommentZuiXinFragment fragment=new CommentZuiXinFragment();
         fragment.setArguments(args);
         return fragment;
     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.comment_hot_fragment,container,false);
        ButterKnife.bind(this,view);
        //初始化数据
        initData();
        setAdapter();
        bindAdapter();
        initRefreshListen();
        return view;
    }

    private void initRefreshListen() {
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                OkHttpTool.newInstance().start(SevenDayUrl.getUrl_comment_hot_refresh).callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                        CommentZuiXinBean mbean = gson.fromJson(result, CommentZuiXinBean.class);
                        if (result != null && mbean != null) {
                            mlist.addAll(mbean.getData().getFeeds());
                            ZXAdapter.notifyDataSetChanged();
                            pullToRefreshListView.onRefreshComplete();
                        }
                    }
                });



            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });


        pullToRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                i++;
                if (i<6) {
                    OkHttpTool.newInstance().start(SevenDayUrl.url_comment_RECENTLY_start+i+SevenDayUrl.url_comment_RECENTLY_end).callback(new IOKCallBack() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            CommentZuiXinBean mbean = gson.fromJson(result, CommentZuiXinBean.class);
                            if (result != null && mbean != null) {
                                mlist.addAll(mbean.getData().getFeeds());
                                ZXAdapter.notifyDataSetChanged();
                                pullToRefreshListView.onRefreshComplete();
                            }

                        }
                    });


                }

            }




        });

    }


    private void bindAdapter() {
        pullToRefreshListView.setAdapter(ZXAdapter);
    }

    private void setAdapter() {
        ZXAdapter=new ZuiXinAdapter();
    }



    private void initData() {

        OkHttpTool.newInstance().start(SevenDayUrl.URL_COMMENT_RECENTLY).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                CommentZuiXinBean bean=gson.fromJson(result,CommentZuiXinBean.class);
                if(result!=null&&bean!=null){
                    mlist.addAll(bean.getData().getFeeds());
                    ZXAdapter.notifyDataSetChanged();
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
    class ZuiXinAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mlist==null?0:mlist.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
                convertView = LayoutInflater.from(getActivity()).
                        inflate(R.layout.comment_hot_fragment_listview, null);
                viewHolder = new ViewHolder();
                viewHolder.iv_show= (CircleImageView) convertView.findViewById(R.id.iv_comment_hot_icon);
                viewHolder.tv_name= (TextView) convertView.findViewById(R.id.iv_comment_hot_name);
                viewHolder.tv_context= (TextView) convertView.findViewById(R.id.tv_hot_text);
                viewHolder.gv_picture= (CustomGridView) convertView.findViewById(R.id.gv_hot_picture);
                viewHolder.tv_data= (TextView) convertView.findViewById(R.id.tv_hot_data);
                viewHolder.likes_count= (TextView) convertView.findViewById(R.id.tv_hot_likes_count);
                viewHolder.comments_count= (TextView) convertView.findViewById(R.id.tv_hot_comments_count);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();

            }
            Picasso.with(getActivity()).load(mlist.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
            viewHolder.tv_name.setText(mlist.get(position).getUser().getNickname());
            viewHolder.tv_context.setText(mlist.get(position).getContent().getText());
            String Date=returnDate((mlist.get(position).getUpdated_at()));
            viewHolder.tv_data.setText(Date);
            viewHolder.likes_count.setText(""+mlist.get(position).getLikes_count());
            viewHolder.comments_count.setText(""+mlist.get(position).getComments_count());

            List<String> list=new ArrayList<>();
            if(mlist.get(position).getContent().getImages()!=null){
                list.addAll(mlist.get(position).getContent().getImages());
            }

            int layoutId=0;

            if(list.size()!=1){
                layoutId =R.layout.comment_hot_fragment_gridview;

            }else {
                layoutId=R.layout.comment_hot_fragment_gridview2;


//                int   colnum  =  (int) (((getResources().getDisplayMetrics().widthPixels  ))/600  );
//                viewHolder.gv_picture.setNumColumns(colnum);




            }
            gridViewAdapter=new HotGridViewAdapter(getActivity(),layoutId,list);
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
        TextView likes_count;
               TextView comments_count;
    }
}
