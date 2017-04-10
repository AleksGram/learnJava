package com.generics2;

import java.util.*;


public class Garage<T extends Car> {
    private String name;
    private TreeSet<T> cars = new TreeSet<>();

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

    public void showCar() {
        for (T car : cars) {
            System.out.println(car.getModel());
        }
    }

}

