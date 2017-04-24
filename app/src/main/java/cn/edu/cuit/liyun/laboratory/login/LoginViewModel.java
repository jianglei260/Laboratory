package cn.edu.cuit.liyun.laboratory.login;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;import android.view.View.OnClickListener;import android.content.Intent;import android.databinding.*;

import com.avos.avoscloud.AVUser;

import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.LoaddingViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.repository.DailyTimeRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;

import java.lang.String;import java.lang.String;

/**
 * Created by jianglei on 2017/4/16.
 */

public class LoginViewModel extends DetailViewModel {
    private static final String TAG = "LoginViewModel";
    public OnClickListener signClick = new OnClickListener() {
        public void onClick(View var1) {
            onSignClick();
        }
    };
    public ObservableField<String> account = new ObservableField<String>();
    public OnClickListener loginClick = new OnClickListener() {
        public void onClick(View var1) {
            onLoginClick();
        }
    };
    public ObservableField<String> password = new ObservableField<String>();
    private UserLoginActivity userLoginActivity;

    public LoginViewModel(UserLoginActivity userLoginActivity) {
        this.userLoginActivity = userLoginActivity;
        title.set("用户登录");
    }

    public void onLoginClick() {
        loadding.set(true);
        RxUtil.execute(new IOTask<User>() {
            @Override
            public User run() {
                DailyTime dailyTime=new DailyTime();
                dailyTime.setCode("123");
                dailyTime.setSigner(UserRepository.getInstance().getCurrentUser());
                DailyTimeRepository.getInstance().save(dailyTime);
                return UserRepository.getInstance().login(account.get(), password.get());
            }
        }, new UIAction<User>() {
            @Override
            public void onComplete(User user) {
                loadding.set(false);
                Log.d(TAG, "onComplete: "+user.getObjectId());
            }
        });
    }

    public void gotoUserSignActivity() {
        Intent intent = new Intent(userLoginActivity, UserSignActivity.class);
        userLoginActivity.startActivity(intent);
    }

    public void onSignClick() {
        gotoUserSignActivity();
    }
}
