package com.movie;

public class NewReleasePrice extends Price {

    int getPriceCode(){
    return Movie.NEW_RELEASE;
    }

    int getCharge(int _daysRented) {
        return _daysRented * 3;
    }

    int getfrequentRenterPoints(int _daysRented) {
        /*if (_daysRented > 1) {
            return 2;
        } else {
            return 1;
        }*/
        return (_daysRented > 1) ? 2:1;    }
}
