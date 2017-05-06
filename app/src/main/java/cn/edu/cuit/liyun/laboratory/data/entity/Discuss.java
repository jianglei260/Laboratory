package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/15.
 */
//讨论
@LeanEngine.Entity
public class Discuss  {
    private List<Message> messages=new ArrayList<>();//消息内容
    private UserInfo sender;//消息发布者
    private List<UserInfo> receivers;//消息接收者
    private String objectId;//对象id
    private String createdAt;//对象创建时间
    private String updatedAt;//对象更新时间
    private String title="";
    private String content="";
    private boolean read;

    public List<Message> getMessages() {
        return messages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public UserInfo getSender() {
        return sender;
    }

    public void setSender(UserInfo sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UserInfo> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<UserInfo> receivers) {
        this.receivers = receivers;
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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
    //    public String getMessage() {
//        return getString("message");
//    }
//
//    public void setMessage(String message) {
//        put("message", message);
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
//
//    public List<User> getReceivers() {
//        return getList("receivers", User.class);
//    }
//
//    public void setReceivers(List<User> receivers) {
//        put("receivers", receivers);
//    }
}
