package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.NuevaCompraDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.TransaccionCompra;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.ComprasDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.presentacion.FrmDetallesBoletoCompra;
import itson.ticketwizard.presentacion.FrmHistorialCompras;
import itson.ticketwizard.presentacion.FrmMenuPrincipal;
import javax.swing.JOptionPane;

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
    
    // para mostrar el boleto en la tabla
    public BoletoDTO obtenerBoletoCompra(BoletoCompraDTO boletoCompraDTO) throws ControlException{
        try {
            return this.boletosDAO.obtenerBoletoCompra(boletoCompraDTO);
        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }
    }

    // con el boleto que regresa obtenerBoletoCompra
    public void comprarBoleto(UsuarioRegistradoDTO usuarioRegistradoDTO, BoletoDTO boletoDTO) throws ControlException {
        try {
            UsuarioRegistradoDTO usuarioConSaldo = this.usuariosDAO.obtenerUsuario(usuarioRegistradoDTO);

            // Comprobar si el usuario tiene suficiente saldo
            if (usuarioConSaldo.getSaldo().compareTo(boletoDTO.getPrecio()) < 0) {
                System.out.println("No hay dinero suficiente para comprar el boleto.");
                // se aparta el boleto ????
                return;
            }
            NuevaCompraDTO nuevaCompraDTO = new NuevaCompraDTO(usuarioRegistradoDTO.getCodigoUsuario(), boletoDTO.getNumeroSerie(), boletoDTO.getPrecio());
            boolean compraExitosa = this.comprasDAO.registrarCompra(nuevaCompraDTO, boletoDTO);

            if (compraExitosa) {
                this.comprasDAO.actualizarDuenioBoleto(nuevaCompraDTO, boletoDTO);
                this.mostrarMensajeCompraRealizada();  
                this.detallesBoletoCompra.dispose();
                
                
            } else {
                System.out.println("La compra no se pudo realizar.");
            }
        } catch (PersistenciaException ex) {
            System.out.println("Error en la persistencia de la compra: " + ex.getMessage());
            throw new ControlException("Error al realizar la compra.");
        }
    }

    private void mostrarMensajeCompraRealizada() {
        JOptionPane.showMessageDialog(detallesBoletoCompra, "¡Compra exitosa!", "Información", JOptionPane.INFORMATION_MESSAGE);
        detallesBoletoCompra.dispose();
    }
}
