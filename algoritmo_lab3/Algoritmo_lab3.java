/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmo_lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
public class Algoritmo_lab3 {

    /**
     * Ordena la lista usando un algoritmo Natural Merge Sort,
     * mostrando las iteraciones.
     * @param data lista de enteros a ordenar.
     * @return lista ordenada.
     */
    public static List<Integer> naturalMergeSort(List<Integer> data) {
        if (data == null || data.size() <= 1) {
            return data; // Ya está ordenado o es nulo.
        }

        boolean sorted = false;
        int iteracion = 1;

        while (!sorted) {
            System.out.println("Iteración " + iteracion + ":");

            // Paso 1: Detectar runs naturales (sublistas ya ordenadas)
            List<List<Integer>> runs = detectarRunsNaturales(data);
            System.out.println("  Runs detectados: " + runs);

            // Si solo hay un run, la lista ya está ordenada
            if (runs.size() == 1) {
                sorted = true;
                break;
            }

            // Paso 2: Fusionar runs de dos en dos
            data = fusionarRuns(runs);
            System.out.println("  Lista fusionada: " + data + "\n");

            iteracion++;
        }

        return data;
    }

    /**
     * Detecta runs naturales (sublistas ascendentes) en la lista.
     * @param data lista original.
     * @return lista de runs detectados.
     */
    private static List<List<Integer>> detectarRunsNaturales(List<Integer> data) {
        List<List<Integer>> runs = new ArrayList<>();
        List<Integer> currentRun = new ArrayList<>();
        currentRun.add(data.get(0));

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
        return runs;
    }

    /**
     * Fusiona runs de dos en dos usando la función merge.
     * @param runs lista de runs a fusionar.
     * @return lista fusionada.
     */
    private static List<Integer> fusionarRuns(List<List<Integer>> runs) {
        List<Integer> merged = new ArrayList<>();

        for (int i = 0; i < runs.size(); i += 2) {
            if (i + 1 < runs.size()) {
                merged.addAll(merge(runs.get(i), runs.get(i + 1)));
            } else {
                merged.addAll(runs.get(i));
            }
        }

        return merged;
    }

    /**
     * Fusiona dos listas ordenadas en una sola lista ordenada.
     * @param run1 primera lista ordenada.
     * @param run2 segunda lista ordenada.
     * @return lista fusionada ordenada.
     */
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

        while (i < run1.size()) {
            result.add(run1.get(i++));
        }

        while (j < run2.size()) {
            result.add(run2.get(j++));
        }

        return result;
    }    

    public static void main(String[] args) {
 List<Integer> data = Arrays.asList(10, 20, 5, 30, 40, 25, 50);

        System.out.println("Original: " + data);
        List<Integer> sorted = naturalMergeSort(new ArrayList<>(data));
        System.out.println("Ordenado: " + sorted);        
        
    }
    
}
