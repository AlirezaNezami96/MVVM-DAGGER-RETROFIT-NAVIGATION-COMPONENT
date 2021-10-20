package com.nezami.parstasmimtestproject.data.api;

import com.nezami.parstasmimtestproject.util.common.Status;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public class Result<T> {

    private Status status;
    private T data;

    Result(Status status, T data) {
        this.status = status;
        this.data = data;

    }

    public Result success(Status status, T data) {
        return new Result(status, data);
    }
}
