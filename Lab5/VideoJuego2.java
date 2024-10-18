package Ejercicio;
import java.util.*;
public class VideoJuego2 {
    private Soldado[][] tablero; 
    private ArrayList<Soldado> listaSoldados; 
    // Constructor
    public VideoJuego2(int filas, int columnas) {
        tablero = new Soldado[filas][columnas];
        listaSoldados = new ArrayList<>();
        inicializarSoldados();
    }
    // Inicializar soldados con cantidad aleatoria
    private void inicializarSoldados() {
        Random rand = new Random();
        int numSoldados = rand.nextInt(10) + 1; 
        for (int i=0; i<numSoldados;i++) {
            String nombre = "Soldado" + i;
            int nivelVida = rand.nextInt(5) + 1; 
            int fila, columna;
            do {
                fila = rand.nextInt(tablero.length);      
                columna = rand.nextInt(tablero[0].length); 
            } while (tablero[fila][columna] != null);    
            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fila, columna);
            tablero[fila][columna] = nuevoSoldado;
            listaSoldados.add(nuevoSoldado);            
        }
    }
    public void mostrarTablero() {
        // Títulos de columnas (A, B, C...)
        System.out.print("   ");
        for (int j = 0; j < tablero[0].length; j++) {
            System.out.print(" \s " + (char) ('A' + j) + "      ");
        }
        System.out.println();   
        // Recorrer filas y columnas del tablero
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\n" + (i + 1) + " ");
            if (i + 1 < 10) System.out.print(" "); // Alinear los números de fila
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    // Mostrar el nombre del soldado en la celda
                    String soldado = tablero[i][j].getNombre(); // Directamente desde el tablero
                    soldado = String.format("%-8s", soldado);    // Ajustar a 8 espacios
                    System.out.print("| " + soldado);
                } else {
                	System.out.print("| ________");
                }
            }
            System.out.println("|"); 
        }
    }
    // Algoritmo de ordenamiento Burbuja (por nivel de vida)
    public void ordenarPorVidaBurbuja() {
        int n = listaSoldados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Cambiar la comparación para ordenar de mayor a menor
                if (listaSoldados.get(j).getVida() < listaSoldados.get(j + 1).getVida()) {
                    // Intercambiar
                    Soldado temp = listaSoldados.get(j);
                    listaSoldados.set(j, listaSoldados.get(j + 1));
                    listaSoldados.set(j + 1, temp);
                }
            }
        }
    }
    // Algoritmo de ordenamiento por inserción binaria (de mayor a menor)
    public void ordenarPorVidaInsercionBinaria() {
        for (int i = 1; i < listaSoldados.size(); i++) {
            Soldado key = listaSoldados.get(i);
            int pos = busquedaBinaria(listaSoldados, key, 0, i - 1);
            for (int j = i - 1; j >= pos; j--) {
                listaSoldados.set(j + 1, listaSoldados.get(j));
            }
            listaSoldados.set(pos, key);
        }
    }
    // Búsqueda binaria para encontrar la posición de inserción
    private int busquedaBinaria(List<Soldado> lista, Soldado key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            // Cambiar la comparación para ordenar de mayor a menor
            if (key.getVida() > lista.get(mid).getVida()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    // Mostrar el ranking de soldados por nivel de vida
    public void mostrarRanking() {
        System.out.println("Ranking de Soldados (por nivel de vida):");
        for (Soldado soldado : listaSoldados) {
            System.out.println(soldado.getNombre() + " - Vida: " + soldado.getVida());
        }
    }
}