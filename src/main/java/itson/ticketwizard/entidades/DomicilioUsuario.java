package itson.ticketwizard.entidades;

import java.util.Objects;

/**
 *
 * @author victoria
 */
public class DomicilioUsuario {
    private Integer codigoUsuario;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private String codigoPostal;

    public DomicilioUsuario() {
    }

    public DomicilioUsuario(Integer codigoUsuario, String calle, String numero, String colonia, String ciudad, String estado, String codigoPostal) {
        this.codigoUsuario = codigoUsuario;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public DomicilioUsuario(String calle, String numero, String colonia, String ciudad, String estado, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigoUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DomicilioUsuario other = (DomicilioUsuario) obj;
        return Objects.equals(this.codigoUsuario, other.codigoUsuario);
    }

    @Override
    public String toString() {
        return "DomicilioUsuario{" + "codigoUsuario=" + codigoUsuario + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal + '}';
    }
    
    
}
