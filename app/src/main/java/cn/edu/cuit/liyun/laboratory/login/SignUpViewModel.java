package cn.edu.cuit.liyun.laboratory.login;

import android.content.Intent;
import android.databinding.*;

import java.lang.String;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.Role;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.main.MainActivity;
import cn.edu.cuit.liyun.laboratory.me.UserInfoActivity;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;

import java.lang.String;

/**
 * Created by jianglei on 2017/4/16.
 */

public class SignUpViewModel extends DetailViewModel {
    private static final String TAG = "SignUpViewModel";
    public OnClickListener signClick = new OnClickListener() {
        public void onClick(View var1) {
            onSignClick();
        }
    };
    public ObservableField<String> account = new ObservableField<String>();
    public ObservableField<String> password = new ObservableField<String>();
    public ObservableInt type = new ObservableInt(R.id.type_student);
    private UserSignActivity userSignActivity;


    public SignUpViewModel(UserSignActivity userSignActivity) {
        this.userSignActivity = userSignActivity;
        title.set("用户注册");
    }

    public void onSignClick() {
        if (TextUtils.isEmpty(account.get())) {
            Toast.makeText(userSignActivity, R.string.account_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            Toast.makeText(userSignActivity, R.string.password_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        loadding.set(true);
        RxUtil.execute(new IOTask<User>() {
            @Override
            public User run() {
                Role role = Role.STUDENT;
                switch (type.get()) {
                    case R.id.type_teacher:
                        role = Role.TEACHER;
                        break;
                    case R.id.type_admin:
                        role = Role.ADMIN;
                        break;
                    default:
                        role = Role.STUDENT;
                }
                return UserRepository.getInstance().signUp(account.get(), password.get(), role);
            }
        }, new UIAction<User>() {
            @Override
            public void onComplete(User user) {
                loadding.set(false);
                if (user!=null){
                    Intent intent=new Intent(userSignActivity, MainActivity.class);
                    userSignActivity.startActivity(intent);
                    Intent infoIntent=new Intent(userSignActivity, UserInfoActivity.class);
                    userSignActivity.startActivity(infoIntent);
                    userSignActivity.finish();
                }else {
                    Toast.makeText(userSignActivity, R.string.sign_up_failed, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBack() {
        userSignActivity.finish();
    }
}
