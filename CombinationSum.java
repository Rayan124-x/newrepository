/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.combinationsum;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int objetivo) {
        List<List<Integer>> resultados = new ArrayList<>();
        backtrack(nums, objetivo, 0, new ArrayList<>(), resultados);
        return resultados;
    }

    private static void backtrack(int[] nums, int objetivo, int index,
                                  List<Integer> actual, List<List<Integer>> resultados) {

        // Caso: objetivo alcanzado
        if (objetivo == 0) {
            resultados.add(new ArrayList<>(actual));
            return;
        }

        // Caso: objetivo negativo o índice fuera de rango
        if (objetivo < 0 || index >= nums.length) {
            return;
        }

        // 1. Tomamos el número nums[index]
        actual.add(nums[index]);
        backtrack(nums, objetivo - nums[index], index, actual, resultados);
        actual.remove(actual.size() - 1); // backtracking

        // 2. No tomamos el número y avanzamos al siguiente
        backtrack(nums, objetivo, index + 1, actual, resultados);
    }

    public static void main(String[] args) {
        int[] numeros = {2, 3, 6, 7};
        int objetivo = 7;

        List<List<Integer>> soluciones = combinationSum(numeros, objetivo);

        System.out.println("Combinaciones que suman " + objetivo + ":");
        for (List<Integer> sol : soluciones) {
            System.out.println(sol);
        }
    }
}


 