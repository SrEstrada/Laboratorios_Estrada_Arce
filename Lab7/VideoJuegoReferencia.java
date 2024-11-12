import java.util.*;
public class VideoJuegoReferencia {
    private Soldado[][] tablero;
    private ArrayList<Soldado> ejercito1;
    private ArrayList<Soldado> ejercito2;
    public VideoJuegoReferencia(int filas, int columnas) {
        tablero = new Soldado[filas][columnas];
        ejercito1 = new ArrayList<>();
        ejercito2 = new ArrayList<>();
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
            ejercito1.add(nuevoSoldado);
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
            ejercito2.add(nuevoSoldado);
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
    private int sumarVida(ArrayList<Soldado> ejercito) {
        int vidaTotal = 0;
        for (Soldado soldado : ejercito) {
            vidaTotal += soldado.getVida();
        }
        return vidaTotal;
    }
    // 1. Método para mostrar el soldado con mayor vida de cada ejército
    public Soldado soldadoMayorVida(ArrayList<Soldado> ejercito) {
        Soldado soldadoMayor = ejercito.get(0);
        for (Soldado soldado : ejercito) {
            if (soldado.getVida() > soldadoMayor.getVida()) {
                soldadoMayor = soldado;
            }
        }
        return soldadoMayor;
    }
    // 2. Método para calcular el promedio de vida de los soldados por ejército
    public double promedioVida(ArrayList<Soldado> ejercito) {
        return (double) sumarVida(ejercito) / ejercito.size();
    }
    // 3. Método para mostrar los datos de todos los soldados en el orden en que fueron creados
    public void mostrarSoldadosPorEjercito(ArrayList<Soldado> ejercito) {
        System.out.println("Soldados del ejército:");
        for (Soldado soldado : ejercito) {
            System.out.println(soldado);
        }
    }
    // 4. Ranking de poder usando algoritmo de ordenamiento (burbuja y quicksort)
    public void rankingSoldadosBurbuja(ArrayList<Soldado> ejercito) {
        for (int i = 0; i < ejercito.size() - 1; i++) {
            for (int j = 0; j < ejercito.size() - 1 - i; j++) {
                if (ejercito.get(j).getVida() < ejercito.get(j + 1).getVida()) {
                    Soldado temp = ejercito.get(j);
                    ejercito.set(j, ejercito.get(j + 1));
                    ejercito.set(j + 1, temp);
                }
            }
        }
        System.out.println("Ranking de soldados por burbuja:");
        mostrarSoldadosPorEjercito(ejercito);
    }
    public void rankingSoldadosQuicksort(ArrayList<Soldado> ejercito, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(ejercito, inicio, fin);
            rankingSoldadosQuicksort(ejercito, inicio, indiceParticion - 1);
            rankingSoldadosQuicksort(ejercito, indiceParticion + 1, fin);
        }
    }
    private int particion(ArrayList<Soldado> ejercito, int inicio, int fin) {
        int pivote = ejercito.get(fin).getVida();
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (ejercito.get(j).getVida() > pivote) {
                i++;
                Soldado temp = ejercito.get(i);
                ejercito.set(i, ejercito.get(j));
                ejercito.set(j, temp);
            }
        }
        Soldado temp = ejercito.get(i + 1);
        ejercito.set(i + 1, ejercito.get(fin));
        ejercito.set(fin, temp);
        return i + 1;
    }
    public ArrayList<Soldado> getEjercito1() {
        return ejercito1;
    }

    public ArrayList<Soldado> getEjercito2() {
        return ejercito2;
    }
}

