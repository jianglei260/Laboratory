package cn.edu.cuit.liyun.laboratory.discuss;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import cn.edu.cuit.liyun.laboratory.base.BaseViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;

/**
 * Created by jianglei on 2017/5/3.
 */

public class UserItemViewModel extends ListItemViewModel {
    public ObservableBoolean selected = new ObservableBoolean(false);
    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> userHead = new ObservableField<>();
    public UserInfo userInfo;

    public UserItemViewModel(UserInfo userInfo) {
        this.userInfo = userInfo;
        username.set(userInfo.getName());
        userHead.set(userInfo.getUrl());
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_NORMAL;
    }
}
