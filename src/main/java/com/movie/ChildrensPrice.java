package com.movie;

public class ChildrensPrice extends Price {

    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    int getCharge(int _daysRented) {
      int result= 15;
         if (_daysRented > 3){
           result += (_daysRented - 3) * 15;
         }
    return result;
    }

}
