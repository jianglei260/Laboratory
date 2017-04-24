package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by jianglei on 2017/4/15.
 */
@AVClassName("Event")//活动
public class Event extends AVObject {
    private String content;//活动内容
    private User sender;//活动发布者

    public String getContent() {
        return getString("content");
    }

    public void setContent(String content) {
        put("content", content);
    }

    public User getSender() {
        try {
            return getAVObject("sender", User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setSender(User sender) {
        put("sender", sender);
    }
}
