package itson.ticketwizard.entidades;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Clase entidad que representa a la tabla TransaccionesVentas en la BD. Equivale a la reventa de un boleto en el mismo sistema. Hereda los atributos de la clase Transaccion.
 *
 * @author victoria
 */
public class TransaccionVenta extends Transaccion {

    private Integer codigoTransaccion;
    private Date fechaLimite;
    private float precioVenta;
    private String numeroSerieBoleto;

    /**
     * Constructor por defecto. Llama al constructor de la clase padre {@code Transaccion}.
     */
    public TransaccionVenta() {
        super();
    }

    /**
     * Constructor que inicializa una transacción de venta con todos sus atributos.
     *
     * @param fechaLimite Fecha límite hasta la que estará a la venta el boleto.
     * @param precioVenta Precio de venta del boleto.
     * @param numeroSerieBoleto Número de serie del boleto puesto en venta.
     * @param codigoTransaccion Código único de la transacción.
     * @param codigoUsuario Código del usuario que realiza la venta del boleto.
     * @param fechaHoraTransaccion Fecha y hora en que se realiza la venta.
     * @param montoTransaccion Monto de la transacción. Precio de la venta menos la comisión del sistema.
     */
    public TransaccionVenta(Date fechaLimite, float precioVenta, String numeroSerieBoleto, Integer codigoTransaccion, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoTransaccion, codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.codigoTransaccion = codigoTransaccion;
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    /**
     * Constructor que omite el código de transacción.
     *
     * @param fechaLimite Fecha límite hasta la que estará a la venta el boleto.
     * @param precioVenta Precio de venta del boleto.
     * @param numeroSerieBoleto Número de serie del boleto puesto en venta.
     * @param codigoUsuario Código del usuario que realiza la venta del boleto.
     * @param fechaHoraTransaccion Fecha y hora en que se realiza la venta.
     * @param montoTransaccion Monto de la transacción. Precio de la venta menos la comisión del sistema.
     */
    public TransaccionVenta(Date fechaLimite, float precioVenta, String numeroSerieBoleto, Integer codigoUsuario, LocalDateTime fechaHoraTransaccion, float montoTransaccion) {
        super(codigoUsuario, fechaHoraTransaccion, montoTransaccion);
        this.fechaLimite = fechaLimite;
        this.precioVenta = precioVenta;
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    /**
     * Obtiene el código de la transacción de venta.
     *
     * @return Código de la transacción.
     */
    @Override
    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    /**
     * Establece el código de la transacción de venta.
     *
     * @param codigoTransaccion Código único de la transacción.
     */
    @Override
    public void setCodigoTransaccion(Integer codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    /**
     * Obtiene la fecha límite hasta la que estará a la venta el boleto.
     *
     * @return Fecha límite de la transacción.
     */
    public Date getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Establece la fecha límite hasta la que estará a la venta el boleto.
     *
     * @param fechaLimite Nueva fecha límite de la transacción.
     */
    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * Obtiene el precio de venta del boleto que establece el usuario.
     *
     * @return Precio de venta.
     */
    public float getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Establece el precio de venta del boleto. Puede ser mayor o menor al precio original del boleto.
     *
     * @param precioVenta Nuevo precio de venta.
     */
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Obtiene el número de serie del boleto que está a la venta.
     *
     * @return Número de serie del boleto.
     */
    public String getNumeroSerieBoleto() {
        return numeroSerieBoleto;
    }

    /**
     * Establece el número de serie del boleto que está a la venta.
     *
     * @param numeroSerieBoleto Nuevo número de serie del boleto.
     */
    public void setNumeroSerieBoleto(String numeroSerieBoleto) {
        this.numeroSerieBoleto = numeroSerieBoleto;
    }

    /**
     * Calcula el código hash de la transacción basado en el código de transacción.
     *
     * @return Código hash de la transacción.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.codigoTransaccion);
        return hash;
    }

    /**
     * Compara dos objetos para verificar si son iguales. La comparación se basa en el código de transacción.
     *
     * @param obj Objeto a comparar.
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
        final TransaccionVenta other = (TransaccionVenta) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    /**
     * Devuelve una representación en cadena de la transacción de venta.
     *
     * @return Cadena que representa la transacción de venta.
     */
    @Override
    public String toString() {
        return "TransaccionVenta{" + "codigoTransaccion=" + codigoTransaccion + ", fechaLimite=" + fechaLimite + ", precioVenta=" + precioVenta + ", numeroSerieBoleto=" + numeroSerieBoleto + '}';
    }

}
