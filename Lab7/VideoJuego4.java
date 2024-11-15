import java.util.*;

public class VideoJuego4 {
    private Soldado[][] tablero;
    public Soldado[] ejercito1;
    public Soldado[] ejercito2;

    public VideoJuego4(int filas, int columnas) {
        tablero = new Soldado[filas][columnas];
        ejercito1 = new Soldado[10];
        ejercito2 = new Soldado[10];
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
            ejercito1[i] = nuevoSoldado;
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
            ejercito2[i] = nuevoSoldado;
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

    public double promedioVida(Soldado[] ejercito) {
        int totalVida = 0;
        int soldadosValidos = 0;
        for (Soldado soldado : ejercito) {
            if (soldado != null) {
                totalVida += soldado.getVida();
                soldadosValidos++;
            }
        }
        return soldadosValidos > 0 ? (double) totalVida / soldadosValidos : 0;
    }

    public void mostrarSoldadosPorEjercito(Soldado[] ejercito) {
        System.out.println("Soldados del ejército:");
        for (Soldado soldado : ejercito) {
            if (soldado != null) {
                System.out.println(soldado);
            }
        }
    }

    public void rankingSoldadosBurbuja(Soldado[] ejercito) {
        for (int i = 0; i < ejercito.length - 1; i++) {
            for (int j = 0; j < ejercito.length - 1 - i; j++) {
                if (ejercito[j] != null && ejercito[j + 1] != null &&
                    ejercito[j].getVida() < ejercito[j + 1].getVida()) {
                    Soldado temp = ejercito[j];
                    ejercito[j] = ejercito[j + 1];
                    ejercito[j + 1] = temp;
                }
            }
        }
        System.out.println("Ranking de soldados por burbuja:");
        mostrarSoldadosPorEjercito(ejercito);
    }

    public void rankingSoldadosQuicksort(Soldado[] ejercito, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(ejercito, inicio, fin);
            rankingSoldadosQuicksort(ejercito, inicio, indiceParticion - 1);
            rankingSoldadosQuicksort(ejercito, indiceParticion + 1, fin);
        }
    }

    private int particion(Soldado[] ejercito, int inicio, int fin) {
        int pivote = ejercito[fin].getVida();
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (ejercito[j] != null && ejercito[j].getVida() > pivote) {
                i++;
                Soldado temp = ejercito[i];
                ejercito[i] = ejercito[j];
                ejercito[j] = temp;
            }
        }
        Soldado temp = ejercito[i + 1];
        ejercito[i + 1] = ejercito[fin];
        ejercito[fin] = temp;
        return i + 1;
    }

    public void determinarGanador() {
        int vidaTotalEjercito1 = sumarVida(ejercito1);
        int vidaTotalEjercito2 = sumarVida(ejercito2);

        System.out.println("Vida total del Ejército 1: " + vidaTotalEjercito1);
        System.out.println("Vida total del Ejército 2: " + vidaTotalEjercito2);
        if (vidaTotalEjercito1 > vidaTotalEjercito2) {
            System.out.println("¡Ejército 1 gana la batalla!");
        } else if (vidaTotalEjercito1 < vidaTotalEjercito2) {
            System.out.println("¡Ejército 2 gana la batalla!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    private int sumarVida(Soldado[] ejercito) {
        int vidaTotal = 0;
        for (Soldado soldado : ejercito) {
            if (soldado != null) {
                vidaTotal += soldado.getVida();
            }
        }
        return vidaTotal;
    }
    public Soldado[] getEjercito1() {
        return ejercito1;
    }

    public Soldado[] getEjercito2() {
        return ejercito2;
    }
}
