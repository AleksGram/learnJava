package com.threads.treads2;

/**
 * Created by agra on 7/11/2017.
 */
public class MainBank {
    public static void main(String[] args) {
       final BankAccount account = new BankAccount("12345-678", 1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("User1 started...");
       account.transfer(300,50);
                System.out.println("User1 finished");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("User2 started...");
               account.transfer(203,100);
                System.out.println("User2 finished");
            }
        }).start();
    }
}
