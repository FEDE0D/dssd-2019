package com.dssd.videconf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.sql.Time;

@Entity(name = "solicitud")
public class Solicitud extends GenericModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;

    private Date fecha;
    private Time hora;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "interno_id")
    private Interno interno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "juez_id")
    private Participante juez;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abogado_id")
    private Participante abogado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "procurador_id")
    private Participante procurador;

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Interno getInterno() {
        return interno;
    }

    public void setInterno(Interno interno) {
        this.interno = interno;
    }

    public Participante getJuez() {
        return juez;
    }

    public void setJuez(Participante juez) {
        this.juez = juez;
    }

    public Participante getAbogado() {
        return abogado;
    }

    public void setAbogado(Participante abogado) {
        this.abogado = abogado;
    }

    public Participante getProcurador() {
        return procurador;
    }

    public void setProcurador(Participante procurador) {
        this.procurador = procurador;
    }

}
