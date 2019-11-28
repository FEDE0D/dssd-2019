package com.dssd.videconf.model;

import javax.persistence.Entity;

@Entity(name = "tipo_videoconferencia")
public class TipoVideoconferencia extends GenericModel {

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
