package com.movie;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private  Vector _rentals = new Vector();

    //конструктор
    public Customer(String name) {
        this._name = name;
    }

    public void addRental(Rental arg) {
        _rentals addElement(arg);
    }

    public String get_name() {
        return _name;
    }

    //(c) Если взглянуть на код,
    //можно увидеть, что невозможно повторно использовать текущий метод statement для создания отчета в HTML.
    //Можно просто скопировать метод statement и произвести необходимые изменения.
    //Но что произойдет, если изменятся правила оплаты? Придется изменить как statement, так и htmlStatement,
    //проследив за тем, чтобы изменения были согласованы.
    //по мере роста сложности правил расчётов и вывода информации - становится все труднее определить,
    //где должны быть произведены изменения, и осуществить их, не сделав ошибки.

    //Обнаружив, что в программу необходимо добавить новую функциональность, но код программы не
    //структурирован удобным для добавления этой функциональности образом, сначала произведите рефакторинг
    //программы, чтобы упростить внесение необходимых изменений, а только потом добавьте функцию.
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result ="Учет аренды для" + get_name() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
//определить сумму для каждой строки
            switch (each.get_movie().get_priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.get_daysRented() > 2){
                        thisAmount += (each.get_daysRented() - 2) * 15;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.get_daysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 15;
                    if (each.get_daysRented() > 3){
                        thisAmount += (each.get_daysRented() - 3) * 15;
                    }
                    break;
            } //
// добавить очки для активного арендатора
            frequentRenterPoints ++;
// бонус за аренду новинки на два дня
            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE) &&
                    each.get_daysRented() > 1) {
                frequentRenterPoints ++;
            }
//показать результаты для этой аренды
            result += "\t" + each.get_movie().get_title()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        } // WHILE

//добавить нижний колонтитул
        result += "Сумма задолженности составляет" +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
"очков за активность";
        return result;

    }  // statement()

}
