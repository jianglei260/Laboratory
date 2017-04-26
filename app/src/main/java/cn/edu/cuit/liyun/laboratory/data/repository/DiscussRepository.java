package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/17.
 */

public class DiscussRepository {
    private static DiscussRepository instance;

    public static DiscussRepository getInstance() {
        if (instance == null)
            instance = new DiscussRepository();
        return instance;
    }

    public void send(UserInfo sender, String content, UserInfo... receivers) {
        Discuss discuss = new Discuss();
        discuss.setMessage(content);
        discuss.setSender(sender);
        List<UserInfo> receiverList = new ArrayList<>();
        for (UserInfo receiver : receivers) {
            receiverList.add(receiver);
        }
        discuss.setReceivers(receiverList);
        save(discuss);
    }

    public List<Discuss> getAllDiscusses(User receiver) {
        return LeanEngine.Query.get(Discuss.class).whereEqualTo("receivers", receiver).find();
    }

    public List<Discuss> getAllDiscusses(UserInfo receiver, UserInfo sender) {
        LeanEngine.Query receiverQuery = LeanEngine.Query.get(Discuss.class).whereEqualTo("receivers", receiver);
        LeanEngine.Query senderQuery = LeanEngine.Query.get(Discuss.class).whereEqualTo("sender", sender);
        return LeanEngine.Query.and(receiverQuery, senderQuery).find();
    }

    public void save(Discuss discuss) {
        LeanEngine.save(discuss);
    }
}
