package cn.edu.cuit.liyun.laboratory.team;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.util.List;

import cn.edu.cuit.liyun.laboratory.BR;
import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.base.Refreshable;
import cn.edu.cuit.liyun.laboratory.data.entity.Role;
import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.TeamRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.event.SendEventActivity;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/4.
 */

public class TeamListViewMode extends DetailViewModel implements Refreshable {
    private TeamListActivity activity;
    public ObservableList<ListItemViewModel> viewModels = new ObservableArrayList<>();
    public ItemViewSelector<ListItemViewModel> itemView = new ItemViewSelector<ListItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, ListItemViewModel item) {
            switch (item.getViewType()) {
                case ListItemViewModel.VIEW_TYPE_NORMAL:
                    itemView.set(BR.itemViewModel, R.layout.list_team);
                    break;
            }
        }

        @Override
        public int viewTypeCount() {
            return 1;
        }
    };

    public TeamListViewMode(TeamListActivity activity) {
        this.activity = activity;
        title.set(activity.getString(R.string.team_title));
        initTeam(null);
    }

    public ReplyCommand addClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(activity, CreateTeamActivity.class);
            activity.startActivity(intent);
        }
    });

    public void initTeam(final OnComplete complete) {
        RxUtil.execute(new IOTask<List<Team>>() {
            @Override
            public List<Team> run() {
                UserInfo myInfo = UserRepository.getInstance().getMyInfo();
                if (myInfo.getRole() == Role.STUDENT) {
                    return TeamRepository.getInstance().findTeamList(myInfo);
                } else {
                    return TeamRepository.getInstance().findAllTeam();
                }

            }
        }, new UIAction<List<Team>>() {
            @Override
            public void onComplete(List<Team> teams) {
                viewModels.clear();
                if (complete != null)
                    complete.onComplete();
                if (teams == null || teams.size() == 0) {
                    emptyContent.set(true);
                } else {
                    for (Team team : teams) {
                        TeamItemViewModel itemViewModel = new TeamItemViewModel(team, activity);
                        viewModels.add(itemViewModel);
                    }
                }
            }
        });
    }

    @Override
    public void onLoadMore(OnComplete complete) {

    }

    @Override
    public void onRefresh(OnComplete complete) {
        initTeam(complete);
    }

    @Override
    public void onBack() {
        activity.finish();
    }
}
