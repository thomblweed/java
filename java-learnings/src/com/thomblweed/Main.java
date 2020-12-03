package com.thomblweed;

public class Main {
    public static void main(String[] args) {
        System.out.println(ThreadColour.ANSI_RED + "Hello from Main Thread!");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColour.ANSI_BLUE + "Hello from annoymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new AnotherRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColour.ANSI_CYAN
                        + "Hello from annoymous implmentation of run Another Runnable");

                try {
                    anotherThread.join();
                    System.out.println(ThreadColour.ANSI_CYAN
                            + "AnotherThread terminated or timed out, I'm running again!");
                } catch (InterruptedException e) {
                    System.out
                            .println(ThreadColour.ANSI_CYAN + "I couldn't wait, I was interupted!");
                }
            }
        });
        myRunnableThread.start();

        // anotherThread.interrupt();

        System.out.println(ThreadColour.ANSI_RED + "Hello again from Main Thread!");
    }
}
