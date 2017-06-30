package com.threads.interruptedException;


public class InterruptBuffer {
    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (elem != null) {
            try {
                // ?
                if (producers == null) {
                    producers = new ThreadNode(Thread.currentThread(), null);

                } else {


                    ThreadNode temp = producers;
                    while (temp.nextNode != null)
                        temp = temp.nextNode;
                        temp.nextNode = new ThreadNode(Thread.currentThread(), null);

                }
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        elem = newElem;
        if (consumers != null) {
            consumers.thread.interrupt();
            // ?
            consumers = consumers.nextNode;
        }
    }

    public synchronized int get() throws InterruptedException {
        while (elem == null) {
            try {
                // ?
                if (consumers == null) {
                    consumers = new ThreadNode(Thread.currentThread(), null);

                } else {
                    ThreadNode temp = consumers;
                    while (temp.nextNode != null)
                        temp = temp.nextNode;

                        temp.nextNode = new ThreadNode(Thread.currentThread(), null);

                }

                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        int result = elem;
        elem = null;
        if (producers != null) {
            producers.thread.interrupt();
            // ?
            producers = producers.nextNode;

        }
        return result;
    }
}