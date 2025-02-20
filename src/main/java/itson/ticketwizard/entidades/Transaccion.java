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
    private double monto;
    private String numeroSerieBoleto;

    public Transaccion() {
    }

    public Transaccion(Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, double monto, String numeroSerieBoleto) {
        this.codigoTransaccion = codigoTransaccion;
        this.codigoUsuario = codigoUsuario;
        this.fechaHoraTransaccion = fechaHoraTransaccion;
        this.monto = monto;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    public Transaccion(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, double monto, String numeroSerieBoleto) {
        this.codigoUsuario = codigoUsuario;
        this.fechaHoraTransaccion = fechaHoraTransaccion;
        this.monto = monto;
        this.numeroSerieBoleto = numeroSerieBoleto;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getNumeroSerieBoleto() {
        return numeroSerieBoleto;
    }

    public void setNumeroSerieBoleto(String numeroSerieBoleto) {
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Transaccion other = (Transaccion) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    @Override
    public String toString() {
        return "Transaccion{" + "codigoTransaccion=" + codigoTransaccion + ", codigoUsuario=" + codigoUsuario + ", fechaHoraTransaccion=" + fechaHoraTransaccion + ", monto=" + monto + ", numeroSerieBoleto=" + numeroSerieBoleto + '}';
    }
    
    
}
