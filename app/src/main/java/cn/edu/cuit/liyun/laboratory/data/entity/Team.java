package cn.edu.cuit.liyun.laboratory.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.List;

/**
 * Created by jianglei on 2017/4/15.
 */
@AVClassName("Team")//团队
public class Team extends AVObject {
    private String teamName;//团队名称
    private User leader;//团队负责人
    private List<User> students;//团队成员

    public String getTeamName() {
        return getString("teamName");
    }

    public void setTeamName(String teamName) {
        put("teamName", teamName);
    }

    public User getLeader() {
        try {
            return getAVObject("leader", User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setLeader(User leader) {
        put("leader", leader);
    }

    public List<User> getStudents() {
        return getList("students", User.class);
    }

    public void setStudents(List<User> students) {
        put("students", students);
    }

    public void addStudents(User user) {
        add("students", user);
    }
}
