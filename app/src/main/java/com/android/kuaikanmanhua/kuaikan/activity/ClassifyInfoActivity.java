package com.android.kuaikanmanhua.kuaikan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.ClassifyInfoAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.ClassifyInfoBean;
import com.android.kuaikanmanhua.kuaikan.bean.ClassifyBean;
import com.android.kuaikanmanhua.kuaikan.bean.FullWatchBean;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.google.gson.Gson;
import com.mob.tools.gui.ScrollableListView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassifyInfoActivity extends Activity {

    private String title;
    private List<ClassifyInfoBean.DataBean.TopicsBean> itemsBeanList;
    private ClassifyInfoAdapter infoAdapter;
    private ClassifyBean.DataBean.SuggestionBean suggestionBean;

    @BindView(R.id.tv_banner_title_name)
    TextView tv_title;
    @BindView(R.id.sv_buttom)
    ScrollableListView mScrollableListView;

    private ClassifyInfoBean classifyInfoBean;
    private String encode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_info);
        ButterKnife.bind(this);

        setupListView();

    }


    private void setupListView() {
        //初始化数据
        initData();
        //初始化适配器
        initAdapter();
        //绑定适配器
        bindAdapter();
        //设置监听
        initListener();
    }



    private void initListener() {
        mScrollableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ClassifyInfoActivity.this,OpusActivity.class);
                intent.putExtra("id",classifyInfoBean.getData().getTopics().get(position).getId());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        Intent intent=getIntent();
        if(intent.getSerializableExtra("id")!=null){
            suggestionBean=
                    (ClassifyBean.DataBean.SuggestionBean) intent.getSerializableExtra("id");
            tv_title.setText(suggestionBean.getTitle());
            title=suggestionBean.getTitle();
        }

        initListViewData();
    }

    /**
     * 异步任务取得
     * 设置listview 的数据
     */
    private void initListViewData() {
        itemsBeanList = new ArrayList<>();

        try {
            encode = URLEncoder.encode(title, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        OkHttpTool.newInstance().start(URLConstants.URL_CLASSIFYINFO + encode)
                .callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson = new Gson();
                         classifyInfoBean = gson.fromJson(result, ClassifyInfoBean.class);
                        if (classifyInfoBean != null) {

                            itemsBeanList.addAll(classifyInfoBean.getData().getTopics());

                            infoAdapter.notifyDataSetChanged();
                        }

                    }
                });
    }

    private void bindAdapter() {
        mScrollableListView.setAdapter(infoAdapter);
    }

    private void initAdapter() {
        infoAdapter=new ClassifyInfoAdapter(this,R.layout.item_classify_info,itemsBeanList);
    }

    //    设置返回键
    public void BackToClassify(View view) {
        finish();
    }
}
