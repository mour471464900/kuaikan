package com.android.kuaikanmanhua.kuaikan.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/20.
 *
 *  传 bandle 的bean类
 *
 */
public class HelpBean implements Serializable{
    private  int id;
    private  String title;

    public HelpBean(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
