package com.movie;

import java.util.Enumeration;
import java.util.Vector;
import  com.movie.Rental;

public class Customer {
    private String _name;
    private  Vector _rentals = new Vector();

    //конструктор
    public Customer(String name) {
        this._name = name;
    }

    //Объект - Арендатор, будет список аренды
    public void addRental(Rental arg) {
        //исправлена опечатка кода в книге
        _rentals.addElement(arg);
    }

    public String get_name() {
        return _name;
    }

    private int amountFor(Rental aRental) {
        return aRental.getCharge();
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
        int totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result ="Учет аренды для : " + get_name() + "\n";
        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();
            //определить сумму для каждой строки


            // убрали временную переменную thisAmount,  и присваиваем выход each.getCharge(); там где это нужно - напрямую
            //старайтесь избаляться от временных переменных


            //выделим так же начисление бонусов в отдельный метод. и поместим его в класс Rental, потому что
            //в этом блоке логики идёт работа с переменными, относящимися к этому классу
            frequentRenterPoints+=each.getfrequentRenterPoints();

//показать результаты для этой аренды
            result += "\t" + each.get_movie().get_title()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        } // WHILE

//добавить нижний колонтитул
        result += "Сумма задолженности составляет: " +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
" очка(ов) за активность";
        return result;

    }  // statement()


}
