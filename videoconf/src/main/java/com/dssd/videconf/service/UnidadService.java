package com.dssd.videconf.service;

import com.dssd.videconf.repository.UnidadRepository;
import com.dssd.videconf.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadService extends GenericService<Unidad, UnidadRepository> {

    @Autowired
    public UnidadService(UnidadRepository repository) {
        super(repository);
    }

}
