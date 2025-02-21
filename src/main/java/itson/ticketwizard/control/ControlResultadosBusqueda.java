package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BusquedaBoletoFechasDTO;
import itson.ticketwizard.dtos.BusquedaBoletoNombreDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.presentacion.FrmResultadosBusqueda;
import itson.ticketwizard.utilidades.Utilidades;
import java.util.List;

/**
 *
 * @author victoria
 */
public class ControlResultadosBusqueda {

    private FrmResultadosBusqueda resultadosBusqueda;
    private BoletosDAO boletosDAO;
    private ControlRegistrarCompra controlRegistrarCompra;

    public ControlResultadosBusqueda(BoletosDAO boletosDAO, ControlRegistrarCompra controlRegistrarCompra) {
        this.boletosDAO = boletosDAO;
        this.controlRegistrarCompra = controlRegistrarCompra;
    }

    public List<BoletoDTO> obtenerBoletosPaginados(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);
        
        try {
            return this.boletosDAO.buscarPaginadoBoletosTabla(limit, offset, usuarioRegistradoDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }

    public List<BoletoDTO> obtenerBoletosPaginadosNombreEvento(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO, BusquedaBoletoNombreDTO busquedaBoletoNombreDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);

        try {
            return this.boletosDAO.buscarPaginadoBoletosTablaNombreEvento(limit, offset, usuarioRegistradoDTO, busquedaBoletoNombreDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }

    public List<BoletoDTO> obtenerBoletosPaginadosRangoFechas(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO, BusquedaBoletoFechasDTO busquedaBoletoFechasDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);

        try {
            return this.boletosDAO.buscarPaginadoBoletosTablaRangoFechas(limit, offset, usuarioRegistradoDTO, busquedaBoletoFechasDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }
        
    public void mostrarResultadosBusqueda(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.resultadosBusqueda = new FrmResultadosBusqueda(this, usuarioRegistradoDTO);
        this.resultadosBusqueda.setVisible(true);
    }
    
    public void mostrarDetallesCompra(UsuarioRegistradoDTO usuarioRegistradoDTO, BoletoCompraDTO boletoCompraDTO){
        controlRegistrarCompra.mostrarDetallesBoletoCompra(usuarioRegistradoDTO, boletoCompraDTO);
    }
}
