package com.android.kuaikanmanhua.kuaikan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.ClassifyInfoAdapter;
import com.android.kuaikanmanhua.kuaikan.adapter.SearchAdapter;
import com.android.kuaikanmanhua.kuaikan.bean.SearchBean;
import com.android.kuaikanmanhua.kuaikan.bean.SevenDayBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.fragment.SevenDayFragment;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;
import com.mob.tools.gui.ScrollableListView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends Activity {
    @BindView(R.id.et_search_text)
    EditText editText;
    @BindView(R.id.sv_buttom1)
    ListView mScrollableListView;
    List<SearchBean.DataBean.TopicsBean> mlist = new ArrayList<>();
    //     给listview 设置空视图 要在listview 的下方，写一个视图
    @BindView(R.id.tv_empty)
    View empty;
//    这个是历史记录的集合
    @BindView(R.id.lv_search_record)
    ListView recordListView;

    private SearchAdapter infoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
//       初始化搜索的集合
        setupSearchList();
//        初始化greendao的帮助类
        initGreenDao();
    }

    private void initGreenDao() {

    }

    private void setupSearchList() {
        initView();
        initListen();
        initListListen();
    }

    private void initListListen() {
        mScrollableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchActivity.this, OpusActivity.class);
                intent.putExtra("id", mlist.get(position).getId());
                startActivity(intent);
                finish();
            }
        });
        mScrollableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //  长按删除该条目，对于listview 条目的删除。是删除适配器集合的元素
                 mlist.remove(position);// 这个就是当前条目的元素
//                mlist.removeAll(mlist);
                infoAdapter.notifyDataSetChanged();
                // 当删除数据之后，要通知适配器更新
                return true;
            }
        });
    }

    private void initView() {
    }

    private void initListen() {
    }

    private void initAdapter() {
        infoAdapter = new SearchAdapter(this, R.layout.item_classify_info, mlist);
        mScrollableListView.setAdapter(infoAdapter);
//         设置当加载数据的时候 ，集合没有数据的时候显示空视图
        mScrollableListView.setEmptyView(empty);
    }

    private void initData() {
        String text = editText.getText().toString();
        String encode = null;
        try {
            encode = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(text)) {
            OkHttpTool.newInstance().start(SevenDayUrl.SEARCH_START + encode + SevenDayUrl.SEARCH_END).callback(new IOKCallBack() {
                @Override
                public void success(String result) {
                    Gson gson = new Gson();
                    SearchBean bean = gson.fromJson(result, SearchBean.class);
                    if (result != null && bean.getData()!= null) {
                        mlist.addAll(bean.getData().getTopics());
                        initAdapter();
                        infoAdapter.notifyDataSetChanged();
//                        通知适配器刷新
                    }
                }
            });
        }
    }
    //   返回键
    public void onCancel(View view) {
        finish();
    }

//    按搜索键来进行
    public void onSearch(View view) {
        initData();
    }
}
