package cn.edu.cuit.liyun.laboratory.data.repository;

import android.util.Log;

import com.avos.avoscloud.AVException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String, Team> cache = new HashMap<>();

    public static TeamRepository getInstance() {
        if (instance == null)
            instance = new TeamRepository();
        return instance;
    }

    public boolean createTeam(String name, UserInfo leader, List<UserInfo> students) {
        Team team = new Team();
        team.setLeader(leader);
        team.setTeamName(name);
        students.add(leader);
        team.setStudents(students);
        return save(team);
    }

    public boolean addStudent(Team team, UserInfo user) {
        return LeanEngine.insertToList(team, "students", user);
    }

    public List<Team> findTeamList(UserInfo userInfo) {
        return saveToCache(LeanEngine.Query.get(Team.class).whereEqualTo("students", userInfo).find());
    }

    public List<Team> saveToCache(List<Team> teams) {
        for (Team team : teams) {
            cache.put(team.getObjectId(), team);
        }
        return teams;
    }

    public Team findFromCache(String objectId) {
        return cache.get(objectId);
    }

    public List<Team> findAllTeam() {
        return saveToCache(LeanEngine.Query.get(Team.class).find());
    }

    public boolean save(Team team) {
        return LeanEngine.save(team);
    }

    public boolean deleteStudent(Team team, UserInfo student) {
        boolean removed = LeanEngine.remove(team.getStudents(), student);
        if (removed) {
            LeanEngine.updateField(team, "students", team.getStudents());
        }
        return removed;
    }

    public boolean deleteStudent(Team team, List<UserInfo> students) {
        boolean removed = LeanEngine.removeFromList(team, "students", students);
        if (removed) {
            team.getStudents().removeAll(students);
        }
        return removed;
    }
}
