package com.movie;

public class Main {
    public static void main(String[] args) {

        Movie movie1 = new Movie("Star Wars 9",Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Chip and Deil",Movie.CHILDRENS);
        Movie movie3 = new Movie("Snatch",Movie.REGULAR);

        Customer c1 = new Customer("Bob Dilan");
        Customer c2 = new Customer("Jon Smith");

        //формируются "закрывающие бух. документы" по всем прокатам
        c1.addRental(new Rental(movie1,5));
        c2.addRental(new Rental(movie1,10));
        c1.addRental(new Rental(movie3,4));


       // System.out.println(c1.statement());
       //  System.out.println();
       // System.out.println(c2.statement());

        System.out.println(c1.HtmlStatement());

        movie1.set_priceCode(Movie.REGULAR); // фильм изменил статус с новинки на обычный. и у него изменился ценник

        System.out.println(c1.HtmlStatement());
    }
}
