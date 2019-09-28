package com.dssd.grupo18.videoconf.model;

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
