package com.examples.multithreading;

public class MainIncrementThread {

    public static void main(String[] args) {
        System.out.println("Init count in main thread");
        Counter counter = new Counter();
        int numThreads = 6;
        int incrementPerThread = 1000;
        IncrementThread[] threads = new IncrementThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            System.out.println("NUM:" + numThreads);
            threads[i] = new IncrementThread(counter, incrementPerThread);
            threads[i].start();
        }
        try{
            for(IncrementThread thread : threads){
                thread.join();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getValue());
    }
}
