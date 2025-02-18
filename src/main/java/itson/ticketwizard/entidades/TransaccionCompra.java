package itson.ticketwizard.entidades;

import itson.ticketwizard.enums.TipoCompra;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase entidad que representa a la tabla TransaccionesCompras en la BD. 
 * Equivale a la compra de un boleto que se revende por el mismo sistema.
 * Hereda los atributos de la clase Transaccion.
 *
 * @author victoria
 */
public class TransaccionCompra extends Transaccion {

    private Integer codigoTransaccion;
    private TipoCompra tipoCompra;
    private String numeroSerieBoleto;

    /**
     * Constructor por defecto.
     * Llama al constructor de la clase padre {@code Transaccion}.
     */
    public TransaccionCompra() {
        super();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param tipoCompra Tipo de compra realizada.
     * @param numeroSerieBoleto Número de serie del boleto.
     * @param codigoTransaccion Código único de la transacción.
     * @param codigoUsuario Código del usuario que realizó la transacción.
     * @param fechaHoraTransaccion Fecha y hora en que se realizó la transacción.
     * @param montoTransaccion Monto de la transacción.
     */
    public TransaccionCompra(TipoCompra tipoCompra, String numeroSerieBoleto, Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.codigoTransaccion = codigoTransaccion;
        this.tipoCompra = tipoCompra;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    /**
     * Constructor sin código de transacción.
     *
     * @param tipoCompra Tipo de compra realizada.
     * @param numeroSerieBoleto Número de serie del boleto.
     * @param codigoUsuario Código del usuario que realizó la transacción.
     * @param fechaHoraTransaccion Fecha y hora en que se realizó la transacción.
     * @param montoTransaccion Monto de la transacción.
     */
    public TransaccionCompra(TipoCompra tipoCompra, String numeroSerieBoleto, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.tipoCompra = tipoCompra;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    /**
     * Constructor con código de usuario, fecha y monto.
     *
     * @param codigoUsuario Código del usuario que realizó la transacción.
     * @param fechaHoraTransaccion Fecha y hora en que se realizó la transacción.
     * @param montoTransaccion Monto de la transacción.
     */
    public TransaccionCompra(Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
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
     * Obtiene el tipo de compra.
     *
     * @return Tipo de compra.
     */
    public TipoCompra getTipoCompra() {
        return tipoCompra;
    }

    /**
     * Establece el tipo de compra.
     *
     * @param tipoCompra Tipo de compra.
     */
    public void setTipoCompra(TipoCompra tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    /**
     * Obtiene el número de serie del boleto.
     *
     * @return Número de serie del boleto.
     */
    public String getNumeroSerieBoleto() {
        return numeroSerieBoleto;
    }

    /**
     * Establece el número de serie del boleto.
     *
     * @param numeroSerieBoleto Número de serie del boleto.
     */
    public void setNumeroSerieBoleto(String numeroSerieBoleto) {
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    /**
     * Calcula el código hash de la transacción de compra.
     *
     * @return Código hash basado en el código de transacción.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codigoTransaccion);
        return hash;
    }

    /**
     * Compara si dos transacciones de compra son iguales basándose en su código de transacción.
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
        final TransaccionCompra other = (TransaccionCompra) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    /**
     * Devuelve una representación en cadena de la transacción de compra.
     *
     * @return Cadena con los detalles de la transacción de compra.
     */
    @Override
    public String toString() {
        return "TransaccionCompra{" + "codigoTransaccion=" + codigoTransaccion + ", tipoCompra=" + tipoCompra + ", numeroSerieBoleto=" + numeroSerieBoleto + '}';
    }

}
