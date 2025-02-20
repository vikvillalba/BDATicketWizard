package itson.ticketwizard.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author victoria
 */
public class BoletoDTO {
    private String nombreEvento;
    private LocalDateTime fechaEvento;
    private String recinto;
    private String fila;
    private String asiento;
    private String ciudad;
    private String estado;
    private BigDecimal precio;

    public BoletoDTO() {
    }

    public BoletoDTO(String nombreEvento, LocalDateTime fechaEvento, String recinto, String fila, String asiento, String ciudad, String estado, BigDecimal precio) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.recinto = recinto;
        this.fila = fila;
        this.asiento = asiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.precio = precio;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public LocalDateTime getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDateTime fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
    
    
}
