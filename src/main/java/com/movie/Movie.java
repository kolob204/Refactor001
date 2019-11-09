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

    //перемещаем метод в соответствующий обрабатываемым параметрам класс
    //так как в нём фигурирует только одна переменная из другого класса (_daysRented) . мы её передаём в качестве параметра из соответствующего
    //класса RENTAL
    int getCharge(int _daysRented) {
        int result=0;
        switch (get_priceCode()) {
            //1 первым объектом для рефакторинга будет SWITCH оператор, который необходимо выделить в отдельный метод
            case Movie.REGULAR:
                result += 2;
                if (_daysRented  > 2){
                    result += (_daysRented - 2) * 15;
                }
                break;
            case Movie.NEW_RELEASE:
                result += _daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 15;
                if (_daysRented > 3){
                    result += (_daysRented - 3) * 15;
                }
                break;
        } //
        return result;
    }

    int getfrequentRenterPoints(int _daysRented) {
        if (_priceCode==Movie.NEW_RELEASE&&_daysRented>1) {return 2;}
        else {return 1;}
    }   //getfrequentRenterPoints
}
