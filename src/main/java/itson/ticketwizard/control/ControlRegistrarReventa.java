package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BoletoUsuarioDTO;
import itson.ticketwizard.dtos.NuevaReventaDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.persistencia.ReventasDAO;
import itson.ticketwizard.presentacion.FrmBoletosReventa;
import itson.ticketwizard.presentacion.FrmHistorialReventas;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class ControlRegistrarReventa {
    private FrmBoletosReventa boletosReventa;
    private FrmHistorialReventas historialReventas;
    private BoletosDAO boletosDAO;
    private ReventasDAO reventasDAO;

    public ControlRegistrarReventa(BoletosDAO boletosDAO, ReventasDAO reventasDAO) {
        this.boletosDAO = boletosDAO;
        this.reventasDAO = reventasDAO;
    }

    public void setBoletosReventa(FrmBoletosReventa boletosReventa) {
        this.boletosReventa = boletosReventa;
    }
    
    
    
    public void mostrarHistorialReventas(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.historialReventas = new FrmHistorialReventas(this);
        this.historialReventas.setVisible(true);
    }

    public BoletoDTO obtenerBoletoReventa(BoletoUsuarioDTO boletoUsuarioDTO) throws ControlException {
        try {
            return this.boletosDAO.obtenerBoletoReventa(boletoUsuarioDTO);
        } catch (PersistenciaException ex) {
             throw new ControlException("error");
        }
    }
 
    public void revenderBoleto(UsuarioRegistradoDTO usuarioRegistradoDTO, NuevaReventaDTO nuevaReventaDTO) throws ControlException {
        BoletoUsuarioDTO boletoUsuarioDTO = new BoletoUsuarioDTO(nuevaReventaDTO.getNumeroSerie());
        BoletoDTO boletoReventa = this.obtenerBoletoReventa(boletoUsuarioDTO);

        try {
            // llamarle a la dao de reventas
            boolean reventaExitosa = this.reventasDAO.registrarReventa(nuevaReventaDTO, boletoReventa);
            
            if(reventaExitosa){
                this.mostrarMensajeCompraRealizada();
            }
            
        } catch (PersistenciaException ex) {
            System.out.println("Error en la persistencia de la compra: " + ex.getMessage());
            throw new ControlException("Error al realizar la compra.");
        }
    }

    private void mostrarMensajeCompraRealizada() {
        JOptionPane.showMessageDialog(boletosReventa, "¡Reventa exitosa!", "Información", JOptionPane.INFORMATION_MESSAGE);
        
    }
    private boolean validarPrecioReventa(BigDecimal precioReventa) {
        return true;
    }

    private boolean validarFecha(LocalDateTime fecha) {
        return true;
    }

}
