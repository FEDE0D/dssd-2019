package com.dssd.videconf.model;

import javax.persistence.Entity;

@Entity(name = "tipo_participante")
public class TipoParticipante extends GenericModel {

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
