package com.k9.hellothread;


import com.k9.hellothread.thread.NotifyThread;
import com.k9.hellothread.thread.ThreadCompleteListener;
import com.k9.hellothread.worker.Worker;

/**
 * Created by Cory on 6/13/2016.
 */
public class Process implements ThreadCompleteListener {

    /**
     * Listen to thread completed messages
     * @param thread
     */
    public void notifyOfThreadComplete(final NotifyThread thread) {
        System.out.println("Thread completed: " + thread.getThreadName());
    }

    /**
     * Message received from a thread
     * @param NotifyThread thread
     * @param String message
     */
    public void messageReceived(final NotifyThread thread, String message) {
        System.out.println("Message Received from thread: " + thread.getThreadName() + ", message: " + message);
    }

    /**
     * Implement error detection on thread
     */
    public void notifyOfThreadError(final NotifyThread thread, Exception e) {
        System.out.println("thread: " + thread.getThreadName() + " ended with error: " + e.getMessage());
    }


    public void start() {
        System.out.println("Starting worker thread");
        Worker worker = new Worker("tester");
        worker.addListener(this);
        worker.start();
    }
}
