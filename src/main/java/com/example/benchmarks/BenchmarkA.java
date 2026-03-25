package com.example.benchmarks;

import java.util.*;
import com.example.EjercicioA;

public class BenchmarkA {

    private static final int[] SIZES_L = { 10, 100, 500, 1000, 5000, 10000 };
    private static final int[] SIZES_R = { 10, 100, 1000, 10000, 100000, 1000000 };
    private static final int REPETITIONS = 10;
    private static final Random RANDOM = new Random(42);

    public static void main(String[] args) {
        System.out.println("ContarL:");
        for (int size : SIZES_L) {
            int[] data = generarDatos(size);
            long[] times = benchmark(EjercicioA::contarL, data);
            System.out.printf("n=%d -> %.4f ms%n", size, mediana(times) / 1_000_000.0);
        }

        System.out.println("\nContarR:");
        for (int size : SIZES_R) {
            int[] data = generarDatos(size);
            long[] times = benchmark(EjercicioA::contarR, data);
            System.out.printf("n=%d -> %.4f ms%n", size, mediana(times) / 1_000_000.0);
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
        method.apply(data);
        method.apply(data);
        for (int i = 0; i < REPETITIONS; i++) {
            long start = System.nanoTime();
            method.apply(data);
            times[i] = System.nanoTime() - start;
        }
        return times;
    }

    private static long mediana(long[] times) {
        long[] sorted = times.clone();
        Arrays.sort(sorted);
        int mid = sorted.length / 2;
        return (sorted.length % 2 == 0)
            ? (sorted[mid - 1] + sorted[mid]) / 2
            : sorted[mid];
    }
}