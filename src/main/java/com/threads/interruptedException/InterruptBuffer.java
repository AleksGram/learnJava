package com.threads.interruptedException;


public class InterruptBuffer {
    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (elem != null) {
            try {
                // ?

                new ThreadNode(Thread.currentThread(), producers.nextNode);

                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        elem = newElem;
        if (consumers != null) {
            consumers.thread.interrupt();
            // ?
        } else{
            throw new InterruptedException();
    }


    }

    public synchronized int get() throws InterruptedException {
        while (elem == null) {
            try {
                // ?
                new ThreadNode(Thread.currentThread(), consumers.nextNode);
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        int result = elem;
        elem = null;
        if (producers != null) {
            producers.thread.interrupt();
            // ?
        }else{
            throw new InterruptedException();



        }
        return result;
    }
}