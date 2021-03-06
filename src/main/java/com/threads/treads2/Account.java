package com.threads.treads2;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by agra on 6/21/2017.
 */
public class Account {
    private int balance;
    Lock l;
    private AtomicInteger failCounter;



    public Account(int initBalance, Lock l) {
        this.balance = initBalance;
        this.l=new ReentrantLock();

    }

    public AtomicInteger getFailCounter() {
        return failCounter;
    }

    public Lock getLock() {
        return l;

    }

    public int getBalance() {
        return balance;

    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;

    }
    public void incFailedTransCount(){
        failCounter.incrementAndGet();
    }


}
