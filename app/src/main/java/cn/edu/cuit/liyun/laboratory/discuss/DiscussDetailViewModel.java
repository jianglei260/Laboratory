package cn.edu.cuit.liyun.laboratory.discuss;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.text.TextUtils;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.BR;
import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.data.entity.Message;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.DiscussRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.me.UserInfoViewModel;
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

public class DiscussDetailViewModel extends DetailViewModel {
    private DiscussDetailActivity activity;
    public ObservableField<String> discussContent = new ObservableField<>();
    public ObservableList<ListItemViewModel> viewModels = new ObservableArrayList<>();
    private UserInfo myInfo;
    public ItemViewSelector<ListItemViewModel> itemView = new ItemViewSelector<ListItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, ListItemViewModel item) {
            if (item instanceof MessageItemViewModel) {
                if (LeanEngine.equeal(((MessageItemViewModel) item).message.getSender(), myInfo)) {
                    itemView.set(BR.itemViewModel, R.layout.list_message_send);
                } else {
                    itemView.set(BR.itemViewModel, R.layout.list_message_receive);
                }
            }
        }

        @Override
        public int viewTypeCount() {
            return 2;
        }
    };
    private Discuss discuss;
    public ReplyCommand sendClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            sendMessage();
        }
    });

    public void sendMessage() {
        if (TextUtils.isEmpty(discussContent.get())) {
            Toast.makeText(activity, R.string.content_empty_notiy, Toast.LENGTH_SHORT).show();
            return;
        }
        final Message message = new Message();
        message.setContent(discussContent.get());
        message.setSender(myInfo);
        message.setCreatedAt(String.valueOf(System.currentTimeMillis()));
        MessageItemViewModel itemViewModel = new MessageItemViewModel(message);
        discuss.getMessages().add(message);
        viewModels.add(itemViewModel);
        discussContent.set("");
        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                boolean result = LeanEngine.insertToList(discuss, "messages", message);
                return result;
            }
        }, new UIAction<Boolean>() {
            @Override
            public void onComplete(Boolean s) {
                if (!s) {
                    Toast.makeText(activity, R.string.send_failed, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public DiscussDetailViewModel(DiscussDetailActivity activity, String objectId) {
        this.activity = activity;
        initMyInfo();
        discuss = DiscussRepository.getInstance().findFromCache(objectId);
        title.set(discuss.getTitle());
    }

    public void initMessages() {
        for (Message message : discuss.getMessages()) {
            MessageItemViewModel itemViewModel = new MessageItemViewModel(message);
            viewModels.add(itemViewModel);
        }
    }

    public void initMyInfo() {
        RxUtil.execute(new IOTask<UserInfo>() {
            @Override
            public UserInfo run() {
                return UserRepository.getInstance().getMyInfo();
            }
        }, new UIAction<UserInfo>() {
            @Override
            public void onComplete(UserInfo userInfo) {
                DiscussDetailViewModel.this.myInfo = userInfo;
                initMessages();
            }
        });
    }

    @Override
    public void onBack() {
        activity.finish();
    }
}
