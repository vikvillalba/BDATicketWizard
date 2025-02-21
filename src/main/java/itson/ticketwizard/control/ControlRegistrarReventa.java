package itson.ticketwizard.control;

import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.presentacion.FrmCatalogoBoletos;
import itson.ticketwizard.presentacion.FrmHistorialReventas;

/**
 *
 * @author victoria
 */
public class ControlRegistrarReventa {
    private FrmCatalogoBoletos misBoletos;
    private FrmHistorialReventas historialReventas;
    private BoletosDAO boletosDAO;

    public ControlRegistrarReventa(BoletosDAO boletosDAO) {
        this.boletosDAO = boletosDAO;
    }
    
    
    public void mostrarMisBoletos(UsuarioRegistradoDTO usuarioRegistradoDTO){ // para reventa
        this.misBoletos = new FrmCatalogoBoletos(this, usuarioRegistradoDTO);
        this.misBoletos.setVisible(true);
    }
    
    public void mostrarHistorialReventas(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.historialReventas = new FrmHistorialReventas(this);
        this.historialReventas.setVisible(true);
    }
    
    
    
}
