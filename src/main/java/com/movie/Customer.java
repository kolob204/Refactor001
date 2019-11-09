package com.movie;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private  Vector _rentals = new Vector();

    //конструктор
    public Customer(String name) {
        this._name = name;
    }

    // Опишем событие - "Арендатор взял фильм в прокат"
    // Объект - Арендатор, будет список аренды
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

        Enumeration rentals = _rentals.elements();
        String result ="Учет аренды для : " + get_name() + "\n";
        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();
            //определить сумму для каждой строки


            // убрали временную переменную thisAmount,  и присваиваем выход each.getCharge(); там где это нужно - напрямую
            //старайтесь избаляться от временных переменных
            //однако теперь each.getCharge();  считается дважды.
            //следующим шагом, мы вынесем этот подсчёт в отдельный метод


            //выделим так же начисление бонусов в отдельный метод. и поместим его в класс Rental, потому что
            //в этом блоке логики идёт работа с переменными, относящимися к этому классу


//показать результаты для этой аренды
            result += "\t" + each.get_movie().get_title()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";

        } // WHILE

//добавить нижний колонтитул
        result += "Сумма задолженности составляет: " +
                String.valueOf(gettotalcharge()) + "\n";
        result += "Вы заработали " + String.valueOf(getfrequentRenterPoints()) +
" очка(ов) за активность";
        return result;

    }  // statement()

   int gettotalcharge() {
        int result=0;
       Enumeration rentals = _rentals.elements();
       while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           result+=each.getCharge();
       }
        return result;
   }

   int getfrequentRenterPoints() {
        int result=0;
       Enumeration rentals = _rentals.elements();
       while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           result+=each.getfrequentRenterPoints();
       }
        return result;
   }

   //отчёт в HTML файл
   public String HtmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<h1>Отчёт аренды для <EM>"+get_name()+"</EM></h1> \n";
        while (rentals.hasMoreElements()) {
            Rental rent = (Rental) rentals.nextElement();

            result+="<p>"+ rent.get_movie().get_title() +" : "+ rent.getCharge()+"</p> \n";
        }
        result+="<b>Ваша задолженнность состовляет: <EM>"+gettotalcharge()+"</EM></b> <br>\n";
        result+="Бонусные очки за текущую аренду: <EM>"+getfrequentRenterPoints()+"</EM></b> <br> \n";

       File newHtmlFile = new File("HTML_report.html");
       try {
           FileUtils.writeStringToFile(newHtmlFile, result,"CP1251");

       } catch (IOException e) {
           e.printStackTrace();
       }

       return result;
   }
}
