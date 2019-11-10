package com.movie;

abstract class Price {
    abstract int getPriceCode();


    //перемещаем метод в соответствующий обрабатываемым параметрам класс
    //так как в нём фигурирует только одна переменная из другого класса (_daysRented) . мы её передаём в качестве параметра из соответствующего
    //класса RENTAL
    int getCharge(int _daysRented) {
        int result=0;
        switch (getPriceCode()) {
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
}
