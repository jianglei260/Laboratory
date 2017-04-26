package cn.edu.cuit.liyun.laboratory.login;

import android.graphics.Canvas;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.databinding.ActivityUserLoginBinding;

import cn.edu.cuit.liyun.laboratory.R;

import android.databinding.DataBindingUtil;

import cn.edu.cuit.liyun.laboratory.base.BaseActivity;

/**
 * Created by jianglei on 2017/4/16.
 */

public class UserLoginActivity extends BaseActivity {
    private ActivityUserLoginBinding binding;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_login);
        LoginViewModel loginViewModel = new LoginViewModel(this);
        binding.setLoginViewModel(loginViewModel);
    }
}
