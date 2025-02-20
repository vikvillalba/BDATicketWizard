package itson.ticketwizard.control;

import itson.ticketwizard.persistencia.DepositosDAO;
import itson.ticketwizard.presentacion.FrmDepositoSaldo;
import itson.ticketwizard.presentacion.FrmHistorialDepositos;

/**
 *
 * @author victoria
 */
public class ControlDepositarSaldo {
    private FrmDepositoSaldo depositarSaldo;
    private FrmHistorialDepositos historialDepositos;
    private DepositosDAO depositosDAO;

    public ControlDepositarSaldo(DepositosDAO depositosDAO) {
        this.depositosDAO = depositosDAO;
    }
    
    public void mostrarDepositoSaldo(){
        this.depositarSaldo = new FrmDepositoSaldo(this);
        this.depositarSaldo.setVisible(true);
    }
    
    public void mostrarHistorialDepositos(){
        this.historialDepositos = new FrmHistorialDepositos(this);
        this.historialDepositos.setVisible(true);
    }
}
