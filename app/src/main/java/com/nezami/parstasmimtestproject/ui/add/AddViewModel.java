package com.nezami.parstasmimtestproject.ui.add;

import com.nezami.parstasmimtestproject.data.api.BooksApi;
import com.nezami.parstasmimtestproject.data.model.Book;
import com.nezami.parstasmimtestproject.ui.base.BaseViewModel;
import com.nezami.parstasmimtestproject.util.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alireza Nezami on 10/19/2021.
 */
public class AddViewModel extends BaseViewModel {

    BooksApi api;
    CompositeDisposable disposable;
    SchedulerProvider schedulerProvider;

    @Inject
    public AddViewModel(
            BooksApi api,
            CompositeDisposable disposable,
            SchedulerProvider schedulerProvider) {
        this.api = api;
        this.disposable = disposable;
        this.schedulerProvider = schedulerProvider;
    }

    public Book book = new Book();

    public void onAddNewBookClick() {
        addNewBook(book);
    }

    public void addNewBook(Book book) {
        disposable.add(
                api.addBook(book)
                        .subscribeOn(Schedulers.io())
                        .subscribe(book1 -> {
                            if (book1.message.equals("OK")) {
                                bookDetail.postValue(book);
                                newBookAdded.postValue(true);
                            }
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
