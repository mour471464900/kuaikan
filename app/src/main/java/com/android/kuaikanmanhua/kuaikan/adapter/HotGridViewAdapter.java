package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.CommentHotBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MBENBEN on 2016/7/13.
 */
public class HotGridViewAdapter extends CommonAdapter<String> {
    private  Context context;
    private int layoutId;
    List<String> list;
    public HotGridViewAdapter(Context context, int layoutId, List<String> list) {
        super(context, layoutId, list);
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }
    @Override
    public void convert(ViewHolderM holderM, String bean) {
        ImageView imageView=holderM.getView(R.id.iv_hot_gridview);
        Picasso.with(context).load(SevenDayUrl.COMMENT_START+
                bean+SevenDayUrl.COMMENT_END).into(imageView);
    }
}
