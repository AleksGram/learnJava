package com.threads.rabbit;

import com.threads.accordion.PrintRunnable;

/**
 * Created by agra on 6/27/2017.
 */
public class RabbitPrinter implements Runnable {

    public RabbitPrinter() {
    }

    @Override
    public void run() {
        System.out.println("New rabbit born!");
        for (int k = 1; k < 10; k++) {
            String spaces = spaces(k);
            Runnable printer = new PrintRunnable(spaces + k, 100);
            Thread thread = new Thread(printer);
            thread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        new Thread(new RabbitPrinter()).start();
        //new Thread(new RabbitPrinter()).start();
    }
    private  String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }
}
