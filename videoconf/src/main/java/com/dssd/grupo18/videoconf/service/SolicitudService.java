package com.dssd.grupo18.videoconf.service;

import org.bonitasoft.engine.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssd.grupo18.videoconf.model.Solicitud;

@Service
public class SolicitudService {

    @Autowired
    BonitaService bonitaService;

    /**
     * Creates a new Solicitud and stores it on the DB
     * Also it will send this data to Bonita and continue on with the process
     *
     * @param processInstanceId
     * @param nroCausa
     * @param motivo
     * @param solicitanteId
     * @param unidadId
     * @param fecha
     * @param hora
     * @param juezId
     * @param internoId
     * @param abogadoId
     * @param procuradorId
     * @return
     */
    public Solicitud create(long activityInstanceId, long nroCausa, String motivo, long solicitanteId, long unidadId,
        String fecha, String hora, long juezId, long internoId, long abogadoId, long procuradorId) throws UpdateException {

        Solicitud solicitud = new Solicitud();
        solicitud.setId(19L);

        this.bonitaService.setCaseVariable(activityInstanceId, "idsolicitudInput", String.valueOf(solicitud.getId()));

        return solicitud;
    }
}
