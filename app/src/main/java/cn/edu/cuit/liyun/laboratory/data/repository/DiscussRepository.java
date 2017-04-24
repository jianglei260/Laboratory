package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.data.entity.User;

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

    public void send(User sender, String content, User... receivers) {
        Discuss discuss = new Discuss();
        discuss.setMessage(content);
        discuss.setSender(sender);
        List<User> receiverList = new ArrayList<>();
        for (User receiver : receivers) {
            receiverList.add(receiver);
        }
        discuss.setReceivers(receiverList);
        save(discuss);
    }

    public List<Discuss> getAllDiscusses(User receiver) {
        AVQuery<Discuss> query = AVQuery.getQuery(Discuss.class);
        query.whereEqualTo("receivers", receiver);
        try {
            query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Discuss> getAllDiscusses(User receiver, User sender) {
        AVQuery<Discuss> receiverQuery = AVQuery.getQuery(Discuss.class);
        receiverQuery.whereEqualTo("receivers", receiver);
        AVQuery<Discuss> senderQuery = AVQuery.getQuery(Discuss.class);
        senderQuery.whereEqualTo("sender", sender);
        try {
            return AVQuery.and(Arrays.asList(receiverQuery, senderQuery)).find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void save(Discuss discuss) {
        try {
            discuss.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }
}
