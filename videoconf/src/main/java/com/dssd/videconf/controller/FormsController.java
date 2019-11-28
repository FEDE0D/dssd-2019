package com.dssd.videconf.controller;

import java.io.IOException;

import org.bonitasoft.engine.bdm.BusinessObjectDaoCreationException;
import org.bonitasoft.engine.bpm.data.DataNotFoundException;
import org.bonitasoft.engine.bpm.flownode.ActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceNotFoundException;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ContractDataNotFoundException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dssd.videconf.model.Schedule;
import com.dssd.videconf.model.Solicitud;
import com.dssd.videconf.service.BonitaService;
import com.dssd.videconf.service.SolicitudService;

@Controller
@RequestMapping("/forms")
public class FormsController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private BonitaService bonitaService;

    @RequestMapping("/solicitud")
    public String solicitud(@RequestParam(name = "id", required = false) String processInstanceId, Model model) {
        model.addAttribute("processInstanceId", processInstanceId);
        return "solicitud";
    }

    @RequestMapping("/unidades")
    public String unidades(@RequestParam("id") long processInstanceId, Model model)
        throws DataNotFoundException, IOException {
        Schedule schedule = this.solicitudService.getSchedule(processInstanceId);
        model.addAttribute("processInstanceId", processInstanceId);
        model.addAttribute("schedule", schedule);
        return "unidades";
    }

    @RequestMapping("/confirmar")
    public String confirmar(@RequestParam("id") long activityInstanceId, Model model)
        throws DataNotFoundException, BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException,
        ActivityInstanceNotFoundException, BusinessObjectDaoCreationException, ContractDataNotFoundException {

        ActivityInstance activityInstance = this.bonitaService.getActivity(activityInstanceId);

        Long idSolicitud = (Long) this.bonitaService.getCaseVariable(activityInstance.getParentProcessInstanceId(),
            "solicitudId");
        Solicitud solicitud = this.solicitudService.getOne(idSolicitud);

        model.addAttribute("solicitud", solicitud);

        return "confirmar";
    }

}
