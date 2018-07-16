/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.msft.clockworks.ob;

/**
 * Created by Pawel Zarzycki on 2017-06-19.
 */
public class Clock implements Runnable {


    /* Measurement units. */
    //how long one application clock tick takes (in seconds)
    private int oneTickPeriod = 25;
    private volatile long ticCounter;
    private volatile boolean clockRunning = false;



    public Clock() {

    }

    @Override
    public void run() {

        long pCounter;
        double currentNanoTime;
        double lastTickNanoTime;


        while (clockRunning) {

            System.out.println("Tic...");

            currentNanoTime = System.nanoTime();
            pCounter = 0;

            /**
             * Waiting at least given amount of seconds.
             * Inside loop below is the place for background tasks.
             * Be aware that some tasks can take longer.
             */
            while (pCounter <= getOneTickPeriod()) {

                lastTickNanoTime = System.nanoTime();
                pCounter = Math.round((lastTickNanoTime - currentNanoTime) / 1000000000);


            }
            //tic ended, update state, render, whatever.
            setTicCounter(1);



            System.out.println("Toc...");


        }

    }


    public int getOneTickPeriod() {
        return oneTickPeriod;
    }

    public void setOneTickPeriod(int oneTickPeriod) {
        this.oneTickPeriod = oneTickPeriod;
    }

    public void setTicCounter(long ticCounter) {
        this.ticCounter += ticCounter;
    }

    public synchronized long getTicCounter() {
        return ticCounter;
    }

    public synchronized void setClockRunning(boolean clockRunning) {
        this.clockRunning = clockRunning;
    }
}
