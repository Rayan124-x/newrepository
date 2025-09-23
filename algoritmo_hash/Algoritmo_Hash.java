/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmo_hash;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Algoritmo_Hash {
     private LinkedList<Entry>[] table;
    private int size;

    // Clase para representar un par clave-valor
    private static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public Algoritmo_Hash(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = capacity;
    }

    // Función hash simple (basada en el hashCode de String)
    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    // Insertar par clave-valor
    public void put(String key, String value) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Si ya existe la clave, actualiza el valor
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    // Buscar un valor por clave
    public String get(String key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // No encontrado
    }

    // Eliminar una clave
    public void remove(String key) {
        int index = hash(key);
        table[index].removeIf(entry -> entry.key.equals(key));
    }

    // Mostrar la tabla hash
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
 Algoritmo_Hash hashTable = new Algoritmo_Hash(10);

        // Insertando elementos
        hashTable.put("Juan", "12345");
        hashTable.put("Ana", "67890");
        hashTable.put("Pedro", "11111");
        hashTable.put("Luis", "22222");

        // Mostrar tabla
        hashTable.display();

        // Buscar elementos
        System.out.println("Teléfono de Ana: " + hashTable.get("Ana"));
        System.out.println("Teléfono de Pedro: " + hashTable.get("Pedro"));

        // Eliminar elemento
        hashTable.remove("Luis");
        System.out.println("\nDespués de eliminar a Luis:");
        hashTable.display();    
    
    }
}
