package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class TransaccionVenta extends Transaccion {
    private Integer codigoTransaccion;
    private Date fechaLimite;
    private float precioVenta;
    private String numeroSerieBoleto;

    public TransaccionVenta() {
        super();
    }

    public TransaccionVenta(Date fechaLimite, float precioVenta, String numeroSerieBoleto, Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.codigoTransaccion = codigoTransaccion;
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    public TransaccionVenta(Integer codigoTransaccion, Date fechaLimite, float precioVenta, String numeroSerieBoleto, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.codigoTransaccion = codigoTransaccion;
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    public TransaccionVenta(Date fechaLimite, float precioVenta, String numeroSerieBoleto, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(Integer codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
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
        hash = 19 * hash + Objects.hashCode(this.codigoTransaccion);
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
        final TransaccionVenta other = (TransaccionVenta) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    @Override
    public String toString() {
        return "TransaccionVenta{" + "codigoTransaccion=" + codigoTransaccion + ", fechaLimite=" + fechaLimite + ", precioVenta=" + precioVenta + ", numeroSerieBoleto=" + numeroSerieBoleto + '}';
    }
    
    
    
    
    
}
