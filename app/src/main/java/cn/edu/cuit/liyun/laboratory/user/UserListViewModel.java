package cn.edu.cuit.liyun.laboratory.user;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.BR;
import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.discuss.UserItemViewModel;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/5.
 */

public class UserListViewModel extends DetailViewModel {
    private UserListActivity activity;

    public ObservableList<ListItemViewModel> viewModels = new ObservableArrayList<>();
    public ItemViewSelector<ListItemViewModel> itemView = new ItemViewSelector<ListItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, ListItemViewModel item) {
            switch (item.getViewType()) {
                case ListItemViewModel.VIEW_TYPE_NORMAL:
                    itemView.set(BR.itemViewModel, R.layout.list_user);
                    break;
            }
        }

        @Override
        public int viewTypeCount() {
            return 1;
        }
    };
    public ReplyCommand finishClick=new ReplyCommand(new Action0() {
        @Override
        public void call() {
            finishSelect();
        }
    });

    public void finishSelect(){
        activity.onSelected(getSelected());
    }

    public UserListViewModel(UserListActivity activity) {
        this.activity = activity;
        initUsers();
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
    public void initUsers() {
        loadding.set(true);
        RxUtil.execute(new IOTask<List<UserInfo>>() {
            @Override
            public List<UserInfo> run() {
                return UserRepository.getInstance().findAll();
            }
        }, new UIAction<List<UserInfo>>() {
            @Override
            public void onComplete(List<UserInfo> userInfos) {
                loadding.set(false);
                if (userInfos == null) {
                    Toast.makeText(activity, R.string.load_failed, Toast.LENGTH_SHORT).show();
                    return;
                }
                for (UserInfo userInfo : userInfos) {
                    UserItemViewModel itemViewModel = new UserItemViewModel(userInfo);
                    viewModels.add(itemViewModel);
                }
            }
        });
    }

    @Override
    public void onBack() {
        activity.finish();
    }
}
