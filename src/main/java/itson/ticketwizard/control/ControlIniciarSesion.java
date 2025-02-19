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

    public ControlIniciarSesion(UsuariosDAO usuariosDAO, DireccionesDAO direccionesDAO) {
        this.usuariosDAO = usuariosDAO;
        this.direccionesDAO = direccionesDAO;
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
    
    public void iniciarSesion(UsuarioRegistradoDTO usuarioRegistradoDTO){
        List<UsuarioRegistradoDTO> cuentasExistentes = this.usuariosDAO.ObtenerCuentasExistentes();
        
        for(int i = 0; i<cuentasExistentes.size(); i++){
            if(cuentasExistentes.get(i).getUsuario().equals(usuarioRegistradoDTO.getUsuario())){
                System.out.println("si");
                this.mostrarMensajeInicioSesionExitoso();
                
                this.menuPrincipal = new FrmMenuPrincipal();
                this.menuPrincipal.setVisible(true);
                this.inicioSesion.dispose();
                return;
            }
            else{
                System.out.println("no");
                this.mostrarMensajeUsuarioNoExiste();
            }
        }
    }
    
    private void mostrarMensajeInicioSesionExitoso(){
        JOptionPane.showMessageDialog(inicioSesion, "Se inició sesión correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensajeUsuarioNoExiste(){
        JOptionPane.showMessageDialog(inicioSesion, "El usuario no existe. Intente nuevamente o cree una cuenta.", "Información", JOptionPane.ERROR_MESSAGE);
    }
}

