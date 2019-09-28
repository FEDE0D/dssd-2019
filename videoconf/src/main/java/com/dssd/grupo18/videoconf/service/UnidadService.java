package com.dssd.grupo18.videoconf.service;

import com.dssd.grupo18.videoconf.model.Unidad;
import com.dssd.grupo18.videoconf.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadService extends GenericService<Unidad, UnidadRepository> {

    @Autowired
    public UnidadService(UnidadRepository repository) {
        super(repository);
    }

}
