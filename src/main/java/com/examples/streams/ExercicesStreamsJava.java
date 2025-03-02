package com.examples.streams;

import com.examples.streams.interfaces.SumLambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class ExercicesStreamsJava {

    public static void main(String[] args) {
        checkIf();

    }

    public static void sumTwoIntegers(){
        List<Integer> listInts= List.of(1,2,3,4,5,6,7,8,9);
        int sum = listInts.stream().mapToInt(i->i).sum();
        System.out.println("Sum: " + sum);
    }

    /**
     * Write a Java program to implement a lambda expression to check if a given string is empty.
     */
    public static void checkIf(){
        List<String> listStrings= List.of("","maria");
        listStrings.stream().filter(s-> !s.equals("")).forEach(System.out::println);

    }
    /**
     * 1. Write a Java program to implement a lambda expression to find the sum of two integers.
     */
    public static void sumTwoNumbers(){
        System.out.println("SUM TWO NUMBERS ");
        /** El equivalente a una clase anonima
         * SumLambda sumLambda = new SumLambda() {
         *     @Override
         *     public int sum(int a, int b) {
         *         return a + b;
         *     }
         * };
         */
        SumLambda sumLambda = (a, b) -> a + b;
        SumLambda sumLambdaOther = Integer::sum;

        int num1 = 10;
        int num2 = 20;

        int result = sumLambda.suma(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);
    }

    /**
     * 4. Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
     * Aqui hay que seleccionar para usar filtros
     */
    public static void filterOutEvenAndOdd(){
        List<Integer> nums = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);

        List<Integer> numsEven = nums.stream().filter(num -> num % 2 == 0).toList();
        nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

    }


    /*
     * 5. Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.
     * */
    public static void sortListStrings(){

    }

}
