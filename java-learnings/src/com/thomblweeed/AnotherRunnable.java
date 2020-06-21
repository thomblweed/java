package com.thomblweeed;

public class AnotherRunnable implements Runnable{
    @Override
    public void run() {
      System.out.println(ThreadColour.ANSI_CYAN + "Hello from Another Runnable");
    }
}