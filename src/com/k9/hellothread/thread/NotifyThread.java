package com.k9.hellothread.thread;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import com.k9.hellothread.thread.ThreadCompleteListener;
/**
 * Extend Thread to enable completion event handlers
 * Created by Cory on 6/13/2016.
 */
public abstract class NotifyThread extends Thread{

    private String name;

    public NotifyThread(String name) {
        super();
        this.name = name;

    }

    public String getThreadName() {
        return this.name;
    }

    /**
     * Store thread listeners
     */
    private final Set<ThreadCompleteListener> listeners = new CopyOnWriteArraySet<ThreadCompleteListener>();

    /**
     * Add listener to the "queue"
     */
    public final void addListener(final ThreadCompleteListener listener) {
        listeners.add(listener);
    }

    /**
     * Remove a listener from the "queue"
     */
    public final void removeListener(final ThreadCompleteListener listener){
        listeners.remove(listener);
    }

    /**
     * Notify Listeners of completion
     */
    private final void notifyListeners() {
        System.out.println("Notifying listeners");

        for (ThreadCompleteListener listener: listeners) {
            listener.notifyOfThreadComplete(this);
        }
    }

    /**
     * Send a string message to the listeners
     * @param String message
     */
    public void sendMessage(String message) {
        for (ThreadCompleteListener listener: listeners) {
            listener.messageReceived(this, message);
        }
    }

    /**
     * triggers and exception message
     * @param Exception e
     */
    public void onException(Exception e) {
        for (ThreadCompleteListener listener: listeners) {
            listener.notifyOfThreadError(this, e);
        }
    }

    /**
     * Override the run method to always notify when the thread completes
     */
    @Override
    public final void run() {
        try {
            doRun();
        } finally {
            notifyListeners();
        }
    }

    /**
     * Do run method to be implemented
     */
    public abstract void doRun();
}
