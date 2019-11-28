package com.dssd.videconf.service;

import com.dssd.videconf.model.Interno;
import com.dssd.videconf.repository.GenericRepository;
import com.dssd.videconf.repository.InternoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternoService extends GenericService<Interno, GenericRepository<Interno>> {

    @Autowired
    public InternoService(InternoRepository repository) {
        super(repository);
    }

}
