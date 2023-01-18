package model;

import java.io.*;
import java.util.HashMap;

/**
 * Clase: Representa un objeto que se encarga
 * de la persistencia de datos. (Almacen de datos)
 * Implementa el patron Singleton (Solitario)
 */
public final class Almacen {
    // Varible de instancia de tipo objeto Almacen.
    private Almacen instancia;

    /**
     * Método constructor.
     */
    private Almacen(){}

    /**
     * Método que retorna la instancia del objeto de tipo Almacen.
     * @return Objeto de tipo Almacen.
     */
    public Almacen getInstancia(){
        if (instancia == null) {
            instancia = new Almacen();
        }
        return instancia;
    }

    /**
     * Método que se encarga de leer el contenido de un .txt para traer
     * las coordenadas del jugador
     * @return objeto de tipo HashMap
     */
    public HashMap<String, Jugador> leer(){
        HashMap<String, Jugador> jugadores = new HashMap<>();

        try {
            BufferedReader lector = new BufferedReader(
                                        new FileReader("datos_bolas.txt"));

            String linea;
            while ((linea = lector.readLine()) != null) {
                String datos[] = linea.split(":");
                jugadores.put(datos[0] ,
                        new Jugador(datos[0],
                                Despachador.getColor(datos[0]),
                                Integer.parseInt(datos[1]),
                                Integer.parseInt(datos[2])
                        )
                );
            }

            lector.close();
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return jugadores;
    }

    /**
     * Método para guardar las coordenadas de los jugadores en un .txt.
     * @param jugadores
     */
    public static void escribir(HashMap<String, Jugador> jugadores){

        try {
            PrintWriter escritor = new PrintWriter(new FileWriter("datos_bolas.txt"));

            for (Jugador j : jugadores.values()) {
                escritor.println(j.getNickname() + ":" + j.getX() + ":" + j.getY());
            }

            escritor.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


