package com.dssd.grupo18.videoconf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.sql.Time;

@Entity(name = "solicitud")
public class Solicitud extends GenericModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unidad")
    private Unidad unidad;

    private Date fecha;
    private Time hora;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "interno")
    private Interno interno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "juez")
    private Participante juez;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abogado")
    private Participante abogado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "procurador")
    private Participante procurador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitante")
    private Participante solicitante;

}
