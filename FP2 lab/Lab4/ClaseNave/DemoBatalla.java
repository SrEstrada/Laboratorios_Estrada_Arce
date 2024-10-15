//Laboratorio Nro 4 - Ejercicio 1
//Autor: Sergio Estrada Arce
//Tiempo: por definir 
package Ejercicios;
import java.util.*;
public class DemoBatalla {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
    	Nave[] misNaves = new Nave[8];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.println("Fila ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
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
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
        String nombre; 
        do {
            System.out.print("Ingrese el nombre de la nave: ");
            nombre = scan.next();
            int pos = busquedaLinealNombre(misNaves, nombre);
            if (pos != -1) {
                System.out.println("Nombre de la nave encontrado, mandando datos...\n" + misNaves[pos]);
            } else {
                System.out.println("Nombre de la nave no encontrado, pruebe de nuevo");
            }
        } while (true);
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);
        // mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        int pos2 = busquedaBinariaNombre(misNaves, nombre);
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }

    public static void mostrarNaves(Nave[] flota) {
    	for (int i=0; i<flota.length;i++) {
    		System.out.println(flota[i]);
    	}
    }
    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        for (int i=0; i<flota.length;i++) {
        }
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        // REUTILIZAR
    }

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        // REUTILIZAR
    }
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (s.equals(flota[i].getNombre())) {
                return i; 
            }
        }
        return -1; 
    }
    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        // Implementación
    }
    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            for (int j = 0; j < flota.length - i; j++) {
                if (flota[j].getNombre().compareTo(flota[j + 1].getNombre()) > 0) {
                    intercambiar(flota, j, j + 1);
                }
            }
        }
    }
    public static void intercambiar(Nave[] flota, int i, int j) {
        Nave temp = flota[i];
        flota[i] = flota[j];
        flota[j] = temp;
    }
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        // Implementación
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        // Implementación
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        // Implementación
    }

    // Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        // Implementación
    }

    // Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota) {
        // Implementación
    }
}