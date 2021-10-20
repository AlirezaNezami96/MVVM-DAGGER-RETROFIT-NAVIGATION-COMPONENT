package com.nezami.parstasmimtestproject.data.model;

import com.nezami.parstasmimtestproject.R;
import com.squareup.moshi.Json;

import java.io.Serializable;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
//@JsonClass(generateAdapter = true)
public class Book implements Serializable {

    @Json(name = "title")
    public String title;
    @Json(name = "author")
    public String author;
    @Json(name = "id")
    public String id;
    @Json(name = "genre")
    public String genre;
    @Json(name = "yearPublished")
    public int yearPublished ;
    @Json(name = "checkedOut")
    public boolean checkedOut;
    @Json(name = "createdAt")
    public String createdAt;
    @Json(name = "message")
    public String message;
    @Json(name = "error")
    public String error;

    public boolean deleted;

    public Book setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
        return this;
    }
    //    public String getTitle() {
//        return title;
//    }
//
//    public Book setTitle(String title) {
//        this.title = title;
//        return this;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public Book setAuthor(String author) {
//        this.author = author;
//        return this;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public Book setId(String id) {
//        this.id = id;
//        return this;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public Book setGenre(String genre) {
//        this.genre = genre;
//        return this;
//    }
//
//    public int getYearPublished() {
//        return yearPublished;
//    }
//
//    public Book setYearPublished(int yearPublished) {
//        this.yearPublished = yearPublished;
//        return this;
//    }
//
//    public boolean isCheckedOut() {
//        return checkedOut;
//    }
//
//    public Book setCheckedOut(boolean checkedOut) {
//        this.checkedOut = checkedOut;
//        return this;
//    }
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public Book setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//        return this;
//    }
//
//    public String getAgeString() {
//        return Integer.toString(yearPublished);
//    }
//
//    public void setAgeString(String ageString) {
//        try {
//            int val = Integer.parseInt(ageString);
//            this.setYearPublished(val);
//        }catch(NumberFormatException ex){
//            this.setYearPublished(2000);
//        }
//    }
}


