package com.android.kuaikanmanhua.kuaikan.util;

/**
 * 这个类是作品Fragment的API
 */
public class URLConstants {
    //广告
    public static final String URL_BANNER = "http://api.kuaikanmanhua.com/v1/banners";

    //热门除了广告外的
    public static final String URL_OTHER = "http://api.kuaikanmanhua.com/v1/topic_lists/mixed/new";

    //热门界面条目箭头的点击
    public static final String URL_PRO_ARRAY_START="http://api.kuaikanmanhua.com/v1/topic_lists/";
    public static final String URL_PRO_ARRAY_END="?offset=0";
    //分类
    public static final String URL_CLASSIFY = "http://api.kuaikanmanhua.com/v1/tag/suggestion";
    //分类的点击
    public static final String URL_CLASSIFYINFO = "http://api.kuaikanmanhua.com/v1/topics?offset=0&limit=20&tag=";


//  http://api.kuaikanmanhua.com/v1/comics/14133/hot_comments
//     这是看漫画的页面的  下面的评论

//    http://api.kuaikanmanhua.com/v1/comics/14133
//    这是  看漫画的主要页面

    public static final String URL_FULL_WATCH = "http://api.kuaikanmanhua.com/v1/comics/";
    //       这个是跳转到看漫画的内容的主要  呈现图片的 界面
    public static final String URL_FULL_COMMENT_START = "http://api.kuaikanmanhua.com/v1/comics/";
    //    这个是热门评论的界面
    public static final String URL_FULL_COMMENT_END = "/hot_comments";


    //    最新评论
    public static final String URL_ZUI_RE_START = "http://api.kuaikanmanhua.com/v1/comics/";
    public static final String URL_ZUI_RE_END = "/comments/0?order=";
//  http://api.kuaikanmanhua.com/v1/comics/14213/comments/0?order=

    //    最热评论
    public static final String URL_ZUI_XING_START = "http://api.kuaikanmanhua.com/v1/comics/";
    public static final String URL_ZUI_XING_END = "/comments/0?order=score";
//    http://api.kuaikanmanhua.com/v1/comics/14213/comments/0?order=score
//    作品的详情
//    http://api.kuaikanmanhua.com/v1/topics/363?sort=0
    public static final String URL_OPUS_START="http://api.kuaikanmanhua.com/v1/topics/";
    public static final String URL_OPUS_END="?sort=0";

}
