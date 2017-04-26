package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/17.
 */

public class DailyTimeRepository {
    private static DailyTimeRepository instance;
    public static long TIMEOUT = 60 * 1000;

    public static DailyTimeRepository getInstance() {
        if (instance == null)
            instance = new DailyTimeRepository();
        return instance;
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
            if (!code.equals(dailyTime.getCode())) {
                dailyTime.setSigned(false);
                dailyTime.setReason("签到码错误");
                result = false;
            }
            dailyTime.setSigned(true);
            userInfo.getTimes().add(dailyTime);
            LeanEngine.save(userInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<DailyTime> getUserDailyTime(UserInfo user) {
        return user.getTimes();
    }

    public List<Long> getAllDailyTime(UserInfo userInfo) {
        List<Long> times = new ArrayList<>();
        for (DailyTime dailyTime : userInfo.getTimes()) {
            times.add(dailyTime.getTime());
        }
        return times;
    }

    public List<DailyTime> findAllByTime(long time) {
        return LeanEngine.Query.get(DailyTime.class).whereEqualTo("time", time).find();
    }

    public void save(DailyTime daylTime) {
        LeanEngine.save(daylTime);
    }
}
