package com.examples.multithreading;

public class EjemploThread {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        Thread hilo1 = new Thread(()-> {
            synchronized (obj){
                try{
                    System.out.println("Hilo 1 esperando ...");
                    obj.wait();
                    System.out.println("Hilo 1 reanundado ...");
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread hilo2 = new Thread(()-> {
           synchronized (obj){
               try{
                   System.out.println("Hilo 2 notificando ...");
                   obj.notifyAll();
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
        });

        hilo1.start();
        Thread.sleep(1000);
        hilo2.start();

    }
}
