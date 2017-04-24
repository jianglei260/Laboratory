package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by jianglei on 2017/4/15.
 */
@AVClassName("DailyTime")//签到
public class DailyTime extends AVObject {
    private long time;//签到时间
    private String code;//签到码
    private boolean signed;//是否签到
    private String reason;//未签到原因
    private User signer;

    public long getTime() {
        return getLong("time");
    }

    public void setTime(long time) {
        put("time", time);
    }

    public String getCode() {
        return getString("code");
    }

    public void setCode(String code) {
        put("code", code);
    }

    public boolean isSigned() {
        return getBoolean("signed");
    }

    public void setSigned(boolean signed) {
        put("signed", signed);
    }

    public String getReason() {
        return getString("reason");
    }

    public User getSigner() throws Exception {
        return getAVObject("signer", User.class);
    }

    public void setSigner(User signer) {
        put("signer", signer);
    }

    public void setReason(String reason) {
        put("reason", reason);
    }
}
