package itson.ticketwizard.control;

import itson.ticketwizard.dtos.NuevoDepositoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Deposito;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.DepositosDAO;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.presentacion.FrmDepositoSaldo;
import itson.ticketwizard.presentacion.FrmHistorialDepositos;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class ControlDepositarSaldo {
    private FrmDepositoSaldo depositarSaldo;
    private FrmHistorialDepositos historialDepositos;
    private DepositosDAO depositosDAO;
    private UsuariosDAO usuariosDAO;

    public ControlDepositarSaldo(DepositosDAO depositosDAO, UsuariosDAO usuariosDAO) {
        this.depositosDAO = depositosDAO;
    }
    
    public void mostrarDepositoSaldo(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.depositarSaldo = new FrmDepositoSaldo(this, usuarioRegistradoDTO);
        this.depositarSaldo.setVisible(true);
    }
    
    public void realizarDeposito(NuevoDepositoDTO nuevoDepositoDTO, UsuarioRegistradoDTO usuarioRegistradoDTO){
       try{
        if(validarDeposito(nuevoDepositoDTO)){
           Deposito deposito = this.depositosDAO.realizarDeposito(nuevoDepositoDTO, usuarioRegistradoDTO);
           if (deposito != null){
               mostrarMensajeDepositoExitoso();
               depositarSaldo.dispose();
           }else{
               mostrarMensajeErrorDeposito();
           }
       }else{
           mostrarMensajeErrorValidacion();
       }}catch(SQLException e){
           mostrarMensajeErrorDeposito();
       }
    }
    
    public boolean validarDeposito(NuevoDepositoDTO nuevoDepositoDTO){
        return nuevoDepositoDTO.getSaldo().intValue() < 0;
    }
    
    private void mostrarMensajeDepositoExitoso() {
        JOptionPane.showMessageDialog(depositarSaldo, "El depósito fue realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensajeErrorDeposito() {
        JOptionPane.showMessageDialog(depositarSaldo, "Hubo un problema al realizar el depósito. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mostrarMensajeErrorValidacion() {
        JOptionPane.showMessageDialog(depositarSaldo, "Monto no válido. El monto debe ser mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    

    public void mostrarHistorialDepositos(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.historialDepositos = new FrmHistorialDepositos(this);
        this.historialDepositos.setVisible(true);
    }
}
