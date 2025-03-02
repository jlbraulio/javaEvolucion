package com.examples.list;

import java.util.List;
import java.util.stream.Collectors;

public class TestMutabilidad {

    public static void main(String[] args) {

        List<String> nombres = List.of("Ana", "Pedro", "María", "Juan");

        List<String> listaNombres = nombres.stream()
                .collect(Collectors.toList());

        // Agregar un nuevo elemento
        listaNombres.add("Carlos");
        System.out.println("Lista después de agregar: " + listaNombres);  // Debe mostrar "Carlos"


        // Eliminar un elemento
        listaNombres.remove("Pedro");
        System.out.println("Lista después de eliminar: " + listaNombres);  // Debe mostrar "Pedro" eliminado
    }
}
