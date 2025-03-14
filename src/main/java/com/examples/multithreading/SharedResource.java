package com.examples.multithreading;

public class SharedResource {

    private boolean condition = false;

    /**
     *
     */
    //public  void waitMethod() {
    public synchronized void waitMethod() {
        while (!condition) {
            try {
                System.out.println(Thread.currentThread().getName() + " está esperando.");
                wait(); // El hilo espera hasta que otro lo notifique.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " está esperando 2.");
        }

        System.out.println(Thread.currentThread().getName() + " ha continuado.");
    }

    /**
     *
     */
    //public void notifyMethod() {
    public synchronized void notifyMethod() {
        condition = true; // Cambiamos la condición.
        System.out.println("Notificando a todos los hilos...");
        notifyAll(); // Despierta a todos los hilos que están esperando en este monitor.
    }
}