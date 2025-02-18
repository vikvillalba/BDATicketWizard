package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase entidad que representa a la tabla TransaccionesDepositos en la BD. Equivale a un depósito de saldo en el perfil del usuario. Hereda los atributos de la clase Transaccion.
 *
 * @author victoria
 */
public class TransaccionDeposito extends Transaccion {

    private Integer codigoTransaccion;

    /**
     * Constructor por defecto de la clase. Llama al constructor de la clase padre {@code Transaccion}.
     */
    public TransaccionDeposito() {
        super();
    }

    /**
     * Constructor con parámetros que inicializa una transacción de depósito con un código de transacción.
     *
     * @param codigoTransaccion Código único de la transacción de depósito.
     * @param codigoUsuario Código del usuario asociado a la transacción.
     * @param fechaHoraTransaccion Fecha y hora en que se realiza la transacción.
     * @param montoTransaccion Monto de la transacción.
     */
    public TransaccionDeposito(Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.codigoTransaccion = codigoTransaccion;
    }

    /**
     * Constructor que inicializa una transacción sin un código de transacción explícito.
     *
     * @param codigoUsuario Código del usuario asociado a la transacción.
     * @param fechaHoraTransaccion Fecha y hora en que se realiza la transacción.
     * @param montoTransaccion Monto de la transacción.
     */
    public TransaccionDeposito(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
    }

    /**
     * Obtiene el código de la transacción de depósito.
     *
     * @return Código de la transacción.
     */
    @Override
    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    /**
     * Establece el código de la transacción de depósito.
     *
     * @param codigoTransaccion Código único de la transacción.
     */
    @Override
    public void setCodigoTransaccion(Integer codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    /**
     * Calcula el código hash de la transacción basado en el código de transacción.
     *
     * @return Código hash de la transacción.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigoTransaccion);
        return hash;
    }

    /**
     * Compara dos objetos para verificar si son iguales. La comparación se basa en el código de transacción.
     *
     * @param obj Objeto a comparar.
     * @return true si los eventos son iguales, false en caso contrario.
     *
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
        final TransaccionDeposito other = (TransaccionDeposito) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    /**
     * Devuelve una representación en cadena de la transacción de depósito.
     *
     * @return Cadena que representa la transacción.
     */
    @Override
    public String toString() {
        return "TransaccionDeposito{" + "codigoTransaccion=" + codigoTransaccion + '}';
    }

}
