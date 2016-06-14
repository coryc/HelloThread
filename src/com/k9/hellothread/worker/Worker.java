package com.k9.hellothread.worker;

import com.k9.hellothread.thread.NotifyThread;

/**
 * Created by Cory on 6/13/2016.
 */
public class Worker extends NotifyThread {

    public Worker(String name) {
        super(name);
    }

    public void doRun() {
        try {
            System.out.println("Worker running");
            this.sendMessage("My watch has begun");

            // testing exception handling
            throw new Exception("winter is here!");

        } catch (Exception e) {
            // call exception event
            this.onException(e);
        }
    }

}
