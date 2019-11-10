package com.movie;

public class RegularPrice extends Price {

    int getPriceCode() {
        return Movie.REGULAR;
    }

    int getCharge(int _daysRented) {
        int result=2;
        if (_daysRented  > 2){
          result += (_daysRented - 2) * 15;
        }
    return result;
    }


}
