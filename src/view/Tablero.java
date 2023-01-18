package view;

import model.Jugador;
import model.LeerMatriz;
import java.awt.*;
import java.util.HashMap;

/**
 * Clase que se encarga de crear el tablero del juego
 */
public class Tablero extends Canvas {

    // Variables de instancia para el laberinto y el color del mismo
    private Laberinto lab;
    private Color colorLaberinto;
    // Mapa de jugadores
    private HashMap<String, Jugador> jugadores = new HashMap<>();
    // Variables para el tamaño de cada casilla del tablero
    private final int alto = 12;
    private final int ancho = 12;
    // Clase para leer la matriz del laberinto
    public LeerMatriz datosMatriz;
    // Contador para el numero de jugadores
    public static int cantJugadores;

    /**
     * Constructor que inicializa el tablero
     * @param no recibe en este caso
     */
    public Tablero() {
        super();
        setBackground(Color.white);
        setBackground(new Color(200, 200, 200));
        setSize(976, 656); 
        configLab();
    }

    /**
     * Método para pintar el tablero
     * @param g 
     */
    public void paint(Graphics g) {
        // Recorre el mapa de jugadores y pinta cada jugador
        for (Jugador j : jugadores.values()) {
            g.setColor(j.getLogin());
            g.fillOval(j.getX(), j.getY(), 12, 12);
            // Llamada al método paint del objeto laberinto
            lab.paint(g);
        }
    }

    // Métodos set y get para el mapa de jugadores
    public void setJugadores(HashMap<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public HashMap<String, Jugador> getJugadores() {     
        setcantJugadores(jugadores.size());
        return jugadores;
    }

    // Método para configurar el laberinto
    public void configLab() {
        datosMatriz = new LeerMatriz();
        datosMatriz.lectura();
        colorLaberinto = new Color(56, 61, 59);
        lab = new Laberinto(datosMatriz.getFilas(), datosMatriz.getColumnas(), alto, ancho, datosMatriz.getMatriz(),
                colorLaberinto);
    }

    /**
     * Método para obtener el objeto laberinto
     * @param no en este caso
     * @return lab objeto de tipo Laberinto
     */
    public Laberinto getLaberinto() {
        return lab;
    }

    /**
     * Métodos set y get para el contador de jugadores
     */
    public static int getcantJugadores() {
        return cantJugadores;
    }

    public static void setcantJugadores(int numJugadores) {
        cantJugadores = numJugadores;
    }
}