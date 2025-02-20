package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoDTO;
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

    public List<BoletoDTO> obtenerBoletosPaginados(int limit, int pagina) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);
        List<BoletoDTO> listaBoletos = new ArrayList<>();
        try {
            listaBoletos = this.boletosDAO.buscarPaginadoAlumnosTabla(limit, offset);

        } catch (PersistenciaException ex) {
            throw new ControlException("petó");
        }
        return listaBoletos;

    }
    
        
    public void mostrarResultadosBusqueda(){
        this.resultadosBusqueda = new FrmResultadosBusqueda(this);
        this.resultadosBusqueda.setVisible(true);
    }
}
