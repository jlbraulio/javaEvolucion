package com.examples.multithreading;

public class NotifyAllExample {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Creamos varios hilos que llamarán al método waitMethod()
        Thread t1 = new Thread(resource::waitMethod, "Hilo-1");
        Thread t2 = new Thread(resource::waitMethod, "Hilo-2");
        Thread t3 = new Thread(resource::waitMethod, "Hilo-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(4000); // Pausa de 2 segundos.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Notificar a todos los hilos esperando.
        //new Thread(resource::notifyMethod).start();
    }
}