package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class TransaccionCompra extends Transaccion {
    private Integer codigoTransaccion;

    public TransaccionCompra() {
    }

    public TransaccionCompra(Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float monto, String numeroSerieBoleto) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, monto, numeroSerieBoleto);
        this.codigoTransaccion = codigoTransaccion;
    }

    public TransaccionCompra(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float monto, String numeroSerieBoleto) {
        super(codigoUsuario, fechaHoraTransaccion, monto, numeroSerieBoleto);
    }

    @Override
    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    @Override
    public void setCodigoTransaccion(Integer codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigoTransaccion);
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
        return "TransaccionCompra{" + "codigoTransaccion=" + codigoTransaccion + '}';
    }
    
    
}
