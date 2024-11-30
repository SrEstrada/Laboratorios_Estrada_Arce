import java.util.*;

public class VideoJuego {
    private Soldado[][] tablero;
    private HashMap<String, Soldado> ejercito1;
    private HashMap<String, Soldado> ejercito2;

    public VideoJuego(int filas, int columnas) {
        tablero = new Soldado[filas][columnas];
        ejercito1 = new HashMap<>();
        ejercito2 = new HashMap<>();
        inicializarEjercitos();
    }
private void inicializarEjercitos() {
    Random rand = new Random();
    int numSoldados1 = rand.nextInt(10) + 1;
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
        ejercito1.put(nombre, nuevoSoldado);
    }

    int numSoldados2 = rand.nextInt(10) + 1;
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
        ejercito2.put(nombre, nuevoSoldado);
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
    public double promedioVida(HashMap<String, Soldado> ejercito) {
        int totalVida = 0;
        for (Soldado soldado : ejercito.values()) {
            totalVida += soldado.getVida();
        }
        return ejercito.size() > 0 ? (double) totalVida / ejercito.size() : 0;
    }

    public void mostrarSoldadosPorEjercito(HashMap<String, Soldado> ejercito) {
        System.out.println("Soldados del ejército:");
        for (Soldado soldado : ejercito.values()) {
            System.out.println(soldado);
        }
    }
    public void rankingSoldadosBurbuja(HashMap<String, Soldado> ejercito) {
        List<Soldado> listaSoldados = new ArrayList<>(ejercito.values());
        for (int i = 0; i < listaSoldados.size() - 1; i++) {
            for (int j = 0; j < listaSoldados.size() - 1 - i; j++) {
                if (listaSoldados.get(j).getVida() < listaSoldados.get(j + 1).getVida()) {
                    Collections.swap(listaSoldados, j, j + 1);
                }
            }
        }
        System.out.println("Ranking de soldados por burbuja:");
        listaSoldados.forEach(System.out::println);
    }

    public void rankingSoldadosQuicksort(HashMap<String, Soldado> ejercito) {
        List<Soldado> listaSoldados = new ArrayList<>(ejercito.values());
        listaSoldados.sort((a, b) -> Integer.compare(b.getVida(), a.getVida()));
        System.out.println("Ranking de soldados por quicksort:");
        listaSoldados.forEach(System.out::println);
    }

    public void determinarGanador() {
        int vidaTotalEjercito1 = ejercito1.values().stream().mapToInt(Soldado::getVida).sum();
        int vidaTotalEjercito2 = ejercito2.values().stream().mapToInt(Soldado::getVida).sum();

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
    public HashMap<String, Soldado> getEjercito1() {
        return ejercito1;
    }

    public HashMap<String, Soldado> getEjercito2() {
        return ejercito2;
    }
}
