package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.Event;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/17.
 */

public class EventRepository {
    private static EventRepository instance;

    public static EventRepository getInstance() {
        if (instance == null)
            instance = new EventRepository();
        return instance;
    }

    public List<Event> getAllEvent() {
        return LeanEngine.Query.get(Event.class).find();
    }

    public void sendEvent(UserInfo sender, String content) {
        Event event = new Event();
        event.setContent(content);
        event.setSender(sender);
        save(event);
    }

    public void save(Event event) {
        LeanEngine.save(event);
    }
}
