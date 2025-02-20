package itson.ticketwizard.control;

import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.presentacion.FrmMenuPrincipal;

/** Controla el flujo para el menú principal
 *
 * @author victoria
 */
public class ControlMenuPrincipal {
    
    private FrmMenuPrincipal menuPrincipal;
    
    private final ControlIniciarSesion controlInicioSesion;
    private final ControlActualizarPerfil controlActualizarPerfil;
    private final ControlRegistrarCompra controlComprarBoletos;
    private final ControlRegistrarReventa controlRevenderBoletos;
    private ControlDepositarSaldo controlDepositarSaldo;
    private final ControlResultadosBusqueda controlResultadosBusqueda;

    public ControlMenuPrincipal(ControlIniciarSesion controlInicioSesion, ControlActualizarPerfil controlActualizarPerfil, ControlRegistrarCompra controlComprarBoletos, ControlRegistrarReventa controlRevenderBoletos, ControlDepositarSaldo controlDepositarSaldo, ControlResultadosBusqueda controlResultadosBusqueda) {
        this.controlInicioSesion = controlInicioSesion;
        this.controlActualizarPerfil = controlActualizarPerfil;
        this.controlComprarBoletos = controlComprarBoletos;
        this.controlRevenderBoletos = controlRevenderBoletos;
        this.controlDepositarSaldo = controlDepositarSaldo;
        this.controlResultadosBusqueda = controlResultadosBusqueda;
    }

    public ControlMenuPrincipal(ControlIniciarSesion controlInicioSesion, ControlActualizarPerfil controlActualizarPerfil, ControlRegistrarCompra controlComprarBoletos, ControlRegistrarReventa controlRevenderBoletos, ControlResultadosBusqueda controlResultadosBusqueda) {
        this.controlInicioSesion = controlInicioSesion;
        this.controlActualizarPerfil = controlActualizarPerfil;
        this.controlComprarBoletos = controlComprarBoletos;
        this.controlRevenderBoletos = controlRevenderBoletos;
        this.controlResultadosBusqueda = controlResultadosBusqueda;
    }


    
    
    public void mostrarMenuPrincipal(UsuarioRegistradoDTO usuarioRegistradoDTO){
        this.menuPrincipal = new FrmMenuPrincipal(this, usuarioRegistradoDTO);
        this.menuPrincipal.setVisible(true);
    }
    
    public void cerrarSesion(){
        controlInicioSesion.iniciar();
    }
    
    public void mostrarActualizarUsuario(){
        controlActualizarPerfil.mostrarPantallaActualizarPerfil();
        
    }
    
    public void mostrarCatalogoBoletos(){
//        controlComprarBoletos.mostrarCatalogoBoletos();
    }
    
    public void mostrarHistorialCompras(){
        controlComprarBoletos.mostrarHistorialCompras();
    }
    
    public void mostrarMisBoletos(){
        controlRevenderBoletos.mostrarMisBoletos();
    }
    
    public void mostrarHistorialReventas(){
        controlRevenderBoletos.mostrarHistorialReventas();
    }
    
    public void mostrarHistorialDepositos(){
        controlDepositarSaldo.mostrarHistorialDepositos();
    }
    
    public void mostrarDepositoSaldo(){
        controlDepositarSaldo.mostrarDepositoSaldo();
    }
    
    public void mostrarResultadosBusqueda(){
        controlResultadosBusqueda.mostrarResultadosBusqueda();
    }
}
