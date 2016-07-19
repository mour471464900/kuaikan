package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.net.Uri;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.ClassifyInfoBean;
import com.android.kuaikanmanhua.kuaikan.bean.ExceptAdvert;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Group1Adapter extends CommonAdapter<ExceptAdvert.DataBean.InfosBean.TopicsBean>{

    private Context context;
    private int layoutId;
    private List<ExceptAdvert.DataBean.InfosBean.TopicsBean>list;

    public Group1Adapter(Context context, int layoutId, List<ExceptAdvert.DataBean.InfosBean.TopicsBean> list) {
        super(context, layoutId, list);
        this.context=context;
        this.layoutId=layoutId;
        this.list=list;
    }

    @Override
    public void convert(ViewHolderM holderM, ExceptAdvert.DataBean.InfosBean.TopicsBean bean) {
        ImageView imageView=(ImageView)holderM.getView(R.id.iv_group1_item);
        TextView textView=(TextView)holderM.getView(R.id.tv_group1_item);

        Picasso.with(context).load(bean.getVertical_image_url()).into(imageView);
        textView.setText(bean.getTitle());
    }
}
