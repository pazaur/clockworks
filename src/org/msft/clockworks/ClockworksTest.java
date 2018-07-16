/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.msft.clockworks;

import org.msft.clockworks.ob.Clock;

/**
 * Created by Pawel Zarzycki on 2017-05-31.
 */
public class ClockworksTest {


    public static void main(String[] args) throws InterruptedException {

        Clock pClock = new Clock();
        pClock.setOneTickPeriod(1);
        pClock.setClockRunning(true);
        Thread pClockThread = new Thread(pClock, "Clock Thread");
        System.out.println("Starting Clock");
        pClockThread.start();
        //Thread.sleep(3000);

        while(true) {
            if (pClock.getTicCounter() == 3) {
                System.out.println("Stopping Clock");
                pClock.setClockRunning(false);
                break;
            }
        }

        /*while (pClock.getTicCounter() == 3) {
            System.out.println("Stopping Clock");
            pClock.setClockRunning(false);

        }*/











    }

    public void testClock2() {

    }

}
