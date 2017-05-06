package cn.edu.cuit.liyun.laboratory.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseFragment;
import cn.edu.cuit.liyun.laboratory.databinding.FragmentEventBinding;

/**
 * Created by jianglei on 2017/5/3.
 */

public class EventFragment extends BaseFragment {
    FragmentEventBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event, container, false);
        EventViewModel viewModel = new EventViewModel(this);
        binding.setEventViewModel(viewModel);
        return binding.getRoot();
    }
}
