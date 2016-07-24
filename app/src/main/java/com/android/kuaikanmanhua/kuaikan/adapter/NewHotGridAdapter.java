package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hao on 2016/7/24.
 */
public class NewHotGridAdapter extends BaseAdapter{
    private Context context;
    private List<String> images;

    public NewHotGridAdapter(Context context) {
        this.context = context;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images==null ?0: images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            if(images.size()==1){
//               当只有一张照片的时候就显示大图
                convertView= LayoutInflater.from(context).
                        inflate(R.layout.comment_hot_fragment_gridview2,null);
                viewHolder=new ViewHolder();
                viewHolder.iv_picture= (ImageView)
                        convertView.findViewById(R.id.iv_hot_gridview);
                convertView.setTag(viewHolder);
            }else {
//                 当有多张图片的时候就显示小图
                convertView= LayoutInflater.from(context).
                        inflate(R.layout.comment_hot_fragment_gridview,null);
                viewHolder=new ViewHolder();
                viewHolder.iv_picture= (ImageView)
                        convertView.findViewById(R.id.iv_hot_gridview);
                convertView.setTag(viewHolder);
            }
        }else {
          viewHolder  =(ViewHolder)convertView.getTag();
        }

        ImageView imageView= (ImageView) convertView.findViewById(R.id.iv_hot_gridview);
        Picasso.with(context).load(SevenDayUrl.COMMENT_START+
                images.get(position)+SevenDayUrl.COMMENT_END)
                .placeholder(R.mipmap.ic_launcher_mine).into(imageView);
        return convertView;
    }

//     评论的照片
    class  ViewHolder{
        ImageView iv_picture;
    }

}
