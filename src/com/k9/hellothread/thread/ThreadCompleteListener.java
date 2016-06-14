package com.k9.hellothread.thread;

/**
 * Created by Cory on 6/13/2016.
 */
public interface ThreadCompleteListener {

    void notifyOfThreadComplete(final NotifyThread thread);

    void messageReceived(final NotifyThread thread, String message);

    void notifyOfThreadError(final NotifyThread thread, Exception e);
}
