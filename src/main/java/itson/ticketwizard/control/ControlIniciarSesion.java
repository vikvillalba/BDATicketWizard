package itson.ticketwizard.control;

import itson.ticketwizard.dtos.NuevoDomicilioUsuarioDTO;
import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.DomicilioUsuario;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.DireccionesDAO;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.presentacion.FrmCrearCuenta;
import itson.ticketwizard.presentacion.FrmInicioSesion;
import itson.ticketwizard.presentacion.FrmMenuPrincipal;
import java.util.List;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

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
    private FrmMenuPrincipal menuPrincipal;
    private UsuariosDAO usuariosDAO;
    private DireccionesDAO direccionesDAO;
    
    private ControlMenuPrincipal controlMenuPrincipal;

    public ControlIniciarSesion(UsuariosDAO usuariosDAO, DireccionesDAO direccionesDAO) {
        this.usuariosDAO = usuariosDAO;
        this.direccionesDAO = direccionesDAO;
    }

    public void setControlMenuPrincipal(ControlMenuPrincipal controlMenuPrincipal) {
        this.controlMenuPrincipal = controlMenuPrincipal;
    }


    public void iniciar() {
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
    
    public void iniciarSesion(UsuarioRegistradoDTO usuarioRegistradoDTO) {
        List<UsuarioRegistradoDTO> cuentasExistentes = this.usuariosDAO.ObtenerCuentasExistentes();

        for (int i = 0; i < cuentasExistentes.size(); i++) {
            if (cuentasExistentes.get(i).getUsuario().equals(usuarioRegistradoDTO.getUsuario())) {
                if (BCrypt.checkpw(usuarioRegistradoDTO.getContrasenia(), cuentasExistentes.get(i).getContrasenia())) {

                    System.out.println("si");
                    this.mostrarMensajeInicioSesionExitoso();
                    controlMenuPrincipal.mostrarMenuPrincipal();
                    this.inicioSesion.dispose();
                    return;
                }

            } else {
                System.out.println("no");
                this.mostrarMensajeUsuarioNoExiste();
            }
        }
    }

    private void mostrarMensajeInicioSesionExitoso(){
        JOptionPane.showMessageDialog(inicioSesion, "Se inició sesión correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensajeUsuarioNoExiste(){
        JOptionPane.showMessageDialog(inicioSesion, "El usuario no existe. Intente nuevamente o cree una cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

