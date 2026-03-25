package com.example;
public class ConctStrings {
        public static String first = "Lorem ipsum dolor sit, amet";
        public static String second = " consectetur adipiscing elit, egestas curabitur. ";
        public static String result = first + second;

        public static String tenConcat() {
                String tenresult = "";
                long startTime = System.nanoTime();
                for (int i = 0; i < 10; i++) {
                        tenresult = first + second;
                        System.out.println(tenresult);
                }
                long endTime = System.nanoTime();
                System.out.println("Time taken for 10 concatenations: " + ((endTime - startTime)/ 1000000.0) + " ms");
                return tenresult;
        }

        public static String oneHundredConcat() {
                String oneHundredresult = "";
                long startTime = System.nanoTime();
                for (int i = 0; i < 100; i++) {
                        oneHundredresult = first + second;
                        System.out.println(oneHundredresult);
                }
                long endTime = System.nanoTime();
                System.out.println("Time taken for 100 concatenations: " + ((endTime - startTime)/ 1000000.0) + " ms");
                return oneHundredresult;
        }

        public static String oneThousandConcat() {
                long startTime = System.nanoTime();
                String oneThousandresult = "";
                for (int i = 0; i < 1000; i++) {
                        oneThousandresult = first + second;
                        System.out.println(oneThousandresult);
                }
                long endTime = System.nanoTime();
                System.out.println("Time taken for 1000 concatenations: " + ((endTime - startTime)/ 1000000.0) + " ms");
                return oneThousandresult;
        }

        //
        //-----------------------------------------------------------
        //Builder zone
        //-----------------------------------------------------------
        //

        public static String tenConcatBuilder() {
                StringBuilder tenresult = new StringBuilder();
                long startTime = System.nanoTime();
                for (int i = 0; i < 10; i++) {
                        tenresult.append(first).append(second).append("\n");
                        System.out.println(tenresult.toString());
                }
                long endTime = System.nanoTime();
                System.out.println("Time taken for 10 concatenations with builder: " + ((endTime - startTime)/ 1000000.0) + " ms");
                return tenresult.toString();
        }

        public static String oneHundredConcatBuilder() {
                StringBuilder oneHundredresult = new StringBuilder();
                long startTime = System.nanoTime();
                for (int i = 0; i < 100; i++) {
                        oneHundredresult.append(first).append(second).append("\n");
                        System.out.println(oneHundredresult.toString());
                }
                long endTime = System.nanoTime();
                System.out.println("Time taken for 100 concatenations with builder: " + ((endTime - startTime)/ 1000000.0) + " ms");
                return oneHundredresult.toString();
        }

        public static String oneThousandConcatBuilder() {
                StringBuilder oneThousandresult = new StringBuilder();
                long startTime = System.nanoTime();
                for (int i = 0; i < 1000; i++) {
                        oneThousandresult.append(first).append(second).append("\n");
                        System.out.println(oneThousandresult.toString());
                }
                long endTime = System.nanoTime();
                System.out.println("Time taken for 1000 concatenations with builder: " + ((endTime - startTime)/ 1000000.0) + " ms");
                return oneThousandresult.toString();
        }

        public static String concatDirect(int repetitions) {
                String result = "";
                for (int i = 0; i < repetitions; i++) {
                        result = first + second;
                }
                return result;
        }

        public static String concatBuilder(int repetitions) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < repetitions; i++) {
                        sb.append(first).append(second);
                }
                return sb.toString();
        }
}
