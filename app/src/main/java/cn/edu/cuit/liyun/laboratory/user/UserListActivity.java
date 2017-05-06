package cn.edu.cuit.liyun.laboratory.user;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseActivity;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.databinding.ActivityUserListBinding;

public class UserListActivity extends BaseActivity {
    ActivityUserListBinding binding;
    public static final String ACTION_USER_SELECTED = "ACTION_USER_SELECTED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);
        binding.setUserViewModel(new UserListViewModel(this));
    }

    public void onSelected(List<UserInfo> userInfos) {
        Intent intent = new Intent(ACTION_USER_SELECTED);
        ArrayList<String> userIds = new ArrayList<>();
        for (UserInfo userInfo : userInfos) {
            userIds.add(userInfo.getObjectId());
        }
        intent.putStringArrayListExtra("ids", userIds);
        publishEvent(intent);
        finish();
    }
}
