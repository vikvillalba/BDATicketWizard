package itson.ticketwizard;

import itson.ticketwizard.control.ControlIniciarSesion;
import itson.ticketwizard.persistencia.DireccionesDAO;
import itson.ticketwizard.persistencia.ManejadorConexiones;
import itson.ticketwizard.persistencia.UsuariosDAO;

/**
 * Representa el flujo de la aplicación.
 *
 * @author victoria
 */
public class TicketWizard {

    /**
     * Método main. Inicializa una instancia del control para iniciar sesión, y ejecuta el método que contiene la lógica para iniciar con el sistema.
     */
    public static void main(String[] args) {
        ManejadorConexiones manejadorConexiones = new ManejadorConexiones();
        UsuariosDAO usuariosDAO = new UsuariosDAO(manejadorConexiones);
        DireccionesDAO direccionesDAO = new DireccionesDAO(manejadorConexiones);
        ControlIniciarSesion control = new ControlIniciarSesion(usuariosDAO, direccionesDAO);
        control.iniciarSesion();

    }
}
