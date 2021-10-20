package com.nezami.parstasmimtestproject.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.nezami.parstasmimtestproject.R;
import com.nezami.parstasmimtestproject.databinding.FragmentHomeBinding;
import com.nezami.parstasmimtestproject.di.component.FragmentComponent;
import com.nezami.parstasmimtestproject.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {


    private BooksAdapter adapter;

    @Override
    public FragmentHomeBinding getViewBinding() {
        return FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void observeEvents() {
        viewModel.response.observe(this, response -> {
                if (adapter != null) {
                    adapter.updateData(response);
                }
                showList();
        });

        viewModel.bookDetail.observe(this, book -> {
            if (adapter!=null && adapter.getItemCount()>0){
                adapter.update(book);
            }
        });

    }

    @Override
    public void injectDependencies(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void setupView() {
        initAdapter();
        if (viewModel.response.getValue() == null)
            viewModel.getBooks();
    }

    private void initAdapter() {
        adapter = new BooksAdapter();
        adapter.setonItemClickListener(book -> {
            Bundle args = new Bundle();
            args.putSerializable("book", book);
            navController.navigate(R.id.show_book_detail, args);
        });
        binding.rvBooks.setAdapter(adapter);
        binding.rvBooks.setLayoutManager(new LinearLayoutManager(this.getContext()));

        binding.btnAdd.setOnClickListener(view -> navController.navigate(R.id.showAddFragment));
    }

    private void showLoading() {
        binding.progress.setVisibility(View.VISIBLE);
        binding.rvBooks.setVisibility(View.GONE);
    }

    private void showList() {
        binding.progress.setVisibility(View.GONE);
        binding.rvBooks.setVisibility(View.VISIBLE);
    }

}