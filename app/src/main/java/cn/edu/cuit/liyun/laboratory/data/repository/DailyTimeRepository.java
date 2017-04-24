package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.User;

/**
 * Created by  2017/4/17.
 */

/**
 * 签到相关操作接口
 */
public class DailyTimeRepository {
    private static DailyTimeRepository instance;
    public static long TIMEOUT = 60 * 1000;
//获取单一实例,整个程序运行期间对象只生成一个
    public static DailyTimeRepository getInstance() {
        if (instance == null)
            instance = new DailyTimeRepository();
        return instance;
    }

    /**
     * 签到接口
     * @param dailyTime 签到表
     * @param code 签到码
     * @param user
     * @return
     */
    public boolean sign(DailyTime dailyTime, String code, User user) {
        long current = System.currentTimeMillis();
        try {
            if (current - dailyTime.getTime() > TIMEOUT) {
                dailyTime.setSigned(false);
                dailyTime.setReason("未在规定时间内签到");
                user.setTimes(dailyTime);
                user.save();
                return false;
            }
            if (!code.equals(dailyTime.getCode())) {
                dailyTime.setSigned(false);
                dailyTime.setReason("签到码错误");
                user.setTimes(dailyTime);
                user.save();
                return false;
            }
            dailyTime.setSigned(true);
            user.setTimes(dailyTime);
            user.save();
            return true;
        } catch (AVException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取用户所有签到信息
     * @param user
     * @return
     */
    public List<DailyTime> getUserDailyTime(User user) {
        return user.getTimes();
    }

    /**
     * 获取所有签到时间
     * @param user
     * @return
     */
    public List<Long> getAllDailyTime(User user) {
        List<Long> times = new ArrayList<>();
        for (DailyTime dailyTime : user.getTimes()) {
            times.add(dailyTime.getTime());
        }
        return times;
    }

    /**
     * 通过时间查找所有签到信息
     * @param time
     * @return
     */
    public List<DailyTime> findAllByTime(long time) {
        AVQuery query = AVQuery.getQuery(DailyTime.class);
        query.whereEqualTo("time", time);
        query.include("signer");
        try {
            return query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * b保存签到信息
     * @param daylTime
     */
    public void save(DailyTime daylTime){
        try {
            daylTime.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }
}
