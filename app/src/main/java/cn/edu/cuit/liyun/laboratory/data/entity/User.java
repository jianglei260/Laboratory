package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;

import java.util.List;

/**
 * Created by jianglei on 2017/4/15.
 */
//用户
public class User extends AVUser {
    private UserInfo info;
    protected Role role;//用户角色

    public AVObject getInfo() {
        return getAVObject("info");
    }

    public void setInfo(AVObject info) {
        put("info", info);
    }

    public void setRole(Role role) {
        put("role", role.ordinal());
    }

    public Role getRole() {
        return Role.values()[getInt("role")];
    }
    //    public String getName() {
//        return getString("name");
//    }
//
//    public void setName(String name) {
//        put("name", name);
//    }
//
//    public String getNumber() {
//        return getString("number");
//    }
//
//    public void setNumber(String number) {
//        put("number", number);
//    }
//
//    public String getOriClass() {
//        return getString("oriClass");
//    }
//
//    public void setOriClass(String oriClass) {
//        put("oriClass", oriClass);
//    }
//
//    public String getLabClass() {
//        return getString("labClass");
//    }
//
//    public void setLabClass(String labClass) {
//        put("labClass", labClass);
//    }
//
//    public List<DailyTime> getTimes() {
//        return getList("times",DailyTime.class);
//    }
//
//    public void setTimes(DailyTime time) {
//        getRelation("times").add(time);
//    }
}
