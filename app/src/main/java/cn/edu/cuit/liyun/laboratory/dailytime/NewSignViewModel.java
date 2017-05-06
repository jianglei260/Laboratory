package cn.edu.cuit.liyun.laboratory.dailytime;

import android.databinding.ObservableField;
import android.text.TextUtils;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.data.repository.DailyTimeRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/5.
 */

public class NewSignViewModel extends DetailViewModel {
    private NewSignActivity activity;
    public ObservableField<String> signCode=new ObservableField<>();
    public ReplyCommand sendClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            sendSign();
        }
    });

    public void sendSign(){
        if (TextUtils.isEmpty(signCode.get())) {
            Toast.makeText(activity, R.string.code_empty_notiy, Toast.LENGTH_SHORT).show();
            return;
        }
        loadding.set(true);
        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                return DailyTimeRepository.getInstance().create(signCode.get(), UserRepository.getInstance().getMyInfo());
            }
        }, new UIAction<Boolean>() {
            @Override
            public void onComplete(Boolean s) {
                if (!s){
                    Toast.makeText(activity, R.string.send_failed, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, R.string.send_success, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public NewSignViewModel(NewSignActivity activity) {
        this.activity = activity;
    }
    public void initSignCode(){
        signCode.set(String.valueOf(System.currentTimeMillis()));
    }
}
