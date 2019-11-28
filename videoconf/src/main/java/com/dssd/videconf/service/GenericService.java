package com.dssd.videconf.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.dssd.videconf.model.GenericModel;
import com.dssd.videconf.repository.GenericRepository;

public abstract class GenericService<M extends GenericModel, R extends GenericRepository<M>> {

    private R repository;

    public GenericService(R repository) {
        this.repository = repository;
    }

    public List<M> findAll() {
        return this.repository.findAll();
    }

    public List<M> findAll(Example<M> example) {
        return this.repository.findAll(example);
    }

    public M getOne(Long id) {
        return this.repository.getOne(id);
    }

    public M save(M model) {
        return this.repository.save(model);
    }
}
