package com.treads2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by agra on 6/23/2017.
 */
public class Operations2 {

    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();
        final Account ac1 = new Account(5000, new ReentrantLock());
        final Account ac2 = new Account(10000, new ReentrantLock());


        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.submit(
                    new Transfer(ac1, ac2, rnd.nextInt(400))
            );

        }

       service.shutdown();
        service.awaitTermination(5000,TimeUnit.MILLISECONDS);
    }


}