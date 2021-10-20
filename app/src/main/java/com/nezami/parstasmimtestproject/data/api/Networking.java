package com.nezami.parstasmimtestproject.data.api;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.nezami.parstasmimtestproject.BuildConfig;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.w3c.dom.Comment;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public class Networking {

    public static BooksApi createService(Application application) {
        Moshi moshi = new Moshi.Builder().build();

        return new Retrofit.Builder()
                .baseUrl("https://postman-library-api.glitch.me/")
                .client(new OkHttpClient.Builder()
                        .cache(new Cache(application.getCacheDir(), 10 * 1024 * 1024))
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG
                                ? HttpLoggingInterceptor.Level.BODY
                                : HttpLoggingInterceptor.Level.NONE))
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .build())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(BooksApi.class);

    }

}
