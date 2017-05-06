package cn.edu.cuit.liyun.laboratory.dailytime;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseActivity;
import cn.edu.cuit.liyun.laboratory.databinding.ActivitySignBinding;

public class SignActivity extends BaseActivity {
    ActivitySignBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign);
        binding.setSignViewModel(new SignViewModel(this));
    }
}
