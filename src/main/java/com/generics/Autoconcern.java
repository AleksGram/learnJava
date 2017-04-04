package com.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agra on 4/4/2017.
 */
public class Autoconcern<T extends Car> {
    private String maker;
    private ArrayList<T> cars = new ArrayList<T>();

    public Autoconcern(String maker) {
        this.maker = maker;
    }

    boolean addCar(T car) {
        if (cars.contains(car)) {
            System.out.println("Aborted!"+car.getModel()+" is already present in list...  ");
            return false;
        } else {
            cars.add(car);
            System.out.println( car.getModel() + " was added to list");
        }
        return true;

    }
    public void print(){
        if(cars==null){
            System.out.println("You haven't any car");
        }
        System.out.println(this.maker);
        for(int i=0;i<cars.size();i++){

            System.out.println(cars.get(i).getModel()+" "+cars.get(i).getEngineVolume());
        }
    }
}
