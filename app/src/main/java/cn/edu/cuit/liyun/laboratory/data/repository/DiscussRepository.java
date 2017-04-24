package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.data.entity.User;

/**
 * 讨论相关接口
 * Created  on 2017/4/17.
 */

public class DiscussRepository {
    private static DiscussRepository instance;

    public static DiscussRepository getInstance() {
        if (instance == null)
            instance = new DiscussRepository();
        return instance;
    }

    /**
     * 发布一条信息
     * @param sender
     * @param content
     * @param receivers
     */
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

    /**
     * 得到所有发给自己的信息
     * @param receiver
     * @return
     */
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

    /**
     * 获取某个用户发送的所有信息
     * @param receiver
     * @param sender
     * @return
     */
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

    /**
     * 保存一条讨论信息
     * @param discuss
     */
    public void save(Discuss discuss) {
        try {
            discuss.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }
}
