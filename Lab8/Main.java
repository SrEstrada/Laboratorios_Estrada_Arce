public class Main {
    public static void main(String[] args) {
        // Crear un videojuego con tablero de 10 filas y 10 columnas
        VideoJuego juego = new VideoJuego(10, 10);

        // Mostrar el tablero con los soldados colocados
        System.out.println("Tablero inicial:");
        juego.mostrarTablero();

        // Mostrar soldados del Ejército 1
        System.out.println("\nSoldados del Ejército 1:");
        juego.mostrarSoldadosPorEjercito(juego.getEjercito1());

        // Mostrar soldados del Ejército 2
        System.out.println("\nSoldados del Ejército 2:");
        juego.mostrarSoldadosPorEjercito(juego.getEjercito2());

        // Calcular y mostrar el promedio de vida de cada ejército
        System.out.printf("\nPromedio de vida del Ejército 1: %.2f%n", juego.promedioVida(juego.getEjercito1()));
        System.out.printf("Promedio de vida del Ejército 2: %.2f%n", juego.promedioVida(juego.getEjercito2()));

        // Mostrar ranking de soldados usando burbuja para cada ejército
        System.out.println("\nRanking del Ejército 1 por burbuja:");
        juego.rankingSoldadosBurbuja(juego.getEjercito1());
        
        System.out.println("\nRanking del Ejército 2 por burbuja:");
        juego.rankingSoldadosBurbuja(juego.getEjercito2());

        // Mostrar ranking de soldados usando quicksort para cada ejército
        System.out.println("\nRanking del Ejército 1 por quicksort:");
        juego.rankingSoldadosQuicksort(juego.getEjercito1());
        
        System.out.println("\nRanking del Ejército 2 por quicksort:");
        juego.rankingSoldadosQuicksort(juego.getEjercito2());

        // Determinar el ejército ganador
        System.out.println("\nDeterminando el ganador:");
        juego.determinarGanador();
    }
}
