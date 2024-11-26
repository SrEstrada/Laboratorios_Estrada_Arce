import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoJuego4 juego = new VideoJuego4(10, 10);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Mostrar tablero");
            System.out.println("2. Mostrar soldados del Ejército 1");
            System.out.println("3. Mostrar soldados del Ejército 2");
            System.out.println("4. Mostrar promedio de vida de Ejército 1");
            System.out.println("5. Mostrar promedio de vida de Ejército 2");
            System.out.println("6. Mostrar ranking de Ejército 1 (Burbuja)");
            System.out.println("7. Mostrar ranking de Ejército 2 (Quicksort)");
            System.out.println("8. Determinar ganador");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> juego.mostrarTablero();
                case 2 -> juego.mostrarSoldadosPorEjercito(juego.getEjercito1());
                case 3 -> juego.mostrarSoldadosPorEjercito(juego.getEjercito2());
                case 4 -> System.out.println("Promedio de vida Ejército 1: " + juego.promedioVida(juego.getEjercito1()));
                case 5 -> System.out.println("Promedio de vida Ejército 2: " + juego.promedioVida(juego.getEjercito2()));
                case 6 -> juego.rankingSoldadosBurbuja(juego.getEjercito1());
                case 7 -> {
                    System.out.println("Ranking de soldados del Ejército 2 por Quicksort:");
                    juego.rankingSoldadosQuicksort(juego.getEjercito2(), 0, juego.getEjercito2().length - 1);
                    juego.mostrarSoldadosPorEjercito(juego.getEjercito2());
                }
                case 8 -> juego.determinarGanador();
                case 9 -> continuar = false;
                default -> System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }
}
