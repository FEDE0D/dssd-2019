package com.dssd.grupo18.videoconf.model;

import java.sql.Date;
import java.sql.Time;

public class Solicitud extends GenericModel {

    private Unidad unidad;

    private Date fecha;
    private Time hora;

    private Interno interno;

    private Participante juez;
    private Participante abogado;
    private Participante procurador;
    private Participante solicitante;

}
