package controller;

import model.Cliente;
import model.Despachador;
import model.Jugador;
import model.LeerMatriz;
import javax.swing.*;
import view.VentanaNivel1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;


public class Controlador implements KeyListener
{
    VentanaNivel1 vista;
    public HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";
    public Despachador despachador;
    private String colorball;
    public LeerMatriz lab = new LeerMatriz();
    public Jugador j;

    public Controlador(VentanaNivel1 v, String colorbolita)
    {
        colorball = colorbolita;
        vista = v;
        vista.getLienzo().setJugadores( jugadores );
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        lab.lectura();
        int [][] laberinto = lab.getMatriz();
        int x_ = jugadores.get(jugadorPresente).getX();
        int y_ = jugadores.get(jugadorPresente).getY();
       
        if(e.getKeyCode()==37){
            if(laberinto[y_/15][(x_/15)-1]!=1) {
                jugadores.get(jugadorPresente).moverX(-15);
            }
        }   
            
        if(e.getKeyCode()==39){
            if(laberinto[y_/15][(x_/15)+1]!=1) {
                jugadores.get(jugadorPresente).moverX(+15);
            }
        }

        if(e.getKeyCode()==40) {
            if (laberinto[(y_/15)+1][x_/15]!=1) {
                jugadores.get(jugadorPresente).moverY(+15);
            }
        }
        if(e.getKeyCode()==38) {
            if(laberinto[(y_/15)-1][x_/15]!=1) {
                jugadores.get(jugadorPresente).moverY(-15);
            }
        }

        int _x = jugadores.get(jugadorPresente).getX();
        int _y = jugadores.get(jugadorPresente).getY();
        despachador.send("mover:"+jugadorPresente+","+_x+","+_y );
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }

    private void ingresar(){
        String color = colorball;
        despachador.send("login:"+color);
        jugadorPresente = color;
    }

    public void conectar()
    {
        Cliente conexion = new Cliente("localhost", 1234);
        try {
            despachador = conexion.conectar(vista);

            if (despachador != null) {
                ingresar();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        }
    }


}