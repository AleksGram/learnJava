package com.threads;

/**
 * Created by agra on 6/20/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();


        new Thread() {
            public void run() {
                System.out.println("Hello from anonymous class thread");
            }
        }.start();
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        System.out.println("Hello again from the main thread ");

    }
}
