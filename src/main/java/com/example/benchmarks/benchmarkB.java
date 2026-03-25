package com.example.benchmarks;

import com.example.ConctStrings;
import java.util.Arrays;

public class benchmarkB {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 10000, 20000};

        for (int size : sizes) {
            double[] timesDirect = new double[20];
            double[] timesBuilder = new double[20];

            for (int i = 0; i < 20; i++) {
                long start = System.nanoTime();
                ConctStrings.concatDirect(size);
                long end = System.nanoTime();
                timesDirect[i] = (end - start) / 1000000.0;
            }

            for (int i = 0; i < 20; i++) {
                long start = System.nanoTime();
                ConctStrings.concatBuilder(size);
                long end = System.nanoTime();
                timesBuilder[i] = (end - start) / 1000000.0;
            }

            Arrays.sort(timesDirect);
            Arrays.sort(timesBuilder);
            
            double medDirect = (timesDirect[9] + timesDirect[10]) / 2.0;
            double medBuilder = (timesBuilder[9] + timesBuilder[10]) / 2.0;

            long d = Math.round(medDirect);
            long b = Math.round(medBuilder);
            System.out.printf("size=%d direct=%d ms builder=%d ms\n", size, d, b);
        }
    }
}

