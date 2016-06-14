package com.k9.hellothread;

/**
 * Created by Cory on 6/13/2016.
 */
public class Main{


    /**
     * Create a worker thread and wait for the response
     * @param args
     */

    public static void main(String[] args) {

        // create a new processor class to start thread exec and monitoring
        Process p = new Process();
        p.start();

    }

}
