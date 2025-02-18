package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class Transaccion {
    private Integer codigoTransaccion;
    private Integer codigoUsuario;
    private LocalDateTime fechaHoraTransaccion;
    private float montoTransaccion;

    public Transaccion() {}

    public Transaccion(Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
        this.codigoUsuario = codigoUsuario;
        this.fechaHoraTransaccion = fechaHoraTransaccion;
        this.montoTransaccion = montoTransaccion;
    }

    public Transaccion(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        this.codigoUsuario = codigoUsuario;
        this.fechaHoraTransaccion = fechaHoraTransaccion;
        this.montoTransaccion = montoTransaccion;
    }

    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(Integer codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public LocalDateTime getFechaHoraTransaccion() {
        return fechaHoraTransaccion;
    }

    public void setFechaHoraTransaccion(LocalDateTime fechaHoraTransaccion) {
        this.fechaHoraTransaccion = fechaHoraTransaccion;
    }

    public float getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(float montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoTransaccion);
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
        final Transaccion other = (Transaccion) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    @Override
    public String toString() {
        return "Transaccion{" + "codigoTransaccion=" + codigoTransaccion + ", codigoUsuario=" + codigoUsuario + ", fechaHoraTransaccion=" + fechaHoraTransaccion + ", montoTransaccion=" + montoTransaccion + '}';
    }
    
    
    
    
}


