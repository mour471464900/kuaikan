package com.android.kuaikanmanhua.kuaikan.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.ClassifyInfoAdapter;
import com.android.kuaikanmanhua.kuaikan.adapter.ProHotArrayAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.ArrayBean;
import com.android.kuaikanmanhua.kuaikan.bean.ExceptAdvert;
import com.android.kuaikanmanhua.kuaikan.bean.HelpBean;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.google.gson.Gson;
import com.mob.tools.gui.ScrollableListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProHotArrayActivity extends AppCompatActivity {

    @BindView(R.id.tv_banner_title_name)
    TextView tv_title;
    @BindView(R.id.sv_buttom)
    ScrollableListView mScrollableListView;

    private List<ArrayBean.DataBean.TopicsBean> itemsBeanList;
    private ExceptAdvert.DataBean.InfosBean infosBean;
    private ProHotArrayAdapter arrayAdapter;
    private ArrayBean arrayBean;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_info);
        ButterKnife.bind(this);

        initBean();
        setupListView();
    }

    private void initBean() {
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", 0);
        }
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
                Intent intent=new Intent(ProHotArrayActivity.this,OpusActivity.class);
                intent.putExtra("id",arrayBean.getData().getTopics().get(position).getId());
                startActivity(intent);
            }
        });
    }

    private void bindAdapter() {
        mScrollableListView.setAdapter(arrayAdapter);
    }

    private void initAdapter() {
        arrayAdapter=new ProHotArrayAdapter(this,R.layout.item_classify_info,itemsBeanList);
    }

    private void initData() {
        Intent intent=getIntent();
        if(intent.getBundleExtra("bean")!=null){
            Bundle bundle = intent.getBundleExtra("bean");
            HelpBean bean  =(HelpBean)bundle.getSerializable("bean");
            id = bean.getId();
            tv_title.setText(bean.getTitle());
        }
        initListViewData();
    }

    private void initListViewData() {
        itemsBeanList = new ArrayList<>();
        if(id!=0){
            OkHttpTool.newInstance().start(URLConstants.URL_PRO_ARRAY_START+id+URLConstants.URL_PRO_ARRAY_END).
                    callback(new IOKCallBack() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            arrayBean=gson.fromJson(result,ArrayBean.class);
                            if (arrayBean!=null){
                                itemsBeanList.addAll(arrayBean.getData().getTopics());
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                    });
        }

    }


    //    设置返回键
    public void BackToClassify(View view) {
        finish();
    }
}
