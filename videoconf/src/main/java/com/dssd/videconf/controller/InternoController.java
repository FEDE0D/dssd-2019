package com.dssd.videconf.controller;

import com.dssd.videconf.model.Interno;
import com.dssd.videconf.service.InternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/interno")
public class InternoController extends GenericController<Interno, InternoService> {

    @Autowired
    public InternoController(InternoService service) {
        super(service);
    }

}
