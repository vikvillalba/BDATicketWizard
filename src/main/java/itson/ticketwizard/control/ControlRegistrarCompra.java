package itson.ticketwizard.control;

import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.presentacion.FrmCatalogoBoletos;
import itson.ticketwizard.presentacion.FrmHistorialCompras;
import itson.ticketwizard.presentacion.FrmResultadosBusqueda;

/** Control que maneja el flujo para el caso de uso de registrar la compra de boletos, así como mostrar los boletos adquiridos.
 *
 * @author victoria
 */
public class ControlRegistrarCompra {
    
    private FrmResultadosBusqueda catalogoBoletos;
    private FrmHistorialCompras historialCompras;
    private BoletosDAO boletosDAO;

    public ControlRegistrarCompra(BoletosDAO boletosDAO) {
        this.boletosDAO = boletosDAO;
    }
    
    
    public void mostrarHistorialCompras(){
        this.historialCompras = new FrmHistorialCompras(this);
        this.historialCompras.setVisible(true);
    }
}
