package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by jianglei on 2017/4/15.
 */
//签到
public class DailyTime {
    private long time;//签到时间
    private String code;//签到码
    private boolean signed;//是否签到
    private String reason;//未签到原因
    private User signer;
    private String objectId;//对象id
    private String createdAt;//对象创建时间
    private String updatedAt;//对象更新时间

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getSigner() {
        return signer;
    }

    public void setSigner(User signer) {
        this.signer = signer;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    //    public long getTime() {
//        return getLong("time");
//    }
//
//    public void setTime(long time) {
//        put("time", time);
//    }
//
//    public String getCode() {
//        return getString("code");
//    }
//
//    public void setCode(String code) {
//        put("code", code);
//    }
//
//    public boolean isSigned() {
//        return getBoolean("signed");
//    }
//
//    public void setSigned(boolean signed) {
//        put("signed", signed);
//    }
//
//    public String getReason() {
//        return getString("reason");
//    }
//
//    public User getSigner() throws Exception {
//        return getAVObject("signer", User.class);
//    }
//
//    public void setSigner(User signer) {
//        put("signer", signer);
//    }
//
//    public void setReason(String reason) {
//        put("reason", reason);
//    }
}
