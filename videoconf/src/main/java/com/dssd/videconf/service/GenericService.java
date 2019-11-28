package com.dssd.videconf.service;

import com.dssd.videconf.model.GenericModel;
import com.dssd.videconf.repository.GenericRepository;

import java.util.List;

public abstract class GenericService<M extends GenericModel, R extends GenericRepository<M>> {

    private R repository;

    public GenericService(R repository) {
        this.repository = repository;
    }

    public List<M> findAll() {
        return this.repository.findAll();
    }

    public M getOne(Long id) {
        return this.repository.getOne(id);
    }

    public M save(M model) {
        return this.repository.save(model);
    }
}
