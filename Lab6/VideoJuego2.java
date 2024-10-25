import java.util.*;
public class VideoJuego2 {
    private Soldado[][] tablero;
    private ArrayList<Soldado> listaSoldados;

    public VideoJuego2(int filas, int columnas) {
        tablero = new Soldado[filas][columnas];
        listaSoldados = new ArrayList<>();
        inicializarSoldados(); // Falta implementar lógica completa
    }

    // Aquí la función de inicialización aún está incompleta
    private void inicializarSoldados() {
        Random rand = new Random();
        int numSoldados = rand.nextInt(10) + 1;
        for (int i = 0; i < numSoldados; i++) {
            String nombre = "Soldado" + i;
            int nivelVida = rand.nextInt(5) + 1;
            int fila = rand.nextInt(tablero.length);
            int columna = rand.nextInt(tablero[0].length);
            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fila, columna);
            tablero[fila][columna] = nuevoSoldado;
            listaSoldados.add(nuevoSoldado);
        }
    }

    // Método aún básico para mostrar tablero
    public void mostrarTablero() {
        System.out.println("Tablero del videojuego:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("S ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

