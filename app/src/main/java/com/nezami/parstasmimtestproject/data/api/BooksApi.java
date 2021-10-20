package com.nezami.parstasmimtestproject.data.api;

import com.nezami.parstasmimtestproject.data.model.Book;
import com.nezami.parstasmimtestproject.data.request.CheckOut;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public interface BooksApi {

    @GET("books")
    Single<List<Book>> getBooks();

    @GET("books/{id}")
    Single<Book> getBook(
            @Path("id") String bookId
    );

    @POST("books")
    Single<Book> addBook(
            @Body Book book
    );

    @PATCH("books/{id}")
    Single<Book> checkOutBook(
            @Path("id") String bookId,
            @Body CheckOut checkOut
    );

    @DELETE("books/{id}")
    Single<Book> deleteBook(
            @Path("id") String bookId
    );
}
