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
public class EventoDTO {
    private int codigoEvento;
    private Date fechaEvento;
    private String recintoEvento;
    private String ciudadEvento;
    private String estadoEvento;
    private String descripcionEvento;
    
    public EventoDTO(int codigoEvento, Date fechaEvento, String recintoEvento, String ciudadEvento, String estadoEvento, String descripcionEvento){
        this.codigoEvento = codigoEvento; 
        this.fechaEvento = fechaEvento;
        this.recintoEvento = recintoEvento;
        this.ciudadEvento = ciudadEvento;
        this.estadoEvento = estadoEvento;
        this.descripcionEvento = descripcionEvento;
    }

    public int getCodigoEvento() {
        return codigoEvento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public String getRecintoEvento() {
        return recintoEvento;
    }

    public String getCiudadEvento() {
        return ciudadEvento;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }
    
    
}
