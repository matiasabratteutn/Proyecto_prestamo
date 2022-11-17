package tup.prestamos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Prestamos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private Double monto;

    private Double tres_cuotas;

    private Double seis_cuotas;

    private Double nueve_cuotas;

    private Double doce_cuotas;

    private Double dieciocho_cuotas;

    public long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getTres_cuotas() {
        return this.tres_cuotas;
    }

    public void setTres_cuotas(Double tres_cuotas) {
        this.tres_cuotas = tres_cuotas;
    }

    public Double getSeis_cuotas() {
        return this.seis_cuotas;
    }

    public void setSeis_cuotas(Double seis_cuotas) {
        this.seis_cuotas = seis_cuotas;
    }

    public Double getNueve_cuotas() {
        return this.nueve_cuotas;
    }

    public void setNueve_cuotas(Double nueve_cuotas) {
        this.nueve_cuotas = nueve_cuotas;
    }

    public Double getDoce_cuotas() {
        return this.doce_cuotas;
    }

    public void setDoce_cuotas(Double doce_cuotas) {
        this.doce_cuotas = doce_cuotas;
    }

    public Double getDieciocho_cuotas() {
        return this.dieciocho_cuotas;
    }

    public void setDieciocho_cuotas(Double dieciocho_cuotas) {
        this.dieciocho_cuotas = dieciocho_cuotas;
    }    
}