package com.nezami.parstasmimtestproject.data.request;

import com.squareup.moshi.Json;

/**
 * Created by Alireza Nezami on 10/19/2021.
 */
public class CheckOut {
    @Json(name = "checkedOut")
    public boolean checkedOut;

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
