package cn.edu.cuit.liyun.laboratory.team;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.databinding.ActivityTeamListBinding;

public class TeamListActivity extends AppCompatActivity {
    ActivityTeamListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_list);
        TeamListViewMode viewMode = new TeamListViewMode(this);
        binding.setTeamViewModel(viewMode);
    }
}
