package itson.ticketwizard.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class Evento {
    private Integer codigoEvento;
    private LocalDate fechaEvento;
    private String recintoEvento;
    private String ciudadEvento;
    private String estadoEvento;
    private String descripcionEvento;
    
    
    public Evento(){}

    public Evento(Integer codigoEvento, LocalDate fechaEvento, String recintoEvento, String ciudadEvento, String estadoEvento, String descripcionEvento) {
        this.codigoEvento = codigoEvento;
        this.fechaEvento = fechaEvento;
        this.recintoEvento = recintoEvento;
        this.ciudadEvento = ciudadEvento;
        this.estadoEvento = estadoEvento;
        this.descripcionEvento = descripcionEvento;
    }

    public Evento(LocalDate fechaEvento, String recintoEvento, String ciudadEvento, String estadoEvento, String descripcionEvento) {
        this.fechaEvento = fechaEvento;
        this.recintoEvento = recintoEvento;
        this.ciudadEvento = ciudadEvento;
        this.estadoEvento = estadoEvento;
        this.descripcionEvento = descripcionEvento;
    }

    public Integer getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getRecintoEvento() {
        return recintoEvento;
    }

    public void setRecintoEvento(String recintoEvento) {
        this.recintoEvento = recintoEvento;
    }

    public String getCiudadEvento() {
        return ciudadEvento;
    }

    public void setCiudadEvento(String ciudadEvento) {
        this.ciudadEvento = ciudadEvento;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigoEvento);
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
        return Objects.equals(this.codigoEvento, other.codigoEvento);
    }

    @Override
    public String toString() {
        return "Evento{" + "codigoEvento=" + codigoEvento + ", fechaEvento=" + fechaEvento + ", recintoEvento=" + recintoEvento + ", ciudadEvento=" + ciudadEvento + ", estadoEvento=" + estadoEvento + ", descripcionEvento=" + descripcionEvento + '}';
    }
    
    
}
