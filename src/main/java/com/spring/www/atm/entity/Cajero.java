package com.spring.www.atm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CAJERO")
public class Cajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "CANTIDAD")
    private int cantidad;

    @Column(name = "DENOMINACION")
    private double denominaciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDenominaciones() {
        return denominaciones;
    }

    public void setDenominaciones(double denominaciones) {
        this.denominaciones = denominaciones;
    }
}
