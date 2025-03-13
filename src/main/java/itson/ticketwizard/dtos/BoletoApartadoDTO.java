package itson.ticketwizard.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representa a un boleto que se aparta cuando el usuario no tiene el suficiente saldo.
 * @author victoria
 */
public class BoletoApartadoDTO {
    private Integer codigoUsuario;
    private Integer codigoBoleto;
    private String numeroSerie;
    private LocalDateTime fechaHoraApartado;
    private BigDecimal precioBoleto;

    public BoletoApartadoDTO(Integer codigoUsuario, Integer codigoBoleto, String numeroSerie, LocalDateTime fechaHoraApartado, BigDecimal precioBoleto) {
        this.codigoUsuario = codigoUsuario;
        this.codigoBoleto = codigoBoleto;
        this.numeroSerie = numeroSerie;
        this.fechaHoraApartado = fechaHoraApartado;
        this.precioBoleto = precioBoleto;
    }

 

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDateTime getFechaHoraApartado() {
        return fechaHoraApartado;
    }

    public void setFechaHoraApartado(LocalDateTime fechaHoraApartado) {
        this.fechaHoraApartado = fechaHoraApartado;
    }

    public BigDecimal getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(BigDecimal precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public Integer getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(Integer codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }
    
    System.out.println("no");
    
}
