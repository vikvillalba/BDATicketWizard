package itson.ticketwizard;

import itson.ticketwizard.control.ControlActualizarPerfil;
import itson.ticketwizard.control.ControlDepositarSaldo;
import itson.ticketwizard.control.ControlIniciarSesion;
import itson.ticketwizard.control.ControlMenuPrincipal;
import itson.ticketwizard.control.ControlRegistrarCompra;
import itson.ticketwizard.control.ControlRegistrarReventa;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.DepositosDAO;
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
        BoletosDAO boletosDAO = new BoletosDAO(manejadorConexiones);
        DepositosDAO depositosDAO = new DepositosDAO(manejadorConexiones);

        // clases de control
        ControlRegistrarCompra controlRegistrarCompra = new ControlRegistrarCompra(boletosDAO);
        ControlActualizarPerfil controlActualizarPerfil = new ControlActualizarPerfil(usuariosDAO, direccionesDAO);
        ControlIniciarSesion control = new ControlIniciarSesion(usuariosDAO, direccionesDAO);
        ControlRegistrarReventa controlRegistrarReventa = new ControlRegistrarReventa(boletosDAO);
        ControlDepositarSaldo controlDepositoSaldo = new ControlDepositarSaldo(depositosDAO);
        

        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(control, controlActualizarPerfil, controlRegistrarCompra, controlRegistrarReventa, controlDepositoSaldo);
        control.setControlMenuPrincipal(controlMenuPrincipal);
  
        control.iniciar();

    }
}
