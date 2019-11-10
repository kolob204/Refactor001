package com.movie;

public class Movie {

    public static final int CHILDRENS = 2;  //коэфициенты для типов фильмов
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String  _title;
    //private int     _priceCode;
    private Price   _price;

    //конструктор
    public Movie(String title, int pricecode) {
        _title      = title;
        set_priceCode(pricecode);
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_priceCode(int arg) {
       switch (arg) {

           case REGULAR:     _price = new RegularPrice();    break;
           case CHILDRENS:   _price = new ChildrensPrice();  break;
           case NEW_RELEASE: _price = new NewReleasePrice(); break;
           default: throw new IllegalArgumentException("Incorrect Code");
       }

    } //set_priceCode  end_of

    public int get_priceCode() {
        return   _price.getPriceCode();
    }

    int getCharge(int _daysRented) {
        return _price.getCharge(_daysRented);
    }

    int getfrequentRenterPoints(int _daysRented) {
        return _price.getfrequentRenterPoints(_daysRented);
    }   //getfrequentRenterPoints end_of
}
