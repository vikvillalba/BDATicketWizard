package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class TransaccionDeposito extends Transaccion {
    private Integer codigoTransaccion;

    public TransaccionDeposito() {
        super();
    }

    public TransaccionDeposito(Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.codigoTransaccion = codigoTransaccion;
    }

    public TransaccionDeposito(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
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
        hash = 23 * hash + Objects.hashCode(this.codigoTransaccion);
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
        final TransaccionDeposito other = (TransaccionDeposito) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    @Override
    public String toString() {
        return "TransaccionDeposito{" + "codigoTransaccion=" + codigoTransaccion + '}';
    }


  



    
    
    
    
    
}
