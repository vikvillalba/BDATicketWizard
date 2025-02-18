package itson.ticketwizard.entidades;

import itson.ticketwizard.enums.TipoCompra;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class TransaccionCompra extends Transaccion {
    private Integer codigoTransaccion;
    private TipoCompra tipoCompra;
    private String numeroSerieBoleto;

    public TransaccionCompra() {
        super();
    }

    public TransaccionCompra(TipoCompra tipoCompra, String numeroSerieBoleto, Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.codigoTransaccion = codigoTransaccion;
        this.tipoCompra = tipoCompra;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    public TransaccionCompra(TipoCompra tipoCompra, String numeroSerieBoleto, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.tipoCompra = tipoCompra;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    public TransaccionCompra(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
    }

    
    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(Integer codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public TipoCompra getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(TipoCompra tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public String getNumeroSerieBoleto() {
        return numeroSerieBoleto;
    }

    public void setNumeroSerieBoleto(String numeroSerieBoleto) {
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codigoTransaccion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransaccionCompra other = (TransaccionCompra) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    @Override
    public String toString() {
        return "TransaccionCompra{" + "codigoTransaccion=" + codigoTransaccion + ", tipoCompra=" + tipoCompra + ", numeroSerieBoleto=" + numeroSerieBoleto + '}';
    }
    
    
    
    
}
