package com.nezami.parstasmimtestproject.util.rx;

import javax.inject.Singleton;

import io.reactivex.Scheduler;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
@Singleton
public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();

}
