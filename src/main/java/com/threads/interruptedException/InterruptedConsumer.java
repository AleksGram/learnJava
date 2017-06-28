package com.threads.interruptedException;

public class InterruptedConsumer implements Runnable {
    private final InterruptBuffer buffer;

    public InterruptedConsumer(InterruptBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int elem = 0;
            try {
                elem = buffer.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(elem + " consumed");
        }
    }
}
