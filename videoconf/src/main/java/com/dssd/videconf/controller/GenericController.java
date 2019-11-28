package com.dssd.videconf.controller;

import com.dssd.videconf.model.GenericModel;
import com.dssd.videconf.repository.GenericRepository;
import com.dssd.videconf.service.GenericService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class GenericController<M extends GenericModel, S extends GenericService<M, GenericRepository<M>>> {

    private GenericService<M, GenericRepository<M>> service;

    public GenericController(GenericService<M, GenericRepository<M>> service) {
        this.service = service;
    }

    @RequestMapping
    public List<M> findAll() {
        return this.service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public M getOne(@PathVariable Long id) {
        return this.service.getOne(id);
    }

}
