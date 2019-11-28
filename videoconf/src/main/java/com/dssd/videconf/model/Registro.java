package com.dssd.videconf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Registro extends GenericModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado")
    private EstadoVideoConferencia estado;

    private Date fecha;

    private Time hora;

    private String descripcion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "videoconferencia")
    private Videoconferencia videoconferencia;

    public EstadoVideoConferencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoVideoConferencia estado) {
        this.estado = estado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Videoconferencia getVideoconferencia() {
        return videoconferencia;
    }

    public void setVideoconferencia(Videoconferencia videoconferencia) {
        this.videoconferencia = videoconferencia;
    }
}
