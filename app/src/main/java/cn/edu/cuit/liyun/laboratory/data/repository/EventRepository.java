package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.Event;
import cn.edu.cuit.liyun.laboratory.data.entity.User;

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
        AVQuery<Event> query = new AVQuery<>("Event");
        try {
            return query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void sendEvent(User sender, String content) {
        Event event = new Event();
        event.setContent(content);
        event.setSender(sender);
        save(event);
    }

    public void save(Event event) {
        try {
            event.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }
}
