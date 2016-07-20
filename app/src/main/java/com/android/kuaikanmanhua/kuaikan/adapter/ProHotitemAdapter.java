package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;

import com.android.kuaikanmanhua.kuaikan.bean.ExceptAdvert;

import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public class ProHotitemAdapter extends CommonAdapter<ExceptAdvert.DataBean.InfosBean>{


    public ProHotitemAdapter(Context context, int layoutId, List<ExceptAdvert.DataBean.InfosBean> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(ViewHolderM holderM, ExceptAdvert.DataBean.InfosBean bean) {

    }
}
