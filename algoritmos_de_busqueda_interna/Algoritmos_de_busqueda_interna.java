/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmos_de_busqueda_interna;

/**
 *
 * @author Usuario
 */
public class Algoritmos_de_busqueda_interna {
public static int buscar(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return i; // retorna la posición donde encontró el valor
            }
        }
        return -1; // si no se encuentra, retorna -1
    }
    public static void main(String[] args) {
int[] numeros = {5, 10, 15, 20, 25, 30};
        int valorBuscado = 20;

        int resultado = buscar(numeros, valorBuscado);

        if (resultado != -1) {
            System.out.println("Valor " + valorBuscado + " encontrado en la posición: " + resultado);
        } else {
            System.out.println("Valor " + valorBuscado + " no se encuentra en el arreglo.");
        }
    }
}
