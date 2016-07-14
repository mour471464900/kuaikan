package com.android.kuaikanmanhua.kuaikan.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/14.
 */
public class ClassifyBean {

    /**
     * code : 200
     * data : {"suggestion":[{"icon":"http://i.kuaikanmanhua.com/image/150814/4z3820v4q.jpg-w200","priority":14,"tag_id":35,"title":"优秀新连载"},{"icon":"http://i.kuaikanmanhua.com/image/160121/svg40hk77.webp-w200","priority":13,"tag_id":43,"title":"短篇"},{"icon":"http://i.kuaikanmanhua.com/image/150814/u3rlucjlc.jpg-w200","priority":12,"tag_id":40,"title":"已完结"},{"icon":"http://i.kuaikanmanhua.com/image/160129/6m6q0mvn4.webp-w200","priority":12,"tag_id":44,"title":"男性"},{"icon":"http://i.kuaikanmanhua.com/image/160129/gm75bclrm.webp-w200","priority":11,"tag_id":20,"title":"恋爱"},{"icon":"http://i.kuaikanmanhua.com/image/160129/kq952jf8m.webp-w200","priority":10,"tag_id":24,"title":"爆笑"},{"icon":"http://i.kuaikanmanhua.com/image/160129/102ox7c1s.webp-w200","priority":9,"tag_id":36,"title":"耽美"},{"icon":"http://i.kuaikanmanhua.com/image/160129/g35mvygkf.webp-w200","priority":7,"tag_id":32,"title":"恐怖"},{"icon":"http://i.kuaikanmanhua.com/image/150725/cphc71alz.jpg-w200","priority":6,"tag_id":23,"title":"剧情"},{"icon":"http://i.kuaikanmanhua.com/image/150814/4zm6oizjg.jpg-w200","priority":5,"tag_id":19,"title":"日常"},{"icon":"http://i.kuaikanmanhua.com/image/150818/lckq0ru88.jpg-w200","priority":4,"tag_id":41,"title":"三次元"},{"icon":"http://i.kuaikanmanhua.com/image/150814/37eve1rks.jpg-w200","priority":2,"tag_id":27,"title":"治愈"},{"icon":"http://i.kuaikanmanhua.com/image/150814/n0phbeeis.jpg-w200","priority":1,"tag_id":31,"title":"百合"},{"icon":"http://i.kuaikanmanhua.com/image/150814/1irpwz4nx.jpg-w200","priority":1,"tag_id":22,"title":"奇幻"},{"icon":"http://i.kuaikanmanhua.com/image/160121/9o902bw0x.webp-w200","priority":0,"tag_id":42,"title":"古风"}]}
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
         * icon : http://i.kuaikanmanhua.com/image/150814/4z3820v4q.jpg-w200
         * priority : 14
         * tag_id : 35
         * title : 优秀新连载
         */

        private List<SuggestionBean> suggestion;

        public List<SuggestionBean> getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(List<SuggestionBean> suggestion) {
            this.suggestion = suggestion;
        }

        public static class SuggestionBean {
            private String icon;
            private int priority;
            private int tag_id;
            private String title;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public int getTag_id() {
                return tag_id;
            }

            public void setTag_id(int tag_id) {
                this.tag_id = tag_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
