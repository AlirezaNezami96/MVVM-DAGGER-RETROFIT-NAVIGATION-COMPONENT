package com.nezami.parstasmimtestproject.ui.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nezami.parstasmimtestproject.data.model.Book;

import java.util.List;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public abstract class BaseViewModel extends ViewModel {

    MutableLiveData<Integer> messageStringId = new MutableLiveData<>();
    MutableLiveData<String> messageString = new MutableLiveData<>();


    public MutableLiveData<Book> bookDetail = new MutableLiveData<>();

    public MutableLiveData<Boolean> newBookAdded = new MutableLiveData<>();

    public MutableLiveData<Boolean> bookCheckedOut = new MutableLiveData<>();

    public MutableLiveData<Boolean> bookDeleted = new MutableLiveData<>();

    public MutableLiveData<List<Book>> response = new MutableLiveData<>();

//    protected void handleNetworkError(@Nullable Throwable error) {
//        if (error != null) {
//
//            NetworkError networkError = networkHelper.castToNetworkError(error);
//            switch (networkError.statusCode) {
//                case -1:
//                    messageStringId.postValue(R.string.network_default_error);
//                    break;
//                case 0:
//                    messageStringId.postValue(R.string.server_connection_error);
//                    break;
//                case HttpsURLConnection.HTTP_UNAUTHORIZED:
//                    messageStringId.postValue(R.string.not_authorized);
//                    break;
//                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
//                    messageStringId.postValue(R.string.network_internal_error);
//                    break;
//                case HttpsURLConnection.HTTP_UNAVAILABLE:
//                    messageStringId.postValue(R.string.network_server_not_available);
//                    break;
//                default:
//
//            }
//        }
//    }
}

