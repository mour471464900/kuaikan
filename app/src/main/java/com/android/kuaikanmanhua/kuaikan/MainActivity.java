package com.android.kuaikanmanhua.kuaikan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.kuaikanmanhua.kuaikan.activity.ContentActivity;
import com.android.kuaikanmanhua.kuaikan.activity.GuideActivity;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

//  这是主界面就是一张图片

public class MainActivity extends AppCompatActivity {


    private SharedPreferences  sp;
    private SharedPreferences.Editor editor;
    private Thread thread;
    public static final int SKIP_GUIDE = 1;
    public static final int SKIP_CONTENT = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("init", Context.MODE_PRIVATE);
        editor = sp.edit();
//       判断是否跳转引导页面
        thread = new Thread(runnable);
        thread.start();
    }

    //          耗时任务在子线程中进行
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            boolean isFirst = sp.getBoolean("isFirst", true);
            Message msg = Message.obtain();
            if (isFirst) {
                //Editor对象用于修改sharedpreference对象,修改完后必须提交事务，才能完成修改（参考数据库的事务处理）
                editor.putBoolean("isFirst", false);
                editor.commit();
                msg.what = SKIP_GUIDE;
            } else {
                msg.what = SKIP_CONTENT;
            }
            try {
                Thread.sleep(2*1000);
//               延时2秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handle.sendMessage(msg);
        }
    };

    //    用来判断跳转到那个页面
    private Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case SKIP_GUIDE:
                    Intent guideIntent = new Intent(MainActivity.this,GuideActivity.class);
                    startActivity(guideIntent);
                    finish();
                    break;
                case SKIP_CONTENT:
                    Intent mainIntent = new Intent(MainActivity.this, ContentActivity.class);
                    startActivity(mainIntent);
                    finish();
                    break;
            }
        }
    };
}
