package view;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que extiende de JFrame y se encarga de crear la ventana del nivel 1 del juego.
 */
public class VentanaNivel1 extends JFrame {
    //Variable de instancia para el panel de contenido de la ventana
    public Container panel;
    //Variable de instancia para el Tablero
    public Tablero lienzo;
   
    /**
     * Constructor de la clase que recibe el nombre del jugador
     * @param nombreJugador nombre del jugador
     */
    public VentanaNivel1(String nombreJugador) {
        //Establecemos el título de la ventana con el nombre del jugador
        super("Laberinto - Jugador: " + nombreJugador);
        //Establecemos el tamaño de la ventana
        setSize(976, 656);
        //Establecemos la operación al cerrar la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Establecemos la posición de la ventana en la pantalla
        setLocationRelativeTo(null);
        // Establecemos si se puede o no redimensionar la ventana
        setResizable(false);

        //Establecemos el panel de contenido de la ventana
        panel = getContentPane();
        //Solicitamos el foco en el panel
        panel.requestFocus();
        //Habilitamos la solicitud automática de foco en el panel
        setAutoRequestFocus(true);
        //Establecemos el layout del panel
        panel.setLayout((new FlowLayout()));
        
        //Creamos una nueva instancia de Tablero
        lienzo = new Tablero();
        //Agregamos el tablero al panel
        panel.add(lienzo);
    }

    /**
     * Método que devuelve el objeto de tipo Tablero
     * @return objeto de tipo Tablero
     */
    public Tablero getLienzo(){
        return lienzo; 
    }

}