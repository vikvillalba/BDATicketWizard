package itson.ticketwizard.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author victoria
 */
public class BoletoReventaDTO {
    private String nombreEvento;
    private String recinto;
    private String fila;
    private String asiento;
    private String ciudad;
    private String estado;
    private BigDecimal precio;
    private String numeroSerie;
    private Integer codigoBoleto;
    private Integer codigoUsuario;
    private Integer numeroTransaccion;
    private LocalDateTime fechaTransaccion;
    private LocalDateTime fechaLimiteReventa;
    private BigDecimal precioReventa;

    public BoletoReventaDTO(String nombreEvento, String recinto, String fila, String asiento, String ciudad, String estado, BigDecimal precio, String numeroSerie, Integer codigoBoleto, Integer codigoUsuario, Integer numeroTransaccion, LocalDateTime fechaTransaccion, LocalDateTime fechaLimiteReventa, BigDecimal precioReventa) {
        this.nombreEvento = nombreEvento;
        this.recinto = recinto;
        this.fila = fila;
        this.asiento = asiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.precio = precio;
        this.numeroSerie = numeroSerie;
        this.codigoBoleto = codigoBoleto;
        this.codigoUsuario = codigoUsuario;
        this.numeroTransaccion = numeroTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.fechaLimiteReventa = fechaLimiteReventa;
        this.precioReventa = precioReventa;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
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

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(Integer numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public LocalDateTime getFechaLimiteReventa() {
        return fechaLimiteReventa;
    }

    public void setFechaLimiteReventa(LocalDateTime fechaLimiteReventa) {
        this.fechaLimiteReventa = fechaLimiteReventa;
    }

    public BigDecimal getPrecioReventa() {
        return precioReventa;
    }

    public void setPrecioReventa(BigDecimal precioReventa) {
        this.precioReventa = precioReventa;
    }


    
    
}
