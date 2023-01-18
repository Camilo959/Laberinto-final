package model;

import java.awt.*;

/**
 * Clase jugador.
 */

public class Jugador {

    // Variables de instancia para login nickname x y.
    private Color login;
    private String nickname;
    private int x;
    private int y;

    /**
     * Constructor para inicializar las variables de instancia.
     * @param n
     * @param l
     * @param x
     * @param y
     */
    public Jugador(String n, Color l, int x, int y)
    {
        nickname = n;
        login = l;
        this.x = x;
        this.y = y;
    }

    /**
     * Método para aumentar un h al x.
     * @param h
     */
    public void moverX(int h)
    {
        x += h;
    }

    /**
     * Método para aumentar un h al y.
     * @param h
     */
    public void moverY(int h)
    {
        y += h;
    }

    /**
     *  Métodos get y set del Login
     */
    /**
     * @return objeto de tipo color
     */
    public Color getLogin() {
        return login;
    }

    /**
     * @param login
     */
    public void setLogin(Color login) {
        this.login = login;
    }

    /**
     * Método get y set para el nickname.
     */
    /**
     * @return objeto de tipo String
     */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Método get y set para el x.
     */
    /**
     * @return variable de tipo entero
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Método get y set para el y.
     */
    /**
     * @return variable de tipo entero
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}