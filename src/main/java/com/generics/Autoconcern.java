package com.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by agra on 4/4/2017.
 */
public class Autoconcern<T extends Car> implements Comparable<Autoconcern<T>> {
    private String maker;
    private List<T> cars = new LinkedList<>();

    public Autoconcern(String maker) {
        this.maker = maker;
    }

    boolean addCar(T car) {
        if (cars.contains(car)) {
            System.out.println("Aborted!" + car.getModel() + " is already present in list...  ");
            return false;
        } else {
            cars.add(car);
            System.out.println(car.getModel() + " was added to list");
        }
        return true;

    }

    public void print() {

        if (cars == null) {
            System.out.println("You haven't any car");
        }
        System.out.println(this.maker);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getModel() + " " + cars.get(i).getEngineVolume());
        }
    }


    @Override
    public int compareTo(Autoconcern<T> cars) {
if (this.maker>cars.maker){
    return
}
        return 0;
    }
}
