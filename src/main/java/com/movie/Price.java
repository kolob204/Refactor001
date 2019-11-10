package com.movie;

abstract class Price {
    abstract int getPriceCode();
    abstract int getCharge(int _daysRented);
    int getfrequentRenterPoints(int _daysRented){
        return 1;
    }


    //перемещаем метод в соответствующий обрабатываемым параметрам класс
    //так как в нём фигурирует только одна переменная из другого класса (_daysRented) . мы её передаём в качестве параметра из соответствующего
    //класса RENTAL

}
