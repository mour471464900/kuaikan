package com.android.kuaikanmanhua.kuaikan.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.bean.CommentIconBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.custom.CustomGridView;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class CommentDatumFragment extends Fragment {
    private CommentHotBean.DataBean.FeedsBean feedBean;
    private List<CommentIconBean.DataBean.TopicsBean> mlist=new ArrayList<>();
    private CommentIconBean bean;
    @BindView(R.id.lv_comment_datum)
    ListView listView;
    private DatumAdapter adapter;
    private View header;
    private View view;

    public static CommentDatumFragment newInstance(Bundle args) {
        CommentDatumFragment fragment = new CommentDatumFragment();
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
        view=inflater.inflate(R.layout.fragment_comment_datum, container, false);
        ButterKnife.bind(this,view);
        header=LayoutInflater.from(getActivity()).inflate(R.layout.comment_datum_list_header,null);
        listView.addHeaderView(header);

           initData();
           initAdapter();

        return view;
    }

    private void initHeader() {
    TextView tv= (TextView) view.findViewById(R.id.tv_comment_datum_introduce);
     tv.setText(bean.getData().getIntro());
    }


    private void initAdapter() {
   adapter=new DatumAdapter();
     listView.setAdapter(adapter);
    }


    private void initData() {
       OkHttpTool.newInstance().start(SevenDayUrl.comment_icon_datum+feedBean.getUser().getId()).callback(new IOKCallBack() {
           @Override
           public void success(String result) {
               Gson gson=new Gson();
                bean=gson.fromJson(result, CommentIconBean.class);

                 mlist.addAll(bean.getData().getTopics());

               adapter.notifyDataSetChanged();
               initHeader();
           }
       });
    }

   class DatumAdapter extends BaseAdapter{

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
            inflate(R.layout.comment_datum_list_content, null);
    viewHolder = new ViewHolder();
      viewHolder.cover_image_url= (ImageView) convertView.findViewById(R.id.iv_comment_datum_icon);
      viewHolder.title= (TextView) convertView.findViewById(R.id.tv_comment_datum_title);
       viewHolder.description= (TextView) convertView.findViewById(R.id.tv_comment_datum_content);

    convertView.setTag(viewHolder);
}else {
    viewHolder= (ViewHolder) convertView.getTag();
}
           Picasso.with(getActivity()).load(mlist.get(position).getCover_image_url()).into(viewHolder.cover_image_url);
        viewHolder.title.setText(mlist.get(position).getTitle());
viewHolder.description.setText(mlist.get(position).getDescription());

           return convertView;
       }
   }
    class ViewHolder {
      ImageView cover_image_url;
       TextView title;
      TextView description;

    }
}
