import java.util.*; // Importa las clases necesarias para colecciones y utilidades

// Clase principal que representa el videojuego
public class VideoJuego {
    private Soldado[][] tablero; // Matriz que representa el tablero del juego
    private HashMap<String, Soldado> ejercito1; // Mapa para almacenar los soldados del Ejército 1
    private HashMap<String, Soldado> ejercito2; // Mapa para almacenar los soldados del Ejército 2

    // Constructor: inicializa el tablero y los ejércitos
    public VideoJuego(int filas, int columnas) {
        tablero = new Soldado[filas][columnas]; // Crea el tablero con las dimensiones indicadas
        ejercito1 = new HashMap<>(); // Inicializa el mapa para el Ejército 1
        ejercito2 = new HashMap<>(); // Inicializa el mapa para el Ejército 2
        inicializarEjercitos(); // Coloca los soldados en el tablero y en los mapas
    }

    // Método para inicializar los ejércitos y colocarlos en el tablero
    private void inicializarEjercitos() {
        Random rand = new Random(); // Generador de números aleatorios
        
        // Generar soldados para el Ejército 1
        int numSoldados1 = rand.nextInt(10) + 1; // Número aleatorio de soldados (entre 1 y 10)
        for (int i = 0; i < numSoldados1; i++) {
            String nombre = "Soldado1_" + i; // Nombre único para cada soldado
            int nivelVida = rand.nextInt(5) + 1; // Nivel de vida aleatorio (entre 1 y 5)
            int fila, columna;
            
            // Buscar una posición vacía en el tablero
            do {
                fila = rand.nextInt(tablero.length);
                columna = rand.nextInt(tablero[0].length);
            } while (tablero[fila][columna] != null);
            
            // Crear el soldado y colocarlo en el tablero y el mapa
            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, fila, columna);
            tablero[fila][columna] = nuevoSoldado;
            ejercito1.put(nombre, nuevoSoldado);
        }

        // Generar soldados para el Ejército 2 (mismo proceso que el anterior)
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

    // Muestra el tablero con los soldados y las posiciones vacías
    public void mostrarTablero() {
        // Encabezado con las letras de las columnas
        System.out.print("   ");
        for (int j = 0; j < tablero[0].length; j++) {
            System.out.print("   \s " + (char) ('A' + j) + "      "); // Letra correspondiente a la columna
        }
        System.out.println();
        
        // Filas del tablero
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\n" + (i + 1) + " "); // Número de fila
            if (i + 1 < 10) System.out.print(" "); // Ajuste para alineación
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) { // Si hay un soldado en la posición
                    String soldado = tablero[i][j].getNombre(); // Obtener el nombre del soldado
                    soldado = String.format("%10s", soldado); // Formatear para alineación
                    System.out.print("| " + soldado);
                } else { // Posición vacía
                    System.out.print("| __________");
                }
            }
            System.out.println("|");
        }
    }

    // Calcula el promedio de vida de un ejército
    public double promedioVida(HashMap<String, Soldado> ejercito) {
        int totalVida = 0;
        for (Soldado soldado : ejercito.values()) { // Sumar la vida de todos los soldados
            totalVida += soldado.getVida();
        }
        // Devolver el promedio si hay soldados, o 0 si el ejército está vacío
        return ejercito.size() > 0 ? (double) totalVida / ejercito.size() : 0;
    }

    // Muestra los soldados de un ejército
    public void mostrarSoldadosPorEjercito(HashMap<String, Soldado> ejercito) {
        System.out.println("Soldados del ejército:");
        for (Soldado soldado : ejercito.values()) { // Iterar sobre los soldados
            System.out.println(soldado); // Mostrar la información del soldado
        }
    }

    // Ordena y muestra los soldados por nivel de vida usando el método de burbuja
    public void rankingSoldadosBurbuja(HashMap<String, Soldado> ejercito) {
        List<Soldado> listaSoldados = new ArrayList<>(ejercito.values());
        // Ordenamiento burbuja
        for (int i = 0; i < listaSoldados.size() - 1; i++) {
            for (int j = 0; j < listaSoldados.size() - 1 - i; j++) {
                if (listaSoldados.get(j).getVida() < listaSoldados.get(j + 1).getVida()) {
                    Collections.swap(listaSoldados, j, j + 1); // Intercambiar posiciones
                }
            }
        }
        // Mostrar el ranking
        System.out.println("Ranking de soldados por burbuja:");
        listaSoldados.forEach(System.out::println);
    }

    // Ordena y muestra los soldados por nivel de vida usando quicksort
    public void rankingSoldadosQuicksort(HashMap<String, Soldado> ejercito) {
        List<Soldado> listaSoldados = new ArrayList<>(ejercito.values());
        listaSoldados.sort((a, b) -> Integer.compare(b.getVida(), a.getVida())); // Ordenar por vida descendente
        System.out.println("Ranking de soldados por quicksort:");
        listaSoldados.forEach(System.out::println);
    }

    // Determina el ejército ganador basado en la vida total
    public void determinarGanador() {
        // Sumar la vida total de ambos ejércitos
        int vidaTotalEjercito1 = ejercito1.values().stream().mapToInt(Soldado::getVida).sum();
        int vidaTotalEjercito2 = ejercito2.values().stream().mapToInt(Soldado::getVida).sum();

        // Mostrar los resultados
        System.out.println("Vida total del Ejército 1: " + vidaTotalEjercito1);
        System.out.println("Vida total del Ejército 2: " + vidaTotalEjercito2);
        // Determinar y anunciar al ganador
        if (vidaTotalEjercito1 > vidaTotalEjercito2) {
            System.out.println("¡Ejército 1 gana la batalla!");
        } else if (vidaTotalEjercito1 < vidaTotalEjercito2) {
            System.out.println("¡Ejército 2 gana la batalla!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    // Métodos getter para obtener los ejércitos
    public HashMap<String, Soldado> getEjercito1() {
        return ejercito1;
    }

    public HashMap<String, Soldado> getEjercito2() {
        return ejercito2;
    }
}
