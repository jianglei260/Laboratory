package cn.edu.cuit.liyun.laboratory.event;

import android.databinding.ObservableField;
import android.text.TextUtils;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseViewModel;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.EventRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/3.
 */

public class SendEventViewModel extends DetailViewModel {
    private SendEventActivity activity;
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> eventTitle = new ObservableField<>();
    public ReplyCommand sendClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            sendEvent();
        }
    });

    public SendEventViewModel(SendEventActivity activity) {
        this.activity = activity;
        title.set(activity.getString(R.string.event_send));
    }

    public void sendEvent() {
        if (TextUtils.isEmpty(eventTitle.get())) {
            Toast.makeText(activity, R.string.title_empty_notiy, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(content.get())) {
            Toast.makeText(activity, R.string.content_empty_notiy, Toast.LENGTH_SHORT).show();
            return;
        }
        loadding.set(true);
        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                UserInfo info = UserRepository.getInstance().getMyInfo();
                boolean result = EventRepository.getInstance().sendEvent(info, eventTitle.get(), content.get());
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
