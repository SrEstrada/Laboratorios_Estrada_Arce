public class MainReferencia {
	public static void main(String[] args) {
		VideoJuegoReferencia videoJuego = new VideoJuegoReferencia(10, 10);
		System.out.println("Tablero inicial:");
		videoJuego.mostrarTablero();
		System.out.println("\nSoldado con mayor vida del Ejército 1:");
		Soldado mayorVidaEj1 = videoJuego.soldadoMayorVida(videoJuego.getEjercito1());
		System.out.println(mayorVidaEj1);
		System.out.println("\nSoldado con mayor vida del Ejército 2:");
		Soldado mayorVidaEj2 = videoJuego.soldadoMayorVida(videoJuego.getEjercito2());
		System.out.println(mayorVidaEj2);
		System.out.println("\nPromedio de vida del Ejército 1: " + videoJuego.promedioVida(videoJuego.getEjercito1()));
		System.out.println("Promedio de vida del Ejército 2: " + videoJuego.promedioVida(videoJuego.getEjercito2()));
		System.out.println("\nSoldados del Ejército 1 en el orden de creación:");
		videoJuego.mostrarSoldadosPorEjercito(videoJuego.getEjercito1());
		System.out.println("\nSoldados del Ejército 2 en el orden de creación:");
		videoJuego.mostrarSoldadosPorEjercito(videoJuego.getEjercito2());
		System.out.println("\nRanking de poder del Ejército 1 (Burbuja):");
		videoJuego.rankingSoldadosBurbuja(videoJuego.getEjercito1());
        System.out.println("\nRanking de poder del Ejército 2 (Burbuja):");
        videoJuego.rankingSoldadosBurbuja(videoJuego.getEjercito2());
        System.out.println("\nRanking de poder del Ejército 1 (Quicksort):");
        videoJuego.rankingSoldadosQuicksort(videoJuego.getEjercito1(), 0, videoJuego.getEjercito1().size() - 1);
        videoJuego.mostrarSoldadosPorEjercito(videoJuego.getEjercito1());
        System.out.println("\nRanking de poder del Ejército 2 (Quicksort):");
        videoJuego.rankingSoldadosQuicksort(videoJuego.getEjercito2(), 0, videoJuego.getEjercito2().size() - 1);
        videoJuego.mostrarSoldadosPorEjercito(videoJuego.getEjercito2());
        videoJuego.determinarGanador();    
	}
}

