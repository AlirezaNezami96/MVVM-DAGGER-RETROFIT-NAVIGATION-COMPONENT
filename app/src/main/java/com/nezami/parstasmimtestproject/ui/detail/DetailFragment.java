package com.nezami.parstasmimtestproject.ui.detail;

import android.os.Bundle;

import com.nezami.parstasmimtestproject.R;
import com.nezami.parstasmimtestproject.databinding.FragmentDetailBinding;
import com.nezami.parstasmimtestproject.di.component.FragmentComponent;
import com.nezami.parstasmimtestproject.ui.base.BaseFragment;

public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> {

    @Override
    public FragmentDetailBinding getViewBinding() {
        return FragmentDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    public void observeEvents() {
        viewModel.bookDetail.observe(this, book -> {
            viewModel.book = book;
        });
        viewModel.bookDeleted.observe(this, edited -> {
            Bundle args = new Bundle();
            args.putSerializable("book", viewModel.bookDetail.getValue());
            navController.navigate(R.id.back_to_home_from_detail, args);
        });
        viewModel.bookCheckedOut.observe(this, aBoolean -> binding.setViewmodel(viewModel));
    }

    @Override
    public void injectDependencies(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void setupView() {
        binding.setViewmodel(viewModel);
    }
}