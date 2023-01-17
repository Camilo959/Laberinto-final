package view;

import javax.swing.*;
import java.awt.*;

public class VentanaNivel1 extends JFrame {
    public Container panel;
    public Tablero lienzo;
   
    public VentanaNivel1(String nombreJugador) {
        super("Laberinto - Jugador: " + nombreJugador);
        setSize(976, 656);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = getContentPane();
        panel.requestFocus();
        setAutoRequestFocus(true);
        panel.setLayout((new FlowLayout()));
        
        lienzo = new Tablero();
        panel.add(lienzo);
    }

    public Tablero getLienzo(){
        return lienzo; 
    }

}