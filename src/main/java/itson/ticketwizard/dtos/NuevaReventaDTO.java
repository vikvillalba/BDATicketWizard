package itson.ticketwizard.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author victoria 
 */
public class NuevaReventaDTO {
    private Integer codigoUsuario;
    private BigDecimal precioBoleto;
    private String numeroSerie;
    private LocalDateTime fechaLimite;
    private BigDecimal precioVenta;

    public NuevaReventaDTO(Integer codigoUsuario, String numeroSerie, LocalDateTime fechaLimite, BigDecimal precioVenta) {
        this.codigoUsuario = codigoUsuario;
        this.numeroSerie = numeroSerie;
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
    }

    
    
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public BigDecimal getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(BigDecimal precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
}
