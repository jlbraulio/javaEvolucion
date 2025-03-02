package com.examples.reales;

import java.util.Arrays;
import java.util.List;

public class ExampleRealPeek {

    public static void main(String[] args) {

    }

    public static List<Usuario> buildList() {

       return Arrays.asList(new Usuario("Ana", 25),
                            new Usuario("Pedro", 30),
                            new Usuario("María", 22),
                            new Usuario("Juan", 40));
    }
}
