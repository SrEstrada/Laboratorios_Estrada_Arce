//Laboratorio Nro 4 - Ejercicio 1
//Autor: Sergio Estrada Arce
//Tiempo: 5h 39m
package Ejercicios;
import java.util.*;
public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[8];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado (true/false): ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave(); 
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        // Mostrar todas las naves
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        // Mostrar naves por nombre
        mostrarPorNombre(misNaves);
        // Mostrar naves por puntos
        mostrarPorPuntos(misNaves);
        // Nave con mayor número de puntos
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves).getNombre());
        // Buscar nave por nombre (búsqueda lineal)
        System.out.print("\nIngrese un nombre para buscar (búsqueda lineal): ");
        String nombre = sc.next();
        int pos = busquedaLinealNombre(misNaves, nombre);
        if (pos != -1) {
            System.out.println("Nave encontrada: " + misNaves[pos].getNombre());
        } else {
            System.out.println("Nave no encontrada.");
        }
        // Ordenar naves por puntos (burbuja)
        ordenarPorPuntosBurbuja(misNaves);
        System.out.println("\nNaves ordenadas por puntos (de menor a mayor) - Burbuja:");
        mostrarNaves(misNaves);
        // Ordenar naves por nombre (burbuja)
        ordenarPorNombreBurbuja(misNaves);
        System.out.println("\nNaves ordenadas por nombre (A a Z) - Burbuja:");
        mostrarNaves(misNaves);
        // Buscar nave por nombre (búsqueda binaria)
        ordenarPorNombreBurbuja(misNaves); // Asegurarse de que las naves están ordenadas
        System.out.print("\nIngrese un nombre para buscar (búsqueda binaria): ");
        nombre = sc.next();
        pos = busquedaBinariaNombre(misNaves, nombre);
        if (pos != -1) {
            System.out.println("Nave encontrada: " + misNaves[pos].getNombre());
        } else {
            System.out.println("Nave no encontrada.");
        }
        // Ordenar naves por puntos (selección)
        ordenarPorPuntosSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por puntos (de menor a mayor) - Selección:");
        mostrarNaves(misNaves);
        // Ordenar naves por nombre (selección)
        ordenarPorNombreSeleccion(misNaves);
        System.out.println("\nNaves ordenadas por nombre (A a Z) - Selección:");
        mostrarNaves(misNaves);
        // Ordenar naves por puntos (inserción)
        ordenarPorPuntosInsercion(misNaves);
        System.out.println("\nNaves ordenadas por puntos (de mayor a menor) - Inserción:");
        mostrarNaves(misNaves);
        // Ordenar naves por nombre (Z a A) - Inserción
        ordenarPorNombreInsercion(misNaves);
        System.out.println("\nNaves ordenadas por nombre (Z a A) - Inserción:");
        mostrarNaves(misNaves);
    }
    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            System.out.println(nave);
        }
    }
    // Método para mostrar naves por nombre pedido por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de la nave a buscar: ");
        String nombre = sc.next();
        boolean encontrado = false;
        for (Nave nave : flota) {
            if (nave.getNombre().equals(nombre)) {
                System.out.println(nave);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ninguna nave con ese nombre.");
        }
    }
    // Método para mostrar naves con puntos menores o iguales al pedido
    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese un número de puntos para buscar naves con puntos menores o iguales: ");
        int puntos = sc.nextInt();
        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntos) {
                System.out.println(nave);
            }
        }
    }
    // Método que devuelve la nave con mayor número de puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayor = flota[0];
        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayor.getPuntos()) {
                naveMayor = nave;
            }
        }
        return naveMayor;
    }
    // Método para buscar la primera nave con un nombre (búsqueda lineal)
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equals(s)) {
                return i;  
            }
        }
        return -1;  
    }
    // Método que ordena por puntos (de menor a mayor) usando Burbuja
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - 1 - i; j++) {
                if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }
    // Método que ordena por nombre (A a Z) usando Burbuja
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - 1 - i; j++) {
                if (flota[j].getNombre().compareTo(flota[j + 1].getNombre()) > 0) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }
    // Método que ordena por puntos (de menor a mayor) usando Selección
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j].getPuntos() < flota[minIndex].getPuntos()) {
                    minIndex = j;
                }
            }
            Nave temp = flota[i];
            flota[i] = flota[minIndex];
            flota[minIndex] = temp;
        }
    }
    // Método que ordena por nombre (A a Z) usando Selección
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j].getNombre().compareTo(flota[minIndex].getNombre()) < 0) {
                    minIndex = j;
                }
            }
            Nave temp = flota[i];
            flota[i] = flota[minIndex];
            flota[minIndex] = temp;
        }
    }
    // Método que ordena por puntos (de mayor a menor) usando Inserción
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getPuntos() < key.getPuntos()) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = key;
        }
    }

    // Método que ordena por nombre (Z a A) usando Inserción
    public static void ordenarPorNombreInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getNombre().compareTo(key.getNombre()) < 0) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = key;
        }
    }
    // Método para buscar una nave por nombre (búsqueda binaria)
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int inicio = 0;
        int fin = flota.length - 1;

        while (inicio <= fin) {
            int mid = (inicio + fin) / 2;
            if (flota[mid].getNombre().equals(s)) {
                return mid;
            } else if (flota[mid].getNombre().compareTo(s) < 0) {
                inicio = mid + 1;
            } else {
                fin = mid - 1;
            }
        }
        return -1;  
    }
}
