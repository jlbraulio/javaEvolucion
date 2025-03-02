package com.examples.maps;

import java.util.Arrays;
import java.util.List;

/** Imagina que tienes un arreglo de diferentes tipos de datos (por ejemplo, enteros, dobles, y cadenas numéricas) y
 *  quieres realizar una suma de todos esos elementos,
 *  asegurándote de que todos los valores se traten como float para la precisión en los cálculos.
 */
public class MapToFloatExample {

    public static void main(String[] args) {
        exampleMapToInt();
    }

    public static void exampleMapToFloat() {
        List<Object> data = getObjects();

        double sumFloat = data.stream()
                .mapToDouble(
                        item -> {
                                        if (item instanceof Integer) {
                                            return ((Integer) item).floatValue();
                                        } else if (item instanceof Double) {
                                            return ((Double) item).floatValue();
                                        } else if (item instanceof Float) {
                                            return (Float) item;
                                        }
                                        return 0.0f;
                                    }).sum();

        System.out.println("SUMA: " + sumFloat);
    }

    public static void exampleMapToInt(){
        List<Object> data = getObjects();
        int sumInt = data.stream()
                .mapToInt(
                        item -> {
                            if (item instanceof Integer) {
                                return (Integer) item;
                            } else if(item instanceof Double) {
                                return ((Double) item).intValue();
                            } else if (item instanceof Float) {
                                return ((Float) item).intValue();
                            }
                            return 0;
                        }).sum();
        System.out.println("SUMA: " + sumInt);
    }

    private static List<Object> getObjects() {
        return Arrays.asList(10, 15.5, "20.5", 30.0, 40, "", "A78", null, 12.6 ,null, 90, 21);
    }

}
