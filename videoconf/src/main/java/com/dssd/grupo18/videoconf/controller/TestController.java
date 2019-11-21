package com.dssd.grupo18.videoconf.controller;

import org.bonitasoft.engine.session.APISession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private APISession apiSession;

    @RequestMapping
    public List<String> test() {
        return this.apiSession.getProfiles();
    }

}
