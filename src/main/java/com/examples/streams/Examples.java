package com.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40,6,23,100);
        int max = numbers.stream().max(Integer::compare).orElse(0);
        System.out.println("Max with compare " + max);
    }

    public static void example2() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie","Carlos","Gonzalo","May","Mario","ALberto");
        Map<Integer, List<String>> grouped = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Example grouped: " + grouped);
    }

    public static void example3() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int suma = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Example tres::" +suma);
    }
}
