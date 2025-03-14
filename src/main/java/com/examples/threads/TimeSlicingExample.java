package com.examples.threads;

/***
 * Características clave del multithreading en Java:
 * Concurrente: Permite realizar múltiples tareas simultáneamente.
 * Compartición de recursos: Los hilos comparten la memoria y el estado del proceso principal.
 * Ligereza: Los hilos son más ligeros que los procesos tradicionales y requieren menos recursos.
 * Sincronización: Java proporciona mecanismos para sincronizar hilos y evitar problemas de concurrencia.
 */
public class TimeSlicingExample extends Thread {

    private String threadName;

    public TimeSlicingExample(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is executing iteration " + i);
            try {
                // Simula un trabajo ejecutándose con un pequeño retraso
                Thread.sleep(1000); // Pausa de 500 ms
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        TimeSlicingExample timeSlicingExample1 = new TimeSlicingExample("Thread-1");
        TimeSlicingExample timeSlicingExample2 = new TimeSlicingExample("Thread-2");
        TimeSlicingExample timeSlicingExample3 = new TimeSlicingExample("Thread-3");

        timeSlicingExample1.start();
        timeSlicingExample2.start();
        timeSlicingExample3.start();

    }

}
