package com.dssd.grupo18.videoconf.controller;

import com.dssd.grupo18.videoconf.model.Unidad;
import com.dssd.grupo18.videoconf.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PublicController {

    @Autowired
    private UnidadService unidadService;

    @RequestMapping(value = "/", method = GET)
    public List<Unidad> index() {
        return this.unidadService.list();
    }

}
