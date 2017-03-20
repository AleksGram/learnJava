package com.useInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agra on 3/20/2017.
 */
public class Bike implements IStorage {
private String bikeModel;
private int horsPower;
private int maxSpeed;

    public Bike(String bikeModel, int horsPower, int maxSpeed) {
        this.bikeModel = bikeModel;
        this.horsPower = horsPower;
        this.maxSpeed = maxSpeed;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public int getHorsPower() {
        return horsPower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public List<String> store() {
        List<String>bike=new ArrayList<String>();
        bike.add(0, this.bikeModel);
        bike.add(1, ""+this.horsPower);
        bike.add(2,""+this.maxSpeed);
        return bike;
    }

    public void read(List<String> savedValues) {
        if(savedValues!=null&&savedValues.size()>0){
            this.bikeModel=savedValues.get(0);
            this.horsPower=Integer.parseInt(savedValues.get(1));
            this.maxSpeed=Integer.parseInt(savedValues.get(2));
        }

    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeModel='" + bikeModel + '\'' +
                ", horsPower=" + horsPower +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
