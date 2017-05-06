package cn.edu.cuit.liyun.laboratory.team;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseActivity;
import cn.edu.cuit.liyun.laboratory.databinding.ActivityTeamDetailBinding;
import cn.edu.cuit.liyun.laboratory.user.UserListActivity;

public class TeamDetailActivity extends BaseActivity {
    ActivityTeamDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String objectId = getIntent().getStringExtra("objectId");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_detail);
        binding.setTeamViewModel(new TeamDetailViewModel(this, objectId));
        registeEventAction(UserListActivity.ACTION_USER_SELECTED);
    }

    @Override
    protected void onEvent(Intent intent) {
        if (intent.getAction().equals(UserListActivity.ACTION_USER_SELECTED)){
            binding.getTeamViewModel().onUserAdd(intent.getStringArrayListExtra("ids"));
        }
    }
}
