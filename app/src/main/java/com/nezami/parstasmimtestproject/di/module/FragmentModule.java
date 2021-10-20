package com.nezami.parstasmimtestproject.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nezami.parstasmimtestproject.data.api.BooksApi;
import com.nezami.parstasmimtestproject.di.scope.FragmentScope;
import com.nezami.parstasmimtestproject.ui.add.AddViewModel;
import com.nezami.parstasmimtestproject.ui.detail.DetailViewModel;
import com.nezami.parstasmimtestproject.ui.home.HomeViewModel;
import com.nezami.parstasmimtestproject.util.factory.ViewModelProviderFactory;
import com.nezami.parstasmimtestproject.util.rx.RxSchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    Context provideContext() {
        return fragment.getContext();
    }

    @Provides
    HomeViewModel provideHomeViewModel(
            BooksApi api,
            CompositeDisposable disposable,
            RxSchedulerProvider schedulerProvider) {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel( api, disposable, schedulerProvider);
        ViewModelProviderFactory<HomeViewModel> factory =
                new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(
                fragment, factory
        ).get(HomeViewModel.class);
    }

    @Provides
    AddViewModel provideAddViewModel(
            BooksApi api,
            CompositeDisposable disposable,
            RxSchedulerProvider schedulerProvider) {
        Supplier<AddViewModel> supplier = () -> new AddViewModel( api, disposable, schedulerProvider);
        ViewModelProviderFactory<AddViewModel> factory =
                new ViewModelProviderFactory<>(AddViewModel.class, supplier);
        return new ViewModelProvider(
                fragment, factory
        ).get(AddViewModel.class);
    }

    @Provides
    DetailViewModel provideDetailViewModel(
            BooksApi api,
            CompositeDisposable disposable,
            RxSchedulerProvider schedulerProvider) {
        Supplier<DetailViewModel> supplier = () -> new DetailViewModel( api, disposable, schedulerProvider);
        ViewModelProviderFactory<DetailViewModel> factory =
                new ViewModelProviderFactory<>(DetailViewModel.class, supplier);
        return new ViewModelProvider(
                fragment, factory
        ).get(DetailViewModel.class);
    }

}
