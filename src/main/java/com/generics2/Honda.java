package com.generics2;

/**
 * Created by Грам on 09.04.2017.
 */
public class Honda extends Car {
    public Honda(String model, int horspower, double engineVolume) {
        super(model, horspower, engineVolume);
    }
    public int compareTo(Honda honda){
        return (this.getModel()).compareTo(honda.getModel());
    }
}
