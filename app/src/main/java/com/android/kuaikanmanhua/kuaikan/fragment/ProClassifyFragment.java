package com.android.kuaikanmanhua.kuaikan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.activity.ClassifyInfoActivity;
import com.android.kuaikanmanhua.kuaikan.bean.ClassifyBean;
import com.android.kuaikanmanhua.kuaikan.custom.CustomGridView;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作品分类界面
 */
public class ProClassifyFragment extends Fragment{

    @BindView(R.id.pull_proClassify_gridview)
    PullToRefreshGridView mGridView;

    List<ClassifyBean.DataBean.SuggestionBean>mList;
    private ClassifyAdapter classifyAdapter;
    private ClassifyBean bean;


    public static ProClassifyFragment newInstance(Bundle args){
        ProClassifyFragment fragment=new ProClassifyFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_pro_classify,container,false);
        ButterKnife.bind(this,view);

        //显示GridView
        setupGridView();
        return view;
    }

    private void setupGridView() {
        mList=new ArrayList<>();
        //初始化数据
        initData();
        //初始化适配器
        initAdapter();
        //绑定适配器
        bindAdapter();
        //监听
        initListener();

    }

    private void initListener() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),ClassifyInfoActivity.class);
                ClassifyBean.DataBean.SuggestionBean suggestionBean=mList.get(position);
                intent.putExtra("id",suggestionBean);
                startActivity(intent);

            }
        });


    }

    private void initAdapter() {
        classifyAdapter=new ClassifyAdapter();
    }

    private void bindAdapter() {
        mGridView.setAdapter(classifyAdapter);
    }

    private void initData() {
        OkHttpTool.newInstance().start(URLConstants.URL_CLASSIFY).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                bean=gson.fromJson(result,ClassifyBean.class);
                List<ClassifyBean.DataBean.SuggestionBean> suggestion=bean.getData().getSuggestion();
                for (int i = 0; i < suggestion.size(); i++) {
                    mList.add(suggestion.get(i));
                }
                    classifyAdapter.notifyDataSetChanged();
                }

        });
    }


    //GridView的适配器
    class ClassifyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return  mList.size();
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
            ClassityViewHolder viewHolder;
            if(convertView==null){
                convertView=LayoutInflater.from(getActivity()).
                        inflate(R.layout.gridview_classify_item,null);
                viewHolder=new ClassityViewHolder();
                viewHolder.iv_show= (ImageView) convertView.findViewById(R.id.iv_classify_icon);
                viewHolder.tv_name= (TextView) convertView.findViewById(R.id.tv_classify_name);

                convertView.setTag(viewHolder);
            }else{
                viewHolder= (ClassityViewHolder) convertView.getTag();
            }
            Picasso.with(getActivity()).load(mList.get(position).getIcon()).into(viewHolder.iv_show);
            viewHolder.tv_name.setText(mList.get(position).getTitle());
            return convertView;
        }
    }

    class ClassityViewHolder{
        ImageView iv_show;
        TextView tv_name;
    }


}
