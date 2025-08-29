/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmos_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 *
 * @author Usuario
 */
public class Algoritmos_2 {
    public static List<Integer> Algoritmos_2(List<Integer> data) {
        boolean sorted = false;

        while (!sorted) {
            List<List<Integer>> runs = new ArrayList<>();
            List<Integer> currentRun = new ArrayList<>();
            currentRun.add(data.get(0));

            // Paso 1: detectar runs naturales
            for (int i = 1; i < data.size(); i++) {
                if (data.get(i) >= data.get(i - 1)) {
                    currentRun.add(data.get(i));
                } else {
                    runs.add(currentRun);
                    currentRun = new ArrayList<>();
                    currentRun.add(data.get(i));
                }
            }
            runs.add(currentRun);

            // Si solo hubo un run → ya está ordenado
            if (runs.size() == 1) {
                sorted = true;
                break;
            }

            // Paso 2: fusionar runs
            List<Integer> merged = new ArrayList<>();
            for (int i = 0; i < runs.size(); i += 2) {
                if (i + 1 < runs.size()) {
                    merged.addAll(merge(runs.get(i), runs.get(i + 1)));
                } else {
                    merged.addAll(runs.get(i));
                }
            }
            data = merged;
        }
        return data;
    }

    // Función para fusionar dos listas ordenadas
    private static List<Integer> merge(List<Integer> run1, List<Integer> run2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < run1.size() && j < run2.size()) {
            if (run1.get(i) <= run2.get(j)) {
                result.add(run1.get(i++));
            } else {
                result.add(run2.get(j++));
            }
        }
        while (i < run1.size()) result.add(run1.get(i++));
        while (j < run2.size()) result.add(run2.get(j++));
        return result;
    }
     


    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(10, 20, 5, 30, 40, 25, 50);

        System.out.println("Original: " + data);
        List<Integer> sorted = Algoritmos_2(new ArrayList<>(data));
        System.out.println("Ordenado: " + sorted);
        
    }
}
    

