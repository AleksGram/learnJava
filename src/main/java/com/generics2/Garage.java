package com.generics2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Грам on 09.04.2017.
 */
public class Garage <T extends Car> implements Comparable<T> {
   private String name;
   private ArrayList<T> cars = new ArrayList<>();

    public Garage(String name) {
        this.name = name;
    }

    public boolean addCar(T car){
        if(cars.contains(car)){
            System.out.println(car.getModel()+" already exist");
            return false;
        }else cars.add(car);
        return true;
    }
    public void showCars(){

    }

    @Override
    public int compareTo(T car) {
        String model=null;
        for(int i=0;i<cars.size();i++){
            model =cars.get(i).getModel();
        }
        return model.compareTo(car.getModel());
    }
}
