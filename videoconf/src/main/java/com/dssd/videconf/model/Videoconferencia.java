package com.dssd.videconf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.sql.Time;

@Entity(name = "videoconferencias")
public class Videoconferencia extends GenericModel {

    private Date fecha;

    private Time hora;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unidad")
    private Unidad unidad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado")
    private EstadoVideoConferencia estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo")
    private TipoVideoconferencia tipo;

    @Column(name = "nro_causa")
    private String nroCausa;

    private String motivo;

    private Long solicitante;

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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public EstadoVideoConferencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoVideoConferencia estado) {
        this.estado = estado;
    }

    public TipoVideoconferencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoVideoconferencia tipo) {
        this.tipo = tipo;
    }

    public String getNroCausa() {
        return nroCausa;
    }

    public void setNroCausa(String nroCausa) {
        this.nroCausa = nroCausa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Long solicitante) {
        this.solicitante = solicitante;
    }
}
