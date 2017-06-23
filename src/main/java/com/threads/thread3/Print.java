package com.threads.thread3;

/**
 * Created by agra on 6/24/2017.
 */
public class Print implements Runnable {
    int delay;
    String arg;

    public Print(int delay, String arg) {
        this.delay = delay;
        this.arg = arg;
    }

    @Override
    public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                Thread.sleep(delay);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(arg);
        }
        }
    }
