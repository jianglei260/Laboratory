package cn.edu.cuit.liyun.laboratory.dailytime;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.util.List;

import cn.edu.cuit.liyun.laboratory.BR;
import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.base.Refreshable;
import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.DailyTimeRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.user.UserListActivity;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/5.
 */

public class SignListViewModel extends DetailViewModel implements Refreshable {
    private SignListActivity activity;
    public ObservableList<ListItemViewModel> viewModels = new ObservableArrayList<>();
    public ItemViewSelector<ListItemViewModel> itemView = new ItemViewSelector<ListItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, ListItemViewModel item) {
            switch (item.getViewType()) {
                case ListItemViewModel.VIEW_TYPE_NORMAL:
                    itemView.set(BR.itemViewModel, R.layout.list_sign);
                    break;
            }
        }

        @Override
        public int viewTypeCount() {
            return 1;
        }
    };

    public ReplyCommand userClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(activity, UserListActivity.class);
            activity.startActivity(intent);
        }
    });

    public SignListViewModel(SignListActivity activity) {
        this.activity = activity;
        initSignList(null);
    }

    public void onUserSelected(List<String> ids) {
        if (ids.size() < 0)
            return;
        if (ids.size() > 0) {
            initSignList(ids.get(0));
        }
    }

    private String userId;

    public void initSignList(final String userId) {
        this.userId = userId;
        emptyContent.set(false);
        loadding.set(true);
        RxUtil.execute(new IOTask<List<DailyTime>>() {
            @Override
            public List<DailyTime> run() {
                String id = userId;
                if (id == null) {
                    id = UserRepository.getInstance().getMyInfo().getObjectId();
                }
                UserInfo info = UserRepository.getInstance().findFromCache(id);
                return DailyTimeRepository.getInstance().getUserDailyTime(info);
            }
        }, new UIAction<List<DailyTime>>() {
            @Override
            public void onComplete(List<DailyTime> dailyTimes) {
                loadding.set(false);
                viewModels.clear();
                if (complete != null)
                    complete.onComplete();
                if (dailyTimes == null) {
                    emptyContent.set(true);
                } else {
                    for (DailyTime dailyTime : dailyTimes) {
                        SignItemViewModel itemViewModel = new SignItemViewModel(activity, dailyTime);
                        viewModels.add(itemViewModel);
                    }
                }
            }
        });
    }

    @Override
    public void onLoadMore(OnComplete complete) {

    }

    private OnComplete complete;

    @Override
    public void onRefresh(OnComplete complete) {
        this.complete = complete;
        initSignList(userId);
    }

    @Override
    public void onBack() {
        activity.finish();
    }
}
