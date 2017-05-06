package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/17.
 */

public class DailyTimeRepository {
    private static DailyTimeRepository instance;
    public static long TIMEOUT = 2 * 60 * 1000;
    private Map<String, DailyTime> cache = new HashMap<>();

    public static DailyTimeRepository getInstance() {
        if (instance == null)
            instance = new DailyTimeRepository();
        return instance;
    }

    public boolean create(String code, UserInfo userInfo) {
        DailyTime dailyTime = new DailyTime();
        dailyTime.setCode(code);
        dailyTime.setSender(userInfo);
        dailyTime.setSigned(true);
        dailyTime.setTime(System.currentTimeMillis());
        return save(dailyTime);
    }

    public boolean sign(DailyTime dailyTime, String code, UserInfo userInfo) {
        long current = System.currentTimeMillis();
        boolean result = true;
        try {
            if (current - dailyTime.getTime() > TIMEOUT) {
                dailyTime.setSigned(false);
                dailyTime.setReason("未在规定时间内签到");
                result = false;
            }
            dailyTime.setSigned(true);
            dailyTime.setCode(code);
            dailyTime.setSigner(userInfo);
            LeanEngine.save(dailyTime);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public DailyTime findLatest() {
        long now = System.currentTimeMillis();
        return LeanEngine.Query.get(DailyTime.class).whereGreaterThan("time", now - TIMEOUT).findFrist();
    }

    public List<DailyTime> getUserDailyTime(UserInfo user) {
        return saveToCache(LeanEngine.Query.get(DailyTime.class).whereEqualTo("signer", user).find());
    }

    public List<Long> getAllDailyTime(UserInfo userInfo) {
        List<Long> times = new ArrayList<>();
        List<DailyTime> dailyTimes = getUserDailyTime(userInfo);
        for (DailyTime dailyTime : dailyTimes) {
            times.add(dailyTime.getTime());
        }
        return times;
    }

    public List<DailyTime> saveToCache(List<DailyTime> dailyTimes) {
        for (DailyTime dailyTime : dailyTimes) {
            cache.put(dailyTime.getObjectId(), dailyTime);
        }
        return dailyTimes;
    }

    public DailyTime findFromCache(String objectId) {
        return cache.get(objectId);
    }

    public List<DailyTime> findAllByTime(long time) {
        return saveToCache(LeanEngine.Query.get(DailyTime.class).whereEqualTo("time", time).find());
    }

    public boolean save(DailyTime daylTime) {
        return LeanEngine.save(daylTime);
    }
}
