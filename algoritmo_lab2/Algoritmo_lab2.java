/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmo_lab2;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
public class Algoritmo_lab2 {
     public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) return; // Si tiene 1 elemento, ya está ordenado

        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];

        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas
        mergeSort(izquierda);
        mergeSort(derecha);

        // Combinar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Método que combina dos arreglos ordenados en uno solo
    public static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mientras haya elementos en ambas mitades
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        // Copiar elementos restantes (si los hay)
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    // Método para imprimir el arreglo
    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
int[] numeros = {5, 2, 9, 1, 6, 3};

        System.out.println("Antes de ordenar:");
        imprimirArreglo(numeros);

        mergeSort(numeros);

        System.out.println("Despues de ordenar:");
        imprimirArreglo(numeros);
    }
}
    
    

