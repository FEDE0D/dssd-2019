package com.dssd.grupo18.videoconf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bonitasoft.engine.session.APISession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/forms")
public class FormsController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        APISession apiSession = (APISession) request.getSession().getAttribute("bonita-session");
        if (apiSession != null) {
            model.addAttribute("username", apiSession.getUserName());
        } else {
            response.sendRedirect("/forms/login");
        }
        return "home";
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/forms/login");
    }

    @RequestMapping("/solicitud")
    public String solicitud(@RequestParam(name = "id", required = false) String processInstanceId, Model model) {
        model.addAttribute("processInstanceId", processInstanceId);
        return "solicitud";
    }

}
