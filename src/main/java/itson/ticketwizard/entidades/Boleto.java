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
    private String asiento;
    private Integer codigoEvento;
    private Integer codigoUsuario;
    private double precio;

    public Boleto() {
    }

    public Boleto(Integer codigoBoleto, String numeroSerie, String fila, String asiento, Integer codigoEvento, Integer codigoUsuario, double precio) {
        this.codigoBoleto = codigoBoleto;
        this.numeroSerie = numeroSerie;
        this.fila = fila;
        this.asiento = asiento;
        this.codigoEvento = codigoEvento;
        this.codigoUsuario = codigoUsuario;
        this.precio = precio;
    }

    public Boleto(String numeroSerie, String fila, String asiento, Integer codigoEvento, Integer codigoUsuario, double precio) {
        this.numeroSerie = numeroSerie;
        this.fila = fila;
        this.asiento = asiento;
        this.codigoEvento = codigoEvento;
        this.codigoUsuario = codigoUsuario;
        this.precio = precio;
    }

    
    
    

    public Integer getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(Integer codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
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
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigoBoleto);
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
        return "Boleto{" + "codigoBoleto=" + codigoBoleto + ", numeroSerie=" + numeroSerie + ", fila=" + fila + ", asiento=" + asiento + ", codigoEvento=" + codigoEvento + ", codigoUsuario=" + codigoUsuario + ", precio=" + precio + '}';
    }
    

    
    
}
