package com.nezami.parstasmimtestproject.ui.detail;

import com.nezami.parstasmimtestproject.data.api.BooksApi;
import com.nezami.parstasmimtestproject.data.model.Book;
import com.nezami.parstasmimtestproject.data.request.CheckOut;
import com.nezami.parstasmimtestproject.ui.base.BaseViewModel;
import com.nezami.parstasmimtestproject.util.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public class DetailViewModel extends BaseViewModel {

    public Book book = new Book();

    BooksApi api;
    CompositeDisposable disposable;
    SchedulerProvider schedulerProvider;

    @Inject
    public DetailViewModel(
            BooksApi api,
            CompositeDisposable disposable,
            SchedulerProvider schedulerProvider) {
        this.api = api;
        this.disposable = disposable;
        this.schedulerProvider = schedulerProvider;
    }


    public void checkOutBook() {
        CheckOut checkOut = new CheckOut();
        checkOut.setCheckedOut(!book.checkedOut);
        book.setCheckedOut(checkOut.checkedOut);
        disposable.add(
                api.checkOutBook(book.id, checkOut)
                        .subscribeOn(Schedulers.io())
                        .subscribe(book1 -> {
                            if (book1.message.equals("OK")) {
                                bookDetail.postValue(book);
                                bookCheckedOut.postValue(true);
                            } else bookCheckedOut.postValue(false);
                        })
        );
    }

    public void deleteBook() {

        disposable.add(
                api.deleteBook(book.id)
                        .subscribeOn(Schedulers.io())
                        .subscribe(book1 -> {
                            if (book1.message.equals("OK")) {
                                book.deleted = true;
                                bookDetail.postValue(book);
                                bookDeleted.postValue(true);
                            } else bookDeleted.postValue(false);
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

}
