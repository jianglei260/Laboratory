package cn.edu.cuit.liyun.laboratory.dailytime;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.repository.DailyTimeRepository;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.StringUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/5.
 */

public class SignDetailViewModel extends DetailViewModel {
    private SignDetailActivity activity;
    private DailyTime dailyTime;
    public ObservableField<String> reason = new ObservableField<>();
    public ObservableField<String> creater = new ObservableField<>();
    public ObservableField<String> signer = new ObservableField<>();
    public ObservableField<String> createTime = new ObservableField<>();
    public ObservableInt selectId = new ObservableInt(R.id.signed);
    public ReplyCommand sendClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            reSign();
        }
    });

    public SignDetailViewModel(SignDetailActivity activity, String objectId) {
        this.activity = activity;
        dailyTime = DailyTimeRepository.getInstance().findFromCache(objectId);
        reason.set(dailyTime.getReason());
        creater.set(dailyTime.getSender().getNick());
        signer.set(dailyTime.getSigner().getNick());
        createTime.set(StringUtil.getFormatDate(dailyTime.getTime()));
    }

    public void reSign() {
        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                dailyTime.setReason(reason.get());
                boolean signed = true;
                switch (selectId.get()) {
                    case R.id.signed:
                        signed = true;
                        break;
                    case R.id.not_sign:
                        signed = false;
                        break;
                }
                dailyTime.setSigned(signed);
                return DailyTimeRepository.getInstance().save(dailyTime);
            }
        }, new UIAction<Boolean>() {
            @Override
            public void onComplete(Boolean s) {
                if (s) {
                    Toast.makeText(activity, "修改成功", Toast.LENGTH_SHORT).show();
                    activity.finish();
                } else {
                    Toast.makeText(activity, "修改失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
