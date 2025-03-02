package com.examples.collections.entity;

/***
 * Los genéricos en Java son una característica que permite crear clases, interfaces y métodos que operan con tipos parametrizados
 *
 */
public class Caja<T> {

    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
    public T getContenido() {
        return contenido;
    }
}
