package itson.ticketwizard.dtos;

/**
 *
 * @author victoria
 */
public class BusquedaBoletoNombreDTO {
    private String nombreEvento;

    public BusquedaBoletoNombreDTO(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    
    
    
}
