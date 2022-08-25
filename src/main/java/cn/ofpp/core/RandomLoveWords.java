package cn.ofpp.core;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.JsonObject;

public class RandomLoveWords {

    public static String getLoveWords(){
        String key = "ebdb7a30f614957b850cd25b0716f205";
        String url =  "http://api.tianapi.com/saylove/index?key="+key;
        String loveWords = HttpUtil.get(url);
        JSONObject jsonObject = JSONUtil.parseObj(loveWords);
        JSONArray jsonArray =jsonObject.getJSONArray("newslist");
        JSONObject object = (JSONObject) jsonArray.get(0);
        loveWords = object.getStr("content");
        return loveWords;
    }

}
