package cn.edu.cuit.liyun.laboratory.team;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.BR;
import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.TeamRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.discuss.MessageItemViewModel;
import cn.edu.cuit.liyun.laboratory.discuss.UserItemViewModel;
import cn.edu.cuit.liyun.laboratory.user.UserListActivity;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/4.
 */

public class TeamDetailViewModel extends DetailViewModel {
    private TeamDetailActivity activity;
    private Team team;
    public ObservableField<String> teamName = new ObservableField<>();
    public ObservableList<ListItemViewModel> viewModels = new ObservableArrayList<>();
    private UserInfo myInfo;
    public ItemViewSelector<ListItemViewModel> itemView = new ItemViewSelector<ListItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, ListItemViewModel item) {
            itemView.set(BR.itemViewModel, R.layout.list_user);
        }

        @Override
        public int viewTypeCount() {
            return 1;
        }
    };
    public ReplyCommand deleteClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            deleteSelected();
        }
    });
    public ReplyCommand addClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(activity, UserListActivity.class);
            activity.startActivity(intent);
        }
    });

    public void deleteSelected() {
        loadding.set(true);
        final List<UserInfo> userInfos = getSelected();
        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                return TeamRepository.getInstance().deleteStudent(team, userInfos);
            }
        }, new UIAction<Boolean>() {
            @Override
            public void onComplete(Boolean s) {
                loadding.set(false);
                if (s) {
                    Iterator iterator = viewModels.iterator();
                    while (iterator.hasNext()) {
                        UserItemViewModel itemViewModel = (UserItemViewModel) iterator.next();

                        if (itemViewModel.selected.get()) {
                            iterator.remove();
                        }
                    }
                }
            }
        });
    }

    public List<UserInfo> getSelected() {
        List<UserInfo> selected = new ArrayList<>();
        for (ListItemViewModel viewModel : viewModels) {
            if (viewModel instanceof UserItemViewModel) {
                if (((UserItemViewModel) viewModel).selected.get()) {
                    selected.add(((UserItemViewModel) viewModel).userInfo);
                }
            }
        }
        return selected;
    }


    public TeamDetailViewModel(TeamDetailActivity activity, String objectId) {
        this.activity = activity;
        team = TeamRepository.getInstance().findFromCache(objectId);
        title.set(team.getTeamName());
        initStudents();
    }

    public void onUserAdd(List<String> ids) {
        for (String id : ids) {
            final UserInfo info = UserRepository.getInstance().findFromCache(id);
            final UserItemViewModel itemViewModel = new UserItemViewModel(info);
            viewModels.add(itemViewModel);
            RxUtil.execute(new IOTask<Boolean>() {
                @Override
                public Boolean run() {
                    return TeamRepository.getInstance().addStudent(team, info);
                }
            }, new UIAction<Boolean>() {
                @Override
                public void onComplete(Boolean s) {
                    if (!s) {
                        Toast.makeText(activity, "添加" + info.getName() + "失败", Toast.LENGTH_SHORT).show();
                        viewModels.remove(itemViewModel);
                    } else {
                        team.getStudents().add(info);
                    }
                }
            });
        }
    }

    public void initStudents() {
        for (UserInfo userInfo : team.getStudents()) {
            UserItemViewModel itemViewModel = new UserItemViewModel(userInfo);
            viewModels.add(itemViewModel);
        }
    }

    @Override
    public void onBack() {
        activity.finish();
    }
}
