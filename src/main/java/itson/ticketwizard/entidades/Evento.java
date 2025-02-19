package itson.ticketwizard.entidades;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class Evento {
    private Integer codigo;
    private Date fecha;
    private String recinto;
    private String ciudad;
    private String estado;
    private String descripcion;

    public Evento() {
    }

    public Evento(Integer codigo, Date fecha, String recinto, String ciudad, String estado, String descripcion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.recinto = recinto;
        this.ciudad = ciudad;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public Evento(Date fecha, String recinto, String ciudad, String estado, String descripcion) {
        this.fecha = fecha;
        this.recinto = recinto;
        this.ciudad = ciudad;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.codigo);
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
        final Evento other = (Evento) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Evento{" + "codigo=" + codigo + ", fecha=" + fecha + ", recinto=" + recinto + ", ciudad=" + ciudad + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }
    
    
}
