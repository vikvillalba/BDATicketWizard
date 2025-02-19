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

    public NuevoUsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
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
    
    
    


}
