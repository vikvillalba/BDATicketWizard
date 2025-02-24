package itson.ticketwizard.control;

import itson.ticketwizard.dtos.UsuarioDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.presentacion.FrmCrearCuenta;
import itson.ticketwizard.presentacion.FrmInicioSesion;
import itson.ticketwizard.presentacion.FrmMenuPrincipal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    private ControlMenuPrincipal controlMenuPrincipal;

    public ControlIniciarSesion(UsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    public void setControlMenuPrincipal(ControlMenuPrincipal controlMenuPrincipal) {
        this.controlMenuPrincipal = controlMenuPrincipal;
    }

    public void iniciar() {
        this.inicioSesion = new FrmInicioSesion(this);
        this.inicioSesion.setVisible(true);

    }

    public void mostrarPantallaCrearCuenta() {
        this.crearCuenta = new FrmCrearCuenta(this);
        this.crearCuenta.setVisible(true);
    }

    public void registrarUsuario(UsuarioDTO nuevoUsuarioDTO) {
        if (!validarDatosUsuario(nuevoUsuarioDTO) && !validarDatosDomicilio(nuevoUsuarioDTO)) {
            JOptionPane.showMessageDialog(crearCuenta, "Datos inválidos. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuarioRegistrado = this.usuariosDAO.registrarUsuario(nuevoUsuarioDTO);

        if (usuarioRegistrado == null) {
            JOptionPane.showMessageDialog(crearCuenta, "Error al registrar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.mostrarMensajeUsuarioRegistrado();
        this.crearCuenta.dispose();
    }

    private boolean validarDatosUsuario(UsuarioDTO nuevoUsuarioDTO) {
        // Validaciones para los datos del usuario
        if (!validarTexto(nuevoUsuarioDTO.getNombres(), "nombres")
                || !validarTexto(nuevoUsuarioDTO.getApellidoPaterno(), "apellido paterno")
                || !validarTexto(nuevoUsuarioDTO.getApellidoMaterno(), "apellido materno")
                || !validarNombreUsuario(nuevoUsuarioDTO)
                || !validarContrasenia(nuevoUsuarioDTO)
                || !validarCorreoElectronico(nuevoUsuarioDTO)) {
            return false;
        }
        return true;
    }

    private boolean validarDatosDomicilio(UsuarioDTO nuevoUsuarioDTO) {
        // Validaciones para los datos del domicilio
        if (!validarTexto(nuevoUsuarioDTO.getCalle(), "calle")
                || !validarTexto(nuevoUsuarioDTO.getCiudad(), "ciudad")
                || !validarTexto(nuevoUsuarioDTO.getColonia(), "colonia")
                || !validarNumeroCasa(nuevoUsuarioDTO)
                || !validarCodigoPostal(nuevoUsuarioDTO.getCodigoPostal())) {
            return false;
        }
        return true;
    }

    private void mostrarMensajeUsuarioRegistrado() {
        JOptionPane.showMessageDialog(crearCuenta, "Se registró el usuario correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void iniciarSesion(UsuarioRegistradoDTO usuarioRegistradoDTO) {
        List<UsuarioRegistradoDTO> cuentasExistentes = this.usuariosDAO.ObtenerCuentasExistentes();
        boolean usuarioEncontrado = false;

        for (int i = 0; i < cuentasExistentes.size(); i++) {
            if (cuentasExistentes.get(i).getUsuario().equals(usuarioRegistradoDTO.getUsuario()) && BCrypt.checkpw(usuarioRegistradoDTO.getContrasenia(), cuentasExistentes.get(i).getContrasenia())) {

                // le asigna el codigo al usuario ya que verifica que existe
                usuarioRegistradoDTO.setCodigoUsuario(cuentasExistentes.get(i).getCodigoUsuario());
                usuarioRegistradoDTO.setSaldo(cuentasExistentes.get(i).getSaldo());
                this.mostrarMensajeInicioSesionExitoso();
                // abre el menu principal y envia al usuario que está en la sesión activa.
                controlMenuPrincipal.mostrarMenuPrincipal(usuarioRegistradoDTO);
                this.inicioSesion.dispose();
                usuarioEncontrado = true;
                break;

            }
        }

        if (!usuarioEncontrado) {
            this.mostrarMensajeUsuarioNoExiste();
        }
    }

    private void mostrarMensajeInicioSesionExitoso() {
        JOptionPane.showMessageDialog(inicioSesion, "Se inició sesión correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeUsuarioNoExiste() {
        JOptionPane.showMessageDialog(inicioSesion, "El usuario no existe. Intente nuevamente o cree una cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public boolean validarNombreUsuario(UsuarioDTO usuarioDTO) {
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

    public boolean validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "El campo " + campo + " no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (texto.length() > 50) {
            JOptionPane.showMessageDialog(crearCuenta, "El campo " + campo + " sobrepasa el limite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean validarContrasenia(UsuarioDTO usuarioDTO) {
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

    public boolean validarNumeroCasa(UsuarioDTO nuevoUsuarioDTO) {
        String numeroCasa = nuevoUsuarioDTO.getNumero().trim();
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

    public boolean validarCodigoPostal(Integer codigoPostal) {
        if (codigoPostal == null) {
            JOptionPane.showMessageDialog(crearCuenta, "El código postal no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica que tenga exactamente 5 dígitos
        String regex = "^\\d{5}$";
        return validarConExpresionRegular(String.valueOf(codigoPostal), regex, "El código postal ingresado no es válido.");
    }

    private boolean validarConExpresionRegular(String valor, String regex, String mensajeError) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valor);

        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(crearCuenta, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    public boolean validarCorreoElectronico(UsuarioDTO usuarioDTO) {
        String correo = usuarioDTO.getCorreoElectronico();
        if (correo == null || correo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(crearCuenta, "El correo no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        /**
         * [A-Za-z0-9+_.-]+ permite las letras de la a a la z, nums del 0-9 y caracteres especiales. [A-Za-z0-9.-]+ permite letras, nums, puntos y guiones en el dominio
         */
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);

        //el correo tiene q cumplir con el formato correcto si no no lo cuenta como valido
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(crearCuenta, "El correo ingresado no es valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


}
