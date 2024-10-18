//Laboratorio Nro5 - Ejercicio 1
//Autor: Sergio Estrada Arce
//Tiempo: 2h 30h
package Ejercicio;
public class Ejercicio1 {
    public static void main(String[] args) {
        VideoJuego2 juego = new VideoJuego2(10, 10);
        
        System.out.println("Tablero Inicial:");
        juego.mostrarTablero();

        // Ordenamiento Burbuja
        juego.ordenarPorVidaBurbuja();
        System.out.println("\nRanking después de Burbuja:");
        juego.mostrarRanking();

        // Ordenamiento por Inserción Binaria
        juego.ordenarPorVidaInsercionBinaria();
        System.out.println("\nRanking después de Inserción Binaria:");
        juego.mostrarRanking();
    }
}
