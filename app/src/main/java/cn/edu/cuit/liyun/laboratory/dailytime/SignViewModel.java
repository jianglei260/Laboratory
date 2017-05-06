package cn.edu.cuit.liyun.laboratory.dailytime;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.DailyTimeRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.StringUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.observers.Observers;
import rx.schedulers.Schedulers;

/**
 * Created by jianglei on 2017/5/5.
 */

public class SignViewModel extends DetailViewModel {
    private SignActivity activity;
    private DailyTime dailyTime;
    public ObservableField<String> signCode = new ObservableField<>();
    public ObservableField<String> creater = new ObservableField<>();
    public ObservableField<String> leftTime = new ObservableField<>();
    public ObservableField<String> createTime = new ObservableField<>();
    public ObservableBoolean end = new ObservableBoolean(false);
    public ReplyCommand sendClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            sign();
        }
    });

    public SignViewModel(SignActivity activity) {
        this.activity = activity;
        initDailyTime();
    }

    public void sign() {
        if (!signCode.get().equals(dailyTime.getCode())) {
            Toast.makeText(activity, "签到码错误", Toast.LENGTH_SHORT).show();
            return;
        }
        loadding.set(true);

        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                DailyTime myDailyTime = new DailyTime();
                myDailyTime.setSender(dailyTime.getSender());
                myDailyTime.setTime(dailyTime.getTime());
                UserInfo myInfo = UserRepository.getInstance().getMyInfo();
                return DailyTimeRepository.getInstance().sign(myDailyTime, signCode.get(), myInfo);
            }
        }, new UIAction<Boolean>() {
            @Override
            public void onComplete(Boolean s) {
                loadding.set(false);
                if (s) {
                    Toast.makeText(activity, "签到成功", Toast.LENGTH_SHORT).show();
                    activity.finish();
                } else {
                    Toast.makeText(activity, "签到失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initDailyTime() {
        loadding.set(true);
        emptyContent.set(false);
        RxUtil.execute(new IOTask<DailyTime>() {
            @Override
            public DailyTime run() {
                return DailyTimeRepository.getInstance().findLatest();
            }
        }, new UIAction<DailyTime>() {
            @Override
            public void onComplete(DailyTime dailyTime) {
                loadding.set(false);
                if (dailyTime == null) {
                    emptyContent.set(true);
                } else {
                    SignViewModel.this.dailyTime = dailyTime;
                    startCountdown();
                    createTime.set(StringUtil.getFormatDate(dailyTime.getTime()));
                    creater.set(dailyTime.getSender().getNick());
                }
            }
        });
    }

    public void startCountdown() {
        final int leftSecond = (int) ((dailyTime.getTime() + DailyTimeRepository.TIMEOUT - System.currentTimeMillis()) / 1000);
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int second = leftSecond; second > 0; second--) {
                    subscriber.onNext(second);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                leftTime.set("签到已结束");
                end.set(true);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Integer time) {
                leftTime.set("剩余时间：" + time + "s");
            }
        });
    }

    @Override
    public void onBack() {
        activity.finish();
    }
}
