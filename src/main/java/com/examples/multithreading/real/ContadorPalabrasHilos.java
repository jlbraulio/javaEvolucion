package com.examples.multithreading.real;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorPalabrasHilos {

    public static void main(String[] args) throws InterruptedException {

        String archivo = "C:/Users/jlbra/Desktop/CarpetaGeneral/ejercicios/log.txt";
        String[] palabrasClave = {"error","warning","info"};

        AtomicInteger contadorError = new AtomicInteger(0);
        AtomicInteger contadorWarning = new AtomicInteger(0);
        AtomicInteger contadorInfo = new AtomicInteger(0);

        // Leer el archivo en paralelo
        File file = new File(archivo);
        long fileLength = file.length();
        int numHilos = 4; // Dividimos en 4 hilos

        System.out.println("fileLenght: " + fileLength);
        System.out.println("numHilos: " + numHilos);
        long chunkSize = fileLength / numHilos;
        System.out.println("ChunkSize: " + chunkSize);

        Thread[] hilos = new Thread[numHilos];

        for (int i = 0; i < numHilos; i++) {

            long start = i * chunkSize;
            System.out.println("start: " + start);
            long end = (i == numHilos - 1) ? fileLength : (i + 1) * chunkSize;
            System.out.println("end: " + end);

            hilos[i] = new Thread(new ProcesarArchivoTask(archivo, start, end, palabrasClave,
                    contadorError, contadorWarning, contadorInfo));

            hilos[i].start();
        }

        // Esperar que todos los hilos terminen
        for (Thread hilo : hilos) {
            hilo.join();
        }

        // Mostrar resultados
        System.out.println("Cantidad de 'error': " + contadorError.get());
        System.out.println("Cantidad de 'warning': " + contadorWarning.get());
        System.out.println("Cantidad de 'info': " + contadorInfo.get());
    }

    static class ProcesarArchivoTask  implements Runnable {

        private final String archivo;
        private final long start;
        private final long end;
        private final String[] palabrasClave;
        private final AtomicInteger contadorError;
        private final AtomicInteger contadorWarning;
        private final AtomicInteger contadorInfo;

        public ProcesarArchivoTask(String archivo, long start, long end, String[] palabrasClave,
                                   AtomicInteger contadorError, AtomicInteger contadorWarning, AtomicInteger contadorInfo) {
            this.archivo = archivo;
            this.start = start;
            this.end = end;
            this.palabrasClave = palabrasClave;
            this.contadorError = contadorError;
            this.contadorWarning = contadorWarning;
            this.contadorInfo = contadorInfo;
        }

        @Override
        public void run() {
            try (RandomAccessFile file = new RandomAccessFile(archivo, "r")) {
                file.seek(start);
                String line;
                // Leer línea por línea dentro del rango especificado
                while (file.getFilePointer() < end && (line = file.readLine()) != null) {
                    for (String palabra : palabrasClave) {
                        // Contar las palabras clave
                        if (line.contains(palabra)) {
                            switch (palabra) {
                                case "error":
                                    contadorError.incrementAndGet();
                                    break;
                                case "warning":
                                    contadorWarning.incrementAndGet();
                                    break;
                                case "info":
                                    contadorInfo.incrementAndGet();
                                    break;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


