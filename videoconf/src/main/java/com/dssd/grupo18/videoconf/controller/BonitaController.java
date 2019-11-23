package com.dssd.grupo18.videoconf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.FlowNodeExecutionException;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstance;
import org.bonitasoft.engine.bpm.flownode.UserTaskNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.NotFoundException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.exception.UpdateException;
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
    public void user(@RequestParam String username, @RequestParam String password, HttpServletRequest request,
        HttpServletResponse response) throws NotFoundException, LoginException, ServerAPIException,
        BonitaHomeNotSetException, UnknownAPITypeException, IOException, ProcessActivationException,
        ProcessExecutionException, FlowNodeExecutionException, ContractViolationException, UpdateException {
        APISession apiSession = this.bonitaService.login(username, password);
        request.getSession().setAttribute("bonita-session", apiSession);
        request.getSession().setMaxInactiveInterval(10 *60);
        response.sendRedirect("/forms/home");
    }

    @RequestMapping("/iniciarSolicitud")
    public void iniciarSolicitud(HttpServletRequest request, HttpServletResponse response)
        throws NotFoundException, ProcessExecutionException, ProcessActivationException, UpdateException,
        ContractViolationException, FlowNodeExecutionException, IOException {
        APISession apiSession = (APISession) request.getSession().getAttribute("bonita-session");
        ProcessInstance processInstance = this.bonitaService.startProcess(apiSession.getUserId(),
            this.bonitaService.getSolicitudEntrevistaProcessID());

        HumanTaskInstance humanTaskInstance = this.bonitaService.getLastHumanTask(processInstance.getId(),
            "Inciar Solicitud");
        this.bonitaService.assignUserTask(apiSession.getUserId(), humanTaskInstance.getId());
        response.sendRedirect("/forms/solicitud?id=" + humanTaskInstance.getId());
    }

    @RequestMapping(value = "/solicitud", method = RequestMethod.POST)
    public Solicitud solicitud(@RequestParam(value = "id", required = true) long activityInstanceId,
        @RequestParam("nro_causa") long nroCausa, @RequestParam(value = "motivo") String motivo, @RequestParam(value = "unidad_id") long unidadId,
        @RequestParam("fecha") String fecha, @RequestParam(value = "hora") String hora, @RequestParam("juez_id") long juezId,
        @RequestParam(value = "interno_id") long internoId, @RequestParam("abogado_id") long abogadoId,
        @RequestParam(value = "procurador_id") long procuradorId, HttpServletRequest request)
        throws UpdateException, FlowNodeExecutionException, ContractViolationException, UserTaskNotFoundException,
        UserNotFoundException, BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException {

        APISession apiSession = (APISession) request.getSession().getAttribute("bonita-session");

        return this.solicitudService.create(apiSession, activityInstanceId, nroCausa, motivo, unidadId, fecha,
            hora, juezId, internoId, abogadoId, procuradorId);
    }

}
