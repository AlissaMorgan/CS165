import java.util.*;

public class WhatOrder<T> {
    // TODO: Define a generic method called checkOrder() that
    //       takes in four variables of generic type as arguments.
    //       The return type of the method is integer

    public static <T extends Comparable <T>> int checkOrder(T one, T two, T three, T four) {
        if (one.compareTo(two) <= -1 && two.compareTo(three) <= -1 && three.compareTo(four) <= -1) {
            return -1;
        }
        if (one.compareTo(two) >= 1 && two.compareTo(three) >= 1 && three.compareTo(four) >= 1) {
            return 1;
        }
        return 0;
    }


    // Check the order of the input: return -1 for ascending,
    // 0 for neither, 1 for descending


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

//       int test = checkOrder("apple", "bear", "cat", "dog");
        int test = checkOrder(63.2, 96.5, 100.1, 123.5);
        System.out.println(test);
//        // Check order of four strings
//        System.out.println("Order: " + checkOrder(scnr.next(), scnr.next(), scnr.next(), scnr.next()));
//
//        // Check order of four doubles
//        System.out.println("Order: " + checkOrder(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble()));
    }
}