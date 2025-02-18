package itson.ticketwizard.control;
import itson.ticketwizard.presentacion.FrmHistorialBoletos;
import itson.ticketwizard.presentacion.FrmInicioSesion;

/**
 *
 * @author victoria
 */
public class ControlIniciarSesion {
    private FrmInicioSesion inicioSesion;
    
    public void iniciarSesion(){ // inicia el caso de uso
        this.inicioSesion = new FrmInicioSesion(this);
        this.inicioSesion.setVisible(true);
    
    } 
            
}
