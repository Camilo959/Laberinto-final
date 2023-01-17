/**
* Clase MainCliente encargada de iniciar el programa cliente
* y mostrar la ventana principal de la interfaz gráfica.
*/

import view.VentanaPrincipal;

public class MainCliente {
    /**
    * Método main encargado de iniciar el programa cliente
    * @param args no se utilizan en este caso.
    */
    public static void main(String[] args) {
        // Vista
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}