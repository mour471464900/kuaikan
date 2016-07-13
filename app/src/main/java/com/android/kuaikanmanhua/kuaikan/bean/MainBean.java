package com.android.kuaikanmanhua.kuaikan.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * 这个是主页进去的
 */
public class MainBean implements Serializable {

    /**
     * comics : [{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160426/valzdprgh.webp-w320.w","description":"2016年度都市情爱大作，快看漫画携手知名漫画家柯小倾力巨献\r\n\u201c一辈子那么长，你会只爱一个人吗？\u201d【独家/每周三更新 责编：半石】","title":"密会情人","created_at":1461558235,"updated_at":1461558235,"order":600,"label_id":11,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160616/81rwrli9c.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"柯小","id":14776286},"cover_image_url":"http://i.kuaikanmanhua.com/image/160530/u3j98bcwf.webp-w750","id":782,"comics_count":12,"discover_image_url":null},"label_text":"都市","title":"第11话 不懂珍惜","url":"http://www.kuaikanmanhua.com/comics/14070","is_liked":false,"shared_count":0,"updated_at":1468330891,"id":14070,"push_flag":1,"info_type":0,"comments_count":13190,"label_color":"#b536e3","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/07unlyke8.webp-w750","label_text_color":"#ffffff","created_at":1468373421,"likes_count":556630},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160705/oonmpdthq.webp-w320.w","description":"一个是隐藏着龙族秘密的妖瞳美人，一个是混迹官场，曾遭师傅利用背叛的孤儿，两个男人在权利阴谋的漩涡中，展开的一段剪不断理还乱的爱恨情仇【独家/每周三更新  责编：M】\r\n","title":"烟雨冢","created_at":1467689754,"updated_at":1467689754,"order":0,"label_id":38,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160129/dyyst03bq.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"岚晓","id":6636029},"cover_image_url":"http://i.kuaikanmanhua.com/image/160705/re26rzq8m.webp-w750","id":868,"comics_count":1,"discover_image_url":"http://i.kuaikanmanhua.com/image/160713/da7u9d3gj.webp-w750"},"label_text":"新连载","title":"第1话 再次相遇绝不放手！","url":"http://www.kuaikanmanhua.com/comics/14032","is_liked":false,"shared_count":0,"updated_at":1468231446,"id":14032,"push_flag":1,"info_type":0,"comments_count":13160,"label_color":"#d90d3c","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/w32yurhni.webp-w750","label_text_color":"#ffffff","created_at":1468372819,"likes_count":288405},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160302/lpwk7kh75.webp-w320.w","description":"现代萝莉爱上穿越锦衣卫！【独家/每周三更新   责编：哑铃lynn】","title":"我男票是锦衣卫","created_at":1454327806,"updated_at":1454327806,"order":500,"label_id":15,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160201/rna6levqw.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"ZQQ虹OR虹君 ","id":6835950},"cover_image_url":"http://i.kuaikanmanhua.com/image/160318/c7x50s6ha.webp-w750","id":709,"comics_count":22,"discover_image_url":null},"label_text":"恋爱","title":"第22话 \u201c女刺客\u201d落跑","url":"http://www.kuaikanmanhua.com/comics/14067","is_liked":false,"shared_count":0,"updated_at":1468323428,"id":14067,"push_flag":1,"info_type":0,"comments_count":14360,"label_color":"#fa6499","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/eco1jaf2f.webp-w750","label_text_color":"#ffffff","created_at":1468372220,"likes_count":317724},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160603/9zzm3sc4l.webp-w320.w","description":"一个是年上大叔，一个是年下的黑手党少爷？\u201c大叔，我要让你做我的身下受！\u201d what！？这是什么爱情走向啊！（剧本：Nico 绘画：子犬）【独家/每周三更新，责编：Nico】","title":"调教关系","created_at":1464950032,"updated_at":1464950032,"order":0,"label_id":7,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160607/i1wl8c2tw.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"子犬","id":13749766},"cover_image_url":"http://i.kuaikanmanhua.com/image/160603/fcxx2wii6.webp-w750","id":841,"comics_count":6,"discover_image_url":"http://i.kuaikanmanhua.com/image/160608/pzild5yyw.webp-w750"},"label_text":"耽美","title":"第6话 本集不可描述","url":"http://www.kuaikanmanhua.com/comics/13635","is_liked":false,"shared_count":0,"updated_at":1467167522,"id":13635,"push_flag":1,"info_type":0,"comments_count":8460,"label_color":"#66a3ff","cover_image_url":"http://i.kuaikanmanhua.com/image/160629/kv1is2tg1.webp-w750","label_text_color":"#ffffff","created_at":1468372158,"likes_count":313719},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160509/e6rcwplvi.webp-w320.w","description":"我是神，一个隐藏在普通人类中的神！抖M神！【独家/每周三更新，责编：Nico】","title":"抖M神","created_at":1462774389,"updated_at":1462774389,"order":200,"label_id":5,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/150707/dux1ctqhq.jpg-w180.webp","pub_feed":1,"reg_type":"author","nickname":"毛虫","id":1062227},"cover_image_url":"http://i.kuaikanmanhua.com/image/160509/551hh74iv.webp-w750","id":797,"comics_count":10,"discover_image_url":"http://i.kuaikanmanhua.com/image/160513/34cm93wn0.webp-w750"},"label_text":"爆笑","title":"第10话 所谓的好人","url":"http://www.kuaikanmanhua.com/comics/14061","is_liked":false,"shared_count":0,"updated_at":1468317318,"id":14061,"push_flag":1,"info_type":0,"comments_count":5422,"label_color":"#f0c609","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/j8xnmclot.webp-w750","label_text_color":"#ffffff","created_at":1468371910,"likes_count":122043},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160204/itqediz02.webp-w320.w","description":"少年时名满天下的\u201c大唐第一女神探\u201d一夜之间变成了全城通缉的要犯？身份高贵无懈可击的一代皇子被施下了终身孤老无亲无伴的诅咒？一个是心思细腻的通缉犯，一个是位高权重的诅咒皇子，于是机关算尽、阴谋权术的侦破型\u201c宫斗\u201d故事层层剥茧地开始了\u2026\u2026【独家/每周三更新 责编：奶片侠】","title":"簪中录","created_at":1454594772,"updated_at":1454594772,"order":300,"label_id":36,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160608/sjete42dz.webp-w180.w","pub_feed":0,"reg_type":"author","nickname":"元气工场","id":14113284},"cover_image_url":"http://i.kuaikanmanhua.com/image/160204/4u1b6vjoj.webp-w750","id":715,"comics_count":17,"discover_image_url":null},"label_text":"古风","title":"第9话（下） 确定王妃人选","url":"http://www.kuaikanmanhua.com/comics/14045","is_liked":false,"shared_count":0,"updated_at":1468236898,"id":14045,"push_flag":0,"info_type":0,"comments_count":4148,"label_color":"#bc70ff","cover_image_url":"http://i.kuaikanmanhua.com/image/160711/ld3kz6nou.webp-w750","label_text_color":"#ffffff","created_at":1468371312,"likes_count":180259},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/151224/kxktdhz8u.webp-w320.w","description":"怪异事件，真实记录！【独家/周三周日更新  责编：林早上】","title":"怪奇实录","created_at":1428118697,"updated_at":1428118697,"order":500,"label_id":16,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/150424/16xisv855.jpg-w180.webp","pub_feed":1,"reg_type":"author","nickname":"妖春桥","id":123160},"cover_image_url":"http://i.kuaikanmanhua.com/image/160318/b0ckh4ek1.webp-w750","id":178,"comics_count":126,"discover_image_url":null},"label_text":"灵异","title":"镜中的我走丢了（中）","url":"http://www.kuaikanmanhua.com/comics/14071","is_liked":false,"shared_count":0,"updated_at":1468336252,"id":14071,"push_flag":1,"info_type":0,"comments_count":2039,"label_color":"#7c5099","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/raw3vg8vq.webp-w750","label_text_color":"#ffffff","created_at":1468371017,"likes_count":134366},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160628/2a36lsq8i.webp-w320.w","description":"体格小的少年穿着女装登上舞台变成偶像，这也意味着新的传说即将开始！【独家/责编：奶片侠】","title":"憧憬闪耀的世界","created_at":1467117730,"updated_at":1467117730,"order":0,"label_id":38,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160627/tfu47d090.webp-w180.w","pub_feed":0,"reg_type":"author","nickname":"D2 COMPANY","id":15802456},"cover_image_url":"http://i.kuaikanmanhua.com/image/160628/n9kjonc00.webp-w750","id":862,"comics_count":3,"discover_image_url":"http://i.kuaikanmanhua.com/image/160630/jsi2avpk3.webp-w750"},"label_text":"新连载","title":"第3话 与偶像同台演出","url":"http://www.kuaikanmanhua.com/comics/14068","is_liked":false,"shared_count":0,"updated_at":1468324402,"id":14068,"push_flag":0,"info_type":0,"comments_count":1325,"label_color":"#d90d3c","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/mdezids98.webp-w750","label_text_color":"#ffffff","created_at":1468370115,"likes_count":109281},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160509/biyaf93aj.webp-w320.w","description":"发生在民国的一段段灵异惊悚的故事，你期待吗~【独家/每周三更新 责编：思宇】","title":"变脸","created_at":1461746208,"updated_at":1461746208,"order":400,"label_id":16,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160427/0uh8a8fyr.webp-w180.w","pub_feed":0,"reg_type":"author","nickname":"AGP崇阳","id":10987560},"cover_image_url":"http://i.kuaikanmanhua.com/image/160427/wttff9j29.webp-w750","id":786,"comics_count":11,"discover_image_url":"http://i.kuaikanmanhua.com/image/160505/umzm5tpem.webp-w750"},"label_text":"灵异","title":"夜车","url":"http://www.kuaikanmanhua.com/comics/14062","is_liked":false,"shared_count":0,"updated_at":1468318035,"id":14062,"push_flag":"1","info_type":0,"comments_count":5423,"label_color":"#7c5099","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/iph273flm.webp-w750","label_text_color":"#ffffff","created_at":1468369962,"likes_count":133122},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160623/bw874rwkh.webp-w320.w","description":"你见过车祸后遗症是变成gay的吗？！我的好友林耀因为一次意外车祸记忆错位，一本正经的将我当做他的男朋友啊！！老子是个直男啊！他甚至觉得我们两个已经牵手过！接吻过！拥抱过！OOXX过！所有的共同回忆都变成了黄暴小剧场？我已经不敢细想他还会要求我做些什么帮他寻找回忆了\u2026\u2026【独家/每周三更新 责编：思宇】","title":"才不是你男朋友","created_at":1466660808,"updated_at":1466660808,"order":0,"label_id":7,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160623/4kjg0gi3z.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"口可口可","id":15321579},"cover_image_url":"http://i.kuaikanmanhua.com/image/160623/ksw8drp5f.webp-w750","id":855,"comics_count":3,"discover_image_url":"http://i.kuaikanmanhua.com/image/160629/nultz4uyd.webp-w750"},"label_text":"耽美","title":"第3话 是你先亲我的！","url":"http://www.kuaikanmanhua.com/comics/14012","is_liked":false,"shared_count":0,"updated_at":1468208505,"id":14012,"push_flag":"1","info_type":0,"comments_count":1532,"label_color":"#66a3ff","cover_image_url":"http://i.kuaikanmanhua.com/image/160711/e7ivx4mjl.webp-w750","label_text_color":"#ffffff","created_at":1468369858,"likes_count":149305},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/151224/l6hswkf9w.webp-w320.w","description":"如梦魇缠绕的故事。【独家/每周二更新  责编：半石】","title":"噩梦碎片","created_at":1419085126,"updated_at":1419085126,"order":500,"label_id":8,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160620/7b5z7p98u.webp-w180.w","pub_feed":1,"reg_type":"weibo","nickname":"祝耕夫","id":103757},"cover_image_url":"http://i.kuaikanmanhua.com/image/151224/g00suan07.webp-w750","id":93,"comics_count":67,"discover_image_url":null},"label_text":"恐怖","title":"地狱冥河之花#3","url":"http://www.kuaikanmanhua.com/comics/14076","is_liked":false,"shared_count":0,"updated_at":1468378466,"id":14076,"push_flag":"1","info_type":0,"comments_count":2733,"label_color":"#46344d","cover_image_url":"http://i.kuaikanmanhua.com/image/160713/hduv136fm.webp-w750","label_text_color":"#ffffff","created_at":1468369827,"likes_count":47674},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160504/s3mq7nax8.webp-w320.w","description":"逗逼情侣的日常。【非独家/每周三，周日更 责编：思宇】","title":"大圣和小夭","created_at":1462328306,"updated_at":1462328306,"order":0,"label_id":5,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160504/a1neglko9.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"妖妖小精233","id":11824542},"cover_image_url":"http://i.kuaikanmanhua.com/image/160504/kx35qqtih.webp-w750","id":793,"comics_count":20,"discover_image_url":null},"label_text":"爆笑","title":"第20话 一起逛街~","url":"http://www.kuaikanmanhua.com/comics/14060","is_liked":false,"shared_count":0,"updated_at":1468311343,"id":14060,"push_flag":1,"info_type":0,"comments_count":4074,"label_color":"#f0c609","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/1yd833cma.webp-w750","label_text_color":"#ffffff","created_at":1468369805,"likes_count":233230},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160204/4lk079icn.webp-w320.w","description":"得到了天下，却失去了你。【独家/每周三更新  责编：哑铃lynn】","title":"竹枝曲","created_at":1446522747,"updated_at":1446522747,"order":500,"label_id":7,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/151103/gj9r1nx5m.jpg-w180.webp","pub_feed":0,"reg_type":"author","nickname":"十二只+不可治","id":2745604},"cover_image_url":"http://i.kuaikanmanhua.com/image/160302/7zeclolzr.webp-w750","id":592,"comics_count":38,"discover_image_url":null},"label_text":"耽美","title":"第39话 六王爷之妻","url":"http://www.kuaikanmanhua.com/comics/14064","is_liked":false,"shared_count":0,"updated_at":1468321504,"id":14064,"push_flag":1,"info_type":0,"comments_count":3614,"label_color":"#66a3ff","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/co59t6x46.webp-w750","label_text_color":"#ffffff","created_at":1468369214,"likes_count":194294},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160215/6woasqndl.webp-w320.w","description":"我经常做一个梦，梦里有个男人一直呼唤我的名字，他说我是\u2026\u2026吸血鬼！【独家/每周三更新 责编：林早上】","title":"恋上你的血小板","created_at":1455546259,"updated_at":1455546259,"order":100,"label_id":3,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160215/qddq6obs9.webp-w180.w","pub_feed":0,"reg_type":"author","nickname":"海与岸＋洛十三","id":8149266},"cover_image_url":"http://i.kuaikanmanhua.com/image/160215/epeaba45l.webp-w750","id":724,"comics_count":20,"discover_image_url":"http://i.kuaikanmanhua.com/image/160413/dm466islt.webp-w750"},"label_text":"少女","title":"第20话 我们都太脆弱了","url":"http://www.kuaikanmanhua.com/comics/14058","is_liked":false,"shared_count":0,"updated_at":1468304355,"id":14058,"push_flag":1,"info_type":0,"comments_count":952,"label_color":"#f06292","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/t1u2tlzx1.webp-w750","label_text_color":"#ffffff","created_at":1468368009,"likes_count":109213},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/150729/oh12xrhg0.jpg-w320.webp","description":"形形色色各类人，你最喜欢哪一种？【独家/每周三更新  责编：思宇】","title":"万花筒","created_at":1438153432,"updated_at":1438153432,"order":300,"label_id":10,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/150729/v50z867os.jpg-w180.webp","pub_feed":0,"reg_type":"author","nickname":"Cheno","id":1487965},"cover_image_url":"http://i.kuaikanmanhua.com/image/150729/xtc0v25i4.jpg-w640.webp","id":443,"comics_count":51,"discover_image_url":null},"label_text":"日常","title":"失恋这件小事","url":"http://www.kuaikanmanhua.com/comics/14059","is_liked":false,"shared_count":0,"updated_at":1468308995,"id":14059,"push_flag":1,"info_type":0,"comments_count":6195,"label_color":"#39bad4","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/47dfdgsv5.webp-w750","label_text_color":"#ffffff","created_at":1468366807,"likes_count":61529},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160530/lxi3co1je.webp-w320.w","description":"4个性格完全不同的少年，在沈老太教练的磨合下，组成了一只奇葩游泳队，4位少年的游泳人生就此开始！【独家/每周三更新 责编：林早上】","title":"飞鱼","created_at":1464592255,"updated_at":1464592255,"order":300,"label_id":17,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160530/vrzpja0ex.webp-w180.w","pub_feed":0,"reg_type":"author","nickname":"陌一飞工作室","id":13551727},"cover_image_url":"http://i.kuaikanmanhua.com/image/160530/iw9watekr.webp-w750","id":837,"comics_count":7,"discover_image_url":"http://i.kuaikanmanhua.com/image/160601/0pmpqtx83.webp-w750"},"label_text":"剧情","title":"第7话 不准你们成立游泳队","url":"http://www.kuaikanmanhua.com/comics/14066","is_liked":false,"shared_count":0,"updated_at":1468322246,"id":14066,"push_flag":1,"info_type":0,"comments_count":994,"label_color":"#6c72e6","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/euve5mn0q.webp-w750","label_text_color":"#ffffff","created_at":1468366211,"likes_count":69076},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160426/10vjf0beu.webp-w320.w","description":"超不专业的漫画点评课！【独家/不定时更新 责编：林早上】","title":"快看教室","created_at":1461663177,"updated_at":1461663177,"order":0,"label_id":5,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160709/dqmzrmdq6.webp-w180.w","nickname":"林早上","id":13278865,"reg_type":"author"},"cover_image_url":"http://i.kuaikanmanhua.com/image/160426/79fur8p3t.webp-w750","id":784,"comics_count":3,"discover_image_url":null},"label_text":"爆笑","title":"第3课 特邀评审安妮来啦~","url":"http://www.kuaikanmanhua.com/comics/14065","is_liked":false,"shared_count":0,"updated_at":1468321539,"id":14065,"push_flag":1,"info_type":0,"comments_count":875,"label_color":"#f0c609","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/b125qrq13.webp-w750","label_text_color":"#ffffff","created_at":1468365906,"likes_count":40225},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/160408/73q6qri57.webp-w320.w","description":"【独家首发/周三、周六更新，责编：哑铃lynn】比男人还帅的女医生，偶遇智商下线的老同学，哭笑不得的会面\u2026\u2026旧时同窗什么时候才能认出当初的她？","title":"二四八月常晴偶雨","created_at":1460108639,"updated_at":1460108639,"order":100,"label_id":15,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/150423/ohz4ixmks.jpg-w180.webp","pub_feed":0,"reg_type":"weibo","nickname":"杨笑汝","id":59},"cover_image_url":"http://i.kuaikanmanhua.com/image/160413/fj3od0xx9.webp-w750","id":772,"comics_count":32,"discover_image_url":null},"label_text":"恋爱","title":"第34话 真心话还是谎话？","url":"http://www.kuaikanmanhua.com/comics/14023","is_liked":false,"shared_count":0,"updated_at":1468219344,"id":14023,"push_flag":1,"info_type":0,"comments_count":933,"label_color":"#fa6499","cover_image_url":"http://i.kuaikanmanhua.com/image/160711/thpk100i2.webp-w750","label_text_color":"#ffffff","created_at":1468365608,"likes_count":58244},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/151211/9wnu3oy85.jpg-w320.webp","description":"两个因为领地互相结仇呆呆撕逼的门派，玩完没想到到了第四代撕出来恋爱的火花\u2026\u2026【剧象漫画授权/周三、周日更新 责编：奶片侠】","title":"燕山派与百花门","created_at":1449830963,"updated_at":1449830963,"order":0,"label_id":19,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/150707/5tmlijkd0.jpg-w180.webp","pub_feed":0,"reg_type":"author","nickname":"剧象漫画","id":1059889},"cover_image_url":"http://i.kuaikanmanhua.com/image/151211/1umggfqcb.jpg-w640.webp","id":650,"comics_count":100,"discover_image_url":null},"label_text":"爱情","title":"第104话 烧光燕山派？","url":"http://www.kuaikanmanhua.com/comics/14063","is_liked":false,"shared_count":0,"updated_at":1468320676,"id":14063,"push_flag":0,"info_type":0,"comments_count":896,"label_color":"#f0487d","cover_image_url":"http://i.kuaikanmanhua.com/image/160713/rbnpulrjx.webp-w750","label_text_color":"#ffffff","created_at":1468363804,"likes_count":40305},{"status":"published","topic":{"vertical_image_url":"http://i.kuaikanmanhua.com/image/151231/inzc7p5a8.webp-w320.w","description":"大家好，我叫圈圈O////O\u2026\u2026！我的身体\u2026\u2026有一点点点与众不同_(:з)∠)_（羞）从今天开始，我会在这里分享一些我的小故事，欢迎大家评论&吐槽！嗯，还有节操劵，也请尽情地喂给我\u2026\u2026_(:з)∠)_（张开双臂）【出品：微漫画，总监制：天空，漫画：酚酞瓜Orz，制作人：t，脚本：T-行星团队       每周三、周五更新  责编：奶片侠】","title":"圈圈","created_at":1451542218,"updated_at":1451542218,"order":0,"label_id":23,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/151230/vqrie5we9.webp-w180.w","pub_feed":0,"reg_type":"author","nickname":"微漫画合集","id":5574462},"cover_image_url":"http://i.kuaikanmanhua.com/image/151231/2xtdvit6z.webp-w750","id":668,"comics_count":54,"discover_image_url":null},"label_text":"治愈","title":"第54话 那一天的恐怖","url":"http://www.kuaikanmanhua.com/comics/14069","is_liked":false,"shared_count":0,"updated_at":1468324619,"id":14069,"push_flag":0,"info_type":0,"comments_count":646,"label_color":"#bbc23a","cover_image_url":"http://i.kuaikanmanhua.com/image/160712/f6k1kdf6t.webp-w750","label_text_color":"#ffffff","created_at":1468363203,"likes_count":50082}]
     * timestamp : 1468339200
     * since : 1468363203
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable  {
        private int timestamp;
        private int since;
        /**
         * status : published
         * topic : {"vertical_image_url":"http://i.kuaikanmanhua.com/image/160426/valzdprgh.webp-w320.w","description":"2016年度都市情爱大作，快看漫画携手知名漫画家柯小倾力巨献\r\n\u201c一辈子那么长，你会只爱一个人吗？\u201d【独家/每周三更新 责编：半石】","title":"密会情人","created_at":1461558235,"updated_at":1461558235,"order":600,"label_id":11,"user":{"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160616/81rwrli9c.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"柯小","id":14776286},"cover_image_url":"http://i.kuaikanmanhua.com/image/160530/u3j98bcwf.webp-w750","id":782,"comics_count":12,"discover_image_url":null}
         * label_text : 都市
         * title : 第11话 不懂珍惜
         * url : http://www.kuaikanmanhua.com/comics/14070
         * is_liked : false
         * shared_count : 0
         * updated_at : 1468330891
         * id : 14070
         * push_flag : 1
         * info_type : 0
         * comments_count : 13190
         * label_color : #b536e3
         * cover_image_url : http://i.kuaikanmanhua.com/image/160712/07unlyke8.webp-w750
         * label_text_color : #ffffff
         * created_at : 1468373421
         * likes_count : 556630
         */

        private List<ComicsBean> comics;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getSince() {
            return since;
        }

        public void setSince(int since) {
            this.since = since;
        }

        public List<ComicsBean> getComics() {
            return comics;
        }

        public void setComics(List<ComicsBean> comics) {
            this.comics = comics;
        }

        public static class ComicsBean implements  Serializable{
            private String status;
            /**
             * vertical_image_url : http://i.kuaikanmanhua.com/image/160426/valzdprgh.webp-w320.w
             * description : 2016年度都市情爱大作，快看漫画携手知名漫画家柯小倾力巨献
             “一辈子那么长，你会只爱一个人吗？”【独家/每周三更新 责编：半石】
             * title : 密会情人
             * created_at : 1461558235
             * updated_at : 1461558235
             * order : 600
             * label_id : 11
             * user : {"grade":1,"avatar_url":"http://i.kuaikanmanhua.com/image/160616/81rwrli9c.webp-w180.w","pub_feed":1,"reg_type":"author","nickname":"柯小","id":14776286}
             * cover_image_url : http://i.kuaikanmanhua.com/image/160530/u3j98bcwf.webp-w750
             * id : 782
             * comics_count : 12
             * discover_image_url : null
             */

            private TopicBean topic;
            private String label_text;
            private String title;
            private String url;
            private boolean is_liked;
            private int shared_count;
            private int updated_at;
            private int id;
            private int push_flag;
            private int info_type;
            private int comments_count;
            private String label_color;
            private String cover_image_url;
            private String label_text_color;
            private int likes_count;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public TopicBean getTopic() {
                return topic;
            }

            public void setTopic(TopicBean topic) {
                this.topic = topic;
            }

            public String getLabel_text() {
                return label_text;
            }

            public void setLabel_text(String label_text) {
                this.label_text = label_text;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isIs_liked() {
                return is_liked;
            }

            public void setIs_liked(boolean is_liked) {
                this.is_liked = is_liked;
            }

            public int getShared_count() {
                return shared_count;
            }

            public void setShared_count(int shared_count) {
                this.shared_count = shared_count;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPush_flag() {
                return push_flag;
            }

            public void setPush_flag(int push_flag) {
                this.push_flag = push_flag;
            }

            public int getInfo_type() {
                return info_type;
            }

            public void setInfo_type(int info_type) {
                this.info_type = info_type;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public String getLabel_color() {
                return label_color;
            }

            public void setLabel_color(String label_color) {
                this.label_color = label_color;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getLabel_text_color() {
                return label_text_color;
            }

            public void setLabel_text_color(String label_text_color) {
                this.label_text_color = label_text_color;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public static class TopicBean implements Serializable {
                private String vertical_image_url;
                private String description;
                private String title;
                private int order;
                private int label_id;
                /**
                 * grade : 1
                 * avatar_url : http://i.kuaikanmanhua.com/image/160616/81rwrli9c.webp-w180.w
                 * pub_feed : 1
                 * reg_type : author
                 * nickname : 柯小
                 * id : 14776286
                 */

                private UserBean user;
                private String cover_image_url;
                private int id;
                private int comics_count;
                private Object discover_image_url;

                public String getVertical_image_url() {
                    return vertical_image_url;
                }

                public void setVertical_image_url(String vertical_image_url) {
                    this.vertical_image_url = vertical_image_url;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public int getLabel_id() {
                    return label_id;
                }

                public void setLabel_id(int label_id) {
                    this.label_id = label_id;
                }

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getComics_count() {
                    return comics_count;
                }

                public void setComics_count(int comics_count) {
                    this.comics_count = comics_count;
                }

                public Object getDiscover_image_url() {
                    return discover_image_url;
                }

                public void setDiscover_image_url(Object discover_image_url) {
                    this.discover_image_url = discover_image_url;
                }

                public static class UserBean implements  Serializable{
                    private int grade;
                    private String avatar_url;
                    private int pub_feed;
                    private String reg_type;
                    private String nickname;
                    private int id;

                    public int getGrade() {
                        return grade;
                    }

                    public void setGrade(int grade) {
                        this.grade = grade;
                    }

                    public String getAvatar_url() {
                        return avatar_url;
                    }

                    public void setAvatar_url(String avatar_url) {
                        this.avatar_url = avatar_url;
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

                    public String getNickname() {
                        return nickname;
                    }

                    public void setNickname(String nickname) {
                        this.nickname = nickname;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }
                }
            }
        }
    }
}
