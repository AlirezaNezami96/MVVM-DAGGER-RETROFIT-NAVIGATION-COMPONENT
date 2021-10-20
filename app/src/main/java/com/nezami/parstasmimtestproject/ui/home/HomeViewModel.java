package com.nezami.parstasmimtestproject.ui.home;

import androidx.annotation.NonNull;

import com.nezami.parstasmimtestproject.data.api.BooksApi;
import com.nezami.parstasmimtestproject.data.model.Book;
import com.nezami.parstasmimtestproject.ui.base.BaseViewModel;
import com.nezami.parstasmimtestproject.util.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public class HomeViewModel extends BaseViewModel {

    BooksApi api;
    CompositeDisposable disposable;
    SchedulerProvider schedulerProvider;

    @Inject
    public HomeViewModel(
            BooksApi api,
            CompositeDisposable disposable,
            SchedulerProvider schedulerProvider) {
        this.api = api;
        this.disposable = disposable;
        this.schedulerProvider = schedulerProvider;
    }


    public void getBooks() {
        disposable.add(
                api.getBooks()
                        .subscribeOn(Schedulers.io())
                        .subscribeWith(new DisposableSingleObserver<List<Book>>() {
                            @Override
                            public void onSuccess(@NonNull List<Book> books) {
                                response.postValue(books);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
//                                handleNetworkError(e);
                            }
                        })
//                        .subscribe(books -> {
//                                    response.postValue(new Response<List<Book>>().success(books));
//                                }
//                        )
        );

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

}
