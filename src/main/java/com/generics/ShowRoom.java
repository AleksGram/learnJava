package com.generics;

import java.util.ArrayList;
import java.util.Collections;


public class ShowRoom<T extends Autoconcern> {
    private String name;
    private ArrayList<T> garage = new ArrayList<>();

    public ShowRoom(String name) {
        this.name = name;
    }
    public boolean add(T car){
        if(garage.contains(car)) {
            return false;
        }
        garage.add(car);
        return true;
    }

public String toString(T car){
    return (car.getMaker());
}

    public void showCars(){
        Collections.sort(garage);
        for(T car:garage){
            car.carInfo();
        }
    }
}
