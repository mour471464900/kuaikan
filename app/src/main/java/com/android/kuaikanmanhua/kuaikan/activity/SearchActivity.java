package com.android.kuaikanmanhua.kuaikan.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kuaikanmanhua.kuaikan.R;
import com.android.kuaikanmanhua.kuaikan.adapter.CommonAdapter;
import com.android.kuaikanmanhua.kuaikan.adapter.SearchAdapter;
import com.android.kuaikanmanhua.kuaikan.adapter.ViewHolderM;
import com.android.kuaikanmanhua.kuaikan.bean.SearchBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.greenHelp.DaoMaster;
import com.android.kuaikanmanhua.kuaikan.greenHelp.DaoSession;
import com.android.kuaikanmanhua.kuaikan.greenHelp.SearchData;
import com.android.kuaikanmanhua.kuaikan.greenHelp.SearchDataDao;
import com.android.kuaikanmanhua.kuaikan.util.IOKCallBack;
import com.android.kuaikanmanhua.kuaikan.util.OkHttpTool;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    @BindView(R.id.et_search_text)
    EditText editText;
    @BindView(R.id.sv_buttom1)
    ListView mScrollableListView;
    List<SearchBean.DataBean.TopicsBean> mList;
    //     给listview 设置空视图 要在listview 的下方，写一个视图
    @BindView(R.id.tv_empty)
    View empty;
    //    这个是历史记录的集合
    @BindView(R.id.lv_search_record)
    ListView recordListView;
    //    搜索条目的适配器
    private SearchAdapter infoAdapter;
    //     dao类里面 就是替你封装的了对数据库的操作
    private SearchDataDao dataDao;

    public static final int POSITION = 1;
    private RecordAdapter recordAdapter;
    private View inflate;
    private View viewById;
    private List<SearchData> beanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
//     初始化 greendao
        initGreenDao();
//     当进入搜索页面的时候就开始  进行对历史记录的监听
        setupRecordList();
//       初始化搜索的集合
        setupSearchList();
//        初始化greendao的帮助类

    }

    private void setupRecordList() {
        beanList = dataDao.loadAll();
        if (beanList != null && !beanList.isEmpty()) {
            recordListView.setVisibility(View.VISIBLE);
            recordAdapter = new RecordAdapter(this, R.layout.item_record_list, beanList);
            recordListView.setAdapter(recordAdapter);
            inflate = LayoutInflater.from(this).inflate(R.layout.item_foot_record, null);
            viewById = inflate.findViewById(R.id.tv_search_clear);
            viewById.setOnClickListener(this);
            recordListView.addFooterView(inflate);
        }
        recordListView.setOnItemClickListener(this);
    }

    private void initGreenDao() {
        //配置 greendao
        DaoMaster.DevOpenHelper openHelper = new
                DaoMaster.DevOpenHelper(this, "record", null);
//         与数据库进行连接
        SQLiteDatabase database = openHelper.getReadableDatabase();
//        read 权限
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        //        初始化 dao数据  利用   searchdao 类对
        dataDao = daoSession.getSearchDataDao();

    }

    private void setupSearchList() {
        initListListen();
    }

    private void initListListen() {
        mScrollableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchActivity.this, OpusActivity.class);
                intent.putExtra("id", mList.get(position).getId());
                startActivity(intent);
            }
        });
        mScrollableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //  长按删除该条目，对于listview 条目的删除。是删除适配器集合的元素
                mList.remove(position);// 这个就是当前条目的元素

                infoAdapter.notifyDataSetChanged();
                // 当删除数据之后，要通知适配器更新
                return true;
            }
        });
    }


    private void initAdapter() {
        infoAdapter = new SearchAdapter(this, R.layout.item_classify_info, mList);
        mScrollableListView.setAdapter(infoAdapter);
//         设置当加载数据的时候 ，集合没有数据的时候显示空视图
        mScrollableListView.setEmptyView(empty);
    }

    // 请求网络
    private void connectionNetWork(String text) {
        if (!TextUtils.isEmpty(text)) {
            //搜索的时候就让  历史记录消失
            recordListView.setVisibility(View.GONE);
            String encode = null;
            try {
                encode = URLEncoder.encode(text, "UTF-8");//对字符串进行转码
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mList=new ArrayList<>();
            OkHttpTool.newInstance().start(SevenDayUrl.SEARCH_START + encode + SevenDayUrl.SEARCH_END).callback(new IOKCallBack() {
                @Override
                public void success(String result) {
                    Gson gson = new Gson();
                    SearchBean bean = gson.fromJson(result, SearchBean.class);
                    if (result != null && bean.getData() != null) {
                        mList.addAll(bean.getData().getTopics());
                        initAdapter();
                        infoAdapter.notifyDataSetChanged();
//                        通知适配器刷新
                    }
                }
            });
        }else {
            Toast.makeText(SearchActivity.this, "客官还是写点什么吧", Toast.LENGTH_SHORT).show();
        }
    }

    //   返回键
    public void onCancel(View view) {
        finish();
    }

    //    按搜索键来进行
    public void onSearch(View view) {
        String text = editText.getText().toString().trim();
        //将空格去掉    trim（）方法
        //当按“搜索”就请求网络
        connectionNetWork(text);
        SearchData data = new SearchData();
        if (!TextUtils.isEmpty(text)) {  //当有文字的时候就存入数据库
            data.setRecord(text);
            data.setPosition(POSITION);
            dataDao.insert(data);
        }
    }

    //全部清空记录
    @Override
    public void onClick(View v) {
        dataDao.deleteAll();
        recordListView.setVisibility(View.GONE);
    }
//    这个  历史记录的条目的监听
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String data=beanList.get(position).getRecord();
        connectionNetWork(data);
        recordListView.setVisibility(View.GONE);
    }

//    ---------------recordlist的适配器

    class RecordAdapter extends CommonAdapter<SearchData> {
        private List<SearchData> list;

        public RecordAdapter(Context context, int layoutId, List<SearchData> list) {
            super(context, layoutId, list);
            this.list = list;
        }

        @Override
        public void convert(ViewHolderM holderM, final SearchData bean) {
            TextView tv_search = (TextView) holderM.getView(R.id.tv_search_record);
            tv_search.setText(bean.getRecord());
            ImageView iv_delete = (ImageView) holderM.getView(R.id.iv_search_delete);
            final int position = holderM.getPosition();
            iv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                     取得当前data对象，
                    SearchData data = beanList.get(position);
//                      删除对象的同时更新条目
                    beanList.remove(position);
                    recordAdapter.notifyDataSetChanged();
                    dataDao.delete(data);
//                     如果删除完了数据 没有数据了
                    if (beanList.isEmpty()) {
                        recordListView.setVisibility(View.GONE);
                    }
                }
            });
        }
    }


}
