/*
 * 
 * Clase que se encarga de manejar un servidor multiusuario.
 */

package model;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Servidor
{
    private int portNumber;
    private ArrayList<Despachador> escritores = new ArrayList<>();
    private HashMap<String, Jugador> jugadores = new HashMap<>();

    public Servidor(int portNumber) {
        this.portNumber = portNumber;
    }

    public void conectar() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true)
        {
            Socket clientSocket = serverSocket.accept();

            Despachador lector = new Despachador(clientSocket);
            escritores.add(lector);
            lector.escritores = escritores;
            lector.jugadores = jugadores;
            lector.start();
        }
        //serverSocket.close();
    }

    public static void cerrarTodo() {
        System.exit(0);
    }
}