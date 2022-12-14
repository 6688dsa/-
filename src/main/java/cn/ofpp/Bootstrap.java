package cn.ofpp;

import cn.hutool.core.util.StrUtil;
import cn.ofpp.core.Wx;

/**
 * 引导配置
 *
 * @author aZe
 * Date 2022-08-25
 */
public class Bootstrap {

    /**
     * 公众号AppID
     */
    public static final String APP_ID = "wxa6047c555743c189";

    /**
     * 公众号秘钥
     */
    public static final String SECRET = "54daf3604eef4b40025bd822cf9751a7";

    /**
     * 全局模板ID  也可针对单个Friend指定模板
     */
    public static final String TEMPLATE_ID = "CQJy9XZmmL4BEGwEv36LUsYW821pg8_KQhKSfakiOzg";


    /**
     * 初始化
     */
    public static void init() {
        if (StrUtil.hasEmpty(APP_ID, SECRET, TEMPLATE_ID)) {
            throw new IllegalArgumentException("请检查配置");
        }
        Wx.init();
    }

}
