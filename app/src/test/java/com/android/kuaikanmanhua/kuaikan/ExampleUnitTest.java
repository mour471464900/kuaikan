package com.android.kuaikanmanhua.kuaikan;

import com.android.kuaikanmanhua.kuaikan.bean.CommentHotContextBean;
import com.android.kuaikanmanhua.kuaikan.common.SevenDayUrl;
import com.android.kuaikanmanhua.kuaikan.fragment.MainUpdateFragment;
import com.android.kuaikanmanhua.kuaikan.util.HttpUtil;
import com.android.kuaikanmanhua.kuaikan.util.HttpUtilNow;
import com.android.kuaikanmanhua.kuaikan.util.URLConstants;
import com.google.gson.Gson;
import com.mob.tools.utils.Data;

import org.junit.Test;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public  void  time() throws Exception{

      long oneDay= (new Date().getTime()-24*60*60*1000*3)/1000;
        System.out.println(oneDay);
    }


}