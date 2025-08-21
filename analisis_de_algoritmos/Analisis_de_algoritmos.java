/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.analisis_de_algoritmos;

/**
 *
 * @author Usuario
 */
public class Analisis_de_algoritmos {

    public static void main(String[] args) {
     int[] numeros = {5, 2, 9, 1, 6};

        // Algoritmo de Burbuja
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Mostrar resultado
        System.out.print("Ordenado: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}
        
    

