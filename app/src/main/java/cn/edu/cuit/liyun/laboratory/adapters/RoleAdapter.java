package cn.edu.cuit.liyun.laboratory.adapters;

import android.databinding.BindingAdapter;
import android.view.View;

import cn.edu.cuit.liyun.laboratory.data.entity.Role;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;

/**
 * Created by jianglei on 2017/5/6.
 */

public class RoleAdapter {
    public static final int STUDENT = 1;
    public static final int TEACHER = 2;
    public static final int ADMIN = 4;

    @BindingAdapter({"roleVisible"})
    public static void setRoleVisible(final View view, final int role) {
        RxUtil.execute(new IOTask<UserInfo>() {
            @Override
            public UserInfo run() {
                return UserRepository.getInstance().getMyInfo();
            }
        }, new UIAction<UserInfo>() {
            @Override
            public void onComplete(UserInfo userInfo) {
                view.setVisibility(View.GONE);
                if (userInfo == null) {
                    view.setVisibility(View.GONE);
                    return;
                }
                if ((role>>0 & 0x01) != 0) {
                    if (userInfo.getRole() == Role.STUDENT) {
                        view.setVisibility(View.VISIBLE);
                    }
                }
                if ((role>>1 & 0x01) != 0) {
                    if (userInfo.getRole() == Role.TEACHER) {
                        view.setVisibility(View.VISIBLE);
                    }
                }
                if ((role>>2 & 0x01) != 0) {
                    if (userInfo.getRole() == Role.ADMIN) {
                        view.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

    }
}
