package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoApartadoDTO;
import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BoletoUsuarioDTO;
import itson.ticketwizard.dtos.NuevaCompraDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosApartadosDAO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.ComprasDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.persistencia.UsuariosDAO;
import itson.ticketwizard.presentacion.FrmBoletosApartados;
import itson.ticketwizard.presentacion.FrmDetallesBoletoCompra;
import itson.ticketwizard.utilidades.Utilidades;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/** Control que maneja el flujo para el caso de uso de registrar la compra de boletos, así como mostrar los boletos adquiridos.
 *
 * @author victoria
 */
public class ControlRegistrarCompra {
    
    private FrmDetallesBoletoCompra detallesBoletoCompra;
    private FrmBoletosApartados boletosApartados;
    private final BoletosDAO boletosDAO;
    private final ComprasDAO comprasDAO;
    private UsuariosDAO usuariosDAO;
    private BoletosApartadosDAO boletosApartadosDAO;

    public ControlRegistrarCompra(BoletosDAO boletosDAO, ComprasDAO comprasDAO, UsuariosDAO usuariosDAO, BoletosApartadosDAO boletosApartadosDAO) {
        this.boletosDAO = boletosDAO;
        this.comprasDAO = comprasDAO;
        this.usuariosDAO = usuariosDAO;
        this.boletosApartadosDAO = boletosApartadosDAO;
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

                BoletoApartadoDTO boletoApartadoDTO = new BoletoApartadoDTO(usuarioRegistradoDTO.getCodigoUsuario(), boletoDTO.getCodigoBoleto(), boletoDTO.getNumeroSerie(), LocalDateTime.now(), boletoDTO.getPrecio());

                if (!this.boletosDAO.obtenerBoletoApartado(boletoDTO)) {
                    this.boletosApartadosDAO.apartarBoleto(boletoApartadoDTO, usuarioRegistradoDTO);
                    this.mostrarMensajeBoletoApartado();
                    this.usuariosDAO.ejecutarEventoBoletosApartados(boletoDTO);
                } else {

                    JOptionPane.showMessageDialog(detallesBoletoCompra, "ya apartaste este boleto.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

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
    
    private void mostrarMensajeBoletoApartado() {
        JOptionPane.showMessageDialog(detallesBoletoCompra,
                "Saldo insuficiente.\nEl boleto se ha apartado por 10 minutos.\n"
                + "Deposite saldo antes del periodo de tiempo o el boleto se liberará a la venta otra vez.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);

        detallesBoletoCompra.dispose();
    }
    
    public void mostrarBoletosApartados(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.boletosApartados = new FrmBoletosApartados(this, usuarioRegistradoDTO);
        this.boletosApartados.setVisible(true);
    }
    
    public List<BoletoUsuarioDTO> obtenerBoletosApartados(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);

        try {
            return this.boletosDAO.buscarBoletosApartadosUsuario(limit, offset, usuarioRegistradoDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }
}
