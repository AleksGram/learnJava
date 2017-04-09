package com.generics2;

/**
 * Created by Грам on 09.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Honda accord =new Honda("Accord",150,2.0);
        Honda civic =new Honda("Civic",140,1.8);
        Honda integra =new Honda("Integra",220,2.0);

        Toyota corolla = new Toyota("Corolla", 180, 2.0);
        Toyota celica = new Toyota("Selica", 180, 1.8);
        Toyota supra = new Toyota("Supra", 250, 3.0);

        Garage<Honda> g1 = new Garage<>("Hall");
        g1.addCar(accord);
        g1.addCar(civic);
        g1.addCar(integra);


    }
}
