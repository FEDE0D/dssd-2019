package com.dssd.grupo18.videoconf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @RequestMapping("/solicitud")
    public String solicitud(@RequestParam(name = "id", required = true) String processInstanceId, Model model) {
        model.addAttribute("processInstanceId", processInstanceId);
        return "solicitud";
    }

}
