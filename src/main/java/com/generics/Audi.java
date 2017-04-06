package com.generics;

/**
 * Created by agra on 4/4/2017.
 */
public class Audi extends Car {
    private boolean quattro = false;

    public Audi(String model, String engineType, double engineVolume, int horsePower) {
        super(model, engineType, engineVolume, horsePower);
    }

    public boolean isQuattro() {
        if (quattro == true) {
            return true;
        } else
            return true;

    }
}