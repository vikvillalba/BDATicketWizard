package itson.ticketwizard.dtos;

import java.util.Date;

/**
 *
 * @author victoria 
 */
public class NuevoUsuarioDTO {

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String nombreUsuario;
    private String contrasenia;
    private String correoElectronico;

    public NuevoUsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String nombreUsuario, String contrasenia, String correoElectronico) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    
    
    


}
