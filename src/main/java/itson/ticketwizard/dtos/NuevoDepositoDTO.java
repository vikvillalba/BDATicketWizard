package itson.ticketwizard.dtos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class NuevoDepositoDTO {
    private final float saldo;
    
    public NuevoDepositoDTO(float saldo){
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }
}
