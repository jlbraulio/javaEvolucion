package com.examples.multithreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MonitorExample {

    private final Object lock = new Object();

    public void criticalSection() {
        synchronized (lock) { // El hilo adquiere el monitor de 'lock'.
            System.out.println(Thread.currentThread().getName() + " está en la sección crítica.");
            System.out.println("Ruta de trabajo actual: " + System.getProperty("user.dir"));

            try {
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
                    writer.write(Thread.currentThread().getName() + "esta escribiendo en un archivo");
                    writer.flush();
                    System.out.println(Thread.currentThread().getName() + " ha escrito en el archivo.");
                }

                Thread.sleep(1000); // Simula trabajo en la sección crítica.
            } catch (InterruptedException | IOException e) {
                Thread.currentThread().interrupt();
                System.err.println(Thread.currentThread().getName() + " fue interrumpido.");
            }
            System.out.println(Thread.currentThread().getName() + " sale de la sección crítica.");
        } // Aquí el hilo libera el monitor de 'lock'.
    }

    public static void main(String[] args) {
        MonitorExample me = new MonitorExample();

        Thread t1 = new Thread(me::criticalSection,"Hilo 1");
        Thread t2 = new Thread(me::criticalSection,"Hilo 2");
        Thread t3 = new Thread(me::criticalSection,"Hilo 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
