package com.threads.interruptedException;

public class ThreadNode {
    public  Thread thread;
    public  ThreadNode nextNode;

    public ThreadNode(Thread thread, ThreadNode nextNode) {
        this.thread = thread;
        this.nextNode = nextNode;
    }


}
