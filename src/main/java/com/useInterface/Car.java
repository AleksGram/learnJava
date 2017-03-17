package com.useInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agra on 3/17/2017.
 */
public class Car implements IStorage {

    private String carModel;
    private int horsPower;
    private int maxSpeed;
    private String color;

    public Car(String carModel, int horsPower, int maxSpeed) {
        this.carModel = carModel;
        this.horsPower = horsPower;
        this.maxSpeed = maxSpeed;
        this.color="Red";
    }



    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getHorsPower() {
        return horsPower;
    }

    public void setHorsPower(int horsPower) {
        this.horsPower = horsPower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", carModel='" + carModel + '\'' +
                ", horsPower=" + horsPower +
                ", maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                '}';
    }

    public List<String> store() {
      List<String> car=new ArrayList<String>();
        car.add(0,this.carModel);
        car.add(1,""+this.horsPower);
        car.add(2,""+this.maxSpeed);
        car.add(3,""+this.color);

        return car;
    }

    public void read(List<String> savedValues) {
        if(savedValues!=null&&savedValues.size()>0){
            this.carModel=savedValues.get(0);
            this.horsPower=Integer.parseInt(savedValues.get(1));
            this.maxSpeed=Integer.parseInt(savedValues.get(2));
            this.color=savedValues.get(3);
        }

    }
}
