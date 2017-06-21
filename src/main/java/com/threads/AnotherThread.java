package com.threads;

/**
 * Created by agra on 6/20/2017.
 */
public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello from anothe thread");

        try{
            Thread.sleep(3000);
            }catch (InterruptedException e){
            System.out.println("Another thread woke me up");
        }
        System.out.println("I am awake");
    }
}
