/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dtos.NuevoDomicilioUsuarioDTO;
import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.presentacion.FrmActualizarPerfil;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.persistencia.DireccionesDAO;
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
    
    public void actualizarPerfil(NuevoUsuarioDTO usuarioActualizado, NuevoDomicilioUsuarioDTO domicilioActualizado){
        boolean usuarioActualizadoExitosamente = usuariosDAO.registrarUsuario(usuarioActualizado) != null;
        boolean domicilioActualizadoExitosamente = direccionesDAO.registrarDireccion(domicilioActualizado, usuarioActualizado) != null;  
        
        if(usuarioActualizadoExitosamente && domicilioActualizadoExitosamente){
            mostrarMensajeExito();
        } else {
            mostrarMensajeError();
        }
    }
    
    private void mostrarMensajeExito(){
        JOptionPane.showMessageDialog(actualizarPerfil, "El perfil ha sido actualizado correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensajeError(){
        JOptionPane.showMessageDialog(actualizarPerfil, "No se ha podido actualizar el perfil.", "Error", JOptionPane.ERROR_MESSAGE);
    
}
    
}
