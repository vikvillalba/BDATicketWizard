package itson.ticketwizard;

import itson.ticketwizard.control.ControlIniciarSesion;

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
        ControlIniciarSesion control = new ControlIniciarSesion();
        control.iniciarSesion();

    }
}
