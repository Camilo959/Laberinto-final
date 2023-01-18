package model;

import view.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que extiende de la clase Thread 
 * y seencarca de enviar y administrar a los jugadores.
 */

public class Despachador extends Thread {

    private PrintWriter out;
    private BufferedReader in;
    public VentanaNivel1 gui = null;
    public ArrayList<Despachador> escritores = new ArrayList<>();
    public HashMap<String, Jugador> jugadores = new HashMap<>();

    /**
     * Método constructor para iniciarlizar
     * el BufferedReader y el PrintWriter.
     * @param socket
     */
    public Despachador(Socket socket) {
        try {
            this.in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método run que ejecuta el hilo.
     */
    public void run(){
        try {
            leer();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para procesar la entrada de los 
     * jugadores.
     * @throws IOException
     */
    private void leer() throws IOException  {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Recibido: " + inputLine);

            if (gui != null) {  // Cliente
                procesarCliente(inputLine);
            } else {            // Servidor
                procesarServidor(inputLine);
            }
        }
    }

    /**
     * Método que recolecta la información del jugador
     * para crear un nuevo objeto de tipo Jugador para 
     * añadirlo al HashMap de la ventana del juego.
     * @param entrada
     */
    public void procesarCliente(String entrada)
    {
        String[] datosJugadores = entrada.split("#");
        for (String jugador: datosJugadores) {
            System.out.println("leyendo jugador: " + jugador);
            String[] data = jugador.split(",");

            gui.getLienzo().getJugadores().put(data[0] ,
                                     new Jugador(data[0],
                                                getColor(data[0]),
                                                Integer.parseInt(data[1]),
                                                Integer.parseInt(data[2])
                                               )
                                    );
        }
        gui.getLienzo().repaint();
    }

    /**
     * Método para obtener el color elegido por el 
     * jugador en la ventana principal.
     * @param colorBola
     * @return objeto de tipo Color
     */
    public static Color getColor(String colorBola)
    {
        HashMap<String, Color> colores = new HashMap<>();
        colores.put( "Rojo", Color.RED);
        colores.put( "Verde", Color.GREEN);
        colores.put( "Azul", Color.BLUE);
        colores.put( "Amarillo", Color.yellow);
        colores.put( "Magenta", Color.MAGENTA);
        colores.put("Aguamarina", new Color(128, 255, 219));
        colores.put("Rosa", new Color(239, 39, 222, 255));
        colores.put("Café", new Color(81, 60, 44));

        Color c = colores.get(colorBola);

        return c;
    }

    /**
     * Método que crea una lista de cadenas con la información de todos 
     * los jugadores en el HashMap de "jugadores" y la envía a todos los
     * objetos "Despachador" en la lista "escritores".
     * @param entrada
     */
    public void procesarServidor(String entrada)
    {
        String[] datos = entrada.split(":");
        if (datos[0].equals("login")) {
            jugadores.put(datos[1] , new Jugador(datos[1], null, 12, 12)); // 948, 564
            System.out.println(jugadores.size());
        } else if (datos[0].equals("mover")) {
            String[] datosJugador = datos[1].split(",");
            jugadores.get(datosJugador[0]).setX(Integer.parseInt(datosJugador[1]));
            jugadores.get(datosJugador[0]).setY(Integer.parseInt(datosJugador[2]));
        }

        String[] lista = new String[jugadores.size()];

        int index = 0;
        for (Jugador e: jugadores.values()) {
            lista[index++] = e.getNickname() + "," + e.getX() + "," + e.getY();
        }

        for (Despachador e: escritores) {
            e.send(String.join("#", lista));
            System.out.println("Jugadores: " + e);
        }

        Almacen.escribir(jugadores);
    }

    /**
     * Método para mostrar la información del jugador por consola.
     * @param inputLine
     */
    public void send(String inputLine)
    {
        try {
            System.out.println("Enviando: " + inputLine);
            out.println(inputLine);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}