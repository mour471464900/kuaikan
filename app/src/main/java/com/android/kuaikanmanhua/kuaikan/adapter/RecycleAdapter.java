package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.ExceptAdvert;
import com.makeramen.roundedimageview.RoundedImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hao on 2016/7/8.
 */
public class RecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<ExceptAdvert.DataBean.InfosBean.TopicsBean> list;
    private Context context;

    public RecycleAdapter(List<ExceptAdvert.DataBean.InfosBean.TopicsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.group2_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getCover_image_url()).into(holder.iv_icon);
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_author.setText(list.get(position).getUser().getNickname());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {

    final ImageView iv_icon;
    final TextView tv_title;
    final TextView tv_author;

    public MyViewHolder(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_group2_item);
        tv_title = (TextView) itemView.findViewById(R.id.tv_group2_title);
        tv_author = (TextView) itemView.findViewById(R.id.tv_group2_author);

    }
}