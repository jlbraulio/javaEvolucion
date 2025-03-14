package com.examples.pub.sub;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a Java program to create a producer-consumer scenario using the wait() and notify() methods for thread synchronization.
 */
public class ProducerConsumer {

    private static final int BUFFER_SIZE = 5;
    private static final Queue<Integer>  buffer = new LinkedList<>();

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {

        @Override
        public void run() {

            int value = 0;
            System.out.println("###INIT PRODUCER###");

            while (true) {
                System.out.println("###Viendo el tamaño producer:: buffer ###" + buffer.size());

                synchronized (buffer) {

                    while (buffer.size() == BUFFER_SIZE) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e){
                           e.printStackTrace();
                        }
                    }

                    System.out.println("Producer produced :: " + Thread.currentThread().getName() + " :: " + value);
                    buffer.add(value++);
                    buffer.notifyAll();

                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {

            System.out.println("###INIT CONSUMER ###");

            while(true) {
                synchronized (buffer) {

                    System.out.println("###Viendo el tamaño consumer:: ###" + buffer.size());

                    while (buffer.isEmpty()) {
                        try{
                            buffer.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    int value = buffer.poll();

                    System.out.println("CONSUMER consumed :: " + Thread.currentThread().getName() + " :: " + value);

                    buffer.notifyAll();

                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
