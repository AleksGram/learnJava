package com.threads.thread3;

/**
 * Created by agra on 6/24/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable print = new Print(500, "  B");
        Thread thread = new Thread(print);
        thread.start();

        for(int i=0;i<10;i++) {
            Thread.sleep(250);
            System.out.println("A");
        }

            System.out.println("Start waiting...join() called");
            thread.join();
            System.out.println(">>FINISH<<");
        }
    }

