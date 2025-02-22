package itson.ticketwizard;

import itson.ticketwizard.control.ControlActualizarPerfil;
import itson.ticketwizard.control.ControlBoletosUsuario;
import itson.ticketwizard.control.ControlDepositarSaldo;
import itson.ticketwizard.control.ControlIniciarSesion;
import itson.ticketwizard.control.ControlMenuPrincipal;
import itson.ticketwizard.control.ControlRegistrarCompra;
import itson.ticketwizard.control.ControlRegistrarReventa;
import itson.ticketwizard.control.ControlResultadosBusqueda;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.ComprasDAO;
import itson.ticketwizard.persistencia.DepositosDAO;
import itson.ticketwizard.persistencia.DireccionesDAO;
import itson.ticketwizard.persistencia.ManejadorConexiones;
import itson.ticketwizard.persistencia.UsuariosDAO;
import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

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
        DireccionesDAO direccionesDAO = new DireccionesDAO(manejadorConexiones);
        BoletosDAO boletosDAO = new BoletosDAO(manejadorConexiones);
        DepositosDAO depositosDAO = new DepositosDAO(manejadorConexiones);
        ComprasDAO comprasDAO = new ComprasDAO(manejadorConexiones);

        // clases de control
        ControlRegistrarCompra controlRegistrarCompra = new ControlRegistrarCompra(boletosDAO, comprasDAO, usuariosDAO);
        ControlActualizarPerfil controlActualizarPerfil = new ControlActualizarPerfil(usuariosDAO, direccionesDAO);
        ControlIniciarSesion control = new ControlIniciarSesion(usuariosDAO, direccionesDAO);
        ControlRegistrarReventa controlRegistrarReventa = new ControlRegistrarReventa(boletosDAO);
        ControlResultadosBusqueda controlResultadosBusqueda = new ControlResultadosBusqueda(boletosDAO, controlRegistrarCompra);
        ControlDepositarSaldo controlDepositoSaldo = new ControlDepositarSaldo(depositosDAO);
        ControlBoletosUsuario controlBoletosUsuario = new ControlBoletosUsuario(boletosDAO, controlRegistrarReventa);

        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(control, controlActualizarPerfil, controlRegistrarCompra, controlRegistrarReventa, controlDepositoSaldo,controlResultadosBusqueda, controlBoletosUsuario);
        control.setControlMenuPrincipal(controlMenuPrincipal);
  
        control.iniciar();
    
    }
}
