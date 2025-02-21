package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.ComprasDAO;
import itson.ticketwizard.presentacion.FrmDetallesBoletoCompra;
import itson.ticketwizard.presentacion.FrmHistorialCompras;

/** Control que maneja el flujo para el caso de uso de registrar la compra de boletos, así como mostrar los boletos adquiridos.
 *
 * @author victoria
 */
public class ControlRegistrarCompra {
    
    private FrmDetallesBoletoCompra detallesBoletoCompra;
    private FrmHistorialCompras historialCompras;
    private BoletosDAO boletosDAO;
    private ComprasDAO comprasDAO;

    public ControlRegistrarCompra(BoletosDAO boletosDAO, ComprasDAO comprasDAO) {
        this.boletosDAO = boletosDAO;
        this.comprasDAO = comprasDAO;
    }
    
    
    public void mostrarHistorialCompras(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.historialCompras = new FrmHistorialCompras(this);
        this.historialCompras.setVisible(true);
    }
    
    public void mostrarDetallesBoletoCompra(UsuarioRegistradoDTO usuarioRegistradoDTO, BoletoCompraDTO boletoCompraDTO){
        this.detallesBoletoCompra = new FrmDetallesBoletoCompra(this, usuarioRegistradoDTO, boletoCompraDTO);
        this.detallesBoletoCompra.setVisible(true);
        
    }
}
