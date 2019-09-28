package com.dssd.grupo18.videoconf.service;

import com.dssd.grupo18.videoconf.model.Interno;
import com.dssd.grupo18.videoconf.repository.GenericRepository;
import com.dssd.grupo18.videoconf.repository.InternoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternoService extends GenericService<Interno, GenericRepository<Interno>> {

    @Autowired
    public InternoService(InternoRepository repository) {
        super(repository);
    }

}
