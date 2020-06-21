package com.thomblweed;

public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread threadOne = new CountdownThread(countdown);
        threadOne.setName("Thread 1");
        CountdownThread threadTwo = new CountdownThread(countdown);
        threadTwo.setName("Thread 2");

        threadOne.start();
        threadTwo.start();
    }
}


class Countdown {
    private int i;

    public void doCountdown() {
        String colour;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                colour = ThreadColour.ANSI_CYAN;
                break;
            case "Thread 2":
                colour = ThreadColour.ANSI_PURPLE;
                break;
            default:
                colour = ThreadColour.ANSI_GREEN;
        }

        synchronized(this) {
            for (i = 10; i > 0; i--) {
                System.out.println(colour + Thread.currentThread().getName() + ": i =" + i);
            }
        }    
    }
}


class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}
