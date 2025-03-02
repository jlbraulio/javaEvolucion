package com.examples.collections.entity;

/**
 * En Java, la palabra clave this se utiliza para referirse a la instancia actual de la clase en la que se encuentra. Aquí te explico cuándo y cómo usar this:
 */
public class Fruta {

    String nombre;
    int cantidad;

    public Fruta(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + cantidad + ")";
    }
}
