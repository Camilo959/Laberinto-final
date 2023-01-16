package view;

import model.Jugador;
import model.LeerMatriz;
import java.awt.*;
import java.util.HashMap;

public class Tablero extends Canvas {
    public LeerMatriz datosMatriz;
    private Laberinto lab;
    private Color colorLaberinto;
    private HashMap<String, Jugador> jugadores = new HashMap<>();
    private final int alto = 15;
    private final int ancho = 15;

    public Tablero()
    {
        super();
        setBackground(Color.white);
        setBackground(new Color(200,200,200));
        setSize(1215, 800);
        datosMatriz = new LeerMatriz();
        datosMatriz.lectura();
        colorLaberinto = new Color(56,61,59);
        lab = new Laberinto(datosMatriz.getFilas(),datosMatriz.getColumnas(),alto,ancho,datosMatriz.getMatriz(),colorLaberinto);

   }

    public void paint(Graphics g) {
        for (Jugador j: jugadores.values()) {
            g.setColor(j.getLogin());
            g.fillOval(j.getX(), j.getY(), 15, 15);
            lab.paint(g);
        }
    }

    public void setJugadores(HashMap<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }

    public Laberinto getLaberinto(){
        return lab;
    }
}