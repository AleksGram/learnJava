package com.treads2;

import javax.naming.InsufficientResourcesException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by agra on 6/22/2017.
 */
public class Transfer implements Callable<Boolean> {
    private static final long WAIT_SEC = 2;
    Account acc1;
    Account acc2;
    int amount;
    int transferID;


    public Transfer(Account acc1, Account acc2, int amount, int transferID) {

        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
        this.transferID=transferID;

    }

    public int getTransferID() {
        return transferID;
    }

    @Override
    public Boolean call() throws Exception {
        if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {

                    try {

                        if (acc1.getBalance() < amount)
                            throw new InsufficientResourcesException();


                        acc1.withdraw(amount);
                        System.out.println("Grabed the lock acc1 from transfer "+getTransferID());

                        acc2.deposit(amount);
                        System.out.println("Grabed the lock acc2");
                       // Thread.sleep(new Random().nextInt(1000 - 5000));


                    } finally {
                        acc1.getLock().unlock();
                    }
                } else {
                    acc1.incFailedTransCount();
                    acc2.incFailedTransCount();
                    return false;

                }
            } catch (InsufficientResourcesException e) {
                e.getMessage();
            }
        }
        return true;
    }
}