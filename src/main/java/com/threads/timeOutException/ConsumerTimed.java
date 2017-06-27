package com.threads.timeOutException;




public class ConsumerTimed implements Runnable {
    private final SingleElementBufferTimed buffer;
    private final long timeout;

    public ConsumerTimed(SingleElementBufferTimed buffer, long timeout) {
        this.buffer = buffer;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int elem = buffer.get(timeout);
                System.out.println(elem + " consumed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped.");
                return;
            } catch (java.util.concurrent.TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}