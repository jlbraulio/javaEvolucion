package com.examples.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Es principalmente para inspeccionar los elementos del flujo mientras se procesan, sin modificar el flujo.
 * Aunque no es recomendable usarlo para alterar el comportamiento del flujo,
 * se utiliza comúnmente para depuración o para realizar acciones adicionales como contabilizar,
 * registrar, o verificar los elementos sin interrumpir la cadena de operaciones
 * */
public class ExamplesPeek {

    /****
     *Cuándo usar peek:
     * Depuración: Para ver los datos que pasan por el flujo.
     * Acciones adicionales: Para realizar efectos secundarios (como imprimir información, actualizar contadores, etc.) sin alterar el flujo.
     * Monitoreo: Para verificar los valores intermedios a medida que se procesan sin modificar el flujo.
     * @param args
     */
    public static void main(String[] args) {
        peekExampleDos();
    }

    /**
     *
     */
    public static void peekExampleUno() {
        List<String> nombres = Arrays.asList("Ana", "Pedro", "María", "Juan");

        List<String> resulado = nombres
                .stream()
                .peek(System.out::println)
                .filter(nombre -> nombre.length() > 3)
                .toList();

    }

    /**
     * Contabilizar elementos: Usar peek para contar cuántos elementos cumplen con una condición.
     */
    public static void peekExampleDos() {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);
        final int[] contador = {0};

        List<Integer> resultado = numeros
                .stream()
                .peek(num -> {
                    if(num % 2 == 0) {
                        contador[0]++;
                    }
                }).toList();

        System.out.println("Cantidad de números pares: " + contador[0]);
    }
}
