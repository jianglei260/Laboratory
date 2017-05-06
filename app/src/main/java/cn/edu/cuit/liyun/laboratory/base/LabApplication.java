package cn.edu.cuit.liyun.laboratory.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.facebook.drawee.backends.pipeline.Fresco;

import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.data.entity.Event;
import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import cn.edu.cuit.liyun.laboratory.data.entity.User;

/**
 * Created by jianglei on 2017/4/15.
 */

public class LabApplication extends Application {
    private static LabApplication instance;

    public static LabApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
        AVUser.alwaysUseSubUserClass(User.class);
        AVOSCloud.initialize(this, "MkaIThVom8VfFE4I0iR31RdB-gzGzoHsz", "hoNGn8dti59WVbMTVcDqqCIV");
    }
}
