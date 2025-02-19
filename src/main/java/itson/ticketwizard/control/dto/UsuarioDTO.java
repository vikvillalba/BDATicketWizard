/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control.dto;

import java.util.Date;

/**
 *
 * @author victoria 
 */
public class UsuarioDTO {
    private int codigoUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private double saldoDisponible;
    
    public UsuarioDTO(int codigoUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, double saldoDisponible){
        this.codigoUsuario = codigoUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.saldoDisponible = saldoDisponible;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
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

    public double getSaldoDisponible() {
        return saldoDisponible;
    }
    
    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

}
