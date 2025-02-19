package itson.ticketwizard.dtos;

/**
 *
 * @author victoria
 */
public class NuevoDomicilioUsuarioDTO {
    private final String calle;
    private final String numero;
    private final String colonia;
    private final String ciudad;
    private final String estado;
    private final Integer codigoPostal;

    public NuevoDomicilioUsuarioDTO( String calle, String numero, String colonia, String ciudad, String estado, Integer codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }
    

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
    
}
