package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.ClassifyInfoBean;
import com.android.kuaikanmanhua.kuaikan.bean.SearchBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MBENBEN on 2016/7/19.
 */
public class SearchAdapter extends CommonAdapter<SearchBean.DataBean.TopicsBean> {
    private Context context;
    private int layoutId;
    private List<SearchBean.DataBean.TopicsBean> list;
    public SearchAdapter(Context context, int layoutId, List<SearchBean.DataBean.TopicsBean> list) {
        super(context, layoutId, list);
        this.context=context;
        this.layoutId=layoutId;
        this.list=list;
    }

    @Override
    public void convert(ViewHolderM holderM, SearchBean.DataBean.TopicsBean bean) {
        ImageView imageView=(ImageView) holderM.getView(R.id.iv_pro_icon);
        TextView tv_pro_name=(TextView) holderM.getView(R.id.tv_pro_name);
        TextView tv_pro_author=(TextView)holderM.getView(R.id.tv_pro_author);
        TextView tv_pro_dianzan=(TextView) holderM.getView(R.id.tv_pro_dianzan);
        TextView tv_pro_pinglun=(TextView)holderM.getView(R.id.tv_pro_pinglun);

        Picasso.with(context).load(bean.getCover_image_url()).into(imageView);
        tv_pro_name.setText(bean.getTitle());
        tv_pro_author.setText(bean.getUser().getNickname());
        //获取int类型的数据，前面要加上""+
        tv_pro_dianzan.setText(""+bean.getLikes_count());
        tv_pro_pinglun.setText(""+bean.getComments_count());
    }
}
