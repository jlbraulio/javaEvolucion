package com.examples.multithreading;

public class Counter {

    private int count = 0;

    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + ": Incremented " + count + " times");
        count++;
    }

    public int getValue() {
        return count;
    }
}
