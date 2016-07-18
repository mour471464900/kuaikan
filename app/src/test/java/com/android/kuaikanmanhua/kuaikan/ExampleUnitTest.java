package com.android.kuaikanmanhua.kuaikan;

import com.android.kuaikanmanhua.kuaikan.bean.CommentHotContextBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.fragment.MainUpdateFragment;
import com.android.kuaikanmanhua.kuaikan.util.HttpUtil;
import com.android.kuaikanmanhua.kuaikan.util.HttpUtilNow;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.google.gson.Gson;

import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String s = HttpUtilNow.get(URLConstants.URL_FULL_COMMENT_START + 14191 + URLConstants.URL_FULL_COMMENT_END);
        Gson gson=new Gson();
        CommentHotContextBean commentHotContextBean = gson.fromJson(s, CommentHotContextBean.class);
        System.out.println(commentHotContextBean);
    }
}