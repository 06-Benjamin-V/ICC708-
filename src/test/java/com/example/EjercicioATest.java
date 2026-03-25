package com.example;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EjercicioATest {

    @Test
    void testCasoNormal() {
        int[] data = { 1, 2, 2, 3, 1 };

        Map<Integer, Integer> conFor = EjercicioA.contarL(data);
        Map<Integer, Integer> conHash = EjercicioA.contarR(data);

        assertEquals(conFor, conHash);
        assertEquals(2, conFor.get(1));
        assertEquals(2, conFor.get(2));
        assertEquals(1, conHash.get(3));
    }

    @Test
    void testCasoVacio() {
        int[] data = {};

        assertTrue(EjercicioA.contarL(data).isEmpty());
        assertTrue(EjercicioA.contarR(data).isEmpty());
    }

    @Test
    void testCasoUnico() {
        int[] data = { 5 };

        Map<Integer, Integer> result = EjercicioA.contarR(data);

        assertEquals(1, result.get(5));
    }

    @Test
    void testCasoRepetido() {
        int[] data = { 7, 7, 7, 7 };

        Map<Integer, Integer> result = EjercicioA.contarR(data);

        assertEquals(4, result.get(7));
    }

    @Test
    void testCasoOrdenadoYReverso() {
        int[] ordered = { 1, 2, 3, 4, 5 };
        int[] reversed = { 5, 4, 3, 2, 1 };

        assertEquals(
                EjercicioA.contarL(ordered),
                EjercicioA.contarR(reversed));
    }
}
