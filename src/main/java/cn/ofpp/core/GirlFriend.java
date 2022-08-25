package cn.ofpp.core;

/**
 * 你可以new一个女朋友
 *
 * @author aZe
 * Date 2022-08-25
 */
public class GirlFriend extends Friend {

    public GirlFriend(String fullName, String province, String city, String birthday, String loveTime,String constellation, String userId) {
        super(fullName, province, city, userId, birthday, loveTime, "女",constellation);
    }

    public GirlFriend(String fullName, String province, String city, String birthday, String loveTime,String constellation ,String userId, String templateId) {
        super(fullName, province, city, userId, birthday, loveTime, "女",constellation, templateId);
    }

}
