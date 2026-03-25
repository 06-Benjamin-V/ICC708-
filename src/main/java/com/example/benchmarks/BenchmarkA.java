package com.example.benchmarks;

import java.util.*;

import com.example.EjercicioA;

public class BenchmarkA {
    private static final int[] SIZES = { 10, 100, 1000, 10000, 100000, 1000000 };
    private static final int REPETITIONS = 30;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        for (int size : SIZES) {
            int[] data = generarDatos(size);

            long[] timesL = benchmark(EjercicioA::contarL, data);
            double medianLms = calcularMedian(timesL) / 1_000_000.0;
            System.out.println("Tamaño " + size + " - ContarL mediana: " + medianLms + " ms");

            long[] timesR = benchmark(EjercicioA::contarR, data);
            double medianRms = calcularMedian(timesR) / 1_000_000.0;
            System.out.println("Tamaño " + size + " - contarR mediana: " + medianRms + " ms");
        }
    }

    private static int[] generarDatos(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = RANDOM.nextInt(100);
        }
        return data;
    }

    private static long[] benchmark(java.util.function.Function<int[], Map<Integer, Integer>> method, int[] data) {
        long[] times = new long[REPETITIONS];
        for (int i = 0; i < REPETITIONS; i++) {
            long start = System.nanoTime();
            method.apply(data);
            long end = System.nanoTime();
            times[i] = end - start;
        }
        return times;
    }

    private static long calcularMedian(long[] times) {
        Arrays.sort(times);
        return times[REPETITIONS / 2];
    }
}