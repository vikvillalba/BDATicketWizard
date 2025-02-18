package itson.ticketwizard.entidades;

import java.util.Objects;

/**
 *
 * @author victoria
 */
public class Boleto {
    private Integer codigoBoleto;
    private String numeroSerie;
    private String fila;
    private String Asiento;
    private Integer codigoEvento;
    private Integer codigoUsuario;
    
    public Boleto(){} // constructor por defecto.

    public Boleto(String numeroSerie, String fila, String Asiento, Integer codigoEvento, Integer codigoUsuario) {
        this.numeroSerie = numeroSerie;
        this.fila = fila;
        this.Asiento = Asiento;
        this.codigoEvento = codigoEvento;
        this.codigoUsuario = codigoUsuario;
    }

    public Boleto(String fila, String Asiento, Integer codigoEvento, Integer codigoUsuario) {
        this.fila = fila;
        this.Asiento = Asiento;
        this.codigoEvento = codigoEvento;
        this.codigoUsuario = codigoUsuario;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getAsiento() {
        return Asiento;
    }

    public void setAsiento(String Asiento) {
        this.Asiento = Asiento;
    }

    public Integer getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.codigoBoleto);
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
        final Boleto other = (Boleto) obj;
        return Objects.equals(this.codigoBoleto, other.codigoBoleto);
    }

    @Override
    public String toString() {
        return "Boleto{" + "codigoBoleto=" + codigoBoleto + ", numeroSerie=" + numeroSerie + ", fila=" + fila + ", Asiento=" + Asiento + ", codigoEvento=" + codigoEvento + ", codigoUsuario=" + codigoUsuario + '}';
    }
    
    
}
