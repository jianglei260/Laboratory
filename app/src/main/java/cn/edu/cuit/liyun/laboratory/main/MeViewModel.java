package cn.edu.cuit.liyun.laboratory.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseViewModel;
import cn.edu.cuit.liyun.laboratory.dailytime.NewSignActivity;
import cn.edu.cuit.liyun.laboratory.dailytime.SignActivity;
import cn.edu.cuit.liyun.laboratory.dailytime.SignListActivity;
import cn.edu.cuit.liyun.laboratory.data.entity.Role;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.login.UserLoginActivity;
import cn.edu.cuit.liyun.laboratory.me.UserInfoActivity;
import cn.edu.cuit.liyun.laboratory.me.UserInfoViewModel;
import cn.edu.cuit.liyun.laboratory.settings.SettingActivity;
import cn.edu.cuit.liyun.laboratory.team.TeamListActivity;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/4.
 */

public class MeViewModel extends BaseViewModel {
    private MeFragment fragment;
    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> userHead = new ObservableField<>();
    private UserInfo myInfo;
    public ReplyCommand teamClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(fragment.getActivity(), TeamListActivity.class);
            fragment.startActivity(intent);
        }
    });

    public ReplyCommand settingClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
//            Intent intent = new Intent(fragment.getActivity(), SettingActivity.class);
//            fragment.startActivity(intent);
            logout();
        }
    });
    public ReplyCommand allTeamClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(fragment.getActivity(), TeamListActivity.class);
            fragment.startActivity(intent);
        }
    });
    public ReplyCommand signClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            if (myInfo.getRole()== Role.STUDENT){
                Intent intent = new Intent(fragment.getActivity(), SignActivity.class);
                fragment.startActivity(intent);
            }else {
                Intent intent = new Intent(fragment.getActivity(), NewSignActivity.class);
                fragment.startActivity(intent);
            }
        }
    });
    public ReplyCommand signViewClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(fragment.getActivity(), SignListActivity.class);
            fragment.startActivity(intent);
        }
    });
    public ReplyCommand userHeadClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(fragment.getActivity(), UserInfoActivity.class);
            fragment.startActivity(intent);
        }
    });

    public MeViewModel(MeFragment fragment) {
        this.fragment = fragment;
        initUserInfo();
    }

    public void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getActivity());
        builder.setMessage("是否退出登录").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doLogout();
                dialog.dismiss();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void doLogout() {
        RxUtil.execute(new IOTask<Boolean>() {
            @Override
            public Boolean run() {
                UserRepository.getInstance().logout();
                return true;
            }
        }, new UIAction<Boolean>() {
            @Override
            public void onComplete(Boolean aBoolean) {
                Intent intent = new Intent(fragment.getActivity(), UserLoginActivity.class);
                fragment.startActivity(intent);
                fragment.getActivity().finish();
            }
        });
    }

    public void initUserInfo() {
        RxUtil.execute(new IOTask<UserInfo>() {
            @Override
            public UserInfo run() {
                return UserRepository.getInstance().getMyInfo();
            }
        }, new UIAction<UserInfo>() {
            @Override
            public void onComplete(UserInfo userInfo) {
                MeViewModel.this.myInfo = userInfo;
                bindInfo();
            }
        });
    }

    public void bindInfo() {
        userHead.set(myInfo.getUrl());
        userName.set(myInfo.getName());
    }
}
