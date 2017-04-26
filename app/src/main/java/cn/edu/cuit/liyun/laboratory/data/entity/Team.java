package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by jianglei on 2017/4/15.
 */
//团队
public class Team  {
    private String teamName;//团队名称
    private UserInfo leader;//团队负责人
    private List<UserInfo> students;//团队成员
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public UserInfo getLeader() {
        return leader;
    }

    public void setLeader(UserInfo leader) {
        this.leader = leader;
    }

    public List<UserInfo> getStudents() {
        return students;
    }

    public void setStudents(List<UserInfo> students) {
        this.students = students;
    }
    //    public String getTeamName() {
//        return getString("teamName");
//    }
//
//    public void setTeamName(String teamName) {
//        put("teamName", teamName);
//    }
//
//    public User getLeader() {
//        try {
//            return getAVObject("leader", User.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void setLeader(User leader) {
//        put("leader", leader);
//    }
//
//    public List<User> getStudents() {
//        return getList("students", User.class);
//    }
//    public void addStudents(User user) {
//        getRelation("students").add(user);
//    }
}
