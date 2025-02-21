package itson.ticketwizard.dtos;

/**
 *
 * @author victo
 */
public class BoletoCompraDTO {
    private String numeroSerie;

    public BoletoCompraDTO(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
    
}
