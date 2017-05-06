package cn.edu.cuit.liyun.laboratory.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.base.BaseFragment;
import cn.edu.cuit.liyun.laboratory.databinding.FragmentDiscussBinding;

/**
 * Created by jianglei on 2017/5/3.
 */

public class DiscussFragment extends BaseFragment {
    FragmentDiscussBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discuss, container, false);
        DisscussViewModel viewModel = new DisscussViewModel(this);
        binding.setDisscussViewModel(viewModel);
        return binding.getRoot();
    }
}
