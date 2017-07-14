package com.threads.buchakaChallenge;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by agra on 7/14/2017.
 */

    class TransferChallenge {
        private double balance;
        private String accountNumber;
        private Lock lock = new ReentrantLock();

        TransferChallenge(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public boolean withdraw(double amount) {
            if (lock.tryLock()) {
                try{
                    try {
                        // Simulate database access
                        Thread.sleep(100);
                    }
                     catch (InterruptedException e) {
                        }
                        balance -= amount;
                        System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                        return true;
                    }
                    finally {
                        lock.unlock();
                    }
                }
            return false;
            }



        public boolean deposit(double amount) {
            if (lock.tryLock()) {
                try{
                    try {
                        // Simulate database access
                        Thread.sleep(100);
                    }catch (InterruptedException e) {
                    }
                    balance += amount;
                    System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                    return true;

                }
                finally {
                    lock.unlock();
                }
                }
            return false;
            }


        public  boolean transfer(TransferChallenge destinationAccount, double amount) {
            if (withdraw(amount)) {
                if (destinationAccount.deposit(amount)) {
                    return true;
                }
                else {
                    // The deposit failed. Refund the money back into the account.
                    System.out.printf("%s: Destination account busy. Refunding money\n",
                            Thread.currentThread().getName());
                    deposit(amount);
                }
            }

            return false;
        }
    }

    class Transfer implements Runnable {
        private TransferChallenge sourceAccount, destinationAccount;
        private double amount;

        Transfer(TransferChallenge sourceAccount, TransferChallenge destinationAccount, double amount) {
            this.sourceAccount = sourceAccount;
            this.destinationAccount = destinationAccount;
            this.amount = amount;
        }

        public void run() {

            while (!sourceAccount.transfer(destinationAccount, amount))
                continue;
            System.out.printf("%s completed\n", Thread.currentThread().getName());
        }
}
