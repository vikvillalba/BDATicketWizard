package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BoletoReventaDTO;
import itson.ticketwizard.dtos.BoletoUsuarioDTO;
import itson.ticketwizard.dtos.NuevaReventaDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.persistencia.ReventasDAO;
import itson.ticketwizard.presentacion.FrmBoletosReventa;
import itson.ticketwizard.presentacion.FrmBoletosUsuario;
import itson.ticketwizard.presentacion.FrmHistorialReventas;
import itson.ticketwizard.utilidades.Utilidades;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class ControlRegistrarReventa {
    private FrmBoletosReventa boletosReventa;
    private FrmBoletosUsuario boletosUsuario;
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

    public void mostrarHistorialReventas(UsuarioRegistradoDTO usuarioRegistradoDTO) {
        this.historialReventas = new FrmHistorialReventas(this, usuarioRegistradoDTO);
        this.historialReventas.setVisible(true);
    }

    public List<BoletoUsuarioDTO> obtenerBoletosPaginados(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);

        try {
            return this.boletosDAO.buscarPaginadoBoletosTablaUsuario(limit, offset, usuarioRegistradoDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

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
        if (!validarFecha(nuevaReventaDTO.getFechaLimite()) && !validarPrecioReventa(nuevaReventaDTO.getPrecioVenta())) {
            return;
        }
        try {
            // llamarle a la dao de reventas
            boolean reventaExitosa = this.reventasDAO.registrarReventa(nuevaReventaDTO, boletoReventa);

            if (reventaExitosa) {
                this.mostrarMensajeCompraRealizada();
                this.boletosReventa.dispose();
                this.mostrarBoletosUsuario(usuarioRegistradoDTO);
            }

        } catch (PersistenciaException ex) {
            System.out.println("Error en la persistencia de la compra: " + ex.getMessage());
            throw new ControlException("Error al realizar la compra.");
        }
    }

    private void mostrarMensajeCompraRealizada() {
        JOptionPane.showMessageDialog(boletosReventa, "¡Reventa exitosa!", "Información", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    private boolean validarPrecioReventa(BigDecimal precioReventa) throws ControlException {
        BigDecimal porcentaje = new BigDecimal("0.03"); 
        BigDecimal limiteSuperior = precioReventa.add(precioReventa.multiply(porcentaje));

        if (precioReventa.compareTo(limiteSuperior) <= 0) {
            return true;
        } else {
            throw new ControlException("El precio de reventa no puede exceder más del 3% sobre el precio original del boleto.");
        }

    }

    private boolean validarFecha(LocalDateTime fecha) {
        LocalDateTime fechaActual = LocalDateTime.now();

        if (fecha.isBefore(fechaActual)) {
            JOptionPane.showMessageDialog(null, "La fecha y hora no pueden ser anteriores a la fecha y hora actuales.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; 
    }


    public void mostrarBoletosParaReventa(UsuarioRegistradoDTO usuarioRegistradoDTO, List<BoletoUsuarioDTO> listaBoletos){
        this.boletosReventa = new FrmBoletosReventa(this, usuarioRegistradoDTO, listaBoletos);
        this.boletosReventa.setVisible(true);
    }
    
    
    public void mostrarBoletosUsuario(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.boletosUsuario = new FrmBoletosUsuario(this, usuarioRegistradoDTO);
        this.boletosUsuario.setVisible(true);
    }

        public List<BoletoReventaDTO> obtenerBoletosReventa(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);

        try {
            return this.boletosDAO.buscarBoletosRevendidos(limit, offset, usuarioRegistradoDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }
}
