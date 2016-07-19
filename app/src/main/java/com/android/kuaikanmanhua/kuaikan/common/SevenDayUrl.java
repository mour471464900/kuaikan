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

    //热门跳转后的链接
 //   http://api.kuaikanmanhua.com/v1/comments/feed/16386219085176832/order/time?offset=0&limit=20
public static final String  COMMENT_START_HOT_CONTEXT ="http://api.kuaikanmanhua.com/v1/comments/feed/";
    public static final String  COMMENT_END_HOT_CONTEXT="/order/time?offset=0&limit=20";



  // "http://api.kuaikanmanhua.com/v1/users/6638304";
  public static final String comment_icon_datum ="http://api.kuaikanmanhua.com/v1/users/";
//这是点击图像后跳转进来的链接
//    http://api.kuaikanmanhua.com/v1/feeds/feed_lists?uid=13278865&since=13718771437449216&page_num=2&catalog_type=3
public static final String comment_icon_dynamic_start="http://api.kuaikanmanhua.com/v1/feeds/feed_lists?uid=";
  // public static final String comment_icon_dynamic_second="&since=";
    public static final String comment_icon_dynamic_end="&since=&page_num=2&catalog_type=3";
//这首点击图像后跳转进来的动态链接


 // public static final String works="http://api.kuaikanmanhua.com/v1/topics/799?sort=0"  ;
 public static final String works_start="http://api.kuaikanmanhua.com/v1/topics/";
    public static final String works_end="?sort=0";


    //搜索
    // http://api.kuaikanmanhua.com/v1/topics/search?keyword=神&offset=0&limit=20
public static final String SEARCH_START="http://api.kuaikanmanhua.com/v1/topics/search?keyword=";
    public static final String SEARCH_END="&offset=0&limit=20";
}
