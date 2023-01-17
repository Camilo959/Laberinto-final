package view;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que extiende de JPanel y se encarga de dibujar una imagen de fondo en el panel.
 */
public class Fondo extends JPanel {
    //Variable de instancia para almacenar la imagen de fondo
    private ImageIcon imgFondo;

    /**
     * Método sobreescrito de JPanel que se encarga de dibujar la imagen de fondo en el panel.
     * @param g Objeto Graphics que permite dibujar en el panel
     */
    @Override
    public void paint(Graphics g) {
        //Obtenemos el tamaño del panel
        Dimension tamano = getSize();

        //Cargamos la imagen de fondo
        imgFondo = new ImageIcon(((getClass().getResource("img/fondo.png"))));

        //Dibujamos la imagen en el panel, utilizando las coordenadas (0,0) y el tamaño del panel como tamaño de la imagen
        g.drawImage(imgFondo.getImage(),0,0,tamano.width,tamano.height,null);
        
        // Establecemos la propiedad "opaque" del panel en false para garantizar que la imagen de fondo se vea correctamente
        setOpaque(false);
        
        // Llamamos al método "paint()" de la clase padre (JPanel) para continuar con el proceso de pintado
        super.paint(g);
    }
}