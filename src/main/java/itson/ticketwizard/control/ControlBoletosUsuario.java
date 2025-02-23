

package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BoletoUsuarioDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.PersistenciaException;
import itson.ticketwizard.presentacion.FrmBoletosReventa;
import itson.ticketwizard.presentacion.FrmBoletosUsuario;
import itson.ticketwizard.presentacion.FrmHistorialReventas;
import itson.ticketwizard.utilidades.Utilidades;
import java.util.List;

/**
 *
 * @author victoria
 */
public class ControlBoletosUsuario {
    private FrmBoletosUsuario boletosUsuario;
    private FrmBoletosReventa boletosReventa;
    private FrmHistorialReventas historialReventas;
    private BoletosDAO boletosDAO;
    private ControlRegistrarReventa controlRegistrarReventa;

    public ControlBoletosUsuario(BoletosDAO boletosDAO, ControlRegistrarReventa controlRegistrarReventa) {
        this.boletosDAO = boletosDAO;
        this.controlRegistrarReventa = controlRegistrarReventa;
    }
    
    public List<BoletoUsuarioDTO> obtenerBoletosPaginados(int limit, int pagina, UsuarioRegistradoDTO usuarioRegistradoDTO) throws ControlException {
        int offset = Utilidades.RegresarOFFSETMySQL(limit, pagina);

        try {
            return this.boletosDAO.buscarPaginadoBoletosTablaUsuario(limit, offset, usuarioRegistradoDTO);

        } catch (PersistenciaException ex) {
            throw new ControlException("error");
        }

    }
    
    public void mostrarBoletosUsuario(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.boletosUsuario = new FrmBoletosUsuario(this, usuarioRegistradoDTO);
        this.boletosUsuario.setVisible(true);
    }
    
    public void mostrarBoletosParaReventa(UsuarioRegistradoDTO usuarioRegistradoDTO, List<BoletoUsuarioDTO> listaBoletos){
        this.boletosReventa = new FrmBoletosReventa(this, usuarioRegistradoDTO, listaBoletos);
        this.boletosReventa.setVisible(true);
    }

}
