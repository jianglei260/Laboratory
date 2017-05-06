package cn.edu.cuit.liyun.laboratory.dailytime;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseActivity;
import cn.edu.cuit.liyun.laboratory.databinding.ActivitySignListBinding;
import cn.edu.cuit.liyun.laboratory.user.UserListActivity;

public class SignListActivity extends BaseActivity {
    ActivitySignListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_list);
        binding.setSignViewModel(new SignListViewModel(this));
        registeEventAction(UserListActivity.ACTION_USER_SELECTED);
    }

    @Override
    protected void onEvent(Intent intent) {
        if (intent.getAction().equals(UserListActivity.ACTION_USER_SELECTED)) {
            binding.getSignViewModel().onUserSelected(intent.getStringArrayListExtra("ids"));
        }
    }
}
