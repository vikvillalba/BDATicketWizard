package itson.ticketwizard.control;

import itson.ticketwizard.dtos.NuevoDomicilioUsuarioDTO;
import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.presentacion.FrmActualizarPerfil;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.persistencia.DireccionesDAO;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 * Caso de uso de actualizar la informacion de un usuario.
 * Modifica informacion personal y el domicilio.
 * @author victoria
 */

/**
 * Caso de uso de actualizar la información de un usuario.
 * Modifica información personal y el domicilio.
 * @author victoria
 */
public class ControlActualizarPerfil {
    private FrmActualizarPerfil actualizarPerfil;
    private UsuariosDAO usuariosDAO;
    private DireccionesDAO direccionesDAO;
    
    public ControlActualizarPerfil(UsuariosDAO usuariosDAO, DireccionesDAO direccionesDAO){
        this.usuariosDAO = usuariosDAO;
        this.direccionesDAO = direccionesDAO;
    }
    
    public void mostrarPantallaActualizarPerfil(){
        this.actualizarPerfil = new FrmActualizarPerfil(this);
        this.actualizarPerfil.setVisible(true);
    }
    
    /**
     * Método para actualizar el perfil de un usuario con su información personal y domicilio.
     * @param usuarioDTO Contiene la información personal del usuario.
     * @param domicilioDTO Contiene la información del domicilio del usuario.
     */
    public void actualizarPerfil(NuevoUsuarioDTO usuarioDTO, NuevoDomicilioUsuarioDTO domicilioDTO) {
        if (!validarCorreoElectronico(usuarioDTO.getCorreoElectronico()) ||
            !validarTexto(usuarioDTO.getApellidoPaterno(), "Apellido Paterno") ||
            !validarTexto(usuarioDTO.getApellidoMaterno(), "Apellido Materno") ||
            !validarTexto(usuarioDTO.getNombres(), "Nombres") ||
            !validarTexto(usuarioDTO.getNombreUsuario(), "Nombre de usuario") ||
            !validarTexto(usuarioDTO.getContrasenia(), "Contraseña") ||
            !validarTexto(domicilioDTO.getCalle(), "Calle") ||
            !validarTexto(domicilioDTO.getNumero(), "Número de casa") ||
            !validarTexto(domicilioDTO.getColonia(), "Colonia") ||
            !validarTexto(domicilioDTO.getCiudad(), "Ciudad") ||
            !validarTexto(domicilioDTO.getEstado(), "Estado") ||
            !validarCodigoPostal(String.valueOf(domicilioDTO.getCodigoPostal()))) {
            return;
        }
        
        //se actualiza la informacion del usuario en la base de datos.
        //se usan las dao para verificar si las operaciones son exitosas.
        //si ambos son exitosos muestra mensaje de exito, si falla muestra mensaje de error.
        
        boolean usuarioActualizado = usuariosDAO.registrarUsuario(usuarioDTO) != null;
////        boolean domicilioRegistrado = direccionesDAO.registrarDireccion(domicilioDTO, usuarioDTO) != null;
//        
//        if (usuarioActualizado && domicilioRegistrado) {
//            mostrarMensajeExito();
//        } else {
//            mostrarMensajeError();
//        }
    }
//    
    /**
     * Valida que el correo electrónico tenga el formato correcto.
     * @param correo El correo a validar.
     * @return true si el correo es válido, false en caso contrario.
     */
    private boolean validarCorreoElectronico(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El correo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Expresión regular para validar el formato de un correo electrónico
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return validarConExpresionRegular(correo, regex, "El correo ingresado no es válido.");
    }
    
    /**
     * Valida que un campo de texto no esté vacío y no exceda el límite de caracteres.
     * @param texto El texto a validar.
     * @param campo El nombre del campo para mostrar en el mensaje de error.
     * @return true si el texto es válido, false en caso contrario.
     */
    private boolean validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El campo " + campo + " no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (texto.length() > 50) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El campo " + campo + " sobrepasa el límite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * Valida que el código postal sea un número de exactamente 5 dígitos.
     * @param codigoPostal El código postal a validar.
     * @return true si es válido, false en caso contrario.
     */
    private boolean validarCodigoPostal(String codigoPostal) {
        if (codigoPostal == null || codigoPostal.trim().isEmpty()) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El código postal no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Expresión regular para validar un código postal de 5 dígitos
        String regex = "^\\d{5}$";
        return validarConExpresionRegular(codigoPostal, regex, "El código postal ingresado no es válido.");
    }
    
    /**
     * Valida que un valor cumpla con una expresión regular.
     * @param valor El valor a validar.
     * @param regex La expresión regular a aplicar.
     * @param mensajeError Mensaje de error si la validación falla.
     * @return true si el valor es válido, false en caso contrario.
     */
    private boolean validarConExpresionRegular(String valor, String regex, String mensajeError) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valor);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(actualizarPerfil, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * Muestra un mensaje de éxito al actualizar el perfil.
     */
    private void mostrarMensajeExito(){
        JOptionPane.showMessageDialog(actualizarPerfil, "El perfil ha sido actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra un mensaje de error si no se pudo actualizar el perfil.
     */
    private void mostrarMensajeError(){
        JOptionPane.showMessageDialog(actualizarPerfil, "No se ha podido actualizar el perfil.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
