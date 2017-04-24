package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;

import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import cn.edu.cuit.liyun.laboratory.data.entity.User;

/**
 * 团队相关接口
 * Created on 2017/4/17.
 */

public class TeamRepository {
    private static TeamRepository instance;

    public static TeamRepository getInstance() {
        if (instance != null)
            instance = new TeamRepository();
        return instance;
    }

    /**
     * 创建团队
     * @param name
     * @param leader
     * @return
     */
    public Team createTeam(String name, User leader) {
        Team team = new Team();
        team.setLeader(leader);
        team.setTeamName(name);
        save(team);
        return team;
    }

    /**
     * 添加团队成员
     * @param team
     * @param user
     */
    public void addStudent(Team team, User user) {
        team.addStudents(user);
        save(team);
    }

    /**
     * 保存团队信息
     * @param team
     */
    public void save(Team team) {
        try {
            team.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除团队成员
     * @param team
     * @param student
     */
    public void deleteStudent(Team team,User student){
       team.getRelation("stuents").remove(student);
    }
}
