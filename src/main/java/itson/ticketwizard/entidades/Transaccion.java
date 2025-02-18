package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase entidad que representa a la tabla Transacciones en la BD.
 *
 * @author victoria
 */
public class Transaccion {

    private Integer codigoTransaccion;
    private Integer codigoUsuario;
    private LocalDateTime fechaHoraTransaccion;
    private float montoTransaccion;

    /**
     * Constructor por defecto.
     */
    public Transaccion() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param codigoTransaccion Código único de la transacción.
     * @param codigoUsuario Código del usuario que realizó la transacción.
     * @param fechaHoraTransaccion Fecha y hora en que se realizó la transacción.
     * @param montoTransaccion Monto de la transacción.
     */
    public Transaccion(Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
        this.codigoUsuario = codigoUsuario;
        this.fechaHoraTransaccion = fechaHoraTransaccion;
        this.montoTransaccion = montoTransaccion;
    }

    /**
     * Constructor sin el código de transacción (puede ser generado posteriormente).
     *
     * @param codigoUsuario Código del usuario que realizó la transacción.
     * @param fechaHoraTransaccion Fecha y hora en que se realizó la transacción.
     * @param montoTransaccion Monto de la transacción.
     */
    public Transaccion(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        this.codigoUsuario = codigoUsuario;
        this.fechaHoraTransaccion = fechaHoraTransaccion;
        this.montoTransaccion = montoTransaccion;
    }

    /**
     * Obtiene el código de la transacción.
     *
     * @return Código de la transacción.
     */
    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    /**
     * Establece el código de la transacción.
     *
     * @param codigoTransaccion Código de la transacción.
     */
    public void setCodigoTransaccion(Integer codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    /**
     * Obtiene el código del usuario que realizó la transacción.
     *
     * @return Código del usuario.
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * Establece el código del usuario que realizó la transacción.
     *
     * @param codigoUsuario Código del usuario.
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * Obtiene la fecha y hora de la transacción.
     *
     * @return Fecha y hora de la transacción.
     */
    public LocalDateTime getFechaHoraTransaccion() {
        return fechaHoraTransaccion;
    }

    /**
     * Establece la fecha y hora de la transacción.
     *
     * @param fechaHoraTransaccion Fecha y hora de la transacción.
     */
    public void setFechaHoraTransaccion(LocalDateTime fechaHoraTransaccion) {
        this.fechaHoraTransaccion = fechaHoraTransaccion;
    }

    /**
     * Obtiene el monto de la transacción.
     *
     * @return Monto de la transacción.
     */
    public float getMontoTransaccion() {
        return montoTransaccion;
    }

    /**
     * Establece el monto de la transacción.
     *
     * @param montoTransaccion Monto de la transacción.
     */
    public void setMontoTransaccion(float montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    /**
     * Calcula el código hash de la transacción.
     *
     * @return Código hash basado en el código de transacción.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoTransaccion);
        return hash;
    }

    /**
     * Compara si dos transacciones son iguales basándose en su código de transacción.
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
        final Transaccion other = (Transaccion) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    /**
     * Devuelve una representación en cadena de la transacción.
     *
     * @return Cadena con los detalles de la transacción.
     */
    @Override
    public String toString() {
        return "Transaccion{" + "codigoTransaccion=" + codigoTransaccion + ", codigoUsuario=" + codigoUsuario + ", fechaHoraTransaccion=" + fechaHoraTransaccion + ", montoTransaccion=" + montoTransaccion + '}';
    }

    
    
    
}


