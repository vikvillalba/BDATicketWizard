package itson.ticketwizard;

import itson.ticketwizard.control.ControlActualizarPerfil;
import itson.ticketwizard.control.ControlDepositarSaldo;
import itson.ticketwizard.control.ControlIniciarSesion;
import itson.ticketwizard.control.ControlMenuPrincipal;
import itson.ticketwizard.control.ControlRegistrarCompra;
import itson.ticketwizard.control.ControlRegistrarReventa;
import itson.ticketwizard.control.ControlResultadosBusqueda;
import itson.ticketwizard.persistencia.BoletosApartadosDAO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.ComprasDAO;
import itson.ticketwizard.persistencia.DepositosDAO;
import itson.ticketwizard.persistencia.ManejadorConexiones;
import itson.ticketwizard.persistencia.ReventasDAO;
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
        
        // clases DAO
        UsuariosDAO usuariosDAO = new UsuariosDAO(manejadorConexiones);
        BoletosDAO boletosDAO = new BoletosDAO(manejadorConexiones);
        DepositosDAO depositosDAO = new DepositosDAO(manejadorConexiones);
        ComprasDAO comprasDAO = new ComprasDAO(manejadorConexiones);
        ReventasDAO reventasDAO = new ReventasDAO(manejadorConexiones);
        BoletosApartadosDAO boletosApartadosDAO = new BoletosApartadosDAO(manejadorConexiones);

        // clases de control
        ControlRegistrarCompra controlRegistrarCompra = new ControlRegistrarCompra(boletosDAO, comprasDAO, usuariosDAO, boletosApartadosDAO);
        ControlActualizarPerfil controlActualizarPerfil = new ControlActualizarPerfil(usuariosDAO);
        ControlIniciarSesion control = new ControlIniciarSesion(usuariosDAO);
        ControlResultadosBusqueda controlResultadosBusqueda = new ControlResultadosBusqueda(boletosDAO, controlRegistrarCompra);
        ControlDepositarSaldo controlDepositoSaldo = new ControlDepositarSaldo(depositosDAO);
        ControlRegistrarReventa controlRegistrarReventa = new ControlRegistrarReventa(boletosDAO, reventasDAO);

        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(control, controlActualizarPerfil, controlRegistrarCompra, controlRegistrarReventa, controlDepositoSaldo,controlResultadosBusqueda);
        control.setControlMenuPrincipal(controlMenuPrincipal);
  
        control.iniciar();
    
    }
}
