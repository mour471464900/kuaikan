package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.ExceptAdvert;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Group5Adapter extends CommonAdapter<ExceptAdvert.DataBean.InfosBean.BannersBean>{

    private Context context;
    private int layoutId;
    private List<ExceptAdvert.DataBean.InfosBean.BannersBean>list;

    public Group5Adapter(Context context, int layoutId, List<ExceptAdvert.DataBean.InfosBean.BannersBean> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(ViewHolderM holderM, ExceptAdvert.DataBean.InfosBean.BannersBean bean) {
        ImageView imageView=(ImageView)holderM.getView(R.id.iv_group5_item);
        TextView textView=(TextView)holderM.getView(R.id.tv_group5_item);

        Picasso.with(context).load(bean.getPic()).into(imageView);
        textView.setText(bean.getTarget_title());
    }
}
