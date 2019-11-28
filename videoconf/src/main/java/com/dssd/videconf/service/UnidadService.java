package com.dssd.videconf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssd.videconf.model.Unidad;
import com.dssd.videconf.repository.GenericRepository;

@Service
public class UnidadService
    extends GenericService<Unidad, GenericRepository<Unidad>> {

    @Autowired
    public UnidadService(GenericRepository<Unidad> repository) {
        super(repository);
    }

}
