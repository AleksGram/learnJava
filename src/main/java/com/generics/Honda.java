package com.generics;

/**
 * Created by agra on 4/4/2017.
 */
public class Honda extends Car {
    private boolean vtec=true;

    public Honda( String model, String engineType, double engineVolume, int horsePower) {
        super( model, engineType, engineVolume, horsePower);
    }

    public boolean isVtec() {
        return vtec;
    }
}
