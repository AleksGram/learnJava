package com.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Autoconcern<T extends Car> implements Comparable<Autoconcern<T>> {
    private String maker;
    private ArrayList<T> cars = new ArrayList<>();

    public Autoconcern(String maker) {
        this.maker = maker;
    }
    abstract void subCompaire (Car car);

    public String getMaker() {
        return maker;
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

public void carInfo(){
    for(int i=0;i<this.cars.size();i++){
        System.out.println(cars.get(i).getModel());
    }
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
    public int compareTo(Autoconcern<T> car) {

        return ((this.maker).compareTo(car.maker));
    }
}



