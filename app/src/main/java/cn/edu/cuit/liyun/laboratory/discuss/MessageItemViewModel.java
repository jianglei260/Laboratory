package cn.edu.cuit.liyun.laboratory.discuss;

import android.databinding.ObservableField;

import cn.edu.cuit.liyun.laboratory.base.BaseViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.Message;

/**
 * Created by jianglei on 2017/5/4.
 */

public class MessageItemViewModel extends ListItemViewModel {
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();
    public ObservableField<String> userHead = new ObservableField<>();
    public Message message;

    public MessageItemViewModel(Message message) {
        this.message = message;
        content.set(message.getContent());
        userHead.set(message.getSender().getUrl());
        date.set(message.getCreatedAt());
    }

    @Override
    public int getViewType() {
        return 0;
    }
}
