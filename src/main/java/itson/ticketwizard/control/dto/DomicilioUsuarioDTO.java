/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control.dto;

/**
 *
 * @author victoria
 */
public class DomicilioUsuarioDTO {
    private int codigoUsuario;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private int codigoPostal;
    
    public DomicilioUsuarioDTO(int codigoUsuario, String calle, String numero, String colonia, String estado, int codigoPostal){
        this.codigoUsuario = codigoUsuario;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
    
}
