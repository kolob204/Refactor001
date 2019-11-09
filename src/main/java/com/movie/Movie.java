package com.movie;

public class Movie {

    public static final int CHILDRENS = 2;  //коэфициенты для типов фильмов
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String  _title;
    private int     _priceCode;

    //конструктор
    public Movie(String title, int pricecode) {
        _title      = title;
        _priceCode  = pricecode;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

}
