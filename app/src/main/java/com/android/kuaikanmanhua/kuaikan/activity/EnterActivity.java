package com.android.kuaikanmanhua.kuaikan.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.kuaikanmanhua.kuaikan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EnterActivity extends AppCompatActivity {
    @BindView(R.id.et_enter_show)
     EditText editText1;
    @BindView(R.id.et_enter_show1)
    EditText editText2;
    @BindView(R.id.iv_enter_show)
    ImageView imageview;
  @BindView(R.id.tv_enter_text)
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
        initListen();
    }

    private void initListen() {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EnterActivity.this,ForgetActivity.class);
                startActivity(intent);
            }
        });
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    imageview.setImageDrawable(getDrawable(R.drawable.ic_login_visible));
                }
            }
        });
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    imageview.setImageDrawable(getDrawable(R.drawable.ic_login_invisible));
                }
            }
        });
    }
  public void back(View v){
      finish();
  }
}
