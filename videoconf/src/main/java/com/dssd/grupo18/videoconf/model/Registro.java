package com.dssd.grupo18.videoconf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado")
    private EstadoVideoConferencia estado;

    private Date fecha;

    private Time hora;

    private String descripcion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "videoconferencia")
    private Videoconferencia videoconferencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
