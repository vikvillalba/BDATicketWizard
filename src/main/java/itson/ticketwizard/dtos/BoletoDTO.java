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
    private String numeroSerie;
    private Integer codigoBoleto;
    private Integer codigoUsuarioDuenio;

    public BoletoDTO() {
    }

    public BoletoDTO(String nombreEvento, LocalDateTime fechaEvento, String recinto, String fila, String asiento, String ciudad, String estado, BigDecimal precio, String numeroSerie, Integer codigoBoleto) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.recinto = recinto;
        this.fila = fila;
        this.asiento = asiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.precio = precio;
        this.numeroSerie = numeroSerie;
        this.codigoBoleto = codigoBoleto;
    }

    public BoletoDTO(String nombreEvento, LocalDateTime fechaEvento, String recinto, String fila, String asiento, String ciudad, String estado, BigDecimal precio, String numeroSerie, Integer codigoBoleto, Integer codigoUsuarioDuenio) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.recinto = recinto;
        this.fila = fila;
        this.asiento = asiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.precio = precio;
        this.numeroSerie = numeroSerie;
        this.codigoBoleto = codigoBoleto;
        this.codigoUsuarioDuenio = codigoUsuarioDuenio;
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

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Integer getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(Integer codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    public Integer getCodigoUsuarioDuenio() {
        return codigoUsuarioDuenio;
    }

    public void setCodigoUsuarioDuenio(Integer codigoUsuarioDuenio) {
        this.codigoUsuarioDuenio = codigoUsuarioDuenio;
    }
    
    
    
    
}
