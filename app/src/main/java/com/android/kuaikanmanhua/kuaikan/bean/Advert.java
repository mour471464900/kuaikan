package com.android.kuaikanmanhua.kuaikan.bean;

import java.util.List;

/**
 * Created by my on 2016/7/13.
 */
public class Advert {

    /**
     * code : 200
     * data : {"banner_group":[{"pic":"http://i.kuaikanmanhua.com/image/160710/9s3nnlcay.webp-w640","title":"","type":3,"value":"13880"},{"pic":"http://i.kuaikanmanhua.com/image/160712/icxu6sndd.webp-w640","title":"","type":3,"value":"9576"},{"pic":"http://i.kuaikanmanhua.com/image/160712/okxgejxtq.webp-w640","title":"","type":3,"value":"13116"},{"pic":"http://i.kuaikanmanhua.com/image/160712/7jrku4egd.webp-w640","title":"","type":3,"value":"13630"},{"pic":"http://i.kuaikanmanhua.com/image/160709/m0og34kgb.webp-w640","title":"","type":1,"value":"http://tb.cn/POINT?backurl=https://detail.tmall.com/item.htm?id=534624899705&amp;spm=a310v.4.88.1"},{"pic":"http://i.kuaikanmanhua.com/image/160707/ghkujmssd.webp-w640","title":"","type":3,"value":"13765"}]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * pic : http://i.kuaikanmanhua.com/image/160710/9s3nnlcay.webp-w640
         * title :
         * type : 3
         * value : 13880
         */

        private List<BannerGroupBean> banner_group;

        public List<BannerGroupBean> getBanner_group() {
            return banner_group;
        }

        public void setBanner_group(List<BannerGroupBean> banner_group) {
            this.banner_group = banner_group;
        }

        public static class BannerGroupBean {
            private String pic;
            private String title;
            private int type;
            private String value;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
