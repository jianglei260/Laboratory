package cn.edu.cuit.liyun.laboratory.discuss;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseActivity;
import cn.edu.cuit.liyun.laboratory.databinding.ActivityCreateDiscussBinding;

public class CreateDiscussActivity extends BaseActivity {
    ActivityCreateDiscussBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_create_discuss);
        CreateDiscussViewModel viewModel=new CreateDiscussViewModel(this);
        binding.setDiscussViewModel(viewModel);
    }
}
