package com.threads.treads2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by agra on 7/11/2017.
 */
public class BankAccount {
    private String accountId;
    private int initAmount;
    private final ReentrantLock lock;


    public BankAccount(String accountId, int initAmmount) {
        this.accountId = accountId;
        this.initAmount = initAmmount;
        this.lock=new ReentrantLock();

    }

    public String getAccountId() {
        return accountId;
    }

    public void printAccountId() {
        System.out.println("AccountID = " + accountId);
    }

    public int getInitAmmount() {
        return initAmount;
    }

  /*  public void  deposit(int amount){
        synchronized (this){
            if (amount<=0){
                System.out.println("The amount of deposit must to be > 0, Please correct your amount");
            }else{
                initAmount+=amount;
                System.out.println("added "+amount);
            }
        }

    }

    public int withdraw(int ammount){
        synchronized (this){
            if (ammount>this.initAmount){
                System.out.println("Error: Not enought cash");
            }else{
                initAmount+=(-ammount);
                System.out.println("withdrawed "+ammount);
            }
            System.out.println("Cash on account is: "+getInitAmmount()) ;
            return getInitAmmount();
        }

    }*/


    public void deposit(int amount) {
        lock.lock();
        try {
            if (amount <= 0) {
                System.out.println("The amount of deposit must to be > 0, Please correct your amount");
            } else {
                initAmount += amount;
                System.out.println("added " + amount);
            }
        } finally {
            lock.unlock();
        }
    }

    public int withdraw(int ammount) {
        lock.lock();
        try {
            if (ammount > this.initAmount) {
                System.out.println("Error: Not enought cash");
            } else {
                initAmount += (-ammount);
                System.out.println("withdrawed " + ammount);
            }
            System.out.println("Cash on account is: " + getInitAmmount());
            return getInitAmmount();

        } finally {
            lock.unlock();
        }
    }

    public void transfer(int forDeposit, int forWithdraw) {
        deposit(forDeposit);
        withdraw(forWithdraw);
    }
}
