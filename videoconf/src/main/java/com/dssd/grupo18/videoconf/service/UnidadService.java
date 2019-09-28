package com.dssd.grupo18.videoconf.service;

import com.dssd.grupo18.videoconf.model.Unidad;
import com.dssd.grupo18.videoconf.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadService {

    @Autowired
    private UnidadRepository repository;

    public List<Unidad> list() {
        return repository.findAll();
    }

}
