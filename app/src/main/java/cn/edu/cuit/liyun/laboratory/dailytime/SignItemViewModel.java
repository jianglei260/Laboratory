package cn.edu.cuit.liyun.laboratory.dailytime;

import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.base.BaseViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.Role;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.utils.StringUtil;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/6.
 */

public class SignItemViewModel extends ListItemViewModel {
    private DailyTime dailyTime;
    private SignListActivity activity;
    public ObservableField<String> signer = new ObservableField<>();
    public ObservableField<String> creater = new ObservableField<>();
    public ObservableField<String> status = new ObservableField<>();
    public ObservableField<String> createTime = new ObservableField<>();
    public ObservableBoolean signed = new ObservableBoolean(false);

    public SignItemViewModel(SignListActivity activity, DailyTime dailyTime) {
        this.dailyTime = dailyTime;
        this.activity = activity;
        creater.set("发起：" + dailyTime.getSender().getNick());
        signer.set("签到：" + dailyTime.getSigner().getNick());
        if (dailyTime.isSigned()) {
            status.set("已签到");
        } else {
            status.set("未签到");
        }
        createTime.set("发起时间：" + StringUtil.getFormatDate(dailyTime.getTime()));
    }

    public ReplyCommand itemClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            UserInfo myInfo = UserRepository.getInstance().getMyInfo();
            if (myInfo == null || myInfo.getRole() == Role.STUDENT) {
                return;
            }
            Intent intent = new Intent(activity, SignDetailActivity.class);
            intent.putExtra("objectId", dailyTime.getObjectId());
            activity.startActivity(intent);
        }
    });

    @Override
    public int getViewType() {
        return 0;
    }
}
