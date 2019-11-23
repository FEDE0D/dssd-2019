package com.dssd.grupo18.videoconf.controller;

import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.FlowNodeExecutionException;
import org.bonitasoft.engine.bpm.flownode.UserTaskNotFoundException;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.exception.UpdateException;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.session.APISession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dssd.grupo18.videoconf.model.Solicitud;
import com.dssd.grupo18.videoconf.service.BonitaService;
import com.dssd.grupo18.videoconf.service.SolicitudService;

@RestController
@RequestMapping("/bonita")
public class BonitaController {

    @Autowired
    private BonitaService bonitaService;

    @Autowired
    private SolicitudService solicitudService;

    @RequestMapping(value = "/login")
    public void user(@RequestParam String username, @RequestParam String password) throws UserNotFoundException,
        LoginException, ServerAPIException, BonitaHomeNotSetException, UnknownAPITypeException {
        APISession apiSession = this.bonitaService.login(username, password);

    }

    @RequestMapping(value = "/solicitud", method = RequestMethod.POST)
    public Solicitud solicitud(@RequestParam(value = "id", required = true) long processInstanceId,
        @RequestParam("token") String bonitaToken, @RequestParam(value = "nro_causa") long nroCausa,
        @RequestParam(value = "motivo") String motivo, @RequestParam(value = "solicitante_id") long solicitanteId,
        @RequestParam(value = "unidad_id") long unidadId, @RequestParam(value = "fecha") String fecha,
        @RequestParam(value = "hora") String hora, @RequestParam(value = "juez_id") long juezId,
        @RequestParam(value = "interno_id") long internoId, @RequestParam(value = "abogado_id") long abogadoId,
        @RequestParam(value = "procurador_id") long procuradorId) throws UpdateException, FlowNodeExecutionException,
        ContractViolationException, UserTaskNotFoundException, UserNotFoundException {

        return this.solicitudService.create(processInstanceId, nroCausa, motivo, solicitanteId, unidadId, fecha, hora,
            juezId, internoId, abogadoId, procuradorId);
    }

}
