package itson.ticketwizard.dtos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.math.BigDecimal;


public class NuevoDepositoDTO {
    private BigDecimal saldo;
    private Integer codigoUsuario;

    public NuevoDepositoDTO(BigDecimal saldo, Integer codigoUsuario) {
        this.saldo = saldo;
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    
}
