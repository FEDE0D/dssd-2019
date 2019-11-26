package com.dssd.grupo18.videoconf.controller;

import com.dssd.grupo18.videoconf.service.BonitaService;
import org.bonitasoft.engine.exception.ContractDataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/forms")
public class FormsController {

    @Autowired
    private BonitaService bonitaService;

    @RequestMapping("/solicitud")
    public String solicitud(@RequestParam(name = "id", required = false) String processInstanceId, Model model) {
        model.addAttribute("processInstanceId", processInstanceId);
        return "solicitud";
    }

    @RequestMapping("/unidades")
    public String unidades(@RequestParam("id") long processInstanceId, Model model) throws ContractDataNotFoundException {
        String variable = (String) this.bonitaService.getVariable(processInstanceId, "schedule");
        model.addAttribute("processInstanceId", processInstanceId);
        return "unidades";
    }

}
