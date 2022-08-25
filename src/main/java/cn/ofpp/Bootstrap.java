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
    public static final String APP_ID = "wx57929a3c4a1d9423";

    /**
     * 公众号秘钥
     */
    public static final String SECRET = "993c00f11b019e7080955717ccafb53f";

    /**
     * 全局模板ID  也可针对单个Friend指定模板
     */
    public static final String TEMPLATE_ID = "EIoDeknCIT_FIeLFUNvp_JPJEmKvf5lwb64YF8A_Je4";


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
