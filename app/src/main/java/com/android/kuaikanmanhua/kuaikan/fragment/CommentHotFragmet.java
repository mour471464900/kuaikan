package com.android.kuaikanmanhua.kuaikan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.HotGridViewAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.custom.CustomGridView;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
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
   List<CommentHotBean.DataBean.FeedsBean> mlist;
    private HotAdapter hotAdapter;
    private HotGridViewAdapter gridViewAdapter;

    public static CommentHotFragmet newInstance(Bundle args) {
        CommentHotFragmet fragment = new CommentHotFragmet();
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
        return view;
    }

    private void bindAdapter() {
        pullToRefreshListView.setAdapter(hotAdapter);
    }

    private void setAdapter() {
      hotAdapter=new HotAdapter();
    }



    private void initData() {
        mlist=new ArrayList<>();

        OkHttpTool.newInstance().start(SevenDayUrl.URL_COMMENT_HOT).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                CommentHotBean bean=gson.fromJson(result,CommentHotBean.class);
                if(result!=null&&bean!=null){
                    mlist.addAll(bean.getData().getFeeds());




                    hotAdapter.notifyDataSetChanged();
                }

            }
        });
    }
    class HotAdapter extends BaseAdapter{

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
convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();

            }
            Picasso.with(getActivity()).load(mlist.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
            viewHolder.tv_name.setText(mlist.get(position).getUser().getNickname());
            viewHolder.tv_context.setText(mlist.get(position).getContent().getText());

            List<String> list=new ArrayList<>();
                list.addAll(mlist.get(position).getContent().getImages());
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
//        TextView tv_data;
//        TextView tv_click;
//                TextView tv_look;
    }
}
