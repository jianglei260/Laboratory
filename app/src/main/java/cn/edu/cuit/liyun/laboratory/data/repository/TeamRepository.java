package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;

import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import cn.edu.cuit.liyun.laboratory.data.entity.User;

/**
 * Created by jianglei on 2017/4/17.
 */

public class TeamRepository {
    private static TeamRepository instance;

    public static TeamRepository getInstance() {
        if (instance != null)
            instance = new TeamRepository();
        return instance;
    }

    public Team createTeam(String name, User leader) {
        Team team = new Team();
        team.setLeader(leader);
        team.setTeamName(name);
        save(team);
        return team;
    }

    public void addStudent(Team team, User user) {
        team.addStudents(user);
        save(team);
    }

    public void save(Team team) {
        try {
            team.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Team team,User student){
       team.getRelation("stuents").remove(student);
    }
}
