package itson.ticketwizard.dtos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.math.BigDecimal;


public class NuevoDepositoDTO {
    private final BigDecimal saldo;
    
    public NuevoDepositoDTO(BigDecimal saldo){
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
