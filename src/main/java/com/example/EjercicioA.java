package com.example;

import java.util.HashMap;
import java.util.Map;

public class EjercicioA {

    public static Map<Integer, Integer> contarL(int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            result.put(arr[i], count);
        }

        return result;
    }

    public static Map<Integer, Integer> contarR(int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : arr) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}