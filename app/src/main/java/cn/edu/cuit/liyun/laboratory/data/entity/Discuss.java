package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.List;

/**
 * Created by jianglei on 2017/4/15.
 */
@AVClassName("Discuss")//讨论
public class Discuss extends AVObject {
    private String message;//消息内容
    private User sender;//消息发布者
    private List<User> receivers;//消息接收者

    public String getMessage() {
        return getString("message");
    }

    public void setMessage(String message) {
        put("message", message);
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

    public List<User> getReceivers() {
        return getList("receivers", User.class);
    }

    public void setReceivers(List<User> receivers) {
        put("receivers", receivers);
    }
}
