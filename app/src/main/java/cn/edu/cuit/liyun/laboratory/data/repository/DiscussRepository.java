package cn.edu.cuit.liyun.laboratory.data.repository;


import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.data.entity.Message;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/17.
 */

public class DiscussRepository {
    private static DiscussRepository instance;
    private Map<String, Discuss> cache = new HashMap<>();

    public static DiscussRepository getInstance() {
        if (instance == null)
            instance = new DiscussRepository();
        return instance;
    }

    public boolean send(UserInfo sender, String title, String content, UserInfo... receivers) {
        Discuss discuss = new Discuss();
        discuss.setTitle(title);
        discuss.setContent(content);
        discuss.setSender(sender);
        List<UserInfo> receiverList = new ArrayList<>();
        for (UserInfo receiver : receivers) {
            receiverList.add(receiver);
        }
        discuss.setReceivers(receiverList);
        return save(discuss);
    }

    public boolean send(Discuss discuss, UserInfo sender, String content) {
        Message msg = new Message();
        msg.setSender(sender);
        msg.setContent(content);
        return LeanEngine.insertToList(discuss, "messages", msg);
    }

    public List<Discuss> getAllDiscusses(UserInfo receiver) {
        List<Discuss> discusses = LeanEngine.Query.get(Discuss.class).whereEqualTo("receivers", receiver).find();
        return saveToCache(discusses);
    }

    public List<Discuss> saveToCache(List<Discuss> discusses) {
        for (Discuss discuss : discusses) {
            cache.put(discuss.getObjectId(), discuss);
        }
        return discusses;
    }

    public Discuss findFromCache(String objectId) {
        return cache.get(objectId);
    }

    public List<Discuss> getAllDiscusses(UserInfo receiver, UserInfo sender) {
        LeanEngine.Query receiverQuery = LeanEngine.Query.get(Discuss.class).whereEqualTo("receivers", receiver);
        LeanEngine.Query senderQuery = LeanEngine.Query.get(Discuss.class).whereEqualTo("sender", sender);
        return saveToCache(LeanEngine.Query.and(receiverQuery, senderQuery).find());
    }

    public boolean save(Discuss discuss) {
        return LeanEngine.save(discuss);
    }
}
