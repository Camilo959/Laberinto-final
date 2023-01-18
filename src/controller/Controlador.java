package controller;

import model.Cliente;
import model.Despachador;
import model.Jugador;
import model.LeerMatriz;
import model.Servidor;

import javax.swing.*;
import view.VentanaNivel1;
import view.VentanaPrincipal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Clase que se encarga de administrar la vista y el modelo.
 */

public class Controlador implements KeyListener {
    private VentanaNivel1 vistaNivel;
    private String colorball;
    private String nameJugador;
    public HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";
    public Despachador despachador;
    public LeerMatriz lab;
    public Jugador j;

    public Controlador(VentanaNivel1 v, String colorbolita, String nomJugador) {
        colorball = colorbolita;
        vistaNivel = v;
        nameJugador = nomJugador;
        vistaNivel.getLienzo().setJugadores(jugadores);
        obtenerMatriz();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int[][] laberinto = lab.getMatriz();
        int x_ = jugadores.get(jugadorPresente).getX();
        int y_ = jugadores.get(jugadorPresente).getY();

        if (e.getKeyCode() == 37) {
            if (laberinto[y_ / 12][(x_ / 12) - 1] != 1) {
                jugadores.get(jugadorPresente).moverX(-12);
            }
        }

        if (e.getKeyCode() == 39) {
            if (laberinto[y_ / 12][(x_ / 12) + 1] != 1) {
                jugadores.get(jugadorPresente).moverX(+12);
            }
        }

        if (e.getKeyCode() == 40) {
            if (laberinto[(y_ / 12) + 1][x_ / 12] != 1) {
                jugadores.get(jugadorPresente).moverY(+12);
            }
        }
        if (e.getKeyCode() == 38) {
            if (laberinto[(y_ / 12) - 1][x_ / 12] != 1) {
                jugadores.get(jugadorPresente).moverY(-12);
            }
        }

        int _x = jugadores.get(jugadorPresente).getX();
        int _y = jugadores.get(jugadorPresente).getY();

        if (_x == 948 && _y == 600) {
            JOptionPane.showMessageDialog(vistaNivel, "Felicidades " + nameJugador + " completaste el laberinto!");
            VentanaPrincipal.finJuego();
            Servidor.cerrarTodo();
        }

        despachador.send("mover:" + jugadorPresente + "," + _x + "," + _y);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    private void ingresar() {
        String color = colorball;
        despachador.send("login:" + color);
        jugadorPresente = color;
    }

    public void conectar() {
        Cliente conexion = new Cliente("localhost", 1234);
        try {
            despachador = conexion.conectar(vistaNivel);
            System.out.println("DESPACHADOR_ " + despachador);

            if (despachador != null) {
                ingresar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaNivel, "Error: " + e.getMessage());
        }
    }

    public void obtenerMatriz() {
        lab = new LeerMatriz();
        lab.lectura();
    }
}