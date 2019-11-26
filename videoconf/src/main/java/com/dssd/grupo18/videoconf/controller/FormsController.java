package com.dssd.grupo18.videoconf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.session.APISession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dssd.grupo18.videoconf.model.Unidad;
import com.dssd.grupo18.videoconf.service.BonitaService;
import com.dssd.grupo18.videoconf.service.UnidadService;

@Controller
@RequestMapping("/forms")
public class FormsController {

    @Autowired
    private UnidadService unidadService;

    @Autowired
    private BonitaService bonitaService;

    @RequestMapping("/login")
    public String login(Model model) {
        List<Unidad> unidades = unidadService.findAll();
        model.addAttribute("unidades", unidades);
        return "login";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        if (getApiSession(request) != null) {
            model.addAttribute("username", getApiSession(request).getUserName());
        } else {
            response.sendRedirect("/forms/login");
        }
        return "home";
    }

    private APISession getApiSession(HttpServletRequest request) {
        return (APISession) request.getSession().getAttribute("bonita-session");
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/forms/login");
    }

    @RequestMapping("/solicitud")
    public String solicitud(@RequestParam(name = "id", required = false) String processInstanceId, Model model,
        HttpServletRequest request)
        throws LoginException, ServerAPIException, BonitaHomeNotSetException, UnknownAPITypeException {
        model.addAttribute("processInstanceId", processInstanceId);

        return "solicitud";
    }

}
