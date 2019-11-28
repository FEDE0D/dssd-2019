package com.dssd.videconf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssd.videconf.model.Interno;
import com.dssd.videconf.repository.GenericRepository;

@Service
public class InternoService
    extends GenericService<Interno, GenericRepository<Interno>> {

    @Autowired
    public InternoService(GenericRepository<Interno> repository) {
        super(repository);
    }

}
