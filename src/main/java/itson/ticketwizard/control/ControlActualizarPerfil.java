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
    
//    public void actualizarPerfil(NuevoUsuarioDTO usuarioActualizado, NuevoDomicilioUsuarioDTO domicilioActualizado){
//        boolean usuarioActualizadoExitosamente = usuariosDAO.registrarUsuario(usuarioActualizado) != null;
//        boolean domicilioActualizadoExitosamente = direccionesDAO.registrarDireccion(domicilioActualizado, usuarioActualizado) != null;  
//        
//        if(usuarioActualizadoExitosamente && domicilioActualizadoExitosamente){
//            mostrarMensajeExito();
//        } else {
//            mostrarMensajeError();
//        }
//    }
    
    public void actualizarPerfil(NuevoUsuarioDTO usuarioDTO, NuevoDomicilioUsuarioDTO domicilioDTO) {
    if (!validarCorreoElectronico(usuarioDTO.getCorreoElectronico()) ||
        !validarTexto(usuarioDTO.getApellidoPaterno(), "Apellido Paterno") ||
        !validarTexto(usuarioDTO.getApellidoMaterno(), "Apellido Materno") ||
        !validarTexto(usuarioDTO.getNombres(), "Nombres") ||
        !validarTexto(usuarioDTO.getNombreUsuario(), "Nombre de usuario") ||
        !validarTexto(usuarioDTO.getContrasenia(), "Contraseña") ||
        !validarTexto(domicilioDTO.getCalle(), "Calle") ||
        !validarTexto(domicilioDTO.getNumero(), "Numero de casa") ||
        !validarTexto(domicilioDTO.getColonia(), "Colonia") ||
        !validarTexto(domicilioDTO.getCiudad(), "Ciudad") ||
        !validarTexto(domicilioDTO.getEstado(), "Estado") ||
        !validarCodigoPostal(String.valueOf(domicilioDTO.getCodigoPostal()))) {
        return;
    }

    System.out.println("Actualizando perfil de: " + usuarioDTO.getNombreUsuario());
}

    }
    
    //hace que el correo no este vacio
    private boolean validarCorreoElectronico(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El correo no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        /**
         * [A-Za-z0-9+_.-]+ permite las letras de la a a la z, nums del 0-9 y caracteres especiales.
         * [A-Za-z0-9.-]+ permite letras, nums, puntos y guiones en el dominio
         */
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        
        //el correo tiene q cumplir con el formato correcto si no no lo cuenta como valido
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El correo ingresado no es valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    //valida q no este vacio y que no se pase de caracteres
    //el texto es el q se valida
    private boolean validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El campo " + campo + " no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (texto.length() > 50) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El campo " + campo + " sobrepasa el limite de caracteres permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    //valida que el cp sea de 5 digitos nmericos
     private boolean validarCodigoPostal(String codigoPostal) {
        if (codigoPostal == null || codigoPostal.trim().isEmpty()) {
            JOptionPane.showMessageDialog(actualizarPerfil, "El codigo postal no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //hace q sean exactamente 5 digitos
        String regex = "^\\d{5}$";
        return validarConExpresionRegular(codigoPostal, regex, "El codigo postal ingresado no es valido.");
    }
     
     //crea patron de busqueda y se compila, luego se comprueba con el matcher para comparar el string valor
     private boolean validarConExpresionRegular(String valor, String regex, String mensajeError) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valor);
        
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(actualizarPerfil, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void mostrarMensajeExito(){
        JOptionPane.showMessageDialog(actualizarPerfil, "El perfil ha sido actualizado correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensajeError(){
        JOptionPane.showMessageDialog(actualizarPerfil, "No se ha podido actualizar el perfil.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

       