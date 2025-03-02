package com.examples.streams;

import java.util.function.Predicate;

/**
 * Write a Java program to implement a lambda expression to check if a given string is empty.
 */
public class LambdaStringCheckExample {

    public static void main(String[] args) {
        checkStringEmpty();
    }

    public static void checkStringEmpty() {
        Predicate<String> isEmpty = s -> s.isEmpty();

        String str1 = "";
        String str2 = "Java lambda expression!";

        System.out.println("String 1:" + str1);
        System.out.println("String 1 is empty: " + isEmpty.test(str1));
        System.out.println("String 2:" + str2);
        System.out.println("String 2 is empty: " + isEmpty.test(str2));

    }

}