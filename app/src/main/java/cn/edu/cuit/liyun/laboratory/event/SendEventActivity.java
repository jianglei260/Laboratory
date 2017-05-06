package cn.edu.cuit.liyun.laboratory.event;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.databinding.ActivitySendEventBinding;

public class SendEventActivity extends AppCompatActivity {
    private ActivitySendEventBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_event);
        SendEventViewModel viewModel=new SendEventViewModel(this);
        binding.setEventViewModel(viewModel);
    }
}
