package view;
import java.awt.*;

/**
 * Clase que se encarga de pintar las paredes del laberinto 
 * por medio de una matriz
 */

public class Laberinto {
    // Variables de instancia para la fila y columna actual
    private int fila = 0;
    private int columna = 0;
    // Variables de instancia para el tamaño del laberinto
    private int nFilas, nColumnas, altoB, anchoB;
    // Matriz para almacenar el laberinto
    private int[][] mapa;
    // Color para pintar las paredes
    private Color colorlab;

    /**
    *  Constructor para inicializar las variables de instancia
    *  @param Nfila nColumnas altoB anchoB mapa colorlaberinto
    */
    public Laberinto(int Nfila, int nColumnas, int altoB, int anchoB, int[][] mapa,Color colorLaberinto) {
        this.altoB = altoB;
        this.anchoB = anchoB;
        this.mapa = mapa;
        this.nColumnas = nColumnas;
        this.nFilas = Nfila;
        this.colorlab = colorLaberinto;
    }

    /**
     * Método para pintar el laberinto en un objeto Graphics
     * @param g Objeto Graphics que permite dibujar en el panel
     */

    public void paint(Graphics g) {
        int[][] laberinto = obtenerLaberinto();

        // Recorre las filas y columnas de la matriz
        for(fila = 0; fila < nFilas; fila++){
            for(columna = 0; columna < nColumnas; columna++) {
                // Si el valor en la matriz es 1, se pinta un rectángulo en esa posición
                if(laberinto[fila][columna] == 1){ 
                    g.setColor(colorlab);
                    g.fillRect(columna*anchoB, fila*altoB, anchoB, altoB);
                }
            }
        }
    }

    /**
     * Método para obtener la matriz del laberinto
     * @param
     * @return variable de tipo arreglo
     */
    public int[][] obtenerLaberinto(){
        return mapa;
    }
}