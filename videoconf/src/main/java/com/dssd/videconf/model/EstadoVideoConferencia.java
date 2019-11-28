package com.dssd.videconf.model;

import javax.persistence.Entity;

@Entity(name = "estado_videoconferencia")
public class EstadoVideoConferencia extends GenericModel {

    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
