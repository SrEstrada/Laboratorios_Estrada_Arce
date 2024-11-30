import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al Videojuego de Batallas!");
        System.out.print("Introduce el número de filas del tablero: ");
        int filas = scanner.nextInt();
        System.out.print("Introduce el número de columnas del tablero: ");
        int columnas = scanner.nextInt();

        VideoJuego juego = new VideoJuego(filas, columnas);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Mostrar Tablero");
            System.out.println("2. Mostrar soldados del Ejército 1");
            System.out.println("3. Mostrar soldados del Ejército 2");
            System.out.println("4. Mostrar promedio de vida del Ejército 1");
            System.out.println("5. Mostrar promedio de vida del Ejército 2");
            System.out.println("6. Ranking (Burbuja) del Ejército 1");
            System.out.println("7. Ranking (Quicksort) del Ejército 2");
            System.out.println("8. Determinar ganador");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    juego.mostrarTablero();
                    break;
                case 2:
                    juego.mostrarSoldadosPorEjercito(juego.getEjercito1());
                    break;
                case 3:
                    juego.mostrarSoldadosPorEjercito(juego.getEjercito2());
                    break;
                case 4:
                    System.out.println("Promedio de vida del Ejército 1: " +
                            juego.promedioVida(juego.getEjercito1()));
                    break;
                case 5:
                    System.out.println("Promedio de vida del Ejército 2: " +
                            juego.promedioVida(juego.getEjercito2()));
                    break;
                case 6:
                    juego.rankingSoldadosBurbuja(juego.getEjercito1());
                    break;
                case 7:
                    juego.rankingSoldadosQuicksort(juego.getEjercito2());
                    break;
                case 8:
                    juego.determinarGanador();
                    break;
                case 9:
                    continuar = false;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
