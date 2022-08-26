package cn.ofpp.core;

import cn.hutool.core.util.StrUtil;
import cn.ofpp.Bootstrap;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.List;

import static cn.ofpp.core.GaodeUtil.getAdcCode;

/**
 * @author aZe
 * Date 2022-08-25
 */
public class MessageFactory {

    public static WxMpTemplateMessage resolveMessage(Friend friend) {
        return WxMpTemplateMessage.builder()
                .url("http://wap.weather.com.cn/mweather/101180101.shtml") // 点击后的跳转链接 可自行修改 也可以不填
                .toUser(friend.getUserId())
                .templateId(StrUtil.emptyToDefault(friend.getTemplateId(), Bootstrap.TEMPLATE_ID))
                .data(buildData(friend))
                .build();
    }

    /**
     *
     * {@code {{xxxx.DATA}}} xxxx就是一个变量名，消息中设置变量 然后传递时传递变量即可
     * <br/>
     * 色彩取值可以从这里挑选 https://arco.design/palette/list
     *
     *  <p>
     *  {{datetime.DATA}}
     * 早上好呀!{{friendName.DATA}}
     *
     * 距离你下一次生日{{nextBirthday.DATA}}天
     * 具体我们的下一次纪念日{{nextMemorialDay.DATA}}天
     * 现在在{{province.DATA}}{{city.DATA}}
     * 当前天气:{{weather.DATA}}
     * 当前气温:{{temperature.DATA}}
     * 风力描述:{{winddirection.DATA}}
     * 风力级别:{{windpower.DATA}}
     * 空气湿度:{{humidity.DATA}}
     *
     * {{friendName.DATA}}，你{{constellation.DATA}}的今日运势:
     * 健康指数:{{health.DATA}}   恋爱指数:{{love.DATA}}
     * 工作指数:{{work.DATA}}     财运指数:{{money.DATA}}
     * 幸运数字:{{number.DATA}}   综合指数:{{all.DATA}}
     * 今日概述:{{summary.DATA}}
     * 本周运势:
     * 健康方面:{{weekhealth.DATA}}
     * 事业方面:{{job.DATA}}
     * 恋爱方面:{{weeklove.DATA}}
     * 财运方面:{{weekmoney.DATA}}
     * 事业方面:{{weekwork.DATA}}
     *  </p>
     */
    private static List<WxMpTemplateData> buildData(Friend friend) {
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(getAdcCode(friend.getProvince(), friend.getCity()));
        TodayHoroscope.today today = TodayHoroscope.getToday(friend.getConstellation());
//        TodayHoroscope.week week = TodayHoroscope.getweek(friend.getConstellation());
        return List.of(
                TemplateDataBuilder.builder().name("friendName").value(friend.getFullName()).color("#D91AD9").build(),
                TemplateDataBuilder.builder().name("constellation").value(friend.getConstellation().toString()).color("#F77234").build(),
                TemplateDataBuilder.builder().name("howLongLived").value(friend.getHowLongLived()).color("#437004").build(),
                TemplateDataBuilder.builder().name("nextBirthday").value(friend.getNextBirthdayDays()).color("#771F06").build(),
                TemplateDataBuilder.builder().name("nextMemorialDay").value(friend.getNextMemorialDay()).color("#551DB0").build(),
                TemplateDataBuilder.builder().name("province").value(friend.getProvince()).color("#F53F3F").build(),
                TemplateDataBuilder.builder().name("city").value(friend.getCity()).color("#FADC19").build(),
                TemplateDataBuilder.builder().name("weather").value(weather.getWeather()).color("#00B42A").build(),
                TemplateDataBuilder.builder().name("temperature").value(weather.getTemperature()).color("#722ED1").build(),
                TemplateDataBuilder.builder().name("winddirection").value(weather.getWinddirection()).color("#F5319D").build(),
                TemplateDataBuilder.builder().name("windpower").value(weather.getWindpower()).color("#3491FA").build(),
                TemplateDataBuilder.builder().name("humidity").value(weather.getHumidity()).color("#F77234").build(),

                TemplateDataBuilder.builder().name("datetime").value(today.getDatetime()).color("#1d2129").build(),
                TemplateDataBuilder.builder().name("health").value(today.getHealth()).color("#9FDB1D").build(),
                TemplateDataBuilder.builder().name("love").value(today.getLove()).color("#F53F3F").build(),
                TemplateDataBuilder.builder().name("work").value(today.getWork()).color("#F7BA1E").build(),
                TemplateDataBuilder.builder().name("money").value(today.getMoney()).color("#F77234").build(),
                TemplateDataBuilder.builder().name("number").value(today.getNumber()).color("#165DFF").build(),
                TemplateDataBuilder.builder().name("all").value(today.getAll()).color("#FADC19").build(),
                TemplateDataBuilder.builder().name("summary").value(today.getSummary()).color("#3491FA").build(),
                TemplateDataBuilder.builder().name("loveWords").value(RandomLoveWords.getLoveWords()).color("#F77234").build()
//                TemplateDataBuilder.builder().name("weekhealth").value(week.getHealth()).color("#00B42A").build(),
//                TemplateDataBuilder.builder().name("job").value(week.getJob()).color("#165DFF").build(),
//                TemplateDataBuilder.builder().name("weeklove").value(week.getLove()).color("#F53F3F").build(),
//                TemplateDataBuilder.builder().name("weekmoney").value(week.getMoney()).color("#FF7D00").build()
        );
    }

    static class TemplateDataBuilder {
        private String name;
        private String value;
        private String color;

        public static TemplateDataBuilder builder() {
            return new TemplateDataBuilder();
        }
        public TemplateDataBuilder name(String name) {
            this.name = name;
            return this;
        }
        public TemplateDataBuilder value(String value) {
            this.value = value;
            return this;
        }
        public TemplateDataBuilder color(String color) {
            this.color = color;
            return this;
        }
        public WxMpTemplateData build() {
            if (StrUtil.hasEmpty(name, value)) {
                throw new IllegalArgumentException(name+"参数不正确");
            }
            WxMpTemplateData data = new WxMpTemplateData();
            data.setName(name);
            data.setValue(value);
            data.setColor(color);
            return data;
        }
    }

}
