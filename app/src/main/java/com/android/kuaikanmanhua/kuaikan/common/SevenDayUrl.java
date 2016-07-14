package com.android.kuaikanmanhua.kuaikan.common;

/**
 * Created by hao on 2016/7/13.
 */
public class SevenDayUrl {

    public static final String DAY_START =
            "http://api.kuaikanmanhua.com/v1/daily/comic_lists/";

    public static final String DAY_END = "?since=0";

    public static final String URL_COMMENT_HOT="http://api.kuaikanmanhua.com/v1/feeds/feed_lists?uid=&since=&page_num=1&catalog_type=2";
    public static final String url_comment_RECENTLY_start="http://api.kuaikanmanhua.com/v1/feeds/feed_lists?uid=&since=&page_num=" ;
    public static final String url_comment_RECENTLY_end="&catalog_type=1";


    //这是评论热门链接
    public static final String getUrl_comment_hot_refresh="http://api.kuaikanmanhua.com/v1/feeds/feed_lists?uid=&since=29&page_num=4&catalog_type=2";
//这是下拉刷新链接

    // http://f1.kkmh.com/("images")-c.w750.jpg
    //这是评论链接json数据中图片的链接,用images对象数组里的大小写字母将上文链接中的("images")替换即可
    public static  final  String COMMENT_START="http://f1.kkmh.com/";
    public static  final  String COMMENT_END="-c.w750.jpg";
    public static final String URL_COMMENT_RECENTLY="http://api.kuaikanmanhua.com/v1/feeds/feed_lists?uid=&since=&page_num=1&catalog_type=1"  ;

//这是评论最新链接
}
