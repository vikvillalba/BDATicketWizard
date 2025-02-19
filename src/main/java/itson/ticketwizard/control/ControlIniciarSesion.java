package itson.ticketwizard.control;

import itson.ticketwizard.dtos.NuevoDomicilioUsuarioDTO;
import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.entidades.DomicilioUsuario;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.DireccionesDAO;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.presentacion.FrmCrearCuenta;
import itson.ticketwizard.presentacion.FrmInicioSesion;
import javax.swing.JOptionPane;

/**
 * Controla el flujo para el caso de uso de inicio de sesión. Corresponde al inicio del sistema.
 *
 * @author victoria
 */
public class ControlIniciarSesion {

    /**
     * Contiene un formulario que corresponde al inicio de sesión.
     */
    private FrmInicioSesion inicioSesion;
    private FrmCrearCuenta crearCuenta;
    private UsuariosDAO usuariosDAO;
    private DireccionesDAO direccionesDAO;

    public ControlIniciarSesion(UsuariosDAO usuariosDAO, DireccionesDAO direccionesDAO) {
        this.usuariosDAO = usuariosDAO;
        this.direccionesDAO = direccionesDAO;
    }

    

    public void iniciarSesion() {
        this.inicioSesion = new FrmInicioSesion(this);
        this.inicioSesion.setVisible(true);

    }
    
    public void mostrarPantallaCrearCuenta(){
        this.crearCuenta = new FrmCrearCuenta(this);
        this.crearCuenta.setVisible(true);
    }

    // hacer algo para validar q la fecha no sea null.
    
    public void registrarUsuario(NuevoUsuarioDTO nuevoUsuarioDTO, NuevoDomicilioUsuarioDTO nuevoDomicilioDTO){
        Usuario usuario = this.usuariosDAO.registrarUsuario(nuevoUsuarioDTO);
        DomicilioUsuario domicilio = this.direccionesDAO.registrarDireccion(nuevoDomicilioDTO,usuario);
        this.mostrarMensajeUsuarioRegistrado();
        this.crearCuenta.dispose();
    }
    
    private void mostrarMensajeUsuarioRegistrado() {
        JOptionPane.showMessageDialog(crearCuenta, "Se registró el usuario correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

