package com.android.kuaikanmanhua.kuaikan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hao on 2016/7/23.
 */
public class LoginMyActivity extends AppCompatActivity {
    @BindView(R.id.et_enter_show)
    EditText editText1;
    @BindView(R.id.et_enter_show1)
    EditText editText2;
    @BindView(R.id.iv_enter_show)
    ImageView imageview;
    @BindView(R.id.tv_enter_text)
    TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initListen();
    }

    private void initListen() {
//         忘记密码就进入注册页面
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginMyActivity.this,ForgetActivity.class);
                startActivity(intent);
            }
        });
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
//                    当焦点在账号的时候就是初始的图片
                    imageview.setImageDrawable(getDrawable(R.drawable.ic_login_visible));
                }
            }
        });
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
//                    当焦点在密码的时候就是亲亲的照片
                    imageview.setImageDrawable(getDrawable(R.drawable.ic_login_invisible));
                }
            }
        });
    }

    public void back(View v){
        finish();
    }
}
