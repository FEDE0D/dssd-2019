package com.dssd.grupo18.videoconf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/forms")
public class FormsController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/solicitud")
    public String solicitud(@RequestParam(name = "id", required = false) String processInstanceId, Model model,
        @CookieValue(value = "X-Bonita-API-Token", required = false) String bonitaToken) {
        model.addAttribute("processInstanceId", processInstanceId);
        model.addAttribute("bonitaToken", bonitaToken);
        return "solicitud";
    }

}
