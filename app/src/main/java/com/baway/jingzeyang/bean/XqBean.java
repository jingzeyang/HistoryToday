package com.baway.jingzeyang.bean;

import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/24.
 * .::::.
 * .::::::::.
 * :::::::::::  Goddess bless, never bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */

public class XqBean {

    /**
     * reason : success
     * result : [{"e_id":"1993","title":"孙中山请辞临时大总统","content":"    在104年前的今天，1912年2月13日 (农历腊月廿六)，孙中山请辞临时大总统。\r\n    1911年10月10日（距今105年）武昌起义成功后，于12月25日由欧洲返回上海，29日在十六省代表会上当选为临时大总统。次年1月1日到南京宣誓就职，组成中华民国南京临时政府。任职期间颁布了中国第一部宪法、中华民国临时约法》。2月13日，在帝国主义和封建势力逼迫下，辞去临时大总统职，由袁世凯接任。\r\n\r\n","picNo":"2","picUrl":[{"pic_title":"2月15日，孙中山及全体国务员晋谒明孝陵","id":1,"url":"http://images.juheapi.com/history/1993_1.jpg"},{"pic_title":"孙中山，黄兴等在明孝陵合影","id":2,"url":"http://images.juheapi.com/history/1993_2.jpg"}]}]
     * error_code : 0
     */

    public String reason;
    public int error_code;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * e_id : 1993
         * title : 孙中山请辞临时大总统
         * content :     在104年前的今天，1912年2月13日 (农历腊月廿六)，孙中山请辞临时大总统。
         1911年10月10日（距今105年）武昌起义成功后，于12月25日由欧洲返回上海，29日在十六省代表会上当选为临时大总统。次年1月1日到南京宣誓就职，组成中华民国南京临时政府。任职期间颁布了中国第一部宪法、中华民国临时约法》。2月13日，在帝国主义和封建势力逼迫下，辞去临时大总统职，由袁世凯接任。


         * picNo : 2
         * picUrl : [{"pic_title":"2月15日，孙中山及全体国务员晋谒明孝陵","id":1,"url":"http://images.juheapi.com/history/1993_1.jpg"},{"pic_title":"孙中山，黄兴等在明孝陵合影","id":2,"url":"http://images.juheapi.com/history/1993_2.jpg"}]
         */

        public String e_id;
        public String title;
        public String content;
        public String picNo;
        public List<PicUrlBean> picUrl;

        public static class PicUrlBean {
            /**
             * pic_title : 2月15日，孙中山及全体国务员晋谒明孝陵
             * id : 1
             * url : http://images.juheapi.com/history/1993_1.jpg
             */

            public String pic_title;
            public int id;
            public String url;
        }
    }
}
