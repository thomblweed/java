package com.thomblweed;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadColour.ANSI_PURPLE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ThreadColour.ANSI_PURPLE + "Another thread woke me up!");
            return;
        }

        System.out.println(ThreadColour.ANSI_PURPLE + "3 seconds have passed and I am awake!");
    }
}
