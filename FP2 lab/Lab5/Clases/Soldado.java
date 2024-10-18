package ejercicios;
public class Soldado {
    private String nombre;
    private int vida;
    private int fila;
    private int columna;

    // Constructor
    public Soldado(String nombre, int vida, int fila, int columna) {
        this.nombre = nombre;
        this.vida = vida;
        this.fila = fila;
        this.columna = columna;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    // Setters (si es necesario modificar alguna propiedad del soldado)
    public void setVida(int vida) {
        this.vida = vida;
    }

    // Método toString para mostrar la información del soldado
    @Override
    public String toString() {
        return "Soldado{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", posición=(" + fila + ", " + columna + ")" +
                '}';
    }
}
