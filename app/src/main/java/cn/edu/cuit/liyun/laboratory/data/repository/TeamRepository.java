package cn.edu.cuit.liyun.laboratory.data.repository;

import android.util.Log;

import com.avos.avoscloud.AVException;

import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/17.
 */

public class TeamRepository {
    private static final String TAG = "TeamRepository";
    private static TeamRepository instance;

    public static TeamRepository getInstance() {
        if (instance == null)
            instance = new TeamRepository();
        return instance;
    }

    public Team createTeam(String name, UserInfo leader) {
        Team team = new Team();
        team.setLeader(leader);
        team.setTeamName(name);
        save(team);
        return team;
    }

    public void addStudent(Team team, UserInfo user) {
        team.getStudents().add(user);
        save(team);
    }

    public void save(Team team) {
        LeanEngine.save(team);
    }

    public boolean deleteStudent(Team team, UserInfo student) {
        boolean removed = LeanEngine.remove(team.getStudents(), student);
        if (removed) {
            save(team);
        }
        return removed;
    }
}
