/
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosdebusqueda1;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
public class AlgoritmosDeBusqueda1 {
 public static int buscarBinario(int[] arreglo, int valor) {
        // Definimos el rango inicial de búsqueda
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        // Mientras el rango sea válido
        while (izquierda <= derecha) {
            // Calculamos el punto medio
            int medio = izquierda + (derecha - izquierda) / 2;

            // Si encontramos el valor en el punto medio
            if (arreglo[medio] == valor) {
                return medio; // Retorna la posición donde se encontró el valor
            }

            // Si el valor es mayor que el valor en el punto medio, buscar en la mitad derecha
            if (arreglo[medio] < valor) {
                izquierda = medio + 1;
            }
            // Si el valor es menor que el valor en el punto medio, buscar en la mitad izquierda
            else {
                derecha = medio - 1;
            }
        }

        // Si no encontramos el valor, retornamos -1
        return -1;
    }
    public static void main(String[] args) {
 int[] numeros = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        int valorBuscado = 35;

        // Llamamos al método de búsqueda binaria
        int resultado = buscarBinario(numeros, valorBuscado);

        // Imprimimos el resultado
        if (resultado != -1) {
            System.out.println("Valor " + valorBuscado + " encontrado en la posición: " + resultado);
        } else {
            System.out.println("Valor " + valorBuscado + " no se encuentra en el arreglo.");
        }
    }
}    
    

