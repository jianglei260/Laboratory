package cn.edu.cuit.liyun.laboratory.main;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.widget.Toast;

import com.kelin.mvvmlight.command.ReplyCommand;

import java.util.List;

import cn.edu.cuit.liyun.laboratory.BR;
import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.DetailViewModel;
import cn.edu.cuit.liyun.laboratory.base.ListItemViewModel;
import cn.edu.cuit.liyun.laboratory.base.LoaddingViewModel;
import cn.edu.cuit.liyun.laboratory.base.Refreshable;
import cn.edu.cuit.liyun.laboratory.data.entity.Event;
import cn.edu.cuit.liyun.laboratory.data.repository.EventRepository;
import cn.edu.cuit.liyun.laboratory.event.EventItemViewModel;
import cn.edu.cuit.liyun.laboratory.event.SendEventActivity;
import cn.edu.cuit.liyun.laboratory.utils.IOTask;
import cn.edu.cuit.liyun.laboratory.utils.RxUtil;
import cn.edu.cuit.liyun.laboratory.utils.UIAction;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.functions.Action0;

/**
 * Created by jianglei on 2017/5/3.
 */

public class EventViewModel extends DetailViewModel implements Refreshable {
    private EventFragment fragment;
    public ObservableList<ListItemViewModel> viewModels = new ObservableArrayList<>();
    public ItemViewSelector<ListItemViewModel> itemView = new ItemViewSelector<ListItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, ListItemViewModel item) {
            switch (item.getViewType()) {
                case ListItemViewModel.VIEW_TYPE_NORMAL:
                    itemView.set(BR.itemViewModel, R.layout.list_event);
                    break;
            }
        }

        @Override
        public int viewTypeCount() {
            return 1;
        }
    };
    public ReplyCommand addClick = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            Intent intent = new Intent(fragment.getActivity(), SendEventActivity.class);
            fragment.startActivity(intent);
        }
    });


    public EventViewModel(EventFragment fragment) {
        this.fragment = fragment;
        title.set(fragment.getString(R.string.event_title));
        initEvent(null);
    }

    public void initEvent(final OnComplete onComplete) {
        loadding.set(true);
        RxUtil.execute(new IOTask<List<Event>>() {
            @Override
            public List<Event> run() {
                return EventRepository.getInstance().getAllEvent();
            }
        }, new UIAction<List<Event>>() {
            @Override
            public void onComplete(List<Event> events) {
                viewModels.clear();
                loadding.set(false);
                if (onComplete != null)
                    onComplete.onComplete();
                if (events == null) {
                    Toast.makeText(fragment.getActivity(), R.string.load_failed, Toast.LENGTH_SHORT).show();
                    return;
                }
                for (Event event : events) {
                    EventItemViewModel itemViewModel = new EventItemViewModel(fragment, event);
                    viewModels.add(itemViewModel);
                }
            }
        });
    }

    @Override
    public void onLoadMore(OnComplete complete) {

    }

    @Override
    public void onRefresh(OnComplete complete) {
        initEvent(complete);
    }
}
