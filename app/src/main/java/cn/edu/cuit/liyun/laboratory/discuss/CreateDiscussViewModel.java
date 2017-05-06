package cn.edu.cuit.liyun.laboratory.discuss;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.text.TextUtils;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.BR;
import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.DiscussRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.EventRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/3.
 */

public class CreateDiscussViewModel extends DetailViewModel {
    private CreateDiscussActivity activity;
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> discussTitle = new ObservableField<>();
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
    public ReplyCommand sendClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            sendDiscuss();
        }
    });

    public CreateDiscussViewModel(CreateDiscussActivity activity) {
        this.activity = activity;
        title.set(activity.getString(R.string.discuss_send));
        initUsers();
    }

    public UserInfo[] getSelected() {
        List<UserInfo> selected = new ArrayList<>();
        for (ListItemViewModel viewModel : viewModels) {
            if (viewModel instanceof UserItemViewModel) {
                if (((UserItemViewModel) viewModel).selected.get()) {
                    selected.add(((UserItemViewModel) viewModel).userInfo);
                }
            }
        }
        return selected.toArray(new UserInfo[selected.size()]);
    }

    public void initUsers() {
        RxUtil.execute(new IOTask<List<UserInfo>>() {
            @Override
            public List<UserInfo> run() {
                return UserRepository.getInstance().findAll();
            }
        }, new UIAction<List<UserInfo>>() {
            @Override
            public void onComplete(List<UserInfo> userInfos) {
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

    public void sendDiscuss() {
        if (TextUtils.isEmpty(discussTitle.get())) {
            Toast.makeText(activity, R.string.title_empty_notiy, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(content.get())) {
            Toast.makeText(activity, R.string.content_empty_notiy, Toast.LENGTH_SHORT).show();
            return;
        }
        final UserInfo[] userInfos = getSelected();
        if (userInfos.length <= 0) {
            Toast.makeText(activity, R.string.user_empty_notiy, Toast.LENGTH_SHORT).show();
            return;
        }
        loadding.set(true);
        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                UserInfo info = UserRepository.getInstance().getMyInfo();
                boolean result = DiscussRepository.getInstance().send(info, discussTitle.get(), content.get(), userInfos);
                return result;
            }
        }, new UIAction<Boolean>() {
            @Override
            public void onComplete(Boolean success) {
                loadding.set(false);
                if (success == true) {
                    Toast.makeText(activity, R.string.send_success, Toast.LENGTH_SHORT).show();
                    activity.finish();
                } else {
                    Toast.makeText(activity, R.string.send_failed, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBack() {
        activity.finish();
    }
}
