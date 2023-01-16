import model.Servidor;

public class MainServidor
{
    public static void main(String[] args) {
        final int portNumber = 1234;
        final int maxJugadores = 6;
        try {
            Servidor servidor = new Servidor(portNumber, maxJugadores);
            servidor.conectar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
