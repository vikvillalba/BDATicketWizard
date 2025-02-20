package itson.ticketwizard.dtos;

/**
 *
 * @author victoria
 */
public class UsuarioRegistradoDTO {
    private Integer codigoUsuario;
    private String usuario;
    private String contrasenia;

    public UsuarioRegistradoDTO(Integer codigoUsuario, String usuario, String contrasenia) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public UsuarioRegistradoDTO() {
    }

    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    
    
    
}
