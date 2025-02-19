
package itson.ticketwizard.entidades;

import java.util.Objects;

/**
 *
 * @author victoria
 */
public class ReventaUsuario {
    private Integer codigoReventa;
    private Integer codigoComprador;
    private Integer codigoVendedor;

    public ReventaUsuario() {
    }

    public ReventaUsuario(Integer codigoReventa, Integer codigoComprador, Integer codigoVendedor) {
        this.codigoReventa = codigoReventa;
        this.codigoComprador = codigoComprador;
        this.codigoVendedor = codigoVendedor;
    }

    public ReventaUsuario(Integer codigoComprador, Integer codigoVendedor) {
        this.codigoComprador = codigoComprador;
        this.codigoVendedor = codigoVendedor;
    }

    public Integer getCodigoReventa() {
        return codigoReventa;
    }

    public void setCodigoReventa(Integer codigoReventa) {
        this.codigoReventa = codigoReventa;
    }

    public Integer getCodigoComprador() {
        return codigoComprador;
    }

    public void setCodigoComprador(Integer codigoComprador) {
        this.codigoComprador = codigoComprador;
    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Integer codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigoReventa);
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
        final ReventaUsuario other = (ReventaUsuario) obj;
        return Objects.equals(this.codigoReventa, other.codigoReventa);
    }

    @Override
    public String toString() {
        return "ReventaUsuario{" + "codigoReventa=" + codigoReventa + ", codigoComprador=" + codigoComprador + ", codigoVendedor=" + codigoVendedor + '}';
    }
    
    
}
