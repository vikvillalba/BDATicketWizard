package itson.ticketwizard.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author victoria
 */
public class BoletoUsuarioDTO {

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
    private Integer codigoUsuario;
    private Integer numeroTransaccion;
    private String formaCompra;
    private LocalDateTime fechaHoraCompra;

    public BoletoUsuarioDTO(String nombreEvento, LocalDateTime fechaEvento, String recinto, String fila, String asiento, String ciudad, String estado, BigDecimal precio, String numeroSerie, Integer codigoBoleto, Integer codigoUsuario, Integer numeroTransaccion, String formaCompra, LocalDateTime fechaHoraCompra) {
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
        this.codigoUsuario = codigoUsuario;
        this.numeroTransaccion = numeroTransaccion;
        this.formaCompra = formaCompra;
        this.fechaHoraCompra = fechaHoraCompra;
    }

    public BoletoUsuarioDTO(String nombreEvento, LocalDateTime fechaEvento, String recinto, String fila, String asiento, String ciudad, String estado, BigDecimal precio, String numeroSerie, Integer codigoBoleto, Integer numeroTransaccion, String formaCompra, LocalDateTime fechaHoraCompra) {
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
        this.numeroTransaccion = numeroTransaccion;
        this.formaCompra = formaCompra;
        this.fechaHoraCompra = fechaHoraCompra;
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

    public String getFormaCompra() {
        return formaCompra;
    }

    public void setFormaCompra(String formaCompra) {
        this.formaCompra = formaCompra;
    }

    public LocalDateTime getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(LocalDateTime fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }
    
    
    
}
