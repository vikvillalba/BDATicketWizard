package itson.ticketwizard.dtos;

import java.math.BigDecimal;

/**
 *
 * @author victoria
 */
public class UsuarioRegistradoDTO {
    private Integer codigoUsuario;
    private String usuario;
    private String contrasenia;
    private BigDecimal saldo;
    

    public UsuarioRegistradoDTO(Integer codigoUsuario, String usuario, String contrasenia) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public UsuarioRegistradoDTO(Integer codigoUsuario, String usuario, String contrasenia, BigDecimal saldo) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
    }

    public UsuarioRegistradoDTO(Integer codigoUsuario, String usuario, BigDecimal saldo) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.saldo = saldo;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    
    
}
