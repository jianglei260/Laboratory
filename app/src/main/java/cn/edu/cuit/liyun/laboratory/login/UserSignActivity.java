package cn.edu.cuit.liyun.laboratory.login;

import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.databinding.ActivityUserSignBinding;

import cn.edu.cuit.liyun.laboratory.base.BaseActivity;import android.databinding.DataBindingUtil;import cn.edu.cuit.liyun.laboratory.R;

/**
 * Created by jianglei on 2017/4/16.
 */

public class UserSignActivity extends BaseActivity {
    private ActivityUserSignBinding binding;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_sign);
        SignUpViewModel signUpViewModel = new SignUpViewModel(this);
        binding.setSignUpViewModel(signUpViewModel);
    }
}
