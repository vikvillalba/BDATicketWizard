package itson.ticketwizard.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class Deposito {
    private Integer codigoDeposito;
    private Integer codigoUsuario;
    private BigDecimal monto;
    private LocalDateTime fechaHora;

    public Deposito() {
    }

    public Deposito(Integer codigoDeposito, Integer codigoUsuario, BigDecimal monto, LocalDateTime fechaHora) {
        this.codigoDeposito = codigoDeposito;
        this.codigoUsuario = codigoUsuario;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    public Deposito(Integer codigoDeposito, BigDecimal monto, LocalDateTime fechaHora) {
        this.codigoDeposito = codigoDeposito;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }
    
    

    public Integer getCodigoDeposito() {
        return codigoDeposito;
    }

    public void setCodigoDeposito(Integer codigoDeposito) {
        this.codigoDeposito = codigoDeposito;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.codigoDeposito);
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
        final Deposito other = (Deposito) obj;
        return Objects.equals(this.codigoDeposito, other.codigoDeposito);
    }

    @Override
    public String toString() {
        return "Deposito{" + "codigoDeposito=" + codigoDeposito + ", codigoUsuario=" + codigoUsuario + ", monto=" + monto + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
