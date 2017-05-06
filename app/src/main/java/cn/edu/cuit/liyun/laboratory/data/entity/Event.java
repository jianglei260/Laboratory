package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/15.
 */
//活动
@LeanEngine.Entity
public class Event {
    private String title;//标题
    private String content;//活动内容
    private UserInfo sender;//活动发布者
    private String objectId;//对象id
    private String createdAt;//对象创建时间
    private String updatedAt;//对象更新时间

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfo getSender() {
        return sender;
    }

    public void setSender(UserInfo sender) {
        this.sender = sender;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //    public String getContent() {
//        return getString("content");
//    }
//
//    public void setContent(String content) {
//        put("content", content);
//    }
//
//    public User getSender() {
//        try {
//            return getAVObject("sender", User.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void setSender(User sender) {
//        put("sender", sender);
//    }
}
