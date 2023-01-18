package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que lee la matriz de un .txt y la guarda en un 
 * arreglo de tipo entero.
 */

public class LeerMatriz {
    // Variable de informacion de la matriz.
    private int[][] matriz;
    private int filas;
    private int columnas;

    /**
     * Método encargado de leer la matriz de un .txt,
     */
    public void lectura() {
        try {
            Scanner sc = new Scanner(new File("src/matrix.txt"));

            List<String[]> lines = new ArrayList<>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine().split(","));
            }

            filas = lines.size();
            columnas = lines.get(0).length;
            matriz = new int[filas][columnas];

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = Integer.parseInt(lines.get(i)[j]);
                }
            }

            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Método get de la matriz.
     * @return matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
     * Método get de las filas de la matriz.
     * @return variable de tipo entero
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Método get de las columnas de la matriz.
     * @return variable de tipo entero
     */
    public int getColumnas() {
        return columnas;
    }
}
