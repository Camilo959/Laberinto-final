package model;

import view.VentanaNivel1;

import java.net.*;

/**
 *  Clase que se utiliza para conectarse a un servidor 
 *  especificado por un nombre de host y un número de puerto.
 */
public class Cliente {
    private String hostName;
    private int portNumber;

    /**
     * El constructor de la clase toma dos argumentos, 
     * "hostName" y "portNumber", y asigna estos valores a los 
     * atributos correspondientes
     * @param jugador
     */

    public Cliente(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }
    /**
     * Método para conectarse al servidor.
     * @param gui
     * @return Objeto de tipo Despachador
     * @throws Exception
     */
    public Despachador conectar(VentanaNivel1 gui) throws Exception {
        Socket kkSocket = new Socket(hostName, portNumber);
        Despachador lector = new Despachador(kkSocket);
        lector.gui = gui;
        lector.start();
        return lector;
    }
}