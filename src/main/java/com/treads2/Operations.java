package com.treads2;

import javax.naming.InsufficientResourcesException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by agra on 6/21/2017.
 */
public class Operations {

    private static final long WAIT_SEC = 3;

    public static void main(String[] args) throws InsufficientResourcesException, InterruptedException {
        final Account a = new Account(1000, new ReentrantLock() );
        final Account b = new Account(2000, new ReentrantLock());

        new Thread(new Runnable() {
            public void run() {
                try {
                    transfer(a, b, 500);
                    System.out.println("Transfer a=>b successfully completed ");
                } catch (InsufficientResourcesException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }).start();
        transfer(b, a, 300);
        System.out.println("Transfer b=>a successfully completed ");
    }

    static void transfer(Account acc1, Account acc2, int amount) throws InsufficientResourcesException, InterruptedException {
        if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {

                    try {

                        if (acc1.getBalance() < amount)
                            throw new InsufficientResourcesException();
                      //synchronized (acc1) {
                            System.out.println("Grabed the lock acc1");

                          // Thread.sleep(1000); // invoke the deadlock



                           // synchronized (acc2) {
                                System.out.println("Grabed the lock acc2");

                                acc1.withdraw(amount);
                                acc2.deposit(amount);
                          //  }
                       // }
                    } finally {
                        acc1.getLock().unlock();
                    }
                } else {
                    acc1.incFailedTransCount();
                    acc2.incFailedTransCount();
                    throw new InsufficientResourcesException();
                }
            }catch (InsufficientResourcesException e){
                e.getMessage();
            }
        }
    }
}