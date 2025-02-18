package itson.ticketwizard.entidades;

import java.util.Objects;

/**
 * Clase entidad que representa a la tabla direcciones en la BD.
 *
 * @author victoria
 */
public class DomiciliosUsuarios {

    // atributos que corresponden a las columnas de la tabla.
    private Integer codigoUsuario;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private Integer codigoPostal;

    /**
     * Constructor por defecto.
     */
    public DomiciliosUsuarios() {
    }

    /**
     * Constructor que recibe todos los atributos.
     *
     * @param codigoUsuario un numero único que identifica al usuario.
     * @param calle calle en dónde reside.
     * @param numero número exterior de la casa.
     * @param colonia colonia en dónde reside.
     * @param ciudad ciudad de residencia.
     * @param estado estado en donde se ubica.
     * @param codigoPostal que representa su domicilio.
     */
    public DomiciliosUsuarios(Integer codigoUsuario, String calle, String numero, String colonia, String ciudad, String estado, Integer codigoPostal) {
        this.codigoUsuario = codigoUsuario;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor que recibe todos los atributos menos el código del usuario.
     *
     * @param calle calle en dónde reside.
     * @param numero número exterior de la casa.
     * @param colonia colonia en dónde reside.
     * @param ciudad ciudad de residencia.
     * @param estado estado en donde se ubica.
     * @param codigoPostal que representa su domicilio.
     */
    public DomiciliosUsuarios(String calle, String numero, String colonia, String ciudad, String estado, Integer codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene el codigo del usuario al que corresponde el domicilio.
     *
     * @return codigo del usuario.
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * Asigna un usuario al domicilio
     *
     * @param codigoUsuario codigo del usuario al que corresponde el domicilio.
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * Obtiene la calle del domicilio del usuario.
     *
     * @return Nombre de la calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Asigna la calle del domicilio del usuario.
     *
     * @param calle Nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número del domicilio del usuario.
     *
     * @return Número de la dirección.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Asigna el número del domicilio del usuario.
     *
     * @param numero Número de la dirección.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la colonia del domicilio del usuario.
     *
     * @return Nombre de la colonia.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Asigna la colonia del domicilio del usuario.
     *
     * @param colonia Nombre de la colonia.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene la ciudad del domicilio del usuario.
     *
     * @return Nombre de la ciudad.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Asigna la ciudad del domicilio del usuario.
     *
     * @param ciudad Nombre de la ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el estado del domicilio del usuario.
     *
     * @return Nombre del estado.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna el estado del domicilio del usuario.
     *
     * @param estado Nombre del estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el código postal del domicilio del usuario.
     *
     * @return Código postal.
     */
    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Asigna el código postal del domicilio del usuario.
     *
     * @param codigoPostal Código postal.
     */
    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Genera el código hash del objeto basado en el código de usuario.
     *
     * @return Código hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.codigoUsuario);
        return hash;
    }

    /**
     * Compara si dos objetos DomiciliosUsuarios son iguales, basado en el código de usuario.
     *
     * @param obj Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
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
        final DomiciliosUsuarios other = (DomiciliosUsuarios) obj;
        return Objects.equals(this.codigoUsuario, other.codigoUsuario);
    }

    /**
     * Devuelve una representación en cadena del objeto DomiciliosUsuarios.
     *
     * @return Cadena con los valores del domicilio del usuario.
     */
    @Override
    public String toString() {
        return "DomiciliosUsuarios{" + "codigoUsuario=" + codigoUsuario + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal + '}';
    }

}
