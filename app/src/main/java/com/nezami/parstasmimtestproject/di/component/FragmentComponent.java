package com.nezami.parstasmimtestproject.di.component;


import android.content.Context;

import com.nezami.parstasmimtestproject.di.module.FragmentModule;
import com.nezami.parstasmimtestproject.di.scope.FragmentScope;
import com.nezami.parstasmimtestproject.ui.detail.DetailFragment;
import com.nezami.parstasmimtestproject.ui.add.AddFragment;
import com.nezami.parstasmimtestproject.ui.home.HomeFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = {ApplicationComponent.class}, modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(HomeFragment fragment);

    void inject(DetailFragment fragment);

    Context getContext();

    void inject(AddFragment addFragment);
}
