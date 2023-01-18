/**
 * Clase que se encarga de manejar un servidor multiusuario.
 */

package model;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Servidor
{
    // Variable que almacena el numero del puerto en el que se ejecutara el servidor.
    private int portNumber;
    // Estructuras de datos para guardar los jugadores y los escritores.
    private ArrayList<Despachador> escritores = new ArrayList<>();
    private HashMap<String, Jugador> jugadores = new HashMap<>();

    /**
     * Constructor encargado de inicializar el numero del puerto
     * @param portNumber
     */
    public Servidor(int portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * Método que crea un objeto "ServerSocket" en el puerto especificado 
     * y entra en un bucle infinito para aceptar conexiones entrantes.
     * @throws IOException
     */
    public void conectar() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true)
        {
            /*
             * Cada vez que se acepta una conexión, se crea un nuevo objeto 
             * "Despachador" con el socket del cliente y se agrega a la lista 
             * "escritores". Se asignan las listas "escritores" y "jugadores" 
             * al objeto "Despachador" y se inicia su hilo.
             */
            Socket clientSocket = serverSocket.accept();

            Despachador lector = new Despachador(clientSocket);
            escritores.add(lector);
            lector.escritores = escritores;
            lector.jugadores = jugadores;
            lector.start();
        }
        //serverSocket.close();
    }

    /**
     * El método "cerrarTodo()" estático se utiliza 
     * para cerrar el servidor y todos los clientes conectados.
     */
    public static void cerrarTodo() {
        System.exit(0);
    }
}