package com.dssd.grupo18.videoconf.controller;

import java.io.IOException;
import java.util.Map;

import com.dssd.grupo18.videoconf.model.Solicitud;
import org.bonitasoft.engine.bpm.data.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dssd.grupo18.videoconf.model.Schedule;
import com.dssd.grupo18.videoconf.service.BonitaService;
import com.dssd.grupo18.videoconf.service.SolicitudService;

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
    public String confirmar(@RequestParam("id") long processInstanceId, Model model) throws DataNotFoundException {
        // FIXME posiblemente cambiar a variable de actividad en lugar de variable de proceso?
        Map<String, String> idsolicitudInput = (Map<String, String>) this.bonitaService.getActivityVariable(processInstanceId,
            "idsolicitudInput");
        long idSolicitud = Long.parseLong(idsolicitudInput.get("idsolicitud"));
        Solicitud solicitud = this.solicitudService.getOne(idSolicitud);

        model.addAttribute("solicitud", solicitud);

        return "confirmar";
    }

}
