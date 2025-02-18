package itson.ticketwizard.control;

import itson.ticketwizard.presentacion.FrmInicioSesion;

/**
 * Controla el flujo para el caso de uso de inicio de sesión. Corresponde al inicio del sistema.
 *
 * @author victoria
 */
public class ControlIniciarSesion {

    /**
     * Contiene un formulario que corresponde al inicio de sesión.
     */
    private FrmInicioSesion inicioSesion;

    /**
     * Cosntructor. Inicializa el formulario y lo muestra.
     */
    public void iniciarSesion() {
        this.inicioSesion = new FrmInicioSesion(this);
        this.inicioSesion.setVisible(true);

    }

}
