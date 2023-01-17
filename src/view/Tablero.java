package view;

import model.Jugador;
import model.LeerMatriz;
import java.awt.*;
import java.util.HashMap;

public class Tablero extends Canvas {

    private Laberinto lab;
    private Color colorLaberinto;
    private HashMap<String, Jugador> jugadores = new HashMap<>();
    private final int alto = 12;
    private final int ancho = 12;
    public LeerMatriz datosMatriz;
    public static int cantJugadores;

    public Tablero() {
        super();
        setBackground(Color.white);
        setBackground(new Color(200, 200, 200));
        setSize(976, 656); 
        configLab();
    }

    public void paint(Graphics g) {
        for (Jugador j : jugadores.values()) {
            g.setColor(j.getLogin());
            g.fillOval(j.getX(), j.getY(), 12, 12);
            lab.paint(g);
        }
    }

    public void setJugadores(HashMap<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public HashMap<String, Jugador> getJugadores() {     
        setcantJugadores(jugadores.size());
        System.out.println("jugadores      : " + jugadores.size());
        return jugadores;
    }

    public void configLab() {
        datosMatriz = new LeerMatriz();
        datosMatriz.lectura();
        colorLaberinto = new Color(56, 61, 59);
        lab = new Laberinto(datosMatriz.getFilas(), datosMatriz.getColumnas(), alto, ancho, datosMatriz.getMatriz(),
                colorLaberinto);
    }

    public Laberinto getLaberinto() {
        return lab;
    }

    public static int getcantJugadores() {
        return cantJugadores;
    }

    public static void setcantJugadores(int numJugadores) {
        cantJugadores = numJugadores;
    }
}