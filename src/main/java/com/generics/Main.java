package com.generics;

/**
 * Created by agra on 4/4/2017.
 */
public class Main {
    public static void main(String[] args) {
        Audi a3 = new Audi( "A3", "Petrol", 1.8, 150);
        Audi a8 = new Audi( "A8", "Diesel", 4.2, 330);
        Honda civic = new Honda( "Civic", "Petrol",2.0,200);
        Honda accord = new Honda( "Accord", "Petrol",2.4,190);

        Autoconcern<Audi> audi =new Autoconcern<>("Audi");
        Autoconcern<Honda>honda = new Autoconcern<>("Honda");
        audi.addCar(a3);
        audi.addCar(a8);
        audi.print();
        System.out.println("======================");
        honda.addCar(civic);
        honda.addCar(accord);
        honda.addCar(accord);
        honda.print();


    }
}
