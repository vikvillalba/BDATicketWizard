package itson.ticketwizard.entidades;

import java.util.Objects;

/**
 * Clase entidad que representa a la tabla Boletos en la BD.
 *
 * @author victoria
 */
public class Boleto {

    // atributos que corresponden a las columnas de la tabla 
    private Integer codigoBoleto;
    private String numeroSerie;
    private String fila;
    private String Asiento;
    private Integer codigoEvento;
    private Integer codigoUsuario;

    /**
     * Constructor por defecto.
     */
    public Boleto() {
    }

    /**
     * Constructor que recibe todos los atributos visibles para el usuario.
     *
     * @param numeroSerie un String de 8 caracteres (números y letras) que cambia con cada reventa.
     * @param fila fila del recinto en dónde se ubica el boleto.
     * @param Asiento asiento de la fila en dónde se encuentra el boleto.
     * @param codigoEvento que referencia al evento al que corresponde el boleto.
     * @param codigoUsuario que referencia al usuario dueño del boleto.
     */
    public Boleto(String numeroSerie, String fila, String Asiento, Integer codigoEvento, Integer codigoUsuario) {
        this.numeroSerie = numeroSerie;
        this.fila = fila;
        this.Asiento = Asiento;
        this.codigoEvento = codigoEvento;
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * Constructor que recibe todos los atributos excepto el numero de serie.
     *
     * @param fila fila del recinto en dónde se ubica el boleto.
     * @param Asiento asiento de la fila en dónde se encuentra el boleto.
     * @param codigoEvento que referencia al evento al que corresponde el boleto.
     * @param codigoUsuario que referencia al usuario dueño del boleto.
     */
    public Boleto(String fila, String Asiento, Integer codigoEvento, Integer codigoUsuario) {
        this.fila = fila;
        this.Asiento = Asiento;
        this.codigoEvento = codigoEvento;
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * Obtiene el número de serie del boleto.
     *
     * @return una cadena que corresponde al numero de serie del boleto.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Asigna un número de serie a un boleto.
     *
     * @param numeroSerie un String de 8 caracteres (números y letras) que cambia con cada reventa.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Obtiene la fila del recinto en la que se ubica el boleto.
     *
     * @return una cadena que corresponde a la fila.
     */
    public String getFila() {
        return fila;
    }

    /**
     * Asigna la fila del recinto en la que se ubica el boleto
     *
     * @param fila una cadena que corresponde a la fila.
     */
    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * Obtiene el asiento de la fila en dónde se encuentra el boleto.
     *
     * @return una cadena que corresponde a un asiento de la fila en dónde se encuentra el boleto.
     */
    public String getAsiento() {
        return Asiento;
    }

    /**
     * Asigna el asiento de la fila en dónde se encuentra el bolet
     *
     * @param Asiento una cadena que corresponde a un asiento de la fila en dónde se encuentra el boleto.
     */
    public void setAsiento(String Asiento) {
        this.Asiento = Asiento;
    }

    /**
     * Obtiene el codigo que referencia al evento al que corresponde el boleto.
     *
     * @return un número que referencia al evento al que corresponde el boleto
     */
    public Integer getCodigoEvento() {
        return codigoEvento;
    }

    /**
     * Asigna el codigo que referencia al evento al que corresponde el boleto
     *
     * @param codigoEvento un número que referencia al evento al que corresponde el boleto.
     */
    public void setCodigoEvento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    /**
     * Obtiene el código del usuario al que pertenece el boleto.
     *
     * @return un número que referencia al usuario al que corresponde el boleto.
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * Asigna el código del usuario al que pertenece el boleto
     *
     * @param codigoUsuario un número que referencia al usuario al que corresponde el boleto.
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * Regresa un número que representa a un boleto.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.codigoBoleto);
        return hash;
    }

    /**
     * Compara si dos boletos son iguales.
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
        final Boleto other = (Boleto) obj;
        return Objects.equals(this.codigoBoleto, other.codigoBoleto);
    }

    /**
     * Regresa una cadena con la información de un boleto.
     */
    @Override
    public String toString() {
        return "Boleto{" + "codigoBoleto=" + codigoBoleto + ", numeroSerie=" + numeroSerie + ", fila=" + fila + ", Asiento=" + Asiento + ", codigoEvento=" + codigoEvento + ", codigoUsuario=" + codigoUsuario + '}';
    }

}
