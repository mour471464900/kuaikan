package com.android.kuaikanmanhua.kuaikan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.kuaikanmanhua.kuaikan.R;

public class ForgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
    }
    public void back(View view){
        finish();
    }
}
