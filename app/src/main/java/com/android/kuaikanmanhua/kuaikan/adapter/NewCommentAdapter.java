package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.custom.CustomGridView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hao on 2016/7/23.
 * <p/>
 * 优化
 */
public class NewCommentAdapter extends BaseAdapter {

    private List<CommentHotBean.DataBean.FeedsBean> mList;

    private Context context;

    public NewCommentAdapter(List<CommentHotBean.DataBean.FeedsBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.comment_hot_fragment_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_show = (CircleImageView) convertView.findViewById(R.id.iv_comment_hot_icon);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.iv_comment_hot_name);
            viewHolder.tv_context = (TextView) convertView.findViewById(R.id.tv_hot_text);
            viewHolder.gv_picture = (CustomGridView) convertView.findViewById(R.id.gv_hot_picture);
            //-----------直接在这个就绑定适配器
            viewHolder.adapter = new NewHotGridAdapter(context);
            viewHolder.gv_picture.setAdapter(viewHolder.adapter);
//            ------------------end-------------------
            viewHolder.tv_data = (TextView) convertView.findViewById(R.id.tv_hot_data);
            viewHolder.likes_count = (CheckBox) convertView.findViewById(R.id.tv_hot_likes_count);
            viewHolder.comments_count = (CheckBox) convertView.findViewById(R.id.tv_hot_comments_count);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            if (mList.get(position).getContent().getImages() != null) {
                if(mList.get(position).getContent().getImages().size()==1){
                    viewHolder.gv_picture.setNumColumns(1);
                }else {
                    viewHolder.gv_picture.setNumColumns(3);
                }
                viewHolder.adapter.setImages(mList.get(position).getContent().getImages());
            }
            viewHolder.adapter.notifyDataSetChanged();
        }
        //-----------改变ui
        String Date = returnDate((mList.get(position).getUpdated_at()));
        Picasso.with(context).load(mList.get(position).getUser().getAvatar_url()).into(viewHolder.iv_show);
        viewHolder.tv_name.setText(mList.get(position).getUser().getNickname());
        viewHolder.tv_context.setText(mList.get(position).getContent().getText());
        //设置position
        viewHolder.likes_count.setTag(position);
        viewHolder.comments_count.setTag(position);
        viewHolder.iv_show.setTag(position);
        // --------end-------
        viewHolder.tv_data.setText(Date);
        viewHolder.likes_count.setText("" + mList.get(position).getLikes_count());
        viewHolder.comments_count.setText("" + mList.get(position).getComments_count());
        //  -------end --改变ui

//        ----------点击事件------------------


//        ----------点击事件end-----------------------
        return convertView;
    }


//   这是将毫秒转换成日期的方法

    private String returnDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String now = sdf.format(new Date(time));
        return now;
    }

    class ViewHolder {
        CircleImageView iv_show;
        TextView tv_context;
        TextView tv_name;
        CustomGridView gv_picture;
        TextView tv_data;
        CheckBox likes_count;
        CheckBox comments_count;
        NewHotGridAdapter adapter;
    }
}


