package com.examples.collections;

import com.examples.collections.entity.Fruta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List (Lista): Permite almacenar elementos en un orden específico y admite duplicados.
 * Set (Conjunto): No admite duplicados y no garantiza un orden (a menos que uses implementaciones específicas como LinkedHashSet o TreeSet)
 * Queue (Cola): Se utiliza para estructuras de datos FIFO (Primero en entrar, primero en salir) o LIFO (Primero en entrar, último en salir).
 * Map (Mapa): Asocia claves únicas a valores. No pertenece directamente a la interfaz Collection, pero es esencial en el framework de colecciones.
 *
 * En Java, la palabra clave this se utiliza para referirse a la instancia actual de la clase en la que se encuentra
 */

/***
 * List
 * ArrayList: Es una lista basada en un array dinámico. Es rápida para acceder a elementos por índice,
 * pero más lenta para inserciones y eliminaciones en medio de la lista.
 *
 * LinkedList: Es una lista basada en nodos enlazados.
 * Es más rápida para inserciones y eliminaciones en medio de la lista, pero más lenta para acceder a elementos por índice.
 *
 * Pasar la instancia actual como argumento:
 * Puedes pasar la instancia actual (this) como argumento a otros métodos o constructores.
 *  public void mostrarNombre() {
 *         imprimirNombre(this); // Pasa la instancia actual como argumento
 *     }

 *     Devolver la instancia actual:
 * Puedes devolver la instancia actual desde un método, lo cual es útil en patrones como el "Builder".

 * java
 * Copy
 * public class Persona {
 *     private String nombre;
 *
 *     public Persona setNombre(String nombre) {
 *         this.nombre = nombre;
 *         return this; // Devuelve la instancia actual
 *     }
 * }
 */

public class CategoryCollections {

    public static void main(String[] args) {
        printCollectionList();
    }

    public static void sortedCollectionListFruits() {
        List<Fruta> listFruits = createListFruits();

        /*listFruits.sort(

        );*/

    }

    public static void printCollectionList() {
        List<String> list = new ArrayList<String>();
        list.add("Manzana");
        list.add("Banana");
        list.add("Fresa");
        list.add("Manzana");
        list.add("Papaya");
        list.add("Manzana");

        list.sort((a,b)-> b.compareTo(a));
        System.out.println("##" + list);
    }

    public static void createCollectionList() {
        List<String> list = new ArrayList<String>();
        list.add("Manzana");
        list.add("Banana");
        list.add("Fresa");
        list.add("Manzana");
        list.add("Papaya");
        list.add("Manzana");

        Collections.sort(list);

        System.out.println("##" + list);
    }

    public static List<Fruta> createListFruits() {
        List<Fruta> fruits = new ArrayList<>();
        fruits.add(new Fruta("Manzana",10));
        fruits.add(new Fruta("Banana",5));
        fruits.add(new Fruta("Fresa",20));
        fruits.add(new Fruta("Manzana",5));
        fruits.add(new Fruta("Papaya",15));
        fruits.add(new Fruta("Manzana",15));
        fruits.add(new Fruta("Guayaba",55));
        fruits.add(new Fruta("Mandarina",40));

        return fruits;
    }

}
