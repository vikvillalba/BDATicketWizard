package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.NuevaCompraDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.ComprasDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.presentacion.FrmDetallesBoletoCompra;
import itson.ticketwizard.presentacion.FrmHistorialCompras;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.AEADBadTagException;

/** Control que maneja el flujo para el caso de uso de registrar la compra de boletos, así como mostrar los boletos adquiridos.
 *
 * @author victoria
 */
public class ControlRegistrarCompra {
    
    private FrmDetallesBoletoCompra detallesBoletoCompra;
    private FrmHistorialCompras historialCompras;
    private final BoletosDAO boletosDAO;
    private final ComprasDAO comprasDAO;
    private UsuariosDAO usuariosDAO;

    public ControlRegistrarCompra(BoletosDAO boletosDAO, ComprasDAO comprasDAO, UsuariosDAO usuariosDAO) {
        this.boletosDAO = boletosDAO;
        this.comprasDAO = comprasDAO;
        this.usuariosDAO = usuariosDAO;
    }
    
    
    public void mostrarHistorialCompras(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.historialCompras = new FrmHistorialCompras(this);
        this.historialCompras.setVisible(true);
    }
    
    public void mostrarDetallesBoletoCompra(UsuarioRegistradoDTO usuarioRegistradoDTO, BoletoCompraDTO boletoCompraDTO){
        this.detallesBoletoCompra = new FrmDetallesBoletoCompra(this, usuarioRegistradoDTO, boletoCompraDTO);
        this.detallesBoletoCompra.setVisible(true);
        
    }
    
    public BoletoDTO obtenerBoletoCompra(BoletoCompraDTO boletoCompraDTO) throws ControlException{
        try {
            return this.boletosDAO.obtenerBoletoCompra(boletoCompraDTO);
        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }
    }
    
    public void comprarBoleto(UsuarioRegistradoDTO usuarioRegistradoDTO, BoletoDTO boletoDTO) throws ControlException {
        try {
            UsuarioRegistradoDTO usuarioConSaldo = this.usuariosDAO.obtenerUsuario(usuarioRegistradoDTO);
            if (usuarioConSaldo.getSaldo().compareTo(boletoDTO.getPrecio()) < 0) {
                // agregar boletoDTO a alguna lista de boletos apartados 
            }

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

        NuevaCompraDTO nuevaCompraDTO = new NuevaCompraDTO(usuarioRegistradoDTO.getCodigoUsuario(), boletoDTO.getNumeroSerie(), boletoDTO.getPrecio());
    }
}
