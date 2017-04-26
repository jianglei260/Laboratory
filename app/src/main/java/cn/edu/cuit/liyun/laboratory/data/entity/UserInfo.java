package cn.edu.cuit.liyun.laboratory.data.entity;

import java.util.List;

/**
 * Created by jianglei on 2017/4/25.
 */

public class UserInfo {
    protected String name;//用户名
    protected Role role;//用户角色
    private String number;//编号
    private String oriClass;//所在班级
    private String labClass;//实验室班级
    private List<DailyTime> times;//签到信息
    private String objectId;//对象id
    private String createdAt;//对象创建时间
    private String updatedAt;//对象更新时间

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOriClass() {
        return oriClass;
    }

    public void setOriClass(String oriClass) {
        this.oriClass = oriClass;
    }

    public String getLabClass() {
        return labClass;
    }

    public void setLabClass(String labClass) {
        this.labClass = labClass;
    }

    public List<DailyTime> getTimes() {
        return times;
    }

    public void setTimes(List<DailyTime> times) {
        this.times = times;
    }
}
