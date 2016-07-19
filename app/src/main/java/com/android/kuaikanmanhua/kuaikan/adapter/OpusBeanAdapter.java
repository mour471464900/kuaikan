package com.android.kuaikanmanhua.kuaikan.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.bean.OpusBean;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hao on 2016/7/16.
 *
 * 这个图片的的适配器是全屏的每个属性
 */
public class OpusBeanAdapter extends CommonAdapter<OpusBean.DataBean.ComicsBean> {

    private Context context;
    private int layoutId;
    private List<OpusBean.DataBean.ComicsBean>list;
    public OpusBeanAdapter(Context context, int layoutId, List<OpusBean.DataBean.ComicsBean> list) {
        super(context, layoutId, list);
        this.list=list;
        this.context=context;
        this.layoutId=layoutId;
    }

    @Override
    public void convert(ViewHolderM holderM, OpusBean.DataBean.ComicsBean bean) {
        ImageView imageview =(ImageView) holderM.getView(R.id.iv_opus_icon);
        Picasso.with( imageview.getContext() ).load(bean.getCover_image_url()).into(imageview);

        TextView tv_opus_child_title =(TextView) holderM.getView(R.id.tv_opus_child_title);
        TextView tv_opus_child_time =(TextView) holderM.getView(R.id.tv_opus_child_time);
        TextView tv_opus_child_like =(TextView) holderM.getView(R.id.tv_opus_child_like);

        tv_opus_child_title.setText(bean.getTitle());
        tv_opus_child_like.setText(""+(bean.getLikes_count()/10000)+"万");
        tv_opus_child_time.setText(returnDate((long)bean.getUpdated_at()));
    }

    //   这是将毫秒转换成日期的方法
    private String returnDate(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String now = sdf.format(new Date(time*1000));
        return now;
    }
}
