package com.movie;

public class Rental {

    private Movie _movie; // переменная объекта "ФИЛЬМ"
    private int _daysRented;

    //конструктор

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }
}
