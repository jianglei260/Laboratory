package cn.edu.cuit.liyun.laboratory.event;

import android.databinding.ObservableField;

import cn.edu.cuit.liyun.laboratory.base.BaseViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.base.LoaddingViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.Event;
import cn.edu.cuit.liyun.laboratory.main.EventFragment;
import cn.edu.cuit.liyun.laboratory.utils.StringUtil;

/**
 * Created by jianglei on 2017/5/3.
 */

public class EventItemViewModel extends ListItemViewModel {
    private EventFragment fragment;
    private Event event;
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> sender = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();
    public ObservableField<String> userHead = new ObservableField<>();

    public EventItemViewModel(EventFragment fragment, Event event) {
        this.fragment = fragment;
        this.event = event;
        title.set(event.getTitle());
        content.set(event.getContent());
        date.set(StringUtil.getFormatDate(Long.valueOf(event.getUpdatedAt())));
        sender.set(event.getSender().getNick());
        userHead.set(event.getSender().getUrl());
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_NORMAL;
    }
}
