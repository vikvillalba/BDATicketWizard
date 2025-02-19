package itson.ticketwizard.dtos;

/**
 *
 * @author victoria
 */
public class UsuarioRegistradoDTO {
    private String usuario;
    private String contrasenia;

    public UsuarioRegistradoDTO(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    
}
