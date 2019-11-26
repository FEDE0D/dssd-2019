package com.dssd.grupo18.videoconf.controller;

import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.FlowNodeExecutionException;
import org.bonitasoft.engine.bpm.flownode.UserTaskNotFoundException;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dssd.grupo18.videoconf.service.BonitaService;
import com.dssd.grupo18.videoconf.service.SolicitudService;

@RestController
@RequestMapping("/bonita")
public class BonitaController {

    @Autowired
    private BonitaService bonitaService;

    @Autowired
    private SolicitudService solicitudService;

    @RequestMapping(value = "/solicitud", method = RequestMethod.POST)
    public void solicitud(@RequestParam(value = "id", required = true) long activityInstanceId,
        @RequestParam("nro_causa") long nroCausa, @RequestParam(value = "motivo") String motivo,
        @RequestParam(value = "unidad_id") long unidadId, @RequestParam("fecha") String fecha,
        @RequestParam(value = "hora") String hora, @RequestParam("juez_id") long juezId,
        @RequestParam(value = "interno_id") long internoId, @RequestParam("abogado_id") long abogadoId,
        @RequestParam(value = "procurador_id") long procuradorId, @RequestParam("solicitante_id") long solicitanteId)
        throws UpdateException, FlowNodeExecutionException, ContractViolationException, UserTaskNotFoundException,
        BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException {

        this.solicitudService.create(solicitanteId, activityInstanceId, nroCausa, motivo, unidadId, fecha, hora, juezId,
            internoId, abogadoId, procuradorId);
    }

}
