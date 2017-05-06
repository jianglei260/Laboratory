package cn.edu.cuit.liyun.laboratory.discuss;

import android.content.Intent;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.data.entity.Discuss;
import cn.edu.cuit.liyun.laboratory.main.DiscussFragment;
import cn.edu.cuit.liyun.laboratory.utils.StringUtil;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/3.
 */

public class DiscussItemViewModel extends ListItemViewModel {
    private DiscussFragment fragment;
    private Discuss discuss;
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> sender = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();

    public DiscussItemViewModel(DiscussFragment fragment, Discuss discuss) {
        this.fragment = fragment;
        this.discuss = discuss;
        title.set(discuss.getTitle());
        sender.set(discuss.getSender().getNick());
        date.set(StringUtil.getFormatDate(Long.valueOf(discuss.getUpdatedAt())));
    }

    public ReplyCommand itemClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(fragment.getActivity(), DiscussDetailActivity.class);
            intent.putExtra("objectId",discuss.getObjectId());
            fragment.startActivity(intent);
        }
    });

    @Override
    public int getViewType() {
        return VIEW_TYPE_NORMAL;
    }
}
