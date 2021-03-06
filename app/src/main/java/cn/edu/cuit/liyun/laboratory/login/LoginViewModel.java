package cn.edu.cuit.liyun.laboratory.login;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.databinding.*;
import android.widget.Toast;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.LoaddingViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.DailyTime;
import cn.edu.cuit.liyun.laboratory.data.entity.Team;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.DailyTimeRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.TeamRepository;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.main.MainActivity;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;

import java.lang.String;
import java.lang.String;

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
    public OnClickListener testClick = new OnClickListener() {
        public void onClick(View var1) {
            onTestClick();
        }
    };
    public ObservableField<String> password = new ObservableField<String>();
    private UserLoginActivity userLoginActivity;

    public LoginViewModel(UserLoginActivity userLoginActivity) {
        this.userLoginActivity = userLoginActivity;
        title.set("用户登录");
    }

    public void onTestClick() {
        RxUtil.execute(new IOTask<Void>() {
            @Override
            public Void run() {
                Log.d(TAG, "run: ");
                try {
//                    DailyTime dailyTime = new DailyTime();
//                    dailyTime.setCode("123");
//                    dailyTime.setSigner(UserRepository.getInstance().getCurrentUser());
//                    DailyTimeRepository.getInstance().save(dailyTime);
//                    Team team = TeamRepository.getInstance().createTeam("testteam", UserRepository.getInstance().getCurrentUser());
//                    TeamRepository.getInstance().addStudent(team, UserRepository.getInstance().getCurrentUser());
//                    Log.d(TAG, "run: " + team.getTeamName());
                    AVObject object = AVObject.createWithoutData("Team", "58ff0dbbac502e0063bd0470");
                    object.fetch();
                    Team team =LeanEngine.toObject(object,Team.class);
                    Log.d(TAG, "run: " + team.getTeamName());
                    for (UserInfo user : team.getStudents()) {
                        Log.d(TAG, "run: " + user.getName());
                    }
//
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, new UIAction<Void>() {
            @Override
            public void onComplete(Void aVoid) {

            }
        });
    }

    public void onLoginClick() {
        if (TextUtils.isEmpty(account.get())) {
            Toast.makeText(userLoginActivity, R.string.account_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            Toast.makeText(userLoginActivity, R.string.password_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        loadding.set(true);
        RxUtil.execute(new IOTask<User>() {
            @Override
            public User run() {
                return UserRepository.getInstance().login(account.get(), password.get());
            }
        }, new UIAction<User>() {
            @Override
            public void onComplete(User user) {
                loadding.set(false);
                if (user!=null){
                    Intent intent=new Intent(userLoginActivity, MainActivity.class);
                    userLoginActivity.startActivity(intent);
                    userLoginActivity.finish();
                }else {
                    Toast.makeText(userLoginActivity, R.string.login_failed, Toast.LENGTH_SHORT).show();
                }
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
