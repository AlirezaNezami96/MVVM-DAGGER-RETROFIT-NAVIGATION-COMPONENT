package com.nezami.parstasmimtestproject.ui.add;

import android.os.Bundle;

import com.nezami.parstasmimtestproject.R;
import com.nezami.parstasmimtestproject.databinding.FragmentAddBookBinding;
import com.nezami.parstasmimtestproject.di.component.FragmentComponent;
import com.nezami.parstasmimtestproject.ui.base.BaseFragment;

public class AddFragment extends BaseFragment<FragmentAddBookBinding, AddViewModel> {


    @Override
    public FragmentAddBookBinding getViewBinding() {
        return FragmentAddBookBinding.inflate(getLayoutInflater());
    }

    @Override
    public void observeEvents() {
        viewModel.newBookAdded.observe(this, edited -> {
            Bundle args = new Bundle();
            args.putSerializable("book", viewModel.bookDetail.getValue());
            navController.navigate(R.id.back_to_home, args);
        });
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