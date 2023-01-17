/**
 * Clase MainServidor encargada de iniciar el programa servidor
 * y establecer la conexión con los clientes
 */
import model.Servidor;

public class MainServidor {
    /**
     * Método main encargado de iniciar el programa servidor
     * y establecer la conexión con los clientes
     * @param args no se utilizan en este caso.
     */
    public static void main(String[] args) {
        final int portNumber = 1234;
        try {
            Servidor servidor = new Servidor(portNumber);
            servidor.conectar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
