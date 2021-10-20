package com.nezami.parstasmimtestproject.di.component;

import com.nezami.parstasmimtestproject.MyApplication;
import com.nezami.parstasmimtestproject.data.api.BooksApi;
import com.nezami.parstasmimtestproject.di.module.ApplicationModule;
import com.nezami.parstasmimtestproject.util.rx.RxSchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MyApplication application);

    BooksApi getBooksApi();

    RxSchedulerProvider getSchedulerProvider();

    CompositeDisposable getCompositeDisposable();

//    Application getApplication();
}
