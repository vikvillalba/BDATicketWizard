package itson.ticketwizard.control;

import itson.ticketwizard.dtos.NuevoDepositoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Deposito;
import itson.ticketwizard.persistencia.DepositosDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.presentacion.FrmDepositoSaldo;
import itson.ticketwizard.presentacion.FrmHistorialDepositos;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class ControlDepositarSaldo {
    private FrmDepositoSaldo depositarSaldo;
    private FrmHistorialDepositos historialDepositos;
    private DepositosDAO depositosDAO;

    public ControlDepositarSaldo(DepositosDAO depositosDAO) {
        this.depositosDAO = depositosDAO;
    }
    
    public void mostrarDepositoSaldo(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.depositarSaldo = new FrmDepositoSaldo(this, usuarioRegistradoDTO);
        this.depositarSaldo.setVisible(true);
    }

    public void realizarDeposito(NuevoDepositoDTO nuevoDepositoDTO, UsuarioRegistradoDTO usuarioRegistradoDTO) throws PersistenciaException {
        try {
            if (validarDeposito(nuevoDepositoDTO)) {
                Deposito deposito = this.depositosDAO.realizarDeposito(nuevoDepositoDTO);
                if (deposito != null) {
                    mostrarMensajeDepositoExitoso();
                    depositarSaldo.dispose();

                } else {
                    mostrarMensajeErrorDeposito();
                }
            } else {
                mostrarMensajeErrorValidacion();
            }
        } catch (SQLException e) {
            mostrarMensajeErrorDeposito();
        }
    }

    public boolean validarDeposito(NuevoDepositoDTO nuevoDepositoDTO){
        return nuevoDepositoDTO.getSaldo().intValue() > 0;
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
        this.historialDepositos = new FrmHistorialDepositos(this, usuarioRegistradoDTO);
        this.historialDepositos.setVisible(true);
    }
    
    public List<Deposito> obtenerDepositosUsuario(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException{
        try {
            return this.depositosDAO.obtenerDepositosUsuario(usuarioRegistradoDTO);
        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }
    }
}
