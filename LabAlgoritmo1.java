/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.algoritmo.pkg1;

/**
 *
 * @author LAB-USR-AREQUIPA
 */  


//ejemplo de tiempo exponencial O(n) //
public class LabAlgoritmo1 {

    public static int fibonacci(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 11;
        int[] memo = new int[n + 1];
        java.util.Arrays.fill(memo, -1);

        System.out.println("Fibonacci de " + n + " es: " + fibonacci(n, memo));
    }
}