package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.util.ImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by hao on 2016/7/16.
 *
 * 这个图片的的适配器是全屏的每个属性
 */
public class FullFirstAdapter extends CommonAdapter<String> {

    private Context context;
    private int layoutId;
    private List<String>list;
    public FullFirstAdapter(Context context, int layoutId, List<String> list) {
        super(context, layoutId, list);
        this.list=list;
        this.context=context;
        this.layoutId=layoutId;
    }
    @Override
    public void convert(ViewHolderM holderM, String bean) {
        ImageView imageview=holderM.getView(R.id.iv_full_image);
        Picasso.with( imageview.getContext() )
                .load(bean)
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                .placeholder(R.drawable.ic_common_placeholder_l)
                .into(imageview);
    }
}
