package cn.edu.cuit.liyun.laboratory.dailytime;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.databinding.ActivitySignDetailBinding;

public class SignDetailActivity extends AppCompatActivity {
    ActivitySignDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String objectId = getIntent().getStringExtra("objectId");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_detail);
        binding.setSignViewModel(new SignDetailViewModel(this, objectId));
    }
}
