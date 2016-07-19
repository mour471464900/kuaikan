package com.android.kuaikanmanhua.kuaikan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

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
    ScrollableListView mScrollableListView;
    List<SearchBean.DataBean.TopicsBean> mlist = new ArrayList<>();
    private SearchAdapter infoAdapter;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
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
    }

    private void initView() {
        view = LayoutInflater.from(this).inflate(R.layout.empty_search, null);

    }

    private void initListen() {


        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                initData();
            }
        };
        editText.addTextChangedListener(watcher);
    }

    private void initAdapter() {
        infoAdapter = new SearchAdapter(this, R.layout.item_classify_info, mlist);
        mScrollableListView.setAdapter(infoAdapter);
        // mScrollableListView.setEmptyView(view);
    }

    private void initData() {

        String text = editText.getText().toString();
        String encode = null;
        try {
            encode = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (text != null) {
            OkHttpTool.newInstance().start(SevenDayUrl.SEARCH_START + encode + SevenDayUrl.SEARCH_END).callback(new IOKCallBack() {
                @Override
                public void success(String result) {
                    Gson gson = new Gson();
                    SearchBean bean = gson.fromJson(result, SearchBean.class);
                    if (result != null && bean != null) {
                        mlist.addAll(bean.getData().getTopics());
                        initAdapter();
                        infoAdapter.notifyDataSetChanged();
                    }


                }
            });
        }


    }


    public void onCancel(View view) {
        finish();
    }
}
