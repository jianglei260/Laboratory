package cn.edu.cuit.liyun.laboratory.team;

import android.content.Intent;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.base.BaseViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/4.
 */

public class TeamItemViewModel extends ListItemViewModel {
    private Team team;
    private TeamListActivity teamListActivity;
    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> userHead = new ObservableField<>();
    public ObservableField<String> teamName = new ObservableField<>();
    public ObservableField<String> studentNum = new ObservableField<>();

    public ReplyCommand itemClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(teamListActivity, TeamDetailActivity.class);
            intent.putExtra("objectId",team.getObjectId());
            teamListActivity.startActivity(intent);
        }
    });

    public TeamItemViewModel(Team team, TeamListActivity teamListActivity) {
        this.team = team;
        this.teamListActivity = teamListActivity;
        teamName.set(team.getTeamName());
        username.set(team.getLeader().getName());
        userHead.set(team.getLeader().getUrl());
        studentNum.set("人数：" + team.getStudents().size());
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_NORMAL;
    }
}
