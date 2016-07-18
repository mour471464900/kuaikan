package com.android.kuaikanmanhua.kuaikan.bean;

import java.util.List;

/**
 * Created by hao on 2016/7/16.
 * 这个是，观看漫画，把 comic id
 */
public class FullWatchBean {

    /**
     * banner_info : {"type":0}
     * comments_count : 13652
     * cover_image_url : http://i.kuaikanmanhua.com/image/160714/f1u2u1b8a.webp-w640
     * created_at : 1468533003
     * id : 14133
     * images : ["http://i.kuaikanmanhua.com/image/160714/ogu07m6yn.webp-w640","http://i.kuaikanmanhua.com/image/160714/1yjb4yvqi.webp-w640","http://i.kuaikanmanhua.com/image/160714/c3l48sh18.webp-w640","http://i.kuaikanmanhua.com/image/160714/gq0ic3n6j.webp-w640","http://i.kuaikanmanhua.com/image/160714/209fhe1ul.webp-w640","http://i.kuaikanmanhua.com/image/160714/nm6ooix4s.webp-w640","http://i.kuaikanmanhua.com/image/160714/1fcgw7nh9.webp-w640","http://i.kuaikanmanhua.com/image/160714/t61s1csvu.webp-w640","http://i.kuaikanmanhua.com/image/160714/15755cvmp.webp-w640","http://i.kuaikanmanhua.com/image/160714/gfh56g4e1.webp-w640","http://i.kuaikanmanhua.com/image/160714/ppxscolmv.webp-w640","http://i.kuaikanmanhua.com/image/160714/xofwlelk5.webp-w640","http://i.kuaikanmanhua.com/image/160714/41o75po0u.webp-w640","http://i.kuaikanmanhua.com/image/160714/th7u9sg0n.webp-w640","http://i.kuaikanmanhua.com/image/160714/s96d4q473.webp-w640","http://i.kuaikanmanhua.com/image/160714/ues4jntay.webp-w640","http://i.kuaikanmanhua.com/image/160714/0fc8zmboc.webp-w640","http://i.kuaikanmanhua.com/image/160714/08brna6hw.webp-w640","http://i.kuaikanmanhua.com/image/160714/rwswhy6xy.webp-w640","http://i.kuaikanmanhua.com/image/160714/7tdfvt1zl.webp-w640","http://i.kuaikanmanhua.com/image/160714/t4iq0aurk.webp-w640","http://i.kuaikanmanhua.com/image/160714/is3gnm299.webp-w640","http://i.kuaikanmanhua.com/image/160714/p0gfaj72u.webp-w640","http://i.kuaikanmanhua.com/image/160714/5afy3sepd.webp-w640","http://i.kuaikanmanhua.com/image/160714/3kysijxzt.webp-w640","http://i.kuaikanmanhua.com/image/160714/hk379aiyq.webp-w640","http://i.kuaikanmanhua.com/image/160714/01oadhwg0.webp-w640","http://i.kuaikanmanhua.com/image/160714/00ngq45h0.webp-w640","http://i.kuaikanmanhua.com/image/160714/83qovl8uo.webp-w640","http://i.kuaikanmanhua.com/image/160714/6x4n1mrit.webp-w640","http://i.kuaikanmanhua.com/image/160714/pmiewc1sd.webp-w640","http://i.kuaikanmanhua.com/image/160714/f1s790fha.webp-w640","http://i.kuaikanmanhua.com/image/160714/aav9wnblt.webp-w640","http://i.kuaikanmanhua.com/image/160714/mvt5d4026.webp-w640","http://i.kuaikanmanhua.com/image/160714/982mh18qp.webp-w640","http://i.kuaikanmanhua.com/image/160714/a1y6h0unc.webp-w640","http://i.kuaikanmanhua.com/image/160714/886dj295n.webp-w640","http://i.kuaikanmanhua.com/image/160714/1o8f1kmd4.webp-w640","http://i.kuaikanmanhua.com/image/160714/5r1gh3qab.webp-w640","http://i.kuaikanmanhua.com/image/160714/b7y7ruvmm.webp-w640","http://i.kuaikanmanhua.com/image/160714/mwri59ofu.webp-w640","http://i.kuaikanmanhua.com/image/160714/te800902u.webp-w640","http://i.kuaikanmanhua.com/image/160714/05vofhyr3.webp-w640","http://i.kuaikanmanhua.com/image/160714/18u4zsje5.webp-w640","http://i.kuaikanmanhua.com/image/160714/v2uwrquoh.webp-w640","http://i.kuaikanmanhua.com/image/160714/fqlhowsl3.webp-w640","http://i.kuaikanmanhua.com/image/160714/l5abvztsk.webp-w640","http://i.kuaikanmanhua.com/image/160714/dl7mjbudq.webp-w640","http://i.kuaikanmanhua.com/image/160714/rmght69t8.webp-w640","http://i.kuaikanmanhua.com/image/160714/0d4wyomlm.webp-w640","http://i.kuaikanmanhua.com/image/160714/qma2rrv4e.webp-w640","http://i.kuaikanmanhua.com/image/160714/byavy24ha.webp-w640","http://i.kuaikanmanhua.com/image/160714/716wkdy8l.webp-w640","http://i.kuaikanmanhua.com/image/160714/sn8ve1mkk.webp-w640","http://i.kuaikanmanhua.com/image/160714/yeajz033g.webp-w640","http://i.kuaikanmanhua.com/image/160714/4v1p2lje4.webp-w640","http://i.kuaikanmanhua.com/image/160714/ot32j93dl.webp-w640","http://i.kuaikanmanhua.com/image/160714/3zy2lqwqb.webp-w640","http://i.kuaikanmanhua.com/image/160714/t40ws2c0e.webp-w640","http://i.kuaikanmanhua.com/image/160714/qcua8z4ft.webp-w640","http://i.kuaikanmanhua.com/image/160714/bihqlwual.webp-w640","http://i.kuaikanmanhua.com/image/160714/voykf4zvo.webp-w640","http://i.kuaikanmanhua.com/image/160714/9zhzgm3qz.webp-w640","http://i.kuaikanmanhua.com/image/160714/5wmz0fxfq.webp-w640","http://i.kuaikanmanhua.com/image/160714/qpt5pav6f.webp-w640","http://i.kuaikanmanhua.com/image/160714/tiqcdjvi4.webp-w640","http://i.kuaikanmanhua.com/image/160714/eqrwodq7s.webp-w640","http://i.kuaikanmanhua.com/image/160714/ht778ln6u.webp-w640","http://i.kuaikanmanhua.com/image/160714/jmsg07h1a.webp-w640","http://i.kuaikanmanhua.com/image/160714/84jk6mh3r.webp-w640","http://i.kuaikanmanhua.com/image/160714/oy73ltpe8.webp-w640"]
     * is_favourite : false
     * is_liked : false
     * likes_count : 330840
     * next_comic_id : null
     * previous_comic_id : 13956
     * push_flag : 0
     * recommend_count : 0
     * status : published
     * title : 第47话 我会追回你的！
     * topic : {"comics_count":48,"cover_image_url":"http://i.kuaikanmanhua.com/image/160318/gcldgycnr.webp-w640","created_at":1435225130,"description":"27岁的杜瑞拉自己开了一家摄影工作室，至今单身的她会遇到属于自己的白马王子吗？【独家/每周五更新  责编：林早上】","discover_image_url":null,"id":338,"label_id":11,"order":500,"title":"十二点的灰姑娘","updated_at":1435225130,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/150421/k62wy6wmt.jpg-w180","grade":1,"id":32,"nickname":"栗子liz","pub_feed":1,"reg_type":"weibo"},"vertical_image_url":"http://i.kuaikanmanhua.com/image/151222/927zahhkt.webp-w320"}
     * updated_at : 1468494627
     * url : http://www.kuaikanmanhua.com/comics/14133
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : 0
         */

        private BannerInfoBean banner_info;
        private int comments_count;
        private String cover_image_url;
        private int created_at;
        private int id;
        private boolean is_favourite;
        private boolean is_liked;
        private int likes_count;
//           下一篇
        private int next_comic_id;
        private int previous_comic_id;
//        主要的   上一篇
        private int push_flag;
        private int recommend_count;
        private String status;
        private String title;
        /**
         * comics_count : 48
         * cover_image_url : http://i.kuaikanmanhua.com/image/160318/gcldgycnr.webp-w640
         * created_at : 1435225130
         * description : 27岁的杜瑞拉自己开了一家摄影工作室，至今单身的她会遇到属于自己的白马王子吗？【独家/每周五更新  责编：林早上】
         * discover_image_url : null
         * id : 338
         * label_id : 11
         * order : 500
         * title : 十二点的灰姑娘
         * updated_at : 1435225130
         * user : {"avatar_url":"http://i.kuaikanmanhua.com/image/150421/k62wy6wmt.jpg-w180","grade":1,"id":32,"nickname":"栗子liz","pub_feed":1,"reg_type":"weibo"}
         * vertical_image_url : http://i.kuaikanmanhua.com/image/151222/927zahhkt.webp-w320
         */
        private TopicBean topic;
        private int updated_at;
        private String url;
        private List<String> images;

        public BannerInfoBean getBanner_info() {
            return banner_info;
        }

        public void setBanner_info(BannerInfoBean banner_info) {
            this.banner_info = banner_info;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
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

        public boolean isIs_liked() {
            return is_liked;
        }

        public void setIs_liked(boolean is_liked) {
            this.is_liked = is_liked;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }
//     下一篇
        public int getNext_comic_id() {
            return next_comic_id;
        }

        public void setNext_comic_id(int next_comic_id) {
            this.next_comic_id = next_comic_id;
        }

        public int getPrevious_comic_id() {
            return previous_comic_id;
        }

        public void setPrevious_comic_id(int previous_comic_id) {
            this.previous_comic_id = previous_comic_id;
        }
//      上篇
        public int getPush_flag() {
            return push_flag;
        }

        public void setPush_flag(int push_flag) {
            this.push_flag = push_flag;
        }

        public int getRecommend_count() {
            return recommend_count;
        }

        public void setRecommend_count(int recommend_count) {
            this.recommend_count = recommend_count;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public TopicBean getTopic() {
            return topic;
        }

        public void setTopic(TopicBean topic) {
            this.topic = topic;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public static class BannerInfoBean {
            private int type;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class TopicBean {
            private int comics_count;
            private String cover_image_url;
            private int created_at;
            private String description;
            private Object discover_image_url;
            private int id;
            private int label_id;
            private int order;
            private String title;
            private int updated_at;
            /**
             * avatar_url : http://i.kuaikanmanhua.com/image/150421/k62wy6wmt.jpg-w180
             * grade : 1
             * id : 32
             * nickname : 栗子liz
             * pub_feed : 1
             * reg_type : weibo
             */

            private UserBean user;
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

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public String getVertical_image_url() {
                return vertical_image_url;
            }

            public void setVertical_image_url(String vertical_image_url) {
                this.vertical_image_url = vertical_image_url;
            }

            public static class UserBean {
                private String avatar_url;
                private int grade;
                private int id;
                private String nickname;
                private int pub_feed;
                private String reg_type;

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
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
            }
        }
    }
}
