import view.VentanaPrincipal;

/**
 * clase ejecutable para el cliente.
 * Muestra una interface grafica de usuario
 */
public class MainCliente {
    public static int ju = 0;
    public static void main(String[] args) {
        // Vista
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        ju+=1;
        System.out.println(ju);
    }
}