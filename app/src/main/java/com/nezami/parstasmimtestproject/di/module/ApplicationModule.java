package com.nezami.parstasmimtestproject.di.module;

import android.app.Application;

import com.nezami.parstasmimtestproject.MyApplication;
import com.nezami.parstasmimtestproject.data.api.BooksApi;
import com.nezami.parstasmimtestproject.data.api.Networking;
import com.nezami.parstasmimtestproject.util.rx.RxSchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
@Module
public class ApplicationModule {


    private MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    BooksApi provideBooksApi() {
        return Networking.createService(application);
    }

    @Provides
    @Singleton
    RxSchedulerProvider provideSchedulerProvider() {
        return new RxSchedulerProvider();
    }

    @Provides
    @Singleton
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
