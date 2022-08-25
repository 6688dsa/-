package cn.ofpp.core;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.google.gson.JsonObject;

import java.net.URLEncoder;

/**
 * @author 刘毅泽
 */
public class TodayHoroscope {

    public static final String key="4b8c42b85080512c465cba9043919a1e";
    public static today getToday(String constellation){
        constellation= URLEncoder.encode(constellation);
        String url="http://web.juhe.cn/constellation/getAll?consName="+constellation+"&type=today&key="+key;
        String today = HttpUtil.get(url, 4000);
        return JSONUtil.parseObj(today).toBean(today.class);
    }
    public static week getweek(String constellation){
        constellation= URLEncoder.encode(constellation);
        String url="http://web.juhe.cn/constellation/getAll?consName="+constellation+"&type=week&key="+key;
        String week = HttpUtil.get(url, 4000);
        return JSONUtil.parseObj(week).toBean(week.class);
    }
    static class today{
        @Override
        public String toString() {
            return "today{" +
                    "name='" + name + '\'' +
                    ", datetime='" + datetime + '\'' +
                    ", date='" + date + '\'' +
                    ", all='" + all + '\'' +
                    ", color='" + color + '\'' +
                    ", health='" + health + '\'' +
                    ", love='" + love + '\'' +
                    ", money='" + money + '\'' +
                    ", number='" + number + '\'' +
                    ", QFriend='" + QFriend + '\'' +
                    ", summary='" + summary + '\'' +
                    ", work='" + work + '\'' +
                    '}';
        }

        /*星座名称*/
        String name;
        /*日期 例"2014年06月27日"*/
        String datetime;
        /*日期：20140627*/
        String date;
        /*综合指数*/
        String all;
        /*幸运色*/
        String color;
        /*健康指数*/
        String health;
        /*爱情指数*/
        String love;
        /*财运指数*/
        String money;
        /*幸运数字*/
        String number;
        /*速配星座*/
        String QFriend;
        /*今日概述*/
        String summary;
        /*工作指数*/
        String work;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getQFriend() {
            return QFriend;
        }

        public void setQFriend(String QFriend) {
            this.QFriend = QFriend;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }
    }

    /*本周运势*/
    static class week{
        /*星座名*/
        String name;
        /*本周日期*/
        String date;
        /*周数*/
        String weekth;
        /*健康*/
        String health;
        /*工作*/
        String job;
        /*财运*/
        String money;
        /*恋爱*/
        String love;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getWeekth() {
            return weekth;
        }

        public void setWeekth(String weekth) {
            this.weekth = weekth;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }


        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }
    }


}
