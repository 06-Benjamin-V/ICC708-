package com.example;

import java.util.HashMap;
import java.util.Map;

public class EjercicioA {

    public static Map<Integer, Integer> contarL(int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        long iTiempo = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            result.put(arr[i], count);
        }
        long fTiempo = System.nanoTime();
        System.out.println("tiempo lineal: " + (fTiempo - iTiempo) / 1000000.0 + " ms");

        return result;
    }

    public static Map<Integer, Integer> contarR(int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        long iTiempo = System.nanoTime();
        for (int num : arr) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        long fTiempo = System.nanoTime();
        System.out.println("tiempo hash: " + (fTiempo - iTiempo) / 1000000.0 + " ms");
        return result;
    }
}