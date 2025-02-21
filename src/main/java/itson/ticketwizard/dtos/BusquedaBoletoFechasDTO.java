package itson.ticketwizard.dtos;

import java.time.LocalDateTime;

/**
 *
 * @author victoria
 */
public class BusquedaBoletoFechasDTO {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public BusquedaBoletoFechasDTO(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }



    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
