package com.generics2;

/**
 * Created by Грам on 09.04.2017.
 */
public class Car implements Comparable<Car> {
    private String model;
    private int horspower;
   private double engineVolume;

    public Car(String model, int horspower, double engineVolume) {
        this.model = model;
        this.horspower = horspower;
        this.engineVolume = engineVolume;
    }

    public String getModel() {
        return model;
    }

    public int getHorspower() {
        return horspower;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public int compareTo(Car car) {
        return this.model.compareTo(car.model);
    }
}
