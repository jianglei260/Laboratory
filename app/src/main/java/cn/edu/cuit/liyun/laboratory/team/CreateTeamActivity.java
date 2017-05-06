package cn.edu.cuit.liyun.laboratory.team;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.databinding.ActivityCreateTeamBinding;

public class CreateTeamActivity extends AppCompatActivity {
    ActivityCreateTeamBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_team);
        CreateTeamViewModel viewModel=new CreateTeamViewModel(this);
        binding.setTeamViewModel(viewModel);
    }
}
