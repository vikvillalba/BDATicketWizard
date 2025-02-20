package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class TransaccionReventa extends Transaccion{
    private Integer codigoTransaccion;
    private Date fechaLimite;
    private double precioVenta;
    private Integer codigoComprador;

    public TransaccionReventa() {
    }

    public TransaccionReventa(Date fechaLimite, float precioVenta, Integer codigoComprador, Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, double monto, String numeroSerieBoleto) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, monto, numeroSerieBoleto);
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
        this.codigoComprador = codigoComprador;
    }

    public TransaccionReventa(Date fechaLimite, float precioVenta, Integer codigoComprador, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, double monto, String numeroSerieBoleto) {
        super(codigoUsuario, fechaHoraTransaccion, monto, numeroSerieBoleto);
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
        this.codigoComprador = codigoComprador;
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

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCodigoComprador() {
        return codigoComprador;
    }

    public void setCodigoComprador(Integer codigoComprador) {
        this.codigoComprador = codigoComprador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigoTransaccion);
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
        final TransaccionReventa other = (TransaccionReventa) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    @Override
    public String toString() {
        return "TransaccionReventa{" + "codigoTransaccion=" + codigoTransaccion + ", fechaLimite=" + fechaLimite + ", precioVenta=" + precioVenta + ", codigoComprador=" + codigoComprador + '}';
    }

      
    
    
}
