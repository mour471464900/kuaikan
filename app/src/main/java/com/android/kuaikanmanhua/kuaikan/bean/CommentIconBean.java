package com.android.kuaikanmanhua.kuaikan.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MBENBEN on 2016/7/16.
 */
public class CommentIconBean implements Serializable {

    /**
     * code : 200
     * data : {"avatar_url":"http://i.kuaikanmanhua.com/image/150909/2mhrfvfbb.jpg-w180","bind_phone":13426050127,"follower_cnt":2,"following":false,"grade":1,"id":2798975,"intro":"勇敢川尚雷酷！！！！！继续努力！！！用心吃饭！！！！！！(Â´༎ຶ皿༎ຶ)و！！！！！！","nickname":"小野酵母","pub_feed":1,"reg_type":"author","reply_remind_flag":0,"topics":[{"comics_count":47,"cover_image_url":"http://i.kuaikanmanhua.com/image/151124/t2nujokde.jpg-w640","created_at":1443725876,"description":"爆笑➕励志，完全不一样的感人漫画，让聚光灯和尖叫为你诠释钢管舞的魅力。【独家/每周六更新  责编：林早上】","discover_image_url":null,"id":559,"is_favourite":false,"label_id":5,"order":500,"title":"钢管猛男","updated_at":1443725876,"user_id":2798975,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160304/9xs1dalp1.webp-w320.w"},{"comics_count":5,"cover_image_url":"http://i.kuaikanmanhua.com/image/151019/xnb3tyehb.jpg-w640","created_at":1445225553,"description":"一个戴假面的男子一个个奇怪的任务...【授权/完结  责编：胡辣瞎】","discover_image_url":null,"id":574,"is_favourite":false,"label_id":1,"order":0,"title":"假面人生","updated_at":1445225553,"user_id":2798975,"vertical_image_url":"http://i.kuaikanmanhua.com/image/151019/7srsyr0dd.jpg-w320"},{"comics_count":2,"cover_image_url":"http://i.kuaikanmanhua.com/image/150919/on9ojsff1.jpg-w640","created_at":1442654330,"description":"因为多项身体条件不合格，屡次报考警队失败的三流侦探吴泷遇到了传说中暗杀者学院，他能否抓住凶手呢？【授权/暂停更新  责编：胡辣瞎】","discover_image_url":null,"id":547,"is_favourite":false,"label_id":1,"order":0,"title":"暗杀者学院","updated_at":1442654330,"user_id":2798975,"vertical_image_url":"http://i.kuaikanmanhua.com/image/150919/xfg5tykl6.jpg-w320"}],"u_intro":"认证：漫画作者，代表作《钢管猛男》《假面人生》","update_remind_flag":1,"weibo":"http://weibo.com/ononoimoko","weibo_name":"小野Onono"}
     * message : OK
     */

    private int code;
    /**
     * avatar_url : http://i.kuaikanmanhua.com/image/150909/2mhrfvfbb.jpg-w180
     * bind_phone : 13426050127
     * follower_cnt : 2
     * following : false
     * grade : 1
     * id : 2798975
     * intro : 勇敢川尚雷酷！！！！！继续努力！！！用心吃饭！！！！！！(Â´༎ຶ皿༎ຶ)و！！！！！！
     * nickname : 小野酵母
     * pub_feed : 1
     * reg_type : author
     * reply_remind_flag : 0
     * topics : [{"comics_count":47,"cover_image_url":"http://i.kuaikanmanhua.com/image/151124/t2nujokde.jpg-w640","created_at":1443725876,"description":"爆笑➕励志，完全不一样的感人漫画，让聚光灯和尖叫为你诠释钢管舞的魅力。【独家/每周六更新  责编：林早上】","discover_image_url":null,"id":559,"is_favourite":false,"label_id":5,"order":500,"title":"钢管猛男","updated_at":1443725876,"user_id":2798975,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160304/9xs1dalp1.webp-w320.w"},{"comics_count":5,"cover_image_url":"http://i.kuaikanmanhua.com/image/151019/xnb3tyehb.jpg-w640","created_at":1445225553,"description":"一个戴假面的男子一个个奇怪的任务...【授权/完结  责编：胡辣瞎】","discover_image_url":null,"id":574,"is_favourite":false,"label_id":1,"order":0,"title":"假面人生","updated_at":1445225553,"user_id":2798975,"vertical_image_url":"http://i.kuaikanmanhua.com/image/151019/7srsyr0dd.jpg-w320"},{"comics_count":2,"cover_image_url":"http://i.kuaikanmanhua.com/image/150919/on9ojsff1.jpg-w640","created_at":1442654330,"description":"因为多项身体条件不合格，屡次报考警队失败的三流侦探吴泷遇到了传说中暗杀者学院，他能否抓住凶手呢？【授权/暂停更新  责编：胡辣瞎】","discover_image_url":null,"id":547,"is_favourite":false,"label_id":1,"order":0,"title":"暗杀者学院","updated_at":1442654330,"user_id":2798975,"vertical_image_url":"http://i.kuaikanmanhua.com/image/150919/xfg5tykl6.jpg-w320"}]
     * u_intro : 认证：漫画作者，代表作《钢管猛男》《假面人生》
     * update_remind_flag : 1
     * weibo : http://weibo.com/ononoimoko
     * weibo_name : 小野Onono
     */

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

    public static class DataBean implements Serializable{
        private String avatar_url;
        private long bind_phone;
        private int follower_cnt;
        private boolean following;
        private int grade;

        @Override
        public String toString() {
            return "DataBean{" +
                    "avatar_url='" + avatar_url + '\'' +
                    ", bind_phone=" + bind_phone +
                    ", follower_cnt=" + follower_cnt +
                    ", following=" + following +
                    ", grade=" + grade +
                    ", id=" + id +
                    ", intro='" + intro + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", pub_feed=" + pub_feed +
                    ", reg_type='" + reg_type + '\'' +
                    ", reply_remind_flag=" + reply_remind_flag +
                    ", u_intro='" + u_intro + '\'' +
                    ", update_remind_flag=" + update_remind_flag +
                    ", weibo='" + weibo + '\'' +
                    ", weibo_name='" + weibo_name + '\'' +
                    ", topics=" + topics +
                    '}';
        }

        private int id;
        private String intro;
        private String nickname;
        private int pub_feed;
        private String reg_type;
        private int reply_remind_flag;
        private String u_intro;
        private int update_remind_flag;
        private String weibo;
        private String weibo_name;
        /**
         * comics_count : 47
         * cover_image_url : http://i.kuaikanmanhua.com/image/151124/t2nujokde.jpg-w640
         * created_at : 1443725876
         * description : 爆笑➕励志，完全不一样的感人漫画，让聚光灯和尖叫为你诠释钢管舞的魅力。【独家/每周六更新  责编：林早上】
         * discover_image_url : null
         * id : 559
         * is_favourite : false
         * label_id : 5
         * order : 500
         * title : 钢管猛男
         * updated_at : 1443725876
         * user_id : 2798975
         * vertical_image_url : http://i.kuaikanmanhua.com/image/160304/9xs1dalp1.webp-w320.w
         */

        private List<TopicsBean> topics;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public long getBind_phone() {
            return bind_phone;
        }

        public void setBind_phone(long bind_phone) {
            this.bind_phone = bind_phone;
        }

        public int getFollower_cnt() {
            return follower_cnt;
        }

        public void setFollower_cnt(int follower_cnt) {
            this.follower_cnt = follower_cnt;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getPub_feed() {
            return pub_feed;
        }

        public void setPub_feed(int pub_feed) {
            this.pub_feed = pub_feed;
        }

        public String getReg_type() {
            return reg_type;
        }

        public void setReg_type(String reg_type) {
            this.reg_type = reg_type;
        }

        public int getReply_remind_flag() {
            return reply_remind_flag;
        }

        public void setReply_remind_flag(int reply_remind_flag) {
            this.reply_remind_flag = reply_remind_flag;
        }

        public String getU_intro() {
            return u_intro;
        }

        public void setU_intro(String u_intro) {
            this.u_intro = u_intro;
        }

        public int getUpdate_remind_flag() {
            return update_remind_flag;
        }

        public void setUpdate_remind_flag(int update_remind_flag) {
            this.update_remind_flag = update_remind_flag;
        }

        public String getWeibo() {
            return weibo;
        }

        public void setWeibo(String weibo) {
            this.weibo = weibo;
        }

        public String getWeibo_name() {
            return weibo_name;
        }

        public void setWeibo_name(String weibo_name) {
            this.weibo_name = weibo_name;
        }

        public List<TopicsBean> getTopics() {
            return topics;
        }

        public void setTopics(List<TopicsBean> topics) {
            this.topics = topics;
        }

        public static class TopicsBean implements Serializable{
            private int comics_count;
            private String cover_image_url;
            private int created_at;
            private String description;
            private Object discover_image_url;

            @Override
            public String toString() {
                return "TopicsBean{" +
                        "comics_count=" + comics_count +
                        ", cover_image_url='" + cover_image_url + '\'' +
                        ", created_at=" + created_at +
                        ", description='" + description + '\'' +
                        ", discover_image_url=" + discover_image_url +
                        ", id=" + id +
                        ", is_favourite=" + is_favourite +
                        ", label_id=" + label_id +
                        ", order=" + order +
                        ", title='" + title + '\'' +
                        ", updated_at=" + updated_at +
                        ", user_id=" + user_id +
                        ", vertical_image_url='" + vertical_image_url + '\'' +
                        '}';
            }

            private int id;
            private boolean is_favourite;
            private int label_id;
            private int order;
            private String title;
            private int updated_at;
            private int user_id;
            private String vertical_image_url;

            public int getComics_count() {
                return comics_count;
            }

            public void setComics_count(int comics_count) {
                this.comics_count = comics_count;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getDiscover_image_url() {
                return discover_image_url;
            }

            public void setDiscover_image_url(Object discover_image_url) {
                this.discover_image_url = discover_image_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIs_favourite() {
                return is_favourite;
            }

            public void setIs_favourite(boolean is_favourite) {
                this.is_favourite = is_favourite;
            }

            public int getLabel_id() {
                return label_id;
            }

            public void setLabel_id(int label_id) {
                this.label_id = label_id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getVertical_image_url() {
                return vertical_image_url;
            }

            public void setVertical_image_url(String vertical_image_url) {
                this.vertical_image_url = vertical_image_url;
            }
        }
    }
}
