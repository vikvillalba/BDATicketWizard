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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void registrarUsuario(NuevoUsuarioDTO nuevoUsuarioDTO, NuevoDomicilioUsuarioDTO nuevoDomicilioDTO) {
        if (!validarApellidoPaterno(nuevoUsuarioDTO)
                || !validarApellidoMaterno(nuevoUsuarioDTO)
                || !validarNombre(nuevoUsuarioDTO)
                || !validarNombreUsuario(nuevoUsuarioDTO)
                || !validarContrasenia(nuevoUsuarioDTO)
                || !validarCorreoElectronico(nuevoUsuarioDTO)) {
            return;
        }
        Usuario usuario = this.usuariosDAO.registrarUsuario(nuevoUsuarioDTO);
        if (usuario == null) {
            JOptionPane.showMessageDialog(crearCuenta, "Error al registrar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!validarCalle(nuevoDomicilioDTO)
                || !validarCiudad(nuevoDomicilioDTO)
                || !validarColonia(nuevoDomicilioDTO)
                || !validarNumeroCasa(nuevoDomicilioDTO)
                || !validarCodigoPostal(nuevoDomicilioDTO)){
            return;
        }
        DomicilioUsuario domicilio = this.direccionesDAO.registrarDireccion(nuevoDomicilioDTO, usuario);
        if (domicilio == null) {
            JOptionPane.showMessageDialog(crearCuenta, "Error al registrar dirección.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
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
    
    private void mostrarMensajeUsuarioNoExiste() {
        JOptionPane.showMessageDialog(inicioSesion, "El usuario no existe. Intente nuevamente o cree una cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validarNombre(NuevoUsuarioDTO usuarioDTO) {
        String nombre = usuarioDTO.getNombres().trim(); // Elimina espacios en blanco

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (nombre.length() > 50) {
            JOptionPane.showMessageDialog(crearCuenta, "El nombre ingresado sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    private boolean validarApellidoPaterno(NuevoUsuarioDTO usuarioDTO){
        String apellido = usuarioDTO.getApellidoPaterno().trim();
         if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (apellido.length() > 50) {
            JOptionPane.showMessageDialog(crearCuenta, "El apellido ingresado sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validarApellidoMaterno(NuevoUsuarioDTO usuarioDTO) {
        String apellido = usuarioDTO.getApellidoPaterno().trim();
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (apellido.length() > 50) {
            JOptionPane.showMessageDialog(crearCuenta, "El apellido ingresado sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validarNombreUsuario(NuevoUsuarioDTO usuarioDTO) {
        String nombreUsuario = usuarioDTO.getNombreUsuario().trim();
        List<UsuarioRegistradoDTO> cuentasExistentes = this.usuariosDAO.ObtenerCuentasExistentes();

        if (nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (nombreUsuario.length() > 30) {
            JOptionPane.showMessageDialog(crearCuenta, "El nombre de usuario ingresado sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // verifica si el usuario ya existe
        boolean existe = cuentasExistentes.stream()
                .anyMatch(cuenta -> cuenta.getUsuario().equals(nombreUsuario));

        if (existe) {
            JOptionPane.showMessageDialog(crearCuenta, "El nombre de usuario ingresado ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    private boolean validarContrasenia(NuevoUsuarioDTO usuarioDTO) {
        String contrasenia = usuarioDTO.getContrasenia().trim();
        if (contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (contrasenia.length() > 60) {
            JOptionPane.showMessageDialog(crearCuenta, "La contraseña ingresada sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validarCorreoElectronico(NuevoUsuarioDTO usuarioDTO) {
        String correo = usuarioDTO.getCorreoElectronico().trim();
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (correo.length() > 100) {
            JOptionPane.showMessageDialog(crearCuenta, "El apellido ingresado sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
        
    private boolean validarCalle(NuevoDomicilioUsuarioDTO nuevoDomicilioDTO) {
        String calle = nuevoDomicilioDTO.getCalle().trim();
        if (calle.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (calle.length() > 50) {
            JOptionPane.showMessageDialog(crearCuenta, "La calle ingresada sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validarNumeroCasa(NuevoDomicilioUsuarioDTO nuevoDomicilioDTO) {
        String numeroCasa = nuevoDomicilioDTO.getNumero().trim();
        if (numeroCasa.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (numeroCasa.length() > 10) {
            JOptionPane.showMessageDialog(crearCuenta, "El número del domicilio ingresado sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validarColonia(NuevoDomicilioUsuarioDTO nuevoDomicilioDTO) {
        String colonia = nuevoDomicilioDTO.getColonia().trim();
        if (colonia.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (colonia.length() > 50) {
            JOptionPane.showMessageDialog(crearCuenta, "La colonia ingresada sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validarCiudad(NuevoDomicilioUsuarioDTO nuevoDomicilioDTO) {
        String ciudad = nuevoDomicilioDTO.getCiudad().trim();
        if (ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "No se pueden dejar campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (ciudad.length() > 50) {
            JOptionPane.showMessageDialog(crearCuenta, "La ciudad ingresada sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validarCodigoPostal(NuevoDomicilioUsuarioDTO nuevoDomicilioDTO) {
        Integer codigoPostal = nuevoDomicilioDTO.getCodigoPostal();
    if (codigoPostal == null || codigoPostal <= 0) {
        JOptionPane.showMessageDialog(crearCuenta, "El código postal no puede estar vacío o ser cero.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (codigoPostal < 10000 || codigoPostal > 99999) {
        JOptionPane.showMessageDialog(crearCuenta, "El código postal ingresado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    return true;
    }
    
}
