package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVUser;

import java.util.List;

/**
 * Created by jianglei on 2017/4/15.
 */
//用户
public class User extends AVUser {
    public enum Role {
        ADMIN,//管理员，数据库中对应数字0
        TEACHER,//老师，数据库中对应数字1
        STUDENT//学生，数据库中对应数字2
    }

    protected String name;//用户名
    protected Role role;//用户角色
    private String number;//编号
    private String oriClass;//所在班级
    private String labClass;//实验室班级
    private List<DailyTime> times;//签到信息

    public Role getRole() {
        return Role.values()[getInt("role")];
    }

    public void setRole(Role role) {
        this.role = role;
        put("role", role.ordinal());
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        put("name", name);
    }

    public String getNumber() {
        return getString("number");
    }

    public void setNumber(String number) {
        put("number", number);
    }

    public String getOriClass() {
        return getString("oriClass");
    }

    public void setOriClass(String oriClass) {
        put("oriClass", oriClass);
    }

    public String getLabClass() {
        return getString("labClass");
    }

    public void setLabClass(String labClass) {
        put("labClass", labClass);
    }

    public List<DailyTime> getTimes() {
        return getList("times",DailyTime.class);
    }

    public void setTimes(DailyTime time) {
        add("times",time);
    }
}
