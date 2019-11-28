package com.dssd.videconf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "participante_videoconferencia")
public class Participante extends GenericModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_participante")
    private TipoParticipante tipo;

    private String apellido;

    @Column(name = "nombres")
    private String nombre;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    public TipoParticipante getTipo() {
        return tipo;
    }

    public void setTipo(TipoParticipante tipo) {
        this.tipo = tipo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
