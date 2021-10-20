package com.nezami.parstasmimtestproject;

import android.app.Application;

import com.nezami.parstasmimtestproject.di.component.ApplicationComponent;
import com.nezami.parstasmimtestproject.di.component.DaggerApplicationComponent;
import com.nezami.parstasmimtestproject.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public class MyApplication extends Application {

    public ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        getDependencies();
    }

    public void getDependencies() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }
}
