package com.examples.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureMain {

    public static void main(String[] args) {
        Counter counter = new Counter();
        int incrementPerThread = 1000;
        int numberOfThreads = 6;

        List<CompletableFuture> futures = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                for (int j = 0; j < incrementPerThread; j++) {
                    System.out.println("Valor final del contador: " + j);
                    counter.increment();
                }
            });

            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        // Imprimir el valor final del contador
        System.out.println("Valor final del contador: " + counter.getValue());

    }
}
