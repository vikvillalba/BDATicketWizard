package itson.ticketwizard.control;

import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.presentacion.FrmBoletosUsuario;
import itson.ticketwizard.presentacion.FrmHistorialReventas;

/**
 *
 * @author victoria
 */
public class ControlRegistrarReventa {
    private FrmBoletosUsuario misBoletos;
    private FrmHistorialReventas historialReventas;
    private BoletosDAO boletosDAO;

    public ControlRegistrarReventa(BoletosDAO boletosDAO) {
        this.boletosDAO = boletosDAO;
    }
    
    public void mostrarHistorialReventas(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.historialReventas = new FrmHistorialReventas(this);
        this.historialReventas.setVisible(true);
    }
    
    
    
}
