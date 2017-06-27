package com.threads.rabbit;

import com.threads.thread3.accordion.PrintRunnable;

/**
 * Created by agra on 6/27/2017.
 */
public class RabbitAttack {
    public static void main(String[] args) throws InterruptedException {
       /* for (int k = 1; k < 10; k++) {
            String spaces = spaces(k);
            Runnable printer = new PrintRunnable(spaces + k, 100);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }
    private static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;*/


new Thread(new RabbitPrinter()).start();
    }
}
