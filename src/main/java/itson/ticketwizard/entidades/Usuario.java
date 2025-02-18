package itson.ticketwizard.entidades;

import java.util.Date;
import java.util.Objects;

/**
 * Clase entidad que representa a la tabla Usuarios en la BD.
 *
 * @author victoria
 */
public class Usuario {
    private Integer codigoUsuario;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private Date fechaNacimiento;
    private float saldoDisponible;
    private String nombreUsuario;
    private String contrasenia;

    /**Constructor por defecto.
     */
    public Usuario() {}

    /**
     * Constructor con parámetros para inicializar todos los atributos del usuario.
     *
     * @param codigoUsuario Código único del usuario.
     * @param apellidoPaterno Apellido paterno del usuario.
     * @param apellidoMaterno Apellido materno del usuario.
     * @param nombres Nombres del usuario.
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     * @param saldoDisponible Saldo disponible en la cuenta del usuario.
     * @param nombreUsuario Nombre de usuario para acceder al sistema.
     * @param contrasenia Contraseña asociada al nombre de usuario.
     */
    public Usuario(Integer codigoUsuario, String apellidoPaterno, String apellidoMaterno, String nombres, Date fechaNacimiento, float saldoDisponible, String nombreUsuario, String contrasenia) {
        this.codigoUsuario = codigoUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.saldoDisponible = saldoDisponible;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor que omite el código de usuario.
     *
     * @param apellidoPaterno Apellido paterno del usuario.
     * @param apellidoMaterno Apellido materno del usuario.
     * @param nombres Nombres del usuario.
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     * @param saldoDisponible Saldo disponible en la cuenta del usuario.
     * @param nombreUsuario Nombre de usuario para acceder al sistema.
     * @param contrasenia Contraseña asociada al nombre de usuario.
     */
    public Usuario(String apellidoPaterno, String apellidoMaterno, String nombres, Date fechaNacimiento, float saldoDisponible, String nombreUsuario, String contrasenia) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.saldoDisponible = saldoDisponible;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el código único del usuario.
     *
     * @return Código del usuario.
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * Establece el código único del usuario.
     *
     * @param codigoUsuario Código único del usuario.
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return Apellido paterno del usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno Apellido paterno del usuario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return Apellido materno del usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno Apellido materno del usuario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene los nombres del usuario.
     *
     * @return Nombres del usuario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del usuario.
     *
     * @param nombres Nombres del usuario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return Fecha de nacimiento del usuario.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el saldo disponible del usuario.
     *
     * @return Saldo disponible del usuario.
     */
    public float getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * Establece el saldo disponible del usuario.
     *
     * @param saldoDisponible Saldo disponible del usuario.
     */
    public void setSaldoDisponible(float saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }


    /**
     * Obtiene el nombre de usuario para el acceso al sistema.
     *
     * @return Nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario para el acceso al sistema.
     *
     * @param nombreUsuario Nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña asociada al nombre de usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña asociada al nombre de usuario.
     *
     * @param contrasenia Nueva contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Calcula el código hash del usuario basado en el código de usuario.
     *
     * @return Código hash del usuario.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoUsuario);
        return hash;
    }

    /**
     * Compara dos objetos para verificar si son iguales.
     * La comparación se basa en el código de usuario.
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.codigoUsuario, other.codigoUsuario);
    }

    /**
     * Devuelve una representación en cadena del usuario con todos sus atributos.
     *
     * @return Cadena que representa al usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "codigoUsuario=" + codigoUsuario + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", saldoDisponible=" + saldoDisponible + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + '}';
    }
    
    
}
