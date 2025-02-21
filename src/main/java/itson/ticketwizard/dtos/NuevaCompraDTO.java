package itson.ticketwizard.dtos;

import java.math.BigDecimal;

/**
 *
 * @author victoria
 */
public class NuevaCompraDTO {
    private Integer codigoUsuario;
    private String numeroSerieBoleto;
    private BigDecimal precioBoleto;

    public NuevaCompraDTO(Integer codigoUsuario, String numeroSerieBoleto, BigDecimal precioBoleto) {
        this.codigoUsuario = codigoUsuario;
        this.numeroSerieBoleto = numeroSerieBoleto;
        this.precioBoleto = precioBoleto;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNumeroSerieBoleto() {
        return numeroSerieBoleto;
    }

    public void setNumeroSerieBoleto(String numeroSerieBoleto) {
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    public BigDecimal getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(BigDecimal precioBoleto) {
        this.precioBoleto = precioBoleto;
    }
    
    
}
