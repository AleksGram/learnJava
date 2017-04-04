package com.generics;

/**
 * Created by agra on 4/4/2017.
 */
public class Car {
  //  private String maker;
    private String model;
    private String engineType;
    private double engineVolume;
    private int horsePower;

    public Car( String model, String engineType, double engineVolume, int horsePower) {
    //    this.maker = maker;
        this.model = model;
        this.engineType = engineType;
        this.engineVolume = engineVolume;
        this.horsePower = horsePower;
    }

  /*  public String getMaker() {
        return maker;
    }*/

    public String getModel() {
        return model;
    }

    public String getEngineType() {
        return engineType;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
