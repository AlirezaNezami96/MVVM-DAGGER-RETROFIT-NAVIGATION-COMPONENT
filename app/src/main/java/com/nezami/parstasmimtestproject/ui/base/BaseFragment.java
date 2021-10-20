package com.nezami.parstasmimtestproject.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.nezami.parstasmimtestproject.MyApplication;
import com.nezami.parstasmimtestproject.data.model.Book;
import com.nezami.parstasmimtestproject.di.component.DaggerFragmentComponent;
import com.nezami.parstasmimtestproject.di.component.FragmentComponent;
import com.nezami.parstasmimtestproject.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public abstract class BaseFragment<B extends ViewBinding, VM extends BaseViewModel> extends Fragment {
    public final String TAG = BaseFragment.class.getName();

    @Inject
    public VM viewModel;

    public NavController navController;

    public B binding;

    public abstract B getViewBinding();

    public abstract void observeEvents();

    public abstract void injectDependencies(FragmentComponent fragmentComponent);

    public abstract void setupView();

    private FragmentComponent buildFragmentComponent() {
        return DaggerFragmentComponent
                .builder()
                .applicationComponent(((MyApplication) getContext()
                        .getApplicationContext()).applicationComponent)
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(buildFragmentComponent());
        if (getArguments() != null && viewModel != null) {
            if (getArguments().getSerializable("book") != null)
                viewModel.bookDetail.postValue((Book) getArguments().getSerializable("book"));
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = getViewBinding();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        observeEvents();
        setupView();
    }
}
