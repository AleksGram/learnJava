package com.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Audi a3 = new Audi("A3", "Petrol", 1.8, 150);
        Audi a8 = new Audi("A8", "Diesel", 4.2, 330);
        Honda civic = new Honda("Civic", "Petrol", 2.0, 200);
        Honda accord = new Honda("Accord", "Petrol", 2.4, 190);
        Honda prelude = new Honda("Prelude", "Petrol", 2.2, 220);
        Honda torneo = new Honda("Torneo", "Petrol", 2.2, 200);

        Autoconcern<Audi> audi = new Autoconcern<>("Audi");
        Autoconcern<Honda> honda = new Autoconcern<>("Honda");
        Autoconcern<Honda> hondaBike = new Autoconcern<>("Honda");
        audi.addCar(a3);
        audi.addCar(a8);
        //  audi.print();
        System.out.println("======================");
        honda.addCar(civic);
        honda.addCar(accord);
        honda.addCar(accord);
        honda.addCar(prelude);
        honda.addCar(torneo);
        //  honda.print();
        // League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
        //Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");

        ShowRoom<Autoconcern<Audi>> audiCenter = new ShowRoom<>("Drive");
        // Autoconcern<Audi> audi = new Autoconcern<>("Audi");
        audiCenter.add(audi);
        ShowRoom<Autoconcern<Honda>> hondaCenter = new ShowRoom<>("VTEC");
        hondaCenter.add(honda);
        hondaCenter.add(hondaBike);
        hondaCenter.showCars();
    }
}
