import java.util.*;
public class VideoJuego4 {
    private Soldado[][] tablero;
    private Soldado [] ejercito1;
    private Soldado [] ejercito2;
    public VideoJuego4(int filas, int columnas) {
        tablero = new Soldado[filas][columnas];
        ejercito1 = new Soldado [10];
        ejercito2 = new Soldado [10];
        inicializarEjercitos();
    }
    private void inicializarEjercitos() {
        Random rand = new Random();
        int numSoldados1 = rand.nextInt(5) + 1; 
        for (int i = 0; i < numSoldados1; i++) {
            String nombre = "Soldado1_" + i;
            int nivelVida = rand.nextInt(5) + 1;
            int fila, columna;
            do {
                fila = rand.nextInt(tablero.length);
                columna = rand.nextInt(tablero[0].length);
            } while (tablero[fila][columna] != null);
            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fila, columna);
            tablero[fila][columna] = nuevoSoldado;
            ejercito1[i]=nuevoSoldado;
        }
        int numSoldados2 = rand.nextInt(5) + 1;
        for (int i = 0; i < numSoldados2; i++) {
            String nombre = "Soldado2_" + i;
            int nivelVida = rand.nextInt(5) + 1;
            int fila, columna;
            do {
                fila = rand.nextInt(tablero.length);
                columna = rand.nextInt(tablero[0].length);
            } while (tablero[fila][columna] != null);
            
            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fila, columna);
            tablero[fila][columna] = nuevoSoldado;
            ejercito2[i]=nuevoSoldado;
        }
    }
    public void mostrarTablero() {
        System.out.print("   ");
        for (int j = 0; j < tablero[0].length; j++) {
            System.out.print("   \s " + (char) ('A' + j) + "      ");
        }
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\n" + (i + 1) + " ");
            if (i + 1 < 10) System.out.print(" ");
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    String soldado = tablero[i][j].getNombre();
                    soldado = String.format("%10s", soldado);
                    System.out.print("| " + soldado);
                } else {
                    System.out.print("| __________");
                }
            }
            System.out.println("|");
        }
    }
}