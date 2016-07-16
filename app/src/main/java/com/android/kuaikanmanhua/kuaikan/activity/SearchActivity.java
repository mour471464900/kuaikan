package com.android.kuaikanmanhua.kuaikan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.android.kuaikanmanhua.kuaikan.R;

public class SearchActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    public void onCancel(View view){
        finish();
    }
}
