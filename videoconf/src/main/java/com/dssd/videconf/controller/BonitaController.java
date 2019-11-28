package com.dssd.videconf.controller;

import java.io.IOException;

import com.dssd.videconf.service.SolicitudService;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.data.DataNotFoundException;
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

import com.dssd.videconf.service.BonitaService;

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

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public void schedule(@RequestParam("id") long activityInstanceId, @RequestParam("schedule_id") long scheduleId)
        throws ServerAPIException, BonitaHomeNotSetException, UnknownAPITypeException, UpdateException, IOException,
        DataNotFoundException {
        this.solicitudService.setSchedule(activityInstanceId, scheduleId);
    }

}
