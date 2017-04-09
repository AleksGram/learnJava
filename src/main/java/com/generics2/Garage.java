package com.generics2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Грам on 09.04.2017.
 */
public class Garage<T extends Car> implements Comparable<T> {
    private String name;
    private ArrayList<T> cars = new ArrayList<>();

    public Garage(String name) {
        this.name = name;
    }

    public boolean addCar(T car) {
        if (cars.contains(car)) {
            System.out.println(" already exist");
            return false;
        } else cars.add(car);
        return true;
    }
    public void showCar(){
        for (T car:cars){
            System.out.println(car.getModel());
        }
    }

    @Override
    public int compareTo(T newCar) {
        int comparisson = 0;
        for (T car : cars) {
            comparisson = car.getModel().compareTo(newCar.getModel());
        }
        return comparisson;
    }
}


