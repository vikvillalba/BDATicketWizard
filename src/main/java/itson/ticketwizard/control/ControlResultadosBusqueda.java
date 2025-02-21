package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.presentacion.FrmResultadosBusqueda;
import itson.ticketwizard.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoria
 */
public class ControlResultadosBusqueda {

    private FrmResultadosBusqueda resultadosBusqueda;
    private BoletosDAO boletosDAO;

    public ControlResultadosBusqueda(BoletosDAO boletosDAO) {
        this.boletosDAO = boletosDAO;
    }

    public List<BoletoDTO> obtenerBoletosPaginados(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);
        
        try {
            return this.boletosDAO.buscarPaginadoAlumnosTabla(limit, offset, usuarioRegistradoDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }

    public List<BoletoDTO> obtenerBoletosPaginadosNombreEvento(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);

        try {
            return this.boletosDAO.buscarPaginadoAlumnosTabla(limit, offset, usuarioRegistradoDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }

        
    public void mostrarResultadosBusqueda(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.resultadosBusqueda = new FrmResultadosBusqueda(this, usuarioRegistradoDTO);
        this.resultadosBusqueda.setVisible(true);
    }
}
