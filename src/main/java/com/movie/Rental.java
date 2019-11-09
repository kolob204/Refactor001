package com.movie;

public class Rental {

    private Movie _movie; // переменная объекта "ФИЛЬМ"
    private int _daysRented;

    //конструктор
    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public Movie    get_movie() {
        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    //перемещаем метод в соответствующий обрабатываемым параметрам класс
      int getCharge() {
        int result=0;
        switch (get_movie().get_priceCode()) {
            //1 первым объектом для рефакторинга будет SWITCH оператор, который необходимо выделить в отдельный метод
            case Movie.REGULAR:
                result += 2;
                if (get_daysRented() > 2){
                    result += (get_daysRented() - 2) * 15;
                }
                break;
            case Movie.NEW_RELEASE:
                result += get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 15;
                if (get_daysRented() > 3){
                    result += (get_daysRented() - 3) * 15;
                }
                break;
        } //
        return result;
    }

    int getfrequentRenterPoints() {
    if (get_movie().get_priceCode()==Movie.NEW_RELEASE&&get_daysRented()>1) {return 2;}
    else {return 1;}
    }   //getfrequentRenterPoints



}
