package itson.ticketwizard.entidades;

import java.time.LocalDate;
import java.util.Objects;

/** Clase entidad que representa a la tabla Eventos en la BD.
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
    
    /** Constructor por defecto. */
    public Evento(){}

    /**
     * Constructor que recibe todos los atributos.
     *
     * @param codigoEvento Código único del evento.
     * @param fechaEvento Fecha en la que se llevará a cabo.
     * @param recintoEvento Nombre del recinto donde se celebrará.
     * @param ciudadEvento Ciudad donde se realizará.
     * @param estadoEvento Estado donde se realizará.
     * @param descripcionEvento Breve descripción del evento.
     */
    public Evento(Integer codigoEvento, LocalDate fechaEvento, String recintoEvento, String ciudadEvento, String estadoEvento, String descripcionEvento) {
        this.codigoEvento = codigoEvento;
        this.fechaEvento = fechaEvento;
        this.recintoEvento = recintoEvento;
        this.ciudadEvento = ciudadEvento;
        this.estadoEvento = estadoEvento;
        this.descripcionEvento = descripcionEvento;
    }

/**
     * Constructor que recibe todos los atributos menos el código del evento.
     *
     * @param fechaEvento Fecha en la que se llevará a cabo.
     * @param recintoEvento Nombre del recinto donde se celebrará.
     * @param ciudadEvento Ciudad donde se realizará.
     * @param estadoEvento Estado donde se realizará.
     * @param descripcionEvento Breve descripción del evento.
     */
    public Evento(LocalDate fechaEvento, String recintoEvento, String ciudadEvento, String estadoEvento, String descripcionEvento) {
        this.fechaEvento = fechaEvento;
        this.recintoEvento = recintoEvento;
        this.ciudadEvento = ciudadEvento;
        this.estadoEvento = estadoEvento;
        this.descripcionEvento = descripcionEvento;
    }

    /**
     * Obtiene el código del evento.
     *
     * @return Código del evento.
     */
    public Integer getCodigoEvento() {
        return codigoEvento;
    }

    /**
     * Establece el código del evento.
     *
     * @param codigoEvento Código único del evento.
     */
    public void setCodigoEvento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    /**
     * Obtiene la fecha en que se llevará a cabo el evento.
     *
     * @return Fecha del evento.
     */
    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    /**
     * Establece la fecha en que se llevará a cabo el evento.
     *
     * @param fechaEvento Fecha del evento.
     */
    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    
    /**
     * Obtiene el recinto donde se llevará a cabo el evento.
     *
     * @return Nombre del recinto del evento.
     */
    public String getRecintoEvento() {
        return recintoEvento;
    }

    /**
     * Establece el recinto donde se llevará a cabo el evento.
     *
     * @param recintoEvento Nombre del recinto del evento.
     */
    public void setRecintoEvento(String recintoEvento) {
        this.recintoEvento = recintoEvento;
    }

    /**
     * Obtiene la ciudad donde se realizará el evento.
     *
     * @return Ciudad del evento.
     */
    public String getCiudadEvento() {
        return ciudadEvento;
    }

    /**
     * Establece la ciudad donde se realizará el evento.
     *
     * @param ciudadEvento Ciudad del evento.
     */
    public void setCiudadEvento(String ciudadEvento) {
        this.ciudadEvento = ciudadEvento;
    }

    /**
     * Obtiene el estado donde se llevará a cabo el evento.
     *
     * @return Estado del evento.
     */
    public String getEstadoEvento() {
        return estadoEvento;
    }

    /**
     * Establece el estado donde se llevará a cabo el evento.
     *
     * @param estadoEvento Estado del evento.
     */
    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    /**
     * Obtiene la descripción del evento.
     *
     * @return Descripción del evento.
     */
    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    /**
     * Establece la descripción del evento.
     *
     * @param descripcionEvento Breve descripción del evento.
     */
    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    /**
     * Calcula el código hash basado en el código del evento.
     *
     * @return Código hash del objeto Evento.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigoEvento);
        return hash;
    }

    /**
     * Compara si dos objetos Evento son iguales, basándose en su código de evento.
     *
     * @param obj Objeto a comparar.
     * @return true si los eventos son iguales, false en caso contrario.
     */
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

    /**
     * Devuelve una representación en cadena del objeto Evento.
     *
     * @return Cadena con los valores del evento.
     */
    @Override
    public String toString() {
        return "Evento{" + "codigoEvento=" + codigoEvento + ", fechaEvento=" + fechaEvento + ", recintoEvento=" + recintoEvento + ", ciudadEvento=" + ciudadEvento + ", estadoEvento=" + estadoEvento + ", descripcionEvento=" + descripcionEvento + '}';
    }
    
    
}
