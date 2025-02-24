package itson.ticketwizard.entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class Usuario {
    private Integer codigoUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private float saldoDisponible;
    private String nombreUsuario;
    private String contrasenia;
    private String correoElectronico;

    public Usuario() {
    }

    public Usuario(Integer codigoUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, float saldoDisponible, String nombreUsuario, String contrasenia, String correoElectronico) {
        this.codigoUsuario = codigoUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.saldoDisponible = saldoDisponible;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
    }

    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, float saldoDisponible, String nombreUsuario, String contrasenia, String correoElectronico) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.saldoDisponible = saldoDisponible;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(float saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.codigoUsuario);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.codigoUsuario, other.codigoUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigoUsuario=" + codigoUsuario + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", saldoDisponible=" + saldoDisponible + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", correoElectronico=" + correoElectronico + '}';
    }
    
    
}
