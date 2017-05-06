package cn.edu.cuit.liyun.laboratory.discuss;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseActivity;
import cn.edu.cuit.liyun.laboratory.databinding.ActivityDiscussDetailBinding;

public class DiscussDetailActivity extends BaseActivity {
    private String objectId;
    ActivityDiscussDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        objectId = getIntent().getStringExtra("objectId");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_discuss_detail);
        DiscussDetailViewModel viewModel=new DiscussDetailViewModel(this,objectId);
        binding.setDiscussViewModel(viewModel);
    }
}
