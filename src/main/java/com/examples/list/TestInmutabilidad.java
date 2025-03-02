package com.examples.list;

import java.util.List;

/****
 * 1. Comprobando la inmutabilidad de .toList() (Java 16+)
 * El método .toList() devuelve una lista inmutable, lo que significa que no puedes modificarla después de crearla.
 * Si intentas agregar, eliminar o cambiar un elemento de la lista, se lanzará una excepción de tipo UnsupportedOperationException.
 */
public class TestInmutabilidad {

    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Pedro", "María", "Juan");

        List<String> lstNombres = nombres.stream().toList();

        try {
            lstNombres.add("Carlos");  // Intento de agregar un elemento
        } catch (UnsupportedOperationException e) {
            System.out.println("Excepción (inmutable): " + e.getMessage());
        }

        try {
            lstNombres.remove("Pedro");  // Intento de eliminar un elemento
        } catch (UnsupportedOperationException e) {
            System.out.println("Excepción (inmutable): " + e.getMessage());
        }



    }
}
