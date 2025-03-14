package com.examples.multithreading;

public class EstadoThreadTest {

    public static void main(String[] args) throws InterruptedException{
        System.out.println("#### EJEMPLOO");
        Factura factura = new Factura();

        Thread hilo1 = new Thread(()-> {
            synchronized (factura) {
                factura.setIdFactura(1);
                factura.setDescripcion("factura de comprobacion");
                System.out.println("Hilo 1 " + factura);
            }
        });

        Thread hilo2 = new Thread(()-> {
            synchronized (factura) {
                // Simular otra modificación del objeto factura
                factura.setIdFactura(2);
                factura.setDescripcion("Factura de compra 2");
                System.out.println("Hilo 2: " + factura);
            }
        });

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        // Esperar que ambos hilos terminen su ejecución
        hilo1.join();
        hilo2.join();
    }

    public Factura getFactura(int numeroFactura, String detalle){
        Factura factura = new Factura();
        factura.setIdFactura(numeroFactura);
        factura.setDescripcion(detalle);
        return factura;
    }
}
