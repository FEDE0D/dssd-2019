package com.dssd.videconf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "unidades")
public class Unidad extends GenericModel {

    private String nombre;

    @Column(name = "numeroUnidad")
    private Long numeroUnidad;

    private String coordenadas;

    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroUnidad() {
        return numeroUnidad;
    }

    public void setNumeroUnidad(Long numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
