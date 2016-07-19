package com.android.kuaikanmanhua.kuaikan.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by my on 2016/7/13.
 */
public class ExceptAdvert {



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

    public static class DataBean implements Serializable{
        /**
         * action : topic_lists/4
         * title : 人气飙升
         * topics : [{"comics_count":43,"cover_image_url":"http://i.kuaikanmanhua.com/image/160525/wnamh09of.webp-w640","created_at":1442563580,"description":"一个长相普通的职场女青年，无意中下载了一个整容APP...初尝了变美的禁果，从此踏上了一条不归路\u2014\u2014【独家/每周六更新  责编：Nico】","discover_image_url":null,"id":544,"is_favourite":false,"label_id":17,"order":400,"title":"整容游戏","updated_at":1442563580,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/150918/jdla02iby.jpg-w180","grade":1,"id":2967943,"nickname":"金丘","pub_feed":1,"reg_type":"author"},"user_id":2967943,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160525/fw0n148vi.webp-w320"},{"comics_count":11,"cover_image_url":"http://i.kuaikanmanhua.com/image/160511/u3t0xpufz.webp-w640","created_at":1462964844,"description":"【独家/每周五更新，责编：哑铃lynn】一个是容易害羞的胆小鬼，一个是粗线条的马大哈，听起来一点都不靠谱的两个人却走到了一起\u2026\u2026【每个人都或多或少有着缺点，但是爱我们的人都一并接受了。四个故事，八种心情，一个心意。感谢对方，一直都爱着不完美我们。】","discover_image_url":"http://i.kuaikanmanhua.com/image/160513/gbkbj1mgr.webp-w750","id":799,"is_favourite":false,"label_id":19,"order":300,"title":"胆小鬼与马大哈-《感谢你是爱我的》系列1","updated_at":1462964844,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/150421/1w2wtds1e.jpg-w180","grade":1,"id":48,"nickname":"张三三","pub_feed":1,"reg_type":"weibo"},"user_id":48,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160511/yjddmjysh.webp-w320"},{"comics_count":10,"cover_image_url":"http://i.kuaikanmanhua.com/image/160613/orlfirbig.webp-w640","created_at":1462944148,"description":"毫无女性魅力的体育女胡湘与喜欢的学长约定考入同一所高中，好不容易变身女神的她遇到了看起来像不良少年的陆江陵，让她从女神形象瞬间变成了不良少女\u2026\u2026这可怎么办？学长会喜欢上胡湘吗？\r\n【独家/每周日更新 责编：林早上】","discover_image_url":null,"id":798,"is_favourite":false,"label_id":3,"order":300,"title":"不良诱惑","updated_at":1462944148,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/160511/wg1aieztt.webp-w180","grade":1,"id":12258499,"nickname":"郭晓/夏天岛+芹菜/夏天岛","pub_feed":0,"reg_type":"author"},"user_id":12258499,"vertical_image_url":"http://i.kuaikanmanhua.com/image/160511/cffc85y2f.webp-w320"},{"comics_count":38,"cover_image_url":"http://i.kuaikanmanhua.com/image/151015/so38e1jfs.jpg-w640","created_at":1444890430,"description":"关于夏天的那些事\u2014\u2014【独家/每周四更新  责编：Nico 】","discover_image_url":null,"id":568,"is_favourite":false,"label_id":3,"order":100,"title":"Sunday","updated_at":1444890430,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/151015/rbbbuqvjo.jpg-w180","grade":1,"id":3680043,"nickname":"光盐","pub_feed":1,"reg_type":"author"},"user_id":3680043,"vertical_image_url":"http://i.kuaikanmanhua.com/image/151015/w4uyuo51l.jpg-w320"}]
         * type : 0
         */

        private List<InfosBean> infos;

        public List<InfosBean> getInfos() {
            return infos;
        }

        public void setInfos(List<InfosBean> infos) {
            this.infos = infos;
        }

        public static class InfosBean implements Serializable{
            private String action;
            private String title;
            private int type;
            /**
             * comics_count : 43
             * cover_image_url : http://i.kuaikanmanhua.com/image/160525/wnamh09of.webp-w640
             * created_at : 1442563580
             * description : 一个长相普通的职场女青年，无意中下载了一个整容APP...初尝了变美的禁果，从此踏上了一条不归路——【独家/每周六更新  责编：Nico】
             * discover_image_url : null
             * id : 544
             * is_favourite : false
             * label_id : 17
             * order : 400
             * title : 整容游戏
             * updated_at : 1442563580
             * user : {"avatar_url":"http://i.kuaikanmanhua.com/image/150918/jdla02iby.jpg-w180","grade":1,"id":2967943,"nickname":"金丘","pub_feed":1,"reg_type":"author"}
             * user_id : 2967943
             * vertical_image_url : http://i.kuaikanmanhua.com/image/160525/fw0n148vi.webp-w320
             */

            private List<TopicsBean> topics;

            private List<BannersBean> banners;

            public List<BannersBean> getBanners() {
                return banners;
            }
            public void setBanners(List<BannersBean> banners) {
                this.banners = banners;
            }

            public static class BannersBean {
                private int id;
                private String pic;
                private int target_id;
                private String target_title;
                private int type;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public int getTarget_id() {
                    return target_id;
                }

                public void setTarget_id(int target_id) {
                    this.target_id = target_id;
                }

                public String getTarget_title() {
                    return target_title;
                }

                public void setTarget_title(String target_title) {
                    this.target_title = target_title;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
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
                private int id;
                private boolean is_favourite;
                private int label_id;
                private int order;
                private String title;
                private int updated_at;
                /**
                 * avatar_url : http://i.kuaikanmanhua.com/image/150918/jdla02iby.jpg-w180
                 * grade : 1
                 * id : 2967943
                 * nickname : 金丘
                 * pub_feed : 1
                 * reg_type : author
                 */

                private UserBean user;
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

                public String getDiscover_image_url() {
                    return (String) discover_image_url;
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

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
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

                public static class UserBean implements Serializable{
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
}
